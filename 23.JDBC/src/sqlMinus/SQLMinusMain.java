package sqlMinus;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

import com.itwill.jdbc.common.ConnectionFactory;

public class SQLMinusMain {

	public static void main(String[] args) throws Exception {
		Connection con=ConnectionFactory.getConnection();
		Statement stmt=con.createStatement();
		
		InputStream in=System.in;
		BufferedReader br=
				new BufferedReader(
						new InputStreamReader(in));
		System.out.println();
		System.out.println("SQL*Minus: Release 11.2.0.2.0 Production on "+new Date().toLocaleString());
		System.out.println("Copyright (c) 1982, 2014, Itwill.  All rights reserved.");
		System.out.println();
		while (true) {
			System.out.print("SQL>");
			String readSQL= br.readLine();
			try{
				
				boolean isResultSet = stmt.execute(readSQL);
				if(isResultSet){
					ResultSet rs=stmt.getResultSet();
					System.out.println("ResultSet");
				}else{
					int updateCount=stmt.getUpdateCount();
					System.out.println(updateCount+" rows change.");
				}
				
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
		}

	}

}
