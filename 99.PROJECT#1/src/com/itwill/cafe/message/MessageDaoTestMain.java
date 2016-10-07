package com.itwill.cafe.message;
import java.util.ArrayList;

public class MessageDaoTestMain {

	public static void main(String[] args)throws Exception {
		
		MessageDao msgDao=new MessageDao();
		
		System.out.println("-----insert--------");
		msgDao.insert(new MessageVO(1, "�ȳ��ϼ���", "������ �ݰ����ϴ�", "YYY", "XXX"));
		msgDao.insert(new MessageVO(2, "�ȳ�", "������ �ݰ���", "XXX", "YYY"));
		msgDao.insert(new MessageVO(3, "����", "���� ���� ����", "QQQ", "ZZZ"));
		msgDao.insert(new MessageVO(4, "�ǰ��ϴ�", "������ ������ ����", "ZZZ", "QQQ"));
		msgDao.insert(new MessageVO(5, "�ȳ��ϼ���", "������ �ݰ����ϴ�", "QQQ", "AAA"));
		
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
