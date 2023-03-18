package com.highfive.review.model.service;

import static com.highfive.common.JDBCTemplate.close;
import static com.highfive.common.JDBCTemplate.commit;
import static com.highfive.common.JDBCTemplate.getConnection;
import static com.highfive.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.highfive.certBoard.model.vo.Attachment;
import com.highfive.challenge.model.vo.Challenge;
import com.highfive.review.model.dao.ReviewDao;
import com.highfive.review.model.vo.Review;
import com.highfive.review.model.vo.ReviewReply;

public class ReviewService {

	public int increaseReviewCount(int reviewNo) {
		Connection conn =getConnection();

		int result = new ReviewDao().increaseReviewCount(conn,reviewNo);
		
		if(result>0) {
			commit(conn);
		} else {
			rollback(conn);
			
		} 
		close(conn);
		
		return result;
	}

	
	public Review selectReview(int reviewNo) {
		Connection conn = getConnection();
		
		Review r = new ReviewDao().selectReview(conn, reviewNo);
		close(conn);
		return r;
	}
	
	

	public Challenge selectChall(int challNo) {
		Connection conn = getConnection();		
		Challenge c =  new ReviewDao().selectChall(conn, challNo);
		close(conn);
		return c; 

	}


	public ArrayList<Attachment> selectReviewAttachmentList(int reviewNo) {
		
		Connection conn = getConnection();
		
		ArrayList<Attachment> rAtList =  new ReviewDao().selectReviewAttachmentList(conn, reviewNo);

		close(conn);
		return rAtList;
	}


	public ArrayList<Review> orderReviewList(String selectCategory, String selectOrder) {
		Connection conn = getConnection();
		
		ArrayList<Review> rList =  new ReviewDao().orderReviewList(conn, selectCategory, selectOrder);
		close(conn);
		return rList;
	}


	public ArrayList<ReviewReply> selectReplyList(int reviewNo) {
		Connection conn = getConnection();
		ArrayList<ReviewReply> rpList = new ReviewDao().selectReplyList(conn,reviewNo);
		close(conn);
		return rpList;
	}


	public int insertReply(ReviewReply rr) {
		Connection conn = getConnection();
		int result = new ReviewDao().insertReply(conn, rr);
		
		if(result>0) {
			commit(conn);
		} else {
			rollback(conn);
			
		} 
		
		close(conn);
		
		return result;
		
	}


	public ArrayList<Challenge> seletChallWithoutReview(int userNo) {
		Connection conn = getConnection();
		ArrayList<Challenge> cList = new ReviewDao().seletChallWithoutReview(conn, userNo);
		close(conn);
		return cList;
	}


	public int insertReview(Review r, ArrayList<Attachment> list) {
			Connection conn= getConnection();
		
			int result1 = new ReviewDao().insertReview(conn, r);
			
			int result2 = new ReviewDao().insertAttachmentList(conn, list);
	
			
			
			if(result1*result2 >0) {
				commit(conn);
			} else {
				rollback(conn);
			}
				close(conn);
			
			return result1*result2;		
	}


	public int selectLike(int reviewNo, int userNo) {
		Connection conn = getConnection();
		int likeYN = new ReviewDao().selectLike(conn, reviewNo, userNo);
		
		close(conn);
		
		return likeYN;
		
	}


	public int insertLike(int reviewNo, int userNo) {
		Connection conn = getConnection();
		int insertLike = new ReviewDao().insertLike(conn, reviewNo, userNo);
		
		
		if(insertLike>0) {
			commit(conn);
		} else {
			rollback(conn);
			
		} 
		
		close(conn);
		return insertLike;
		
	}


	public int updateLikeY(int reviewNo, int userNo) {
		Connection conn = getConnection();
		int updateLikeY = new ReviewDao().updateLikeY(conn, reviewNo, userNo);
			
			
			if(updateLikeY>0) {
				commit(conn);
			} else {
				rollback(conn);
				
			} 
			
			close(conn);
			return updateLikeY;
	}


	public int updateLikeN(int reviewNo, int userNo) {
		Connection conn = getConnection();
		int updateLikeN = new ReviewDao().updateLikeN(conn, reviewNo, userNo);
			
			
			if(updateLikeN>0) {
				commit(conn);
			} else {
				rollback(conn);
				
			} 
			
			close(conn);
			return updateLikeN;
	}


	public int countReviewLike(int reviewNo) {
		Connection conn = getConnection();
		int countReviewLike = new ReviewDao().countReviewLike(conn, reviewNo);
		
		close(conn);
		return countReviewLike;
		
	}

	

	public int myLikeYN(int reviewNo, int userNo) {
		Connection conn = getConnection();
		int myLikeYN = new ReviewDao().myLikeYN(conn, reviewNo, userNo);
		
		
		
		
		close(conn);
		return  myLikeYN;
	}





	public int updateReview(Review r, ArrayList<Attachment> list, int[] arr) {
		Connection conn = getConnection();
		
		// case 1 : 새로운 첨부파일 X => b, null =>   UPDATE
		// case 2 : 새로운 첨부파일 O, 기존 첨부파일 O => UPDATE, ATTACHMENT UPDATE
		// case 3 : 새로운 첨부파일 O, 기존 첨부파일 X =>  UPDATE, ATTACHMENT INSERT
		// Attachment vo에 새 필드를추가하거나
		// ArrayList 마지막 인덱스에 판단을 할수있는 int배열을 추가하거나
		// switch문을 돌면서 2,3 case 마다 하나씩 +1되도록 하거나...........
		
		
		int result = new ReviewDao().updateReview(conn, r);
	
		
		int count=0;
		for(int i=1; i<arr.length; i++) {
			
			switch(arr[i]) {
		
			case 2:
				Attachment atForUpdate= list.get(count);
				result +=  new ReviewDao().updateAttachment(conn, atForUpdate);
				
				count++;
				break;
			case 3:
				Attachment atForInsert= list.get(count);
				result +=   new ReviewDao().insertAttachment(conn, atForInsert);
				count++;
				break;
			default:
				result += 1;
				break;
			}
			
		}
		
		
		
		if(result ==4) {
			commit(conn);
		} else {
			rollback(conn);
		}
			close(conn);
		
		return result;		
	}


	public int deleteReview(int reviewNo) {
		Connection conn = getConnection();
		int result = new ReviewDao().deleteReview(conn, reviewNo);
		
		if(result>0) {
			commit(conn);
		} else {
			rollback(conn);
			
		} 
		
		close(conn);
		return result;
		
		
	}


	public int deleteReply(int rCommentNo, int userNo) {
		Connection conn = getConnection();
		int result = new ReviewDao().deleteReply(conn, rCommentNo, userNo);
		
		if(result>0) {
			commit(conn);
		} else {
			rollback(conn);
			
		} 
		
		close(conn);
		return result;
	}



	

}




















