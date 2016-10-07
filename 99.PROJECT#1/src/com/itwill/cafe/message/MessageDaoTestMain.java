package com.itwill.cafe.message;
import java.util.ArrayList;

public class MessageDaoTestMain {

	public static void main(String[] args)throws Exception {
		
		MessageDao msgDao=new MessageDao();
		
		System.out.println("-----insert--------");
		msgDao.insert(new MessageVO(1, "안녕하세요", "만나서 반갑습니다", "YYY", "XXX"));
		msgDao.insert(new MessageVO(2, "안녕", "만나서 반가워", "XXX", "YYY"));
		msgDao.insert(new MessageVO(3, "뭐해", "오늘 날씨 좋다", "QQQ", "ZZZ"));
		msgDao.insert(new MessageVO(4, "피곤하다", "오늘은 쉬도록 하자", "ZZZ", "QQQ"));
		msgDao.insert(new MessageVO(5, "안녕하세요", "만나서 반갑습니다", "QQQ", "AAA"));
		
		/*
		System.out.println("-----selectByNo--------");
		MessageVO findMessage=msgDao.selectByNo(3);
		System.out.println(findMessage);


		System.out.println("-----selectAll--------");
		ArrayList<MessageVO> msgList=msgDao.selectAll();
		for (MessageVO msgVO : msgList) {
			System.out.println(msgVO);
		}

		
		System.out.println("-----delete--------");
		msgDao.delete(1);
		msgDao.delete(2);
		msgList=msgDao.selectAll();
		for (MessageVO msgVO : msgList) {
			System.out.println(msgVO);
		
		}
		*/
	}
}
