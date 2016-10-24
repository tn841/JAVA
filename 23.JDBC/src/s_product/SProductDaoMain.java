package s_product;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class SProductDaoMain {

	public static void main(String[] args) throws Exception {
		SProductDao spDao = new SProductDao();
		
//		int rows = spDao.insert(new SProduct(33333, "name33333", "매우 좋습니다.", 50000, null));
//		System.out.println("1. insert : "+rows);
		
		
		/********** 날짜 표현 ******************/
		Date ipgo_date1 = Date.valueOf("2016-10-20");
		System.out.println(">> "+ipgo_date1);
		
		Date ipgo_date2 = new Date(System.currentTimeMillis());
		System.out.println(">> "+ipgo_date2);
		
		java.util.Date ipgo_date3 = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		ipgo_date3 = sdf.parse("2016-10-22");
		System.out.println(">> "+ipgo_date3);
		
		Calendar ipgoCal = Calendar.getInstance();
		ipgoCal.clear();
		ipgoCal.set(2016, 9, 23, 16, 45, 33);
		Date ipgo_date4 = new Date(ipgoCal.getTimeInMillis());
		System.out.println(">> "+ipgo_date4);
		
		/********** 날짜 표현 ******************/
		
		//System.out.println(spDao.insertDate(new SProduct(12345, "product1234", "최고입니다.", 615000, ipgo_date4)));
		System.out.println(spDao.insertSeqSysdate(new SProduct(0, "product1234", "최고입니다.", (int)(Math.random()*1000000), null)));
	}

}
