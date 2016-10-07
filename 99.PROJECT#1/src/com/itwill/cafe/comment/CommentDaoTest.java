package com.itwill.cafe.comment;

import java.util.ArrayList;
import java.util.Date;

public class CommentDaoTest {

	public static void main(String[] args) throws Exception {
		CommentDao cDao = new CommentDao();
		
//		Data reset
		cDao.testReset();
		
//		insert Test
		System.out.println("1.---------- insert 6명 ----------");
		cDao.insert(new Comment(1,"김영범","참 잘했어요",1));			//insert
		cDao.insert(new Comment(2,"김수민","저는 조장이에요",1));			//insert
		cDao.insert(new Comment(3,"문진성","좋은 글 입니다.",1));			//insert
		cDao.insert(new Comment(4,"박성빈","덴마는 참 재미있어요.,",1));		//insert
		cDao.insert(new Comment(5,"유은혜","디스코드는 어려워요.",1));		//insert
		cDao.insert(new Comment(6,"유준상","><",1));							//insert
		System.out.println();
		
//		selectAll Test
		System.out.println("2.---------- selectAll Test(6명) ----------");
		ArrayList<Comment> commentList = cDao.selectAll();						//selectAll
		for (Comment comment : commentList) {
			System.out.print("  ");
			System.out.println(comment);
		}
		System.out.println();
		
//		update
		System.out.println("3.---------- update 1번(김영범) to 1번(강사) ----------");
		cDao.update(new Comment(1,"강사님","Update 됐어요",1));					//update
		commentList = cDao.selectAll();
		for (Comment comment : commentList) {
			System.out.print("  ");
			System.out.println(comment);
		}
		System.out.println();
		
//		selectByNo
		System.out.println("4.---------- selectByNo Test(1번) ----------");
		System.out.print("  ");
		System.out.println(cDao.selectByNo(1));									//selectByNo
		System.out.println();
		
//		delete
		System.out.println("5.---------- delete (1번) ----------");
		cDao.deleteByNo(1);															//delete
		commentList = cDao.selectAll();
		for (Comment comment : commentList) {
			System.out.print("  ");
			System.out.println(comment);
		}
		
		
	}

}
