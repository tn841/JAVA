package com.itwill.jdbc.common;


import java.sql.Connection;
import java.sql.SQLException;

/**
 * 사용자 정의 커넥션 풀(ConnectionPool) 사용 예제
 * DBMS 접속 시 많은 리소스 사용과 부하가 발생하므로 미리 접속을 하여 메모리상에
 * Connection 객체를 저장해 두고, 필요할 경우 재사용하는 방법
 * 
 * 3Tier(Client -> Middle Server -> DBMS) 구현시 접속자가 폭주하여 DB 처리 시 DBMS가 정지되는
 * 상황를 방지하기 위해 커넥션 풀 사용 권장
 * @author
 *
 */
public class UseConnectionPoolExam {

	public static void main(String[] args) throws SQLException {
		
		ConnectionPool pool = ConnectionPool.getInstance();	//생성자가 private으로 되어있음.
															//또한 ConnectionPool 객체는 static으로 정의되어 있어 오직 한개밖에 생성되지 않는다.
															// <<Singleton Pattern>>
		
		Connection con = pool.getConnection();
		System.out.println("1. : "+con);
		pool.releaseConnection(con);
		System.out.println(">> 1. 반납\n");
		
		con = pool.getConnection();
		System.out.println("2. : "+con);
		pool.releaseConnection(con);
		System.out.println(">> 2. 반납\n");
		
		con = pool.getConnection();
		System.out.println("3. : "+con);
		pool.releaseConnection(con);
		System.out.println(">> 3. 반납\n");
		
		con = pool.getConnection();
		System.out.println("4. : "+con);
		System.out.println();
		
		con = pool.getConnection();
		System.out.println("5. : "+con);
		System.out.println();
		
		con = pool.getConnection();
		System.out.println("6. : "+con);
		System.out.println();

		
		
			
				
	}

}
