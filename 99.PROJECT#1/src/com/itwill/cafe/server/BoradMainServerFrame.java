package com.itwill.cafe.server;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.itwill.cafe.message.MessageVO;

public class BoradMainServerFrame extends JFrame {

	private JPanel contentPane;
	private JList memberList;
	private JTextArea logTA;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		BoradMainServerFrame frame = new BoradMainServerFrame();
	}

	/**
	 * Create the frame.
	 */
	public BoradMainServerFrame() {
		setTitle("\uAC8C\uC2DC\uD310 \uC11C\uBC84");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 694, 522);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(14, 49, 153, 269);
		contentPane.add(scrollPane);
		
		memberList = new JList();
		scrollPane.setViewportView(memberList);
		
		JLabel lblNewLabel = new JLabel("\uC811\uC18D\uC790 \uD604\uD669");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(48, 24, 83, 25);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(181, 49, 481, 269);
		contentPane.add(scrollPane_1);
		
		logTA = new JTextArea();
		scrollPane_1.setViewportView(logTA);
		
		JLabel lblLog = new JLabel("SERVER LOG");
		lblLog.setHorizontalAlignment(SwingConstants.CENTER);
		lblLog.setBounds(329, 27, 160, 25);
		contentPane.add(lblLog);
		
		setVisible(true);
		
		
		/*************************/
		try{
			//BoardServer_Socket boardSocket = new BoardServer_Socket();
			BoardServer bs = new BoardServer();
			bs.start();
			
		}catch(Exception e){
			setLog("�����ӿ��� ��Ĺ ������ �����߻� : "+e.getMessage());
		}
		
		/*************************/
	}
	
	public void setLog(String log){
		logTA.append("["+new Date().toLocaleString()+"]  "+log+"\n");
	}
	
	public void setLine(){
		logTA.append("\n");
	}
	
	/*
	 * ���� ������ �����,, Ŭ���̾�Ʈ�� ������ �ش� Ŭ���̾�Ʈ���� ������ ����� ����..
	 */
	public class BoardServer extends Thread{
		//���� ����
		private ServerSocket serverSocket;
		
		private Socket socket;
		private ObjectOutputStream out;
		private ObjectInputStream in;
		
		private MessageDao msgDao;
		
		String id;
		
		public BoardServer() throws Exception{
			msgDao = new MessageDao();
		}
		
		public void run() {
			
			try{
				serverSocket = new ServerSocket(8880);
				setLog("���� ������ ����� Ŭ���̾�Ʈ�� ���ӿ�û�� ������ ���...");
				while(true){
					socket = serverSocket.accept();
					id = "["+socket.getInetAddress().getHostAddress()+" / "+socket.getPort()+"]";
					setLine();
					setLog(id+"����");
					/*
					 * � Ŭ���̾�Ʈ�κ��� ��û�� ������
					 * �� Ŭ���̾�Ʈ���� ������ �ش�.
					 * 
					 * ���� ���ÿ� �ΰ��� Ŭ���̾�Ʈ�κ��� ��û�� ���´ٸ� ��� �ǳ�?  
					 *  - �����°� ó���ϰ� ������ ó��..
					 */
					in = new ObjectInputStream(socket.getInputStream());
					Object data = in.readObject();
					
					
					
					out = new ObjectOutputStream(socket.getOutputStream());
					if(data instanceof String){
						String clientMsg = (String)data;
						setLog("String�� ���� : "+clientMsg);
						
						
						switch (clientMsg) {
						case "readMsg":
							ArrayList<MessageVO> msgList = msgDao.readData();
							out.writeObject(msgList);
							out.flush();
							
							setLog(id+"���� Msg�����͸� ��� ����");
							break;
						case "saveMsg":
							setLog(id+"�� ���� ���ο� Msg�����͸� ���� ���Ͽ� ����");
							
							break;

						default:
							setLog("�� �� ���� �޽����Դϴ�. : "+clientMsg);
							out.writeObject(new String("�� �� ���� �޽����Դϴ�."));
							out.flush();
							break;
						}
						
					}else{
						setLog("String �̿��� ��ü ����");
						if(data instanceof ArrayList){
							setLog(id+"�� ���� ���ο� Msg�����͸� ���� ���Ͽ� ����");
							out.writeObject(new String("���� ����"));
							out.flush();
						}
					}
					
					
				
					
					out.close();
					in.close();
					socket.close();
				}
			}catch(Exception e){
				setLog("�����߻� : "+e.getMessage());
				e.printStackTrace();
			}

		}
	}
	

	
	

}
