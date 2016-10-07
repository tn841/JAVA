package com.itwill.util;

import java.util.Calendar;
import java.util.Date;

public class CalendarMain {

	public static void main(String[] args) {
		System.out.println("System.currentTimeMillis():"
				+System.currentTimeMillis());
		long startTime=System.currentTimeMillis();
		
		
		System.out.println("-----------Calendar--------");
		//Calendar cal = new Calendar();
		Calendar cal=Calendar.getInstance();
		System.out.println(cal.toString());
		int year=cal.get(Calendar.YEAR);
		//int year=cal.get(1);
		int month=cal.get(Calendar.MONTH);
		/*
		 The first month of the year in the Gregorian and Julian calendars is JANUARY which is 0 
		 */
		int day=cal.get(Calendar.DAY_OF_MONTH);
		int hour=cal.get(Calendar.HOUR);
		int min=cal.get(Calendar.MINUTE);
		int sec=cal.get(Calendar.SECOND);
		int msec=cal.get(Calendar.MILLISECOND);
		
		System.out.println(year+" "+(month+1)+" "+day+" "+hour+":"+min+":"+sec+":"+msec);
		System.out.println("-----------Date--------");
		
		Date today=new Date();
		int year2=today.getYear();
		int month2=today.getMonth();
		int day2=today.getDay();
		System.out.println("しししし"+year2+" "+month2+" "+day2);
		long currentTime = today.getTime();
		System.out.println("Date.getTime():"+currentTime);
		System.out.println("System.currentTimeMillis():"
		+System.currentTimeMillis());
		
		
		long endTime=System.currentTimeMillis();
		long exTime=endTime-startTime;
		System.out.println(">>took "+ exTime+" ms ..");
	}

}
