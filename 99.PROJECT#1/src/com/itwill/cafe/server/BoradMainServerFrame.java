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
			setLog("프레임에서 소캣 생성중 에러발생 : "+e.getMessage());
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
	 * 서버 소켓을 만들고,, 클라이언트가 들어오면 해당 클라이언트에게 소켓을 만들어 전달..
	 */
	public class BoardServer extends Thread{
		//서버 소켓
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
				setLog("서버 소켓을 만들고 클라이언트의 접속요청올 때까지 대기...");
				while(true){
					socket = serverSocket.accept();
					id = "["+socket.getInetAddress().getHostAddress()+" / "+socket.getPort()+"]";
					setLine();
					setLog(id+"접속");
					/*
					 * 어떤 클라이언트로부터 요청이 들어오면
					 * 그 클라이언트에게 소켓을 준다.
					 * 
					 * 만약 동시에 두개의 클라이언트로부터 요청이 들어온다면 어떻게 되나?  
					 *  - 먼저온거 처리하고 다음꺼 처리..
					 */
					in = new ObjectInputStream(socket.getInputStream());
					Object data = in.readObject();
					
					
					
					out = new ObjectOutputStream(socket.getOutputStream());
					if(data instanceof String){
						String clientMsg = (String)data;
						setLog("String을 받음 : "+clientMsg);
						
						
						switch (clientMsg) {
						case "readMsg":
							ArrayList<MessageVO> msgList = msgDao.readData();
							out.writeObject(msgList);
							out.flush();
							
							setLog(id+"에게 Msg데이터를 모두 전송");
							break;
						case "saveMsg":
							setLog(id+"가 보낸 새로운 Msg데이터를 서버 파일에 저장");
							
							break;

						default:
							setLog("알 수 없는 메시지입니다. : "+clientMsg);
							out.writeObject(new String("알 수 없는 메시지입니다."));
							out.flush();
							break;
						}
						
					}else{
						setLog("String 이외의 객체 받음");
						if(data instanceof ArrayList){
							setLog(id+"가 보낸 새로운 Msg데이터를 서버 파일에 저장");
							out.writeObject(new String("저장 성공"));
							out.flush();
						}
					}
					
					
				
					
					out.close();
					in.close();
					socket.close();
				}
			}catch(Exception e){
				setLog("오류발생 : "+e.getMessage());
				e.printStackTrace();
			}

		}
	}
	

	
	

}
