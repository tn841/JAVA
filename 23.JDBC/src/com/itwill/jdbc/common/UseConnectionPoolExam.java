package com.itwill.jdbc.common;


import java.sql.Connection;
import java.sql.SQLException;

/**
 * ����� ���� Ŀ�ؼ� Ǯ(ConnectionPool) ��� ����
 * DBMS ���� �� ���� ���ҽ� ���� ���ϰ� �߻��ϹǷ� �̸� ������ �Ͽ� �޸𸮻�
 * Connection ��ü�� ������ �ΰ�, �ʿ��� ��� �����ϴ� ���
 * 
 * 3Tier(Client -> Middle Server -> DBMS) ������ �����ڰ� �����Ͽ� DB ó�� �� DBMS�� �����Ǵ�
 * ��Ȳ�� �����ϱ� ���� Ŀ�ؼ� Ǯ ��� ����
 * @author
 *
 */
public class UseConnectionPoolExam {

	public static void main(String[] args) throws SQLException {
		
		ConnectionPool pool = ConnectionPool.getInstance();	//�����ڰ� private���� �Ǿ�����.
															//���� ConnectionPool ��ü�� static���� ���ǵǾ� �־� ���� �Ѱ��ۿ� �������� �ʴ´�.
															// <<Singleton Pattern>>
		
		Connection con = pool.getConnection();
		System.out.println("1. : "+con);
		pool.releaseConnection(con);
		System.out.println(">> 1. �ݳ�\n");
		
		con = pool.getConnection();
		System.out.println("2. : "+con);
		pool.releaseConnection(con);
		System.out.println(">> 2. �ݳ�\n");
		
		con = pool.getConnection();
		System.out.println("3. : "+con);
		pool.releaseConnection(con);
		System.out.println(">> 3. �ݳ�\n");
		
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
