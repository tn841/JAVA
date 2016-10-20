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
		
		/********************** statement �̿��� SQL ****************************/		
		String sql = "select * "
				+ "from emp "
				+ "where sal>"+startSal+" and sal<="+endSal+" and job = '"+job+"'";
		/********************** statement �̿��� SQL ****************************/

		
		
		
		
		
		
		
		// 1. PreparedStatement Query�ۼ�
		/********************** preparedStatement �̿��� SQL ****************************/
		String sql2 = "select * "
				+ "from emp "
				+ "where sal > ? and sal <= ? and job = ?";	//?��ȣ�� DB��Ű���� ���õ� �Ϳ��� �� �� ����. SQL ������ ����
		/********************** preparedStatement �̿��� SQL ****************************/
		
	
		con = ConnectionFactory.getConnection();
		
		
		// 2. PreparedStatement ������ �̸� �ۼ��� Query�� ���ڷ� ����
		PreparedStatement pStmt = con.prepareStatement(sql2);
		
		
		
		// 3. ������ PreparedStatement�� ? �Ķ���͵� ����
		pStmt.setInt(1, startSal);
		pStmt.setInt(2, endSal);
		pStmt.setString(3, job);
		
		// 4-1. Query �����Ͽ� rs�� ���
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
		 * 4-2.����
		 */
		/*
		 * �Ķ��Ÿ����
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
