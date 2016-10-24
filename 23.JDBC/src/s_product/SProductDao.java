package s_product;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.itwill.jdbc.common.ConnectionPool;

public class SProductDao {
	
	public int insert(SProduct sp) throws Exception{
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try{
			con = ConnectionPool.getInstance().getConnection();
			pstmt = con.prepareStatement(SProductSQL.INSERT_STRING);
			
			pstmt.setInt(1, sp.getId());
			pstmt.setString(2, sp.getNamel());
			pstmt.setString(3, sp.getShort_desc());
			pstmt.setInt(4, sp.getPrice());
			pstmt.setString(5, "16/10/11");
			
			int insertRow = pstmt.executeUpdate();
			
			return insertRow;
			
		}finally{
			if(pstmt != null){
				pstmt.close();
			}
			if(con != null){
				ConnectionPool.getInstance().releaseConnection(con);
			}
		}
	}
	
	
	public int insertDate(SProduct sp) throws Exception{
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try{
			con = ConnectionPool.getInstance().getConnection();
			pstmt = con.prepareStatement(SProductSQL.INSERT_DATE);
			
			pstmt.setInt(1, sp.getId());
			pstmt.setString(2, sp.getNamel());
			pstmt.setString(3, sp.getShort_desc());
			pstmt.setInt(4, sp.getPrice());
			pstmt.setDate(5, sp.getIpgo_date());
			
			int insertRow = pstmt.executeUpdate();
			
			return insertRow;
			
		}finally{
			if(pstmt != null){
				pstmt.close();
			}
			if(con != null){
				ConnectionPool.getInstance().releaseConnection(con);
			}
		}
	}
	
	
	public int insertSeqSysdate(SProduct sp) throws Exception{
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try{
			con = ConnectionPool.getInstance().getConnection();
			pstmt = con.prepareStatement(SProductSQL.INSERT_SEQ_SYSDATE);
			
	
			pstmt.setString(1, sp.getNamel());
			pstmt.setString(2, sp.getShort_desc());
			pstmt.setInt(3, sp.getPrice());
		
			
			int insertRow = pstmt.executeUpdate();
			
			return insertRow;
			
		}finally{
			if(pstmt != null){
				pstmt.close();
			}
			if(con != null){
				ConnectionPool.getInstance().releaseConnection(con);
			}
		}
	}
	
	

}
