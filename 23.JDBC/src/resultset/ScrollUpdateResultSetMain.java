package resultset;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Date;

import com.itwill.jdbc.common.ConnectionFactory;

public class ScrollUpdateResultSetMain {

	public static void main(String[] args) throws Exception {
		String sql = "select empno, ename, sal, job, hiredate from emp order by empno";
		Connection con = ConnectionFactory.getConnection();
				
		Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		////�⺻���� ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY �̴�.
		
		ResultSet rs = stmt.executeQuery(sql);
		
		System.out.println("---------rs.next()---------");
		while(rs.next()){
			System.out.println(
					rs.getInt("empno")+"\t"+
					rs.getString("ename")+"\t"+
					rs.getInt("sal")+"\t"+
					rs.getString("job")
					);
		}
		
		System.out.println("\n---------rs.previous()---------");
		while(rs.previous()){
			System.out.println(
					rs.getInt("empno")+"\t"+
							rs.getString("ename")+"\t"+
							rs.getInt("sal")+"\t"+
							rs.getString("job")
					);
		}
		
		System.out.println("\n---------rs.first()---------");
		rs.first();
		{
			System.out.println(
					rs.getInt("empno")+"\t"+
							rs.getString("ename")+"\t"+
							rs.getInt("sal")+"\t"+
							rs.getString("job")
					);
		}
		
		
		System.out.println("\n---------rs.last()---------");
		rs.last();
		{
			System.out.println(
					rs.getInt("empno")+"\t"+
							rs.getString("ename")+"\t"+
							rs.getInt("sal")+"\t"+
							rs.getString("job")
					);
		}
		
		
		System.out.println("\n---------rs.getRow()---------");
		int rowCount = rs.getRow();
		System.out.println("row Count : "+rowCount);
		
		
		System.out.println("\n---------rs.absolute(5)---------");
		rs.absolute(5);
		System.out.println(
				rs.getInt("empno")+"\t"+
						rs.getString("ename")+"\t"+
						rs.getInt("sal")+"\t"+
						rs.getString("job")
				);
		
		
		/*
		 * rs.relative(1); = rs.next();
		 * rs.relative(-1); = rs.previous();
		 */
		
		System.out.println("\n---------rs.relative(1)---------");
		rs.relative(1);
		System.out.println(
				rs.getInt("empno")+"\t"+
						rs.getString("ename")+"\t"+
						rs.getInt("sal")+"\t"+
						rs.getString("job")
				);
		
		
		
		System.out.println("\n---------rs.relative(-1)---------");
		rs.relative(-1);
		System.out.println(
				rs.getInt("empno")+"\t"+
						rs.getString("ename")+"\t"+
						rs.getInt("sal")+"\t"+
						rs.getString("job")
				);
		
		
		
		/*
		 * 	ResultSet�� ���� Table�� ������ ����
		 */
		System.out.println("\n\n++++++++++++++++++++++++++++++++++++++++++");
		rs.beforeFirst();	//BOF
		rs.afterLast();		//EOF
		//rs.getInt("empno");
		
		
		System.out.println("ResultSet -> update");
		// 1. cursor ��ġ ����
		rs.first();	
		
		// 2. ResultSet ����
		rs.updateString(2, "���̽�");
		rs.updateDate(5,  new Date(System.currentTimeMillis()));
		
		// 3. table ����
		rs.updateRow();
		
		
		
		rs.beforeFirst();
		while(rs.next()){
			System.out.println(rs.getInt("empno")+"\t"+
					rs.getString("ename")+"\t"+
					rs.getInt("sal")+"\t"+
					rs.getString("job")+"\t\t"+
					rs.getDate("hiredate"));
		}
		
		System.out.println("\nResultSet -> insert");
		// 1. cursor ��ġ ����
		rs.moveToInsertRow();//insert mode�� ����
		
		// 2. insert�� rs������ �Է� 
		rs.updateInt(1, 9997);
		rs.updateString(2, "����Ŭ");
		rs.updateInt(3, 4550);
		rs.updateString(4, "MANAGER");
		rs.updateDate(5, new Date(System.currentTimeMillis()));
		
		// 3. insert����
		rs.insertRow();
		
		rs.beforeFirst();	//insert�� ������ rs������ insert�� �����͸� Ȯ���� �� ����.(����� �Ѵ�.)
		while(rs.next()){
			System.out.println(rs.getInt("empno")+"\t"+
					rs.getString("ename")+"\t"+
					rs.getInt("sal")+"\t"+
					rs.getString("job")+"\t\t"+
					rs.getDate("hiredate"));
		}
		
		
		System.out.println("\n---------ResultSet-->delete-----");
		//1.cursor��ġ
		rs.last();
		
		//3.table row delete
		rs.deleteRow();
		
		
		rs.beforeFirst();
		while(rs.next()){
			System.out.println(
					rs.getInt("empno")+"\t"+
					rs.getString("ename")+"\t"+
					rs.getInt("sal")+"\t"+
					rs.getString("job")+"\t"+
					rs.getDate("hiredate"));
		}
		
		
		rs.close();
		stmt.close();
		ConnectionFactory.releaseConnection(con);
	}

}
