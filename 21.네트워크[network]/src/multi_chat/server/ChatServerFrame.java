package multi_chat.server;

import java.awt.Font;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;

public class ChatServerFrame extends JFrame {

	private JPanel contentPane;
	private JTextArea chatTA;
	private Server_ClientSocketMananger scsManger;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		ChatServerFrame frame = new ChatServerFrame();

	}

	/**
	 * Create the frame.
	 */
	public ChatServerFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 691, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		scrollPane = new JScrollPane();
		contentPane.add(scrollPane);

		chatTA = new JTextArea();
		chatTA.setFont(new Font("����", Font.BOLD, 13));
		chatTA.setEditable(false);
		scrollPane.setViewportView(chatTA);

		setVisible(true);
		
		
		ChatServerThread cst = new ChatServerThread();
		cst.start();
		
		/*
		 * Server_ClientSocketManager ��ü����
		 */
		scsManger = new Server_ClientSocketMananger();
	}
	
	public void setLog(String log){
		chatTA.append("["+new Date().toLocaleString()+"]  "+log+"\n");
		scrollPane.getVerticalScrollBar().setValue(scrollPane.getVerticalScrollBar().getMaximum());
	}
	
	public void setEmptyLine(){
		chatTA.append("\n");
	}

	/*********************** ChatServer Thread Class**************************/
	/*
	 * - �̳�Ŭ���� �������� ���� ������ Ŭ������ ���� 
	 * - ����������� Ư�� ��Ʈ�� ���� Ŭ���̾�Ʈ�� �������ӿ�û�� ��ٸ��� Blocking�Ѵ�.
	 */
	public class ChatServerThread extends Thread{
		
		public void run() {
			try{
				ServerSocket serverSocket = new ServerSocket(8888);
				while(true){
					setLog("<Server> : Info : "+serverSocket.toString());
					setLog("<Server> : serverSocket.accept()... server is blocking...");
					Socket socket = serverSocket.accept();	//blocking, ��û�̿��� Ŭ���̾�Ʈ ������ ����
					Server_ClientSocket clientS = new Server_ClientSocket(socket);	//ClientSocket��ü ����
					clientS.start();
					scsManger.addClientSocket(clientS);	//�Ŵ����� �߰�
				}
			}catch(Exception e){
				setLog("Error : "+e.getMessage());
			}
		}
	}//ChatServerThread
	/*********************** ChatServer Thread Class**************************/
	
	
	
	/*********************** ServerClientSocket Class **************************/
	/*
	 * - �ϳ��� Ŭ���̾�Ʈ���� ����� ���(ó��)�ϴ� ������ ��ü. 
	 * - Ŭ���̾�Ʈ�� ����1���� ������ �ִ� ��ü
	 * - Ŭ���̾�Ʈ�� ������ ������ �ִ� ��ü
	 * - Ŭ���̾�Ʈ �� 1���� ����
	 */
	public class Server_ClientSocket extends Thread{
		Socket socket;
		DataOutputStream out;
		DataInputStream in;
		String id;
		//Server_ClientSocketMananger scsManager;
		
		public Server_ClientSocket(Socket s) throws Exception{
			this.socket = s;
			out = new DataOutputStream(socket.getOutputStream());
			in = new DataInputStream(socket.getInputStream());
			id = socket.getInetAddress().getHostAddress()+"["+socket.getPort()+"]";
		}
		
		public void run() {
			try{
				while(true){
					/*
					 * 
					 */
					setLog("<Server> "+id+"�� ���� �����͸� �б����� ���... Blocking...");
					String readData = in.readUTF();
					scsManger.sendBrodcasting(readData);	//�Ŵ����� �̿��� ��� Ŭ���̾�Ʈ���� ����
					setLog("<Server> "+id+"�� ���� ���� ������ : "+readData);
				}
			}catch(Exception e){
				setEmptyLine();
				setLog("<Server> "+socket.getInetAddress().getHostName()+" ���� ����");
				try {
					scsManger.removeClientSocket(this);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		
		public void send(String sendData) throws Exception{
			out.writeUTF(sendData);
			out.flush();
		}
		
	}//Server_ClientSocket
	/*********************** ServerClientSocket Class **************************/
	
	
	
	/************************ Server_ClientSocketMananger *********************/
	/*
	 * ServerClientSocket ��ü �߰�, ����, ��ε�ĳ����, ã��
	 */
	public class Server_ClientSocketMananger{
		private ArrayList<Server_ClientSocket> clientSocketList;
		
		public Server_ClientSocketMananger(){
			this.clientSocketList = new ArrayList<Server_ClientSocket>();
		}
		

		/*
		 * ClientSocket��ü �߰�
		 */
		public void addClientSocket(Server_ClientSocket clientSocket) throws Exception{
			clientSocketList.add(clientSocket);
			scsManger.sendBrodcasting(clientSocket.id+"�� ����");
			setEmptyLine();
			setLog("<Server Manager> "+clientSocket.id+"���� ���� ���Խ��ϴ�. ������ �� :"+clientSocketList.size());
		}
		
		
		/*
		 * ClientSocket��ü ����
		 */
		public void removeClientSocket(Server_ClientSocket clientSocket) throws Exception {
			clientSocketList.remove(clientSocket);
			scsManger.sendBrodcasting(clientSocket.id+"�� ����");
			setLog("<Server Manager> ���� ������ �� :"+clientSocketList.size());
		}
		
		/*
		 * ����� ��� ClientSocket��ü�鿡�� ��ε�ĳ����
		 */
		public void sendBrodcasting(String sendData) throws Exception{
			for (Server_ClientSocket clientSocket : clientSocketList) {
				clientSocket.send(sendData);
			}
		}
		
		
		/*
		 * 
		 */
		
	}//Server_ClientSocketMananger
	/************************ Server_ClientSocketMananger *********************/
	
}
