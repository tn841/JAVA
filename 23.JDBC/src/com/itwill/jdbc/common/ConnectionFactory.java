package com.itwill.jdbc.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 *  Connection을 생성해서 반환해주는 클래스
 */
public class ConnectionFactory {
	
	public static Connection getConnection() throws Exception{
		String driverClass="oracle.jdbc.driver.OracleDriver";
		String url="jdbc:oracle:thin:@210.16.214.203:1521:XE";
		String user="user21";
		String pass="user21";
		
		Class.forName(driverClass);	//1. Driver Loading
		Connection con = DriverManager.getConnection(url, user, pass);	//2. Connection 연결
		
		return con;
	}
	
	public static void releaseConnection(Connection con) throws SQLException{
		con.close();
	}
	
}
