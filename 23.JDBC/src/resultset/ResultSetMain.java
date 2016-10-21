package resultset;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import com.itwill.jdbc.common.ConnectionFactory;

public class ResultSetMain {

	public static void main(String[] args) throws Exception {
		/*
			이름         널        유형            
			---------- -------- ------------- 
			ID         NOT NULL NUMBER(7)     
			NAME                VARCHAR2(50)  
			SHORT_DESC          VARCHAR2(255) 
			PRICE               NUMBER(10,3)  
			IPGO_DATE           DATE          
		 */
		
		Connection con = ConnectionFactory.getConnection();	// driver로딩, Connect 객체 생성
		PreparedStatement pstmt = con.prepareStatement("select * from s_product");	//connect객체로부터 stmt객체 생성
		ResultSet rs = pstmt.executeQuery();	//stmt로 SQL을 전달하여 결과 객체인 ResultSet 반환
	
		while(rs.next()){
			int id = rs.getInt("id");
			String name = rs.getString("name");
			String desc = rs.getString("short_desc");
			double price = rs.getDouble("price");
			Date date = rs.getDate("ipgo_date");
			System.out.println(id+"\t"+name+"\t\t"+desc+"\t"+price+"\t"+date.toLocaleString());
		}
		rs.close();
		
		
		System.out.println("\n---ResultSet(Colnum)---");
		rs = pstmt.executeQuery();
		while(rs.next()){
			int id = rs.getInt(1);
			String name = rs.getString(2);
			String desc = rs.getString(3);
			double price = rs.getDouble(4);
			Date date = rs.getDate(5);
			System.out.println(id+"\t"+name+"\t\t"+desc+"\t"+price+"\t"+date.toLocaleString());
		}
		rs.close();
		
		
		System.out.println("\n---ResultSet.getString(Colnum)---");
		rs = pstmt.executeQuery();
		while(rs.next()){
			String id = rs.getString(1);
			String name = rs.getString(2);
			String desc = rs.getString(3);
			String price = rs.getString(4);
			String date = rs.getString(5);
			System.out.println(id+"\t"+name+"\t\t"+desc+"\t"+price+"\t"+date);
		}
		rs.close();
		

		System.out.println("\n---ResultSet.getObject(Colnum)---");
		rs = pstmt.executeQuery();
		while(rs.next()){
			Object id = rs.getObject(1);
			Object name = rs.getObject(2);
			Object desc = rs.getObject(3);
			Object price = rs.getObject(4);
			Object date = rs.getObject(5);
			System.out.println(id+"\t"+name+"\t\t"+desc+"\t"+price+"\t"+date);
		}
		rs.close();
		
	}

}
