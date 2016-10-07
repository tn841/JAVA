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
				//System.out.println("activeMemberȮ�� : "+FirstPageService.getActiveMember().getId());
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
//						JDialog dialog = pane.createDialog(null, "�޽��� ����");
//						dialog.setModal(false);
//						dialog.show();
						
						//���̾�α� ����
						//JOptionPane.showMessageDialog(null, "Ȯ���������� �޽����� "+count+"�� �����߽��ϴ�.");
						
						//���� ȭ���� �󺧷� ǥ���ϱ�
						
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
