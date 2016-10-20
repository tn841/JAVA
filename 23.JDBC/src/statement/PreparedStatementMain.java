package statement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.itwill.jdbc.common.ConnectionFactory;

public class PreparedStatementMain {

	public static void main(String[] args) throws Exception {
		Connection con = null;
		
		
		int startSal = 1000;
		int endSal = 3000;
		String job = "SALESMAN";
		
		/********************** statement 이용한 SQL ****************************/		
		String sql = "select * "
				+ "from emp "
				+ "where sal>"+startSal+" and sal<="+endSal+" and job = '"+job+"'";
		/********************** statement 이용한 SQL ****************************/

		
		
		
		
		
		
		
		// 1. PreparedStatement Query작성
		/********************** preparedStatement 이용한 SQL ****************************/
		String sql2 = "select * "
				+ "from emp "
				+ "where sal > ? and sal <= ? and job = ?";	//?기호는 DB스키마와 관련된 것에는 쓸 수 없다. SQL 인젝션 방지
		/********************** preparedStatement 이용한 SQL ****************************/
		
	
		con = ConnectionFactory.getConnection();
		
		
		// 2. PreparedStatement 생성시 미리 작성한 Query를 인자로 전달
		PreparedStatement pStmt = con.prepareStatement(sql2);
		
		
		
		// 3. 생성된 PreparedStatement에 ? 파라미터들 셋팅
		pStmt.setInt(1, startSal);
		pStmt.setInt(2, endSal);
		pStmt.setString(3, job);
		
		// 4-1. Query 실행하여 rs에 담기
		ResultSet rs = pStmt.executeQuery();
		
		while(rs.next()){
			System.out.println(rs.getInt("empno")+"\t"+
					   rs.getString("ename")+"\t"+
					   rs.getDouble("sal")+"\t"+
					   rs.getString("job"));
		}
		rs.close();
		System.out.println();
		
		/*
		 * 4-2.실행
		 */
		/*
		 * 파라메타제거
		 */
		pStmt.clearParameters();
		
		startSal=1000;
		endSal=5000;
		job="MANAGER";
		
		pStmt.setInt(1, startSal);
		pStmt.setInt(2, endSal);
		pStmt.setString(3, job);
		
		rs=pStmt.executeQuery();
		while(rs.next()){
			System.out.println(rs.getInt("empno")+"\t"+
					   rs.getString("ename")+"\t"+
					   rs.getDouble("sal")+"\t"+
					   rs.getString("job"));
		}
		
		rs.close();
		pStmt.close();
		ConnectionFactory.releaseConnection(con);
		System.out.println("------------------");
	
	}

}
