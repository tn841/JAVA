package com.itwill.cafe.message.model;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import com.itwill.cafe.main.FirstPageService;
import com.itwill.cafe.message.MessageService;
import com.itwill.cafe.message.MessageVO;

public class MessageTableModel{
	private MessageService msgService;
	private DefaultTableModel dtModel;
	
	public MessageTableModel(ArrayList<String> colName) throws Exception{
		int row=0;
		int col=5;
		msgService = new MessageService();
		
		
		ArrayList<MessageVO> messageList = msgService.showMessageList(FirstPageService.getActiveMember().getId());//로그인한 회원);
		
	
		
		for (MessageVO messageVO : messageList) {
			row++;
		}
		Object[][] data = new Object[row][col];
		row=0;
		for (MessageVO message : messageList) {
			data[row][0] = message.getMsgNo();
			data[row][1] = message.getMsgSender();
			data[row][2] = message.getMsgTitle();
			data[row][3] = message.getMsgReciver();
			data[row][4] = message.isChecked();
			row++;
		}//data셋팅 완료
		
		
		row=0;
		for(String str : colName){
			row++;
		}
		Object[] colNameArr = new Object[row];
		row=0;
		for (String str : colName) {
			colNameArr[row] = str;
			row++;
		}//colName셋팅 완료
		
		dtModel = new DefaultTableModel(data, colNameArr);
	}

	public DefaultTableModel getDtModel() {
		return dtModel;
	}

	public void setDtModel(DefaultTableModel dtModel) {
		this.dtModel = dtModel;
	}
	
}
