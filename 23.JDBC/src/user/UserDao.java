package user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.itwill.jdbc.common.ConnectionFactory;

public class UserDao {
	/*
	update
	delete
	selectById
	selectUserList 
	 */
	
	/*
	 이름       널        유형           
	-------- -------- ------------ 
	USERID   NOT NULL VARCHAR2(12) 
	PASSWORD NOT NULL VARCHAR2(12) 
	NAME     NOT NULL VARCHAR2(20) 
	EMAIL             VARCHAR2(50) 
*/
	public int update(String id, String email) throws Exception{
		String sql = "update userinfo set email=? where userid = ?";
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1, email);
		pstmt.setString(2, id);
		
		int updateRowCount = pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
		
		return updateRowCount;
	}
	
	public int insert(User user) throws Exception{
		String sql = "insert into userinfo values(?,?,?,?)";
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1, user.getId());
		pstmt.setString(2, user.getPw());
		pstmt.setString(3, user.getName());
		pstmt.setString(4, user.getEmail());
		
		int insertRowCount = pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
		
		
		return insertRowCount;
	}
	
	public int delete(String id) throws Exception{
		String sql = "delete from userinfo where userid=?";
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1, id);
		
		int deleteRowCount = pstmt.executeUpdate();
		pstmt.close();
		con.close();
		return deleteRowCount;
	}
	
	public User selectById(String id) throws Exception{
		String sql = "select * from userinfo where userid = ?";
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1, id);
		
		boolean isResultSet = pstmt.execute();
		User user = null;
		
		if(isResultSet){
			ResultSet rs = pstmt.getResultSet();
			rs.next();
			user = new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
			rs.close();
		}
		pstmt.close();
		con.close();
		return user;
	}
	
	public ArrayList<User> selectUserList() throws Exception{
		ArrayList<User> userList = new ArrayList<User>();
		
		String sql = "select * from userinfo";
		Connection con = ConnectionFactory.getConnection();
		Statement stmt = con.createStatement();
		
		
		boolean isResultSet = stmt.execute(sql);
	
		
		if(isResultSet){
			ResultSet rs = stmt.getResultSet();
			
			while(rs.next()){
				userList.add(new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
			}
			rs.close();
		}
		
		stmt.close();
		con.close();
		return userList;
	}
	
	
}
