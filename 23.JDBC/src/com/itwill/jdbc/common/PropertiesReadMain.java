package com.itwill.jdbc.common;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesReadMain {
	
	public static void main(String[] args) throws Exception {
		/*
		 * db.properties file을 읽어서 Connection 만들기
		 * --> C:\GIT\JAVA_Basic\23.JDBC\src\db.properties
		 */
		FileInputStream propertiesFileIn = new FileInputStream("C:\\GIT\\JAVA_Basic\\23.JDBC\\src\\db.properties"); 
		
		Properties properties = new Properties();
		properties.load(propertiesFileIn);	//properties 파일은 한 라인에 하나의 key와 value를 가지며 '='를 토큰으로 데이터를 분류
		System.out.println(properties.getProperty("url"));
		System.out.println(properties.getProperty("user"));
		System.out.println(properties.getProperty("psswd"));
		System.out.println(properties.getProperty("driver"));
		System.out.println(properties.getProperty("initialCons"));
		System.out.println(properties.getProperty("maxCons"));
		System.out.println(properties.getProperty("block"));
		System.out.println(properties.getProperty("timout"));
	}
}
