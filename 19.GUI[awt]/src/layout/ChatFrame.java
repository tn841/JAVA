package layout;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatFrame extends Frame{
	TextArea chatTA;
	List chatL;
	
	Panel chatP;
	TextField chatTF;
	Button chatB;
	
	public ChatFrame() {
		setTitle("XX채팅");
		chatTA=new TextArea();
		chatTA.setEditable(false);
		chatTA.setText("김태희:이따만나\n");
		chatTA.append("김경호:바빠~~\n");
		chatL=new List();
		chatL.add("접속자 리스트");
		chatL.add("김태희");
		chatL.add("김소라");
		chatL.add("이효리");
		chatL.add("최경녀");
		chatL.add("김은희");
		
		/****ChatPanel*****/
		chatP=new Panel();
		chatTF=new TextField(34);
		chatB=new Button("전송");
		chatP.setLayout(new FlowLayout());
		chatP.add(chatTF);
		chatP.add(chatB);
		
		/*
		 * LayoutManager(BorderLayout)
		 */
		setLayout(new BorderLayout());
		add(chatTA,BorderLayout.CENTER);
		add(chatL,BorderLayout.WEST);
		//add(chatTF,BorderLayout.SOUTH);
		//add(chatB,BorderLayout.SOUTH);
		add(chatP, BorderLayout.SOUTH);
		
		//event(ActionEvent)
		ChatButtonHandler cbh=new ChatButtonHandler();
		chatB.addActionListener(cbh);
		chatTF.addActionListener(cbh);
		
		
		
		setSize(350, 400);
		setVisible(true);
		
		chatTF.requestFocus();
	}
	/****************ChatButtonHandler**************/
	public class ChatButtonHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			//String cmd = e.getActionCommand();
			//System.out.println(cmd);
			
			String chatStr=chatTF.getText();
			if(chatStr.trim().equals("")){
				chatTF.setText("");
				chatTF.requestFocus();
				return;	//쓰레드의 반환
			}
			chatTA.append("고소영:"+chatStr+"\n");
			chatTF.setText("");
			chatTF.requestFocus();
			
		}
		
	}
	/***********************************************/
	
	public static void main(String[] args) {
		new ChatFrame();

	}

}
