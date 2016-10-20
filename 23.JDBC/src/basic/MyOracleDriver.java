package basic;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.DriverPropertyInfo;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Properties;
import java.util.logging.Logger;

public class MyOracleDriver implements Driver{
	
	private MyOracleDriver(){
		System.out.println("1. MyOracleDriver객체 생성.");
	}
	
	/*
	 * static block (정적블록)
	 * 	- class loading 된 후 바로 실행되는 블록
	 */
	static{
		System.out.println("0. MyOracleDriver의 정적블록 실행.");
		MyOracleDriver mod = new MyOracleDriver();
		System.out.println("2. DriverManager에 Driver객체를 등록.");
		try {
			DriverManager.registerDriver(mod);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public Connection connect(String url, Properties info) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean acceptsURL(String url) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public DriverPropertyInfo[] getPropertyInfo(String url, Properties info) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getMajorVersion() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMinorVersion() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean jdbcCompliant() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}

}
