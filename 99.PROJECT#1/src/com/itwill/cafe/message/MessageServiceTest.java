package com.itwill.cafe.message;

public class MessageServiceTest {

	public static void main(String[] args) throws Exception {
		MessageService ms = new MessageService();
		
		ms.createMessage(new MessageVO(1, "sss", "eeeeeeeeee", "XXX", "YYY"));
		ms.createMessage(new MessageVO(2, "xxx", "eeeeeeeeee", "XXX", "YYY"));
		ms.createMessage(new MessageVO(3, "bbb", "cccccccccc", "XXX", "YYY"));
		/*
		System.out.println(ms.showMessage(1));
	
		ms.deleteMessage(new MessageVO(3, "bbb", "cccccccccc", "XXX", "YYY"));
		System.out.println(ms.showMessage(3));
		
		ms.showMessageList("XXX");
		*/
	}

}
