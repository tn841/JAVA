package com.itwill.cafe.server;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.itwill.cafe.board.Board;

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
		logTA.append(log+"\n");
	}
	
	/*
	 * ���� ������ �����,, Ŭ���̾�Ʈ�� ������ �ش� Ŭ���̾�Ʈ���� ������ ����� ����..
	 */
	public class BoardServer extends Thread{
		
		public void run() {
			try{
				while(true){
					ServerSocket serverSocket = new ServerSocket(8888);
					setLog("���� ������ ����� Ŭ���̾�Ʈ�� ���ӿ�û�� ������ ���...");
					Socket socket = serverSocket.accept();
					BoardServer_Socket clientSocket = new BoardServer_Socket(socket);
					clientSocket.start();
				}
			}catch(Exception e){
				
			}

		}
	}
	
		
	public class BoardServer_Socket extends Thread{
		private ObjectInputStream in;
		private ObjectOutputStream out;
		private Socket socket;
		private BoardServerDao bsDao;
		private Object data;
	
		
		public BoardServer_Socket(Socket s) throws Exception{
			socket = s;
			setLog(socket.getRemoteSocketAddress()+"�� ��Ĺ ���� : "+socket);	
			bsDao = new BoardServerDao();
		}
		
		@Override
		public void run() {
			try {
				while(true){
					
					setLog("�б� �����...");
					in = new ObjectInputStream(socket.getInputStream());
					data = in.readObject();
					setLog("���� ������ : "+data.toString());
					if(data instanceof String){
						String temp = (String)data;
						setLog("Ŭ���̾�Ʈ���� ��ü ������ send");
						send();
					}else{			
						setLog("���� ���Ͽ� ���� �۾� ����.. ���� �������� ���� : "+data.getClass().getName());
						bsDao.saveData((ArrayList<Board>)data);
						in.close();
					}
				}
				
			} catch (Exception e) {
				setLog("InSocket���� : "+e.getMessage());
			}
		}//run()
		
		public void send() throws Exception{
			ArrayList<Board> list = bsDao.readData();
			out = new ObjectOutputStream(socket.getOutputStream());
			out.writeObject(list);
			out.flush();
		}
		
	
		

		
	}//BoardServer_InSocket
	
	

}
