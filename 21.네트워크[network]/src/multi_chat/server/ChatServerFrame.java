package multi_chat.server;

import java.awt.Font;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.StringTokenizer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import multi_chat.common.ChatProtocol;

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
		chatTA.setFont(new Font("돋움", Font.BOLD, 13));
		chatTA.setEditable(false);
		scrollPane.setViewportView(chatTA);

		setVisible(true);
		
		
		ChatServerThread cst = new ChatServerThread();
		cst.start();
		
		/*
		 * Server_ClientSocketManager 객체생성
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
	 * - 이너클래스 형식으로 서버 쓰레드 클래스를 정의 
	 * - 서버쓰레드는 특정 포트를 열고 클라이언트의 소켓접속요청을 기다리면 Blocking한다.
	 */
	public class ChatServerThread extends Thread{
		
		public void run() {
			try{
				ServerSocket serverSocket = new ServerSocket(8888);
				while(true){
					setLog("<Server> : Info : "+serverSocket.toString());
					setLog("<Server> : serverSocket.accept()... server is blocking...");
					Socket socket = serverSocket.accept();	//blocking, 요청이오면 클라이언트 소켓을 만듦
					Server_ClientSocket clientS = new Server_ClientSocket(socket);	//ClientSocket객체 생성
					clientS.start();
					scsManger.addClientSocket(clientS);	//매니저에 추가
				}
			}catch(Exception e){
				setLog("Error : "+e.getMessage());
			}
		}
	}//ChatServerThread
	/*********************** ChatServer Thread Class**************************/
	
	
	
	/*********************** ServerClientSocket Class **************************/
	/*
	 * - 하나의 클라이언트와의 통신을 담당(처리)하는 쓰레드 객체. 
	 * - 클라이언트의 소켓1개를 가지고 있는 객체
	 * - 클라이언트의 정보를 가지고 있는 객체
	 * - 클라이언트 당 1개씩 생성
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
					setLog("<Server> "+id+"로 부터 데이터를 읽기위해 대기... Blocking...");
					String readData = in.readUTF();
					
					
					StringTokenizer st = new StringTokenizer(readData, "|");
					String protocol = st.nextToken();
					String data = st.nextToken();
					/*
					 * 0|안녕
					 * 1|id1#id2#id3
					 * 2|id#안녕
					 */
					switch (protocol) {
					case "0":
						scsManger.sendBrodcasting(ChatProtocol.PLAIN_MESSAGE+"|"+data);	//매니저를 이용해 모든 클라이언트에게 전송
						setLog("<Server> "+id+"로 부터 읽은 데이터 : "+data);
						break;
					case "1":
						//scsManger.sendList();
						break;
					case "2":
						//scsManger.sendWhisper();
						break;

					default:
						break;
					}
					
				}
			}catch(Exception e){
				setEmptyLine();
				setLog("<Server> "+socket.getInetAddress().getHostName()+" 소켓 제거");
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
	 * ServerClientSocket 객체 추가, 삭제, 브로드캐스팅, 찾기
	 */
	public class Server_ClientSocketMananger{
		private ArrayList<Server_ClientSocket> clientSocketList;
		
		public Server_ClientSocketMananger(){
			this.clientSocketList = new ArrayList<Server_ClientSocket>();
		}
		

		/*
		 * ClientSocket객체 추가
		 */
		public void addClientSocket(Server_ClientSocket clientSocket) throws Exception{
			clientSocketList.add(clientSocket);
			//모든 클라이언트에 메시지 전송			
			scsManger.sendBrodcasting(ChatProtocol.PLAIN_MESSAGE+"|"+clientSocket.id+"님 입장");
			
			//모든 클라이언트에 접속자 리스트 전송
			scsManger.sendClientList();
			
			setEmptyLine();
			setLog("<Server Manager> "+clientSocket.id+"에서 새로 들어왔습니다. 접속자 수 :"+clientSocketList.size());
		}
		
		
		/*
		 * ClientSocket객체 삭제
		 */
		public void removeClientSocket(Server_ClientSocket clientSocket) throws Exception {
			clientSocketList.remove(clientSocket);
			scsManger.sendBrodcasting(ChatProtocol.PLAIN_MESSAGE+"|"+clientSocket.id+"님 퇴장");
			setLog("<Server Manager> 현재 접속자 수 :"+clientSocketList.size());
			
			//모든 클라이언트에 접속자 리스트 전송
			scsManger.sendClientList();
		}
		
		/*
		 * 연결된 모든 ClientSocket객체들에게 브로드캐스팅
		 */
		public void sendBrodcasting(String sendData) throws Exception{
			for (Server_ClientSocket clientSocket : clientSocketList) {
				clientSocket.send(sendData);
			}
		}
		
		
		/*
		 * 연결된 모든 클라이언트에게 접속자 리스트 ㅓㄴ송
		 */
		public void sendClientList() throws Exception{
			//1|id1#id2#id3
			
			String clientList = "";
			for (int i = 0; i < clientSocketList.size(); i++) {
				Server_ClientSocket scs = clientSocketList.get(i);
				
				clientList = clientList+scs.id;
				if(i != clientSocketList.size()-1){
					clientList = clientList+"#";
				}

			}
			clientList = "1|"+clientList;
			sendBrodcasting(clientList);
		}
		
	}//Server_ClientSocketMananger
	/************************ Server_ClientSocketMananger *********************/
	
}
