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
			int empno = 0;
			try{
				empno =Integer.parseInt(empnoStr);
			}catch(Exception e1){
				System.out.println("입력 오류");
				continue;
			}
			
			/*
			 * 2.PreparedStatement 파레메타셋팅
			 */
			Connection con = ConnectionFactory.getConnection();	// Driver 로딩과 DriverManager등록까지 완료한 Connection 객체 받음
			String sql = "select empno, ename, sal, job from emp where deptno=?";	//PreparedStatement로 보낼 SQL문 준비
			PreparedStatement pstmt = con.prepareStatement(sql);	//Connection객체로부터 PreparedStatement 얻기
			pstmt.setInt(1, empno);	// ? 첫번째 인자 설정
			
			/*
			 * 3.PreparedStatement 실행
			 */
		
			ResultSet rs = pstmt.executeQuery();	//preparedStatment 실행

			/*
			 * 4.ResultSet출력2
			 * 
			 */
			boolean isResultSet;
			if(isResultSet = rs.next()){
					do{
						System.out.println(rs.getInt("empno")+"\t"+
								   rs.getString("ename")+"\t"+
								   rs.getDouble("sal")+"\t"+
								   rs.getString("job"));
					}while(rs.next());
	
			}
			else{
				System.out.println("해당 사원 없음");
			}
			
			
			rs.close();
			
		
			
			pstmt.close();
		}

	}

}
