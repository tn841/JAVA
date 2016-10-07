package com.itwill.cafe.comment;

import java.util.ArrayList;
import java.util.Date;

public class CommentDaoTest {

	public static void main(String[] args) throws Exception {
		CommentDao cDao = new CommentDao();
		
//		Data reset
		cDao.testReset();
		
//		insert Test
		System.out.println("1.---------- insert 6�� ----------");
		cDao.insert(new Comment(1,"�迵��","�� ���߾��",1));			//insert
		cDao.insert(new Comment(2,"�����","���� �����̿���",1));			//insert
		cDao.insert(new Comment(3,"������","���� �� �Դϴ�.",1));			//insert
		cDao.insert(new Comment(4,"�ڼ���","������ �� ����־��.,",1));		//insert
		cDao.insert(new Comment(5,"������","���ڵ�� �������.",1));		//insert
		cDao.insert(new Comment(6,"���ػ�","><",1));							//insert
		System.out.println();
		
//		selectAll Test
		System.out.println("2.---------- selectAll Test(6��) ----------");
		ArrayList<Comment> commentList = cDao.selectAll();						//selectAll
		for (Comment comment : commentList) {
			System.out.print("  ");
			System.out.println(comment);
		}
		System.out.println();
		
//		update
		System.out.println("3.---------- update 1��(�迵��) to 1��(����) ----------");
		cDao.update(new Comment(1,"�����","Update �ƾ��",1));					//update
		commentList = cDao.selectAll();
		for (Comment comment : commentList) {
			System.out.print("  ");
			System.out.println(comment);
		}
		System.out.println();
		
//		selectByNo
		System.out.println("4.---------- selectByNo Test(1��) ----------");
		System.out.print("  ");
		System.out.println(cDao.selectByNo(1));									//selectByNo
		System.out.println();
		
//		delete
		System.out.println("5.---------- delete (1��) ----------");
		cDao.deleteByNo(1);															//delete
		commentList = cDao.selectAll();
		for (Comment comment : commentList) {
			System.out.print("  ");
			System.out.println(comment);
		}
		
		
	}

}
