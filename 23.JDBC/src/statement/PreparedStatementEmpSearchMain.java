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
			int empno = 0;
			try{
				empno =Integer.parseInt(empnoStr);
			}catch(Exception e1){
				System.out.println("�Է� ����");
				continue;
			}
			
			/*
			 * 2.PreparedStatement �ķ���Ÿ����
			 */
			Connection con = ConnectionFactory.getConnection();	// Driver �ε��� DriverManager��ϱ��� �Ϸ��� Connection ��ü ����
			String sql = "select empno, ename, sal, job from emp where deptno=?";	//PreparedStatement�� ���� SQL�� �غ�
			PreparedStatement pstmt = con.prepareStatement(sql);	//Connection��ü�κ��� PreparedStatement ���
			pstmt.setInt(1, empno);	// ? ù��° ���� ����
			
			/*
			 * 3.PreparedStatement ����
			 */
		
			ResultSet rs = pstmt.executeQuery();	//preparedStatment ����

			/*
			 * 4.ResultSet���2
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
				System.out.println("�ش� ��� ����");
			}
			
			
			rs.close();
			
		
			
			pstmt.close();
		}

	}

}
