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
		 * PreparedStatement생성
		 * 
		 */
		BufferedReader consoleIn=
				new BufferedReader(
						new InputStreamReader(System.in));
		
		System.out.println("-------------------");
		System.out.println("사원검색프로그램");
		System.out.println("ver 0.1");
		System.out.println("-------------------");
		
		while (true) {
			System.out.print("사원번호입력:");
			String empnoStr=consoleIn.readLine();
			int empno=Integer.parseInt(empnoStr);
			
			/*
			 * 2.PreparedStatement 파레메타셋팅
			 */
			Connection con = ConnectionFactory.getConnection();
			
			String sql = "select empno, ename, sal, job from emp where empno=?";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, empno);
			
			/*
			 * 3.PreparedStatement 실행
			 */
			ResultSet rs = pstmt.executeQuery();
			
			/*
			 * 4.ResultSet출력
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
