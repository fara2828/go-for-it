package com.highfive.certBoard.model.dao;

import static com.highfive.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

import com.highfive.certBoard.model.vo.Attachment;
import com.highfive.certBoard.model.vo.CertChall;
import com.highfive.challenge.model.vo.Challenge;

public class CertDao {
	
	private Properties prop = new Properties();
	
	public CertDao() {
		String fileName = CertDao.class.getResource("/sql/certChall/certChall-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(fileName));
			// 다량의 정보를 담고 있는 테이블을 조회시
			// 요청시 현재 요청하고 있는 페이지 번호가 url에 매핑된다
			// 게시판 조회시 page=1로 간다 보통..
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	
	}
	
	
	
	

	public ArrayList<CertChall> selectThumbnailList(Connection conn, int challNo) {
		
		ArrayList<CertChall> list = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectThumbnailList");
	
	
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, challNo);
			
			rset = pstmt.executeQuery();			
		
			
			while (rset.next()) {
		
				CertChall cc = new CertChall();
				cc.setCertNo(rset.getInt("CERT_NO"));
				cc.setUserNo(rset.getInt("USER_NO"));
				cc.setChallNo(rset.getInt("CHALL_NO"));
				cc.setCertDate(rset.getString("CERT_DATE"));
				cc.setCertThumbnail(rset.getString("CERT_THUMBNAIL"));
				cc.setCertExp(rset.getString("CERT_EXP"));
				cc.setProfile(rset.getString("PROFILE"));
				cc.setNickName(rset.getString("NICKNAME"));
				
				list.add(cc);
				
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
			
		}
		
		return list; 		
	}
	
	
	public int selectCertCount(Connection conn, int challNo) {
		// TODO Auto-generated method stub
		int result =0;
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		String sql= prop.getProperty("selectCertCount");
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, challNo);
			
			rset = pstmt.executeQuery();
			
