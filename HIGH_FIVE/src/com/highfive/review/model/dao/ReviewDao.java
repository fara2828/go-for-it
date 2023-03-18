package com.highfive.review.model.dao;

import static com.highfive.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.highfive.certBoard.model.vo.Attachment;
import com.highfive.challenge.model.vo.Challenge;
import com.highfive.review.model.vo.Review;
import com.highfive.review.model.vo.ReviewReply;



public class ReviewDao {
	private Properties prop = new Properties();
	
	public ReviewDao() {
		String fileName = ReviewDao.class.getResource("/sql/review/review-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(fileName));
			// 다량의 정보를 담고 있는 테이블을 조회시
			// 요청시 현재 요청하고 있는 페이지 번호가 url에 매핑된다
			// 게시판 조회시 page=1로 간다 보통..
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	
	}
	
	

	public int increaseReviewCount(Connection conn, int reviewNo) {

		int result = 0;
		PreparedStatement pstmt = null;
		// 참조자료형은 기본값이 null이니까 굳이 null을 대입하지 않아도 됨
		String sql = prop.getProperty("increaseReviewCount");
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,reviewNo);
			result = pstmt.executeUpdate();
			/// 왜 여기서 1이 안돌아오지...왜지....!!!!!!!!!!!!!!
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
	
		return result;
	}

	public Challenge selectChall(Connection conn, int challNo) {

		Challenge c = null;
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		String sql= prop.getProperty("selectChall");
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, challNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				c = new Challenge();
				
				c.setChallNo(rset.getInt(1));
				c.setChallName(rset.getString(2));
				c.setChallCategory(rset.getString(3));
				c.setChallPostDate(rset.getString(4));
				c.setChallStart(rset.getString(5));
				c.setChallEnd(rset.getString(6));
			    c.setChallFrequency(rset.getInt(7));
				c.setChallParticipant(rset.getInt(8));
				c.setChallParticipantNow(rset.getInt(9));
				c.setChallHowto(rset.getString(10));
				c.setChallPhothExp(rset.getString(11));
				c.setChallIntroduction(rset.getString(12));
				c.setChallThumbnail(rset.getString(13));
				c.setChallPublic(rset.getString(14));
				c.setStatus(rset.getString(15));
				
				
				}
			
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rset);
				close(pstmt);
			}
			return c;
	}
	
	
	
	public Review selectReview(Connection conn, int reviewNo) {
		Review r = null;
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		String sql= prop.getProperty("selectReview");
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, reviewNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				r = new Review();
				r.setReviewNo(rset.getInt("REVIEW_NO"));
				r.setUserNo(rset.getInt("USER_NO"));
				r.setChallNo(rset.getInt("CHALL_NO"));
				r.setReviewTitle(rset.getString("REVIEW_TITLE"));
				r.setReviewDate(rset.getString("REVIEW_DATE"));
				r.setReviewContent(rset.getString("REVIEW_CONTENT"));
				r.setReviewThumbnail(rset.getString("REVIEW_THUMBNAIL"));
				r.setReviewCount(rset.getInt("REVIEW_COUNT"));
				r.setStatus(rset.getString(9));
				r.setCountLike(rset.getInt(10));
				r.setNickName(rset.getString(11));
				//별칭을 알아볼지 모르겟다..
				
				
				
				}
			
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rset);
				close(pstmt);
			}
			
			return r;
	}



	public ArrayList<Attachment> selectReviewAttachmentList(Connection conn, int reviewNo) {
		ArrayList<Attachment> rAtList = new ArrayList();		
		PreparedStatement pstmt = null;
		
		
		
		ResultSet rset = null;
		String sql= prop.getProperty("selectReviewAttachmentList");
		
		
		try {
	
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, reviewNo);			
			rset = pstmt.executeQuery();
			
			
			while(rset.next()) {		
	
			
				
				Attachment at = new Attachment();
				at.setReviewNo(rset.getInt("REVIEW_NO"));
				at.setFilePath(rset.getString("FILE_PATH"));
				at.setChangeName(rset.getString("CHANGE_NAME"));
				at.setFileNo(rset.getInt("FILE_NO"));
				at.setOriginName(rset.getString("ORIGIN_NAME"));
				at.setUpload(rset.getString("UPLOAD"));
				rAtList.add(at);	
		
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return rAtList;			
	}



	public ArrayList<Review> orderReviewList(Connection conn, String selectCategory, String selectOrder) {


		
		switch(selectOrder){		
		case "upload": selectOrder =  "REVIEW_DATE" ; break;
		case "userLike": selectOrder =  "COUNT_LIKE" ; break;
		case "reviewCount": selectOrder =  "REVIEW_COUNT" ; break;
		default : 
		}
		

		
		
		ArrayList<Review> rList = new ArrayList();		
		PreparedStatement pstmt = null;		
		ResultSet rset = null;

		
		try {	
		    // 카테고리가 "전체보기" 일때는 where절이 빠지므로 위치홀더가 1개
			// 카테고리 "전체보기" 일떄랑 아닐때를 구분하여
			// 서로 다른 mapper메소드 호출
			
			if (selectCategory.equals("전체보기")) {
				//String sql = prop.getProperty("orderAllReviewList");
						
				String sql =  "SELECT"
					          + " DISTINCT"
						      + " REVIEW.REVIEW_NO"
						      + " , REVIEW.USER_NO"
						      + " , CHALL_NO"
						      + " , REVIEW_TITLE"
						      + " , TO_CHAR(REVIEW_DATE, 'YYYY-MM-DD') REVIEW_DATE"
						      + " , REVIEW_CONTENT"
						      + " , REVIEW_THUMBNAIL"
						      + " , REVIEW_COUNT"
						      + " , REVIEW.STATUS"
						      + " , MEMBER.NICKNAME"						      
						      + " , CHALL_CATEGORY"
						      + " , USER_LIKE.COUNT_LIKE"					      
						      + " FROM  REVIEW"
						      + " LEFT OUTER JOIN "
						      + " (SELECT REVIEW_NO, SUM(LIKE_YN) AS COUNT_LIKE FROM USER_LIKE GROUP BY REVIEW_NO) USER_LIKE"
						      + " ON "
						      + " (REVIEW.REVIEW_NO = USER_LIKE.REVIEW_NO)"
						      + " LEFT OUTER JOIN "
						      + " MEMBER"
						      + " ON "
						      + " (REVIEW.USER_NO = MEMBER.USER_NO)"
						      + " LEFT OUTER JOIN "
						      + " CHALLENGE "
						      + " USING "
						      + " (CHALL_NO)"
						      + " WHERE REVIEW.STATUS='Y'"
						      + " ORDER"
						      + " BY "
						      +  selectOrder
						      + " DESC"
						      + " NULLS LAST";				
				
				
				pstmt = conn.prepareStatement(sql);
					//pstmt.setString(1, selectOrder);
				rset =	pstmt.executeQuery();
				
				
			
				
			} else {
			
				String sql =  "SELECT"
				          + " DISTINCT"
					      + " REVIEW.REVIEW_NO"
					      + " , REVIEW.USER_NO"
					      + " , CHALL_NO"
					      + " , REVIEW_TITLE"
					      + " , TO_CHAR(REVIEW_DATE, 'YYYY-MM-DD') REVIEW_DATE"
					      + " , REVIEW_CONTENT"
					      + " , REVIEW_THUMBNAIL"
					      + " , REVIEW_COUNT"
					      + " , REVIEW.STATUS"
					      + " , MEMBER.NICKNAME"						      
					      + " , CHALL_CATEGORY"
					      + " , USER_LIKE.COUNT_LIKE"				      
					      + " FROM  REVIEW"
					      + " LEFT OUTER JOIN "
					      + " (SELECT REVIEW_NO, SUM(LIKE_YN) AS COUNT_LIKE FROM USER_LIKE GROUP BY REVIEW_NO) USER_LIKE"
					      + " ON "
					      + " (REVIEW.REVIEW_NO = USER_LIKE.REVIEW_NO)"
					      + " LEFT OUTER JOIN "
					      + " MEMBER"
					      + " ON "
					      + " (REVIEW.USER_NO = MEMBER.USER_NO)"
					      + " LEFT OUTER JOIN "
					      + " CHALLENGE "
					      + " USING "
					      + " (CHALL_NO)"      
					      + " WHERE  CHALL_CATEGORY = '"
					      + selectCategory
					      + "' AND REVIEW.STATUS = 'Y'"
					      + "  ORDER"
					      + " BY "
					      +  selectOrder
					      + " DESC"	
					      + " NULLS LAST";				
				
				
				
				pstmt = conn.prepareStatement(sql);
					//pstmt.setString(1, selectOrder);
				rset =	pstmt.executeQuery();
				
			
				
			}
				
				while(rset.next()) {		
		
					
				
					Review r = new Review();
					r.setReviewNo(rset.getInt("REVIEW_NO"));
					r.setUserNo(rset.getInt("USER_NO"));
					r.setChallNo(rset.getInt("CHALL_NO"));
					r.setReviewTitle(rset.getString("REVIEW_TITLE"));
					r.setReviewDate(rset.getString("REVIEW_DATE"));
					r.setReviewContent(rset.getString("REVIEW_CONTENT"));
					r.setReviewThumbnail(rset.getString("REVIEW_THUMBNAIL"));
					r.setReviewCount(rset.getInt("REVIEW_COUNT"));
					r.setStatus(rset.getString(9));
					r.setNickName(rset.getString(10));				
					rList.add(r);
				
			}
				
			
		
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return rList;			
	}



	public ArrayList<ReviewReply> selectReplyList(Connection conn, int reviewNo) {
		ArrayList<ReviewReply> rpList = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectReplyList");
		
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, reviewNo);
				
				rset = pstmt.executeQuery();
				
				
				while(rset.next()) {
					
					ReviewReply rr = new ReviewReply();
				
					rr.setrCommentNo(rset.getInt(1));
					rr.setUserNo(rset.getInt(2));
					rr.setNickName(rset.getString(3));
					rr.setReviewNo(rset.getInt(4));	
					rr.setrCommentText(rset.getString(5));
					rr.setReplyDate(rset.getString(6));
					
					rpList.add(rr);
					
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rset);
				close(pstmt);
			}
		return rpList;
		
	}



	public int insertReply(Connection conn, ReviewReply rr) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertReply");
		
		try {
			
	
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rr.getUserNo());
			pstmt.setInt(2, rr.getReviewNo());
			pstmt.setString(3, rr.getrCommentText());
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	
	}



	public ArrayList<Challenge> seletChallWithoutReview(Connection conn, int userNo) {
		
		ArrayList<Challenge> cList = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("seletChallWithoutReview");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userNo);
			pstmt.setInt(2, userNo);

		
			rset = pstmt.executeQuery();
			
			
			while(rset.next()) {
				Challenge c = new Challenge();
				c.setChallNo(rset.getInt(1));
				c.setChallCategory(rset.getString(2));
				c.setChallName(rset.getString(3));
				c.setChallEnd(rset.getString(4));				
				
				cList.add(c);
				

				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return cList;
	}



	public int insertReview(Connection conn, Review r) {
		int result= 0;
		PreparedStatement pstmt = null;
		
		// 사진이 하나도 없을 경우 r객체의 thumbnail필드는 null
		
		String sql = prop.getProperty("insertReview");

		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, r.getUserNo());
			pstmt.setInt(2,r.getChallNo());
			pstmt.setString(3, r.getReviewTitle());
			pstmt.setString(4, r.getReviewContent());
			pstmt.setString (5, r.getReviewThumbnail());
			
			result = pstmt.executeUpdate();
				
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			close(pstmt);
		}
	
		return result;		
	}

	
		
	public int insertAttachmentList(Connection conn, ArrayList<Attachment> list) {
		int result = 1;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertAttachmentList");
		// 이전 만들어둔 것에 fileLevel만 추가하면됨
		
		try {
			// LIST의 요소 갯수만큼 AT테이블 행 추가해야함
			 for (Attachment at : list ) {
				 // 반복문이 돌떄마다 미완성된 sql문을 s담은 pstmt객체 생성
				 // 그리고 완성형태로 만든다. at객체로부터 뽑아서
				
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, at.getFilePath());
				pstmt.setString(2, at.getOriginName());
				pstmt.setString(3, at.getChangeName());
				
	
					result *= pstmt.executeUpdate();
			}
		
				
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
			}
		
		
			return result;	

		}



	public int selectLike(Connection conn, int reviewNo, int userNo) {
		int likeYN = -1;
		// rset이 null일 경우 return받은 likeYN은 -1
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectLike");
		// 이전 만들어둔 것에 fileLevel만 추가하면됨
		
		try {
		
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setInt(1, userNo);
				pstmt.setInt(2, reviewNo);
				rset =  pstmt.executeQuery();
				
				if(rset.next()) {
					likeYN= rset.getInt("LIKE_YN");
					
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
			}
		

			return likeYN;	
	}



	public int insertLike(Connection conn, int reviewNo, int userNo) {
		int insertLike = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertLike");
		// 이전 만들어둔 것에 fileLevel만 추가하면됨
		
		try {
			
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,reviewNo);
			pstmt.setInt(2,userNo);

			insertLike= pstmt.executeUpdate();
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
			}
		
			return insertLike;	

	}
	
	public int updateLikeY(Connection conn, int reviewNo, int userNo) {
		int updateLikeY = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateLikeY");
		// 이전 만들어둔 것에 fileLevel만 추가하면됨
		
		try {
			
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,userNo);
			pstmt.setInt(2,reviewNo);
			
			updateLikeY= pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return updateLikeY;	
		
	}



	public int updateLikeN(Connection conn, int reviewNo, int userNo) {
		int updateLikeN = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateLikeN");
		// 이전 만들어둔 것에 fileLevel만 추가하면됨
		
		try {
			
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,userNo);
			pstmt.setInt(2,reviewNo);
			
			updateLikeN= pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return updateLikeN;	
	}



	public int countReviewLike(Connection conn, int reviewNo) {
		int countReviewLike = 0;
		// rset이 null일 경우 return받은 likeYN은 -1
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("countReviewLike");
		// 이전 만들어둔 것에 fileLevel만 추가하면됨
		
		try {
		
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setInt(1,reviewNo);

				rset =  pstmt.executeQuery();
				
				if(rset.next()) {
					countReviewLike= rset.getInt("SUM(LIKE_YN)");
					
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
			}
		
			return countReviewLike;	
	}


	public int myLikeYN(Connection conn, int reviewNo, int userNo) {
		int myLikeYN = 0;
		// rset이 null일 경우 return받은 likeYN은 -1
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("myLikeYN");
		
		// 이전 만들어둔 것에 fileLevel만 추가하면됨
		
		try {
		
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setInt(1,reviewNo);
				pstmt.setInt(2, userNo);
				rset =  pstmt.executeQuery();
				
				if(rset.next()) {
					 myLikeYN= rset.getInt("LIKE_YN");
					
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
			}
		
			return myLikeYN;
	}

	
	
	
	
	
	public int updateReview(Connection conn, Review r) {
		int result= 0;
		PreparedStatement pstmt = null;
		
		// 사진이 하나도 없을 경우 r객체의 thumbnail필드는 null
		
		String sql = prop.getProperty("updateReview");

		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, r.getReviewTitle());
			pstmt.setString(2, r.getReviewContent());
			pstmt.setString (3, r.getReviewThumbnail());
			pstmt.setInt(4, r.getReviewNo());
			
			result = pstmt.executeUpdate();
				
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			close(pstmt);
		}
		
		
		return result;		
	}




	public int updateAttachment(Connection conn, Attachment at) {
		int result =0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateReviewAttachment");
		// 이전 만들어둔 것에 fileLevel만 추가하면됨
		
		try {
				
				pstmt = conn.prepareStatement(sql);
			
				
				pstmt.setString(1, at.getOriginName());
				pstmt.setString(2, at.getChangeName());				
				pstmt.setString(3, at.getFilePath());
				pstmt.setInt(4, at.getFileNo());
	
					result = pstmt.executeUpdate();
						
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
			}
		
	
			return result;	
	}



	public int insertAttachment(Connection conn, Attachment at) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertReviewAttachment");
		
		
		try {
				
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, at.getFilePath());
				pstmt.setInt(2, at.getReviewNo());
				pstmt.setInt(3, at.getFileNo());
				pstmt.setString(4, at.getChangeName());
				
					result = pstmt.executeUpdate();
						
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
			}
		
		
			return result;	
	}



	public int deleteReview(Connection conn, int reviewNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteReview");
		
		
		try {
				
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setInt(1, reviewNo);
				result = pstmt.executeUpdate();
						
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
			}
		
			return result;	
	}



	public int deleteReply(Connection conn, int rCommentNo, int userNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteReply");
		
		
		try {
				
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setInt(1, rCommentNo);
				pstmt.setInt(2, userNo);
				result = pstmt.executeUpdate();
						
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
			}
		
	
			return result;	
	}





}
