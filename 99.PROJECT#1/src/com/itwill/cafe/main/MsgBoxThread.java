package com.itwill.cafe.main;

import java.awt.Color;
import java.util.ArrayList;

import com.itwill.cafe.member.MemberVO;
import com.itwill.cafe.message.MessageService;
import com.itwill.cafe.message.MessageVO;

public class MsgBoxThread extends Thread{
	private FirstPageFrame fpFrame;
	
	public MsgBoxThread(FirstPageFrame frame){
		fpFrame = frame;
	}
	
	
	@Override
	public void run() {
		super.run();
		
		MessageService msgService;
		try {
			msgService = new MessageService();
			while(true){
				//System.out.println("activeMember확인 : "+FirstPageService.getActiveMember().getId());
				MemberVO activeM = FirstPageService.getActiveMember();
				
					ArrayList<MessageVO> msgList = msgService.selectByReceiverId(activeM.getId());
					
					int count=0;
					for (MessageVO messageVO : msgList) {
						if(!messageVO.isChecked()){
							count++;
						}
					}
					
					if(count>0){
//						JOptionPane pane = new JOptionPane();
//						JDialog dialog = pane.createDialog(null, "메시지 도착");
//						dialog.setModal(false);
//						dialog.show();
						
						//다이얼로그 띄우기
						//JOptionPane.showMessageDialog(null, "확인하지않은 메시지가 "+count+"개 도착했습니다.");
						
						//메인 화면의 라벨로 표시하기
						
						String str = new String("("+count+")");
						fpFrame.getMemberInfoPanel().getLblMsgCount().setText(str);
						fpFrame.getMemberInfoPanel().getMsgBoxPanel().setBackground(new Color(211,160,211));
					}
					else{
						fpFrame.getMemberInfoPanel().getLblMsgCount().setText("("+0+")");
						fpFrame.getMemberInfoPanel().getMsgBoxPanel().setBackground(Color.pink);
					}
					
					Thread.sleep(1000);
				
				
				
			}//while
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}//run()
	
	
	
	
	
	
}
