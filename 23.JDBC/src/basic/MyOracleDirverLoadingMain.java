package basic;

import java.sql.Driver;

public class MyOracleDirverLoadingMain {

	public static void main(String[] args) throws Exception {
		Class driverClass = Class.forName("basic.MyOracleDriver");
		
		//Object driverClassObj = driverClass.newInstance();
		
		Driver driverClassObj = (Driver) driverClass.newInstance();
		
		
	}

}
