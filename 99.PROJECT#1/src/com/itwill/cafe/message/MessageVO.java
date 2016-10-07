package com.itwill.cafe.message;

import java.io.Serializable;

public class MessageVO implements Serializable {
	private int msgNo; // 쪽지의 고유번호
	private String msgTitle; // 쪽지 제목
	private String msgContent; // 쪽지 내용
	private String msgSender; // 발신자(id)
	private String msgReciver; // 수신자(id)
	private boolean isChecked;

	public MessageVO(int msgNo, String msgTitle, String msgContent, String msgSender, String msgReciver) {
		super();
		this.msgNo = msgNo;
		this.msgTitle = msgTitle;
		this.msgContent = msgContent;
		this.msgSender = msgSender;
		this.msgReciver = msgReciver;
		isChecked = false;
	}
	
	

	public boolean isChecked() {
		return isChecked;
	}



	public void setChecked(boolean isChecked) {
		this.isChecked = isChecked;
	}



	public int getMsgNo() {
		return msgNo;
	}

	public void setMsgNo(int msgNo) {
		this.msgNo = msgNo;
	}

	public String getMsgTitle() {
		return msgTitle;
	}

	public void setMsgTitle(String msgTitle) {
		this.msgTitle = msgTitle;
	}

	public String getMsgContent() {
		return msgContent;
	}

	public void setMsgContent(String msgContent) {
		this.msgContent = msgContent;
	}

	public String getMsgSender() {
		return msgSender;
	}

	public void setMsgSender(String msgSender) {
		this.msgSender = msgSender;
	}

	public String getMsgReciver() {
		return msgReciver;
	}

	public void setMsgReciver(String msgReciver) {
		this.msgReciver = msgReciver;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return msgNo+"\t"+msgTitle+"\t"+msgContent+"\t"+msgSender+"\t"+msgReciver;
	}
}

