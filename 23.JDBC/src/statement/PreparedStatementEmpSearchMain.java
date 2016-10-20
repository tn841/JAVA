package statement;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.itwill.jdbc.common.ConnectionFactory;

public class PreparedStatementEmpSearchMain {

	public static void main(String[] args) throws Exception{
		/*
		 * PreparedStatement����
		 * 
		 */
		BufferedReader consoleIn=
				new BufferedReader(
						new InputStreamReader(System.in));
		
		System.out.println("-------------------");
		System.out.println("����˻����α׷�");
		System.out.println("ver 0.1");
		System.out.println("-------------------");
		
		while (true) {
			System.out.print("�����ȣ�Է�:");
			String empnoStr=consoleIn.readLine();
			int empno=Integer.parseInt(empnoStr);
			
			/*
			 * 2.PreparedStatement �ķ���Ÿ����
			 */
			Connection con = ConnectionFactory.getConnection();
			
			String sql = "select empno, ename, sal, job from emp where empno=?";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, empno);
			
			/*
			 * 3.PreparedStatement ����
			 */
			ResultSet rs = pstmt.executeQuery();
			
			/*
			 * 4.ResultSet���
			 */
			while(rs.next()){
				System.out.println(rs.getInt("empno")+"\t"+
						   rs.getString("ename")+"\t"+
						   rs.getDouble("sal")+"\t"+
						   rs.getString("job"));
			}
			
			rs.close();
			
			pstmt.close();
			
		}

	}

}