			if (rset.next()) {

				
				result = rset.getInt("COUNT(CERT_NO)");
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
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
				c.setChallPostDate(rset.getString(3));
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
	
	


	public ArrayList<Attachment> selectAttachmentList(Connection conn, int challNo) {
		
	
		ArrayList<Attachment> atList = null;		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		String sql= prop.getProperty("selectAttachmentList");
		
		
		try {
	
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, challNo);			
			rset = pstmt.executeQuery();
			
			
			while(rset.next()) {
				atList = new ArrayList();					
				Attachment at = new Attachment();
				at.setChallNo(rset.getInt("CHALL_NO"));	
				at.setFilePath(rset.getString("FILE_PATH"));
				at.setChangeName((rset.getString("CHANGE_NAME")));
				at.setFileNo(rset.getInt("FILE_NO"));
				at.setOriginName(rset.getString("ORIGIN_NAME"));
				atList.add(at);				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return atList;			
	}





	public ArrayList<Challenge> selectMyChallList(Connection conn, int userNo) {
		
		ArrayList<Challenge> cList = new ArrayList();
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		String sql= prop.getProperty("selectMyChallList");

		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, userNo);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Challenge c = new Challenge();
			
				c.setChallNo(rset.getInt(1));
				c.setChallName(rset.getString(2));
				c.setChallCategory(rset.getString(3));
				c.setChallPostDate(rset.getString(3));
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
				c.setUserNo(userNo);
				
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





	public ArrayList<Attachment> selectChallAttachmentList(Connection conn, int challNo) {

		ArrayList<Attachment> challAtList = new ArrayList();		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		String sql= prop.getProperty("selectChallAttachmentList");
		
		
		try {
	
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, challNo);			
			rset = pstmt.executeQuery();
			
			
			while(rset.next()) {		
				
		
				Attachment at = new Attachment();
				at.setChallNo(rset.getInt("CHALL_NO"));	
				at.setFilePath(rset.getString("FILE_PATH"));
				at.setChangeName((rset.getString("CHANGE_NAME")));
				at.setFileNo(rset.getInt("FILE_NO"));
				at.setOriginName(rset.getString("ORIGIN_NAME"));

				challAtList.add(at);				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return challAtList;			
	}





	public ArrayList<Attachment>  selectCertAttachmentList(Connection conn, int certNo) {
		ArrayList<Attachment>  certAtList =new ArrayList();	
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		String sql= prop.getProperty("selectCertAttachmentList");
		


		
		try {	
	
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, certNo);			
			rset = pstmt.executeQuery();
			
			
			while(rset.next()) {
		
						
				Attachment at = new Attachment();
				at.setCertNo(rset.getInt("CERT_NO"));	
				at.setFilePath(rset.getString("FILE_PATH"));
				at.setChangeName((rset.getString("CHANGE_NAME")));
				at.setFileNo(rset.getInt("FILE_NO"));
				at.setOriginName(rset.getString("ORIGIN_NAME"));
				certAtList.add(at);				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return certAtList;		
	}


	public CertChall selectCertChall(Connection conn, int certNo) {
		
		
		CertChall  cc = null;
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		String sql= prop.getProperty("selectCertChall");
		
		
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, certNo);
			
			rset = pstmt.executeQuery();
			
				if(rset.next()) {
					
					cc = new CertChall();
					
					cc.setCertNo(rset.getInt("CERT_NO"));
					cc.setCertExp(rset.getString("CERT_EXP"));
					cc.setCertDate(rset.getString("CERT_DATE"));
					cc.setCertThumbnail(rset.getString("CERT_THUMBNAIL"));	
					cc.setNickName(rset.getString("NICKNAME"));
		
				
				}
			
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rset);
				close(pstmt);
			}
			return cc;
		
	}


	public int insertCert( Connection conn, CertChall cc) {

		int result= 0;
		PreparedStatement pstmt = null;
		
		// 사진이 하나도 없을 경우 cc객체의 thumbnail필드는 null
		
		String sql = prop.getProperty("insertCert");

		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, cc.getUserNo());
			pstmt.setInt(2, cc.getChallNo());
			pstmt.setString(3, cc.getCertExp());
			pstmt.setString(4, cc.getCertThumbnail());
		
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
				 // 반복문이 돌떄마다 미완성된 sql문을 담은 pstmt객체 생성
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





	public ArrayList<CertChall> selectTopCertChallList(Connection conn, int challNo) {
		ArrayList<CertChall> list = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectTopCertChallList");
	
	
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, challNo);
			
			rset = pstmt.executeQuery();			
		
			
			while (rset.next()) {
				
				CertChall cc = new CertChall();
				cc.setCertNo(rset.getInt("CERT_NO"));
				cc.setUserNo(rset.getInt("USER_NO"));
				cc.setChallNo(rset.getInt("CHALL_NO"));
				cc.setCertDate(rset.getString("CERT_DATE"));
				cc.setCertThumbnail(rset.getString("CERT_THUMBNAIL"));
				cc.setCertExp(rset.getString("CERT_EXP"));
				cc.setProfile(rset.getString("PROFILE"));
				cc.setNickName(rset.getString("NICKNAME"));
				
				list.add(cc);
				
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
			
		}
	
		return list; 		
	}





	public int selectCertTotal(Connection conn, int userNo) {
		int certTotal= 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql =  prop.getProperty("selectCertTotal");
		
				
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, userNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				
				certTotal= rset.getInt("CERT_TOTAL");
				
			}
				
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return certTotal;		
	}





	public int updateMemberLevel(Connection conn, int userNo) {
		int updateMemberLevel = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateMemberLevel");
		
		try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, userNo);

			updateMemberLevel = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
	
		return updateMemberLevel;	
	}





	public HashMap<String, Integer> selectCertProgress(Connection conn, int userNo) {

		HashMap<String, Integer> certProgress = new HashMap<>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectCertProgress");
		// 이전 만들어둔 것에 fileLevel만 추가하면됨
		
		try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, userNo);
				rset = pstmt.executeQuery();

				if(rset.next()) {
					
				int totalDuration	= rset.getInt("TOTAL_DURATION");
				int challFrequency =	rset.getInt("CHALL_FREQUENCY");
				int countCert=	rset.getInt("COUNT_CERT");	    
				int challWeeks = (totalDuration / 7);
			
				int requiredCerts = challWeeks*challFrequency;
				
				//int progressPercentage = (countCert/requiredCerts)*100;
					
			
				certProgress.put("challWeeks", challWeeks);
				certProgress.put("challFrequency", challFrequency);
				certProgress.put("requiredCerts",requiredCerts);
				certProgress.put("countCert",countCert);
					
				}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
	
		return certProgress;	
	}
	

	
	
	
}