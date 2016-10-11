package multi_chat.client;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.awt.event.ActionEvent;

public class ChatClientFrame extends JFrame {

	private JPanel contentPane;
	private JTextArea chatTA;
	private JTextField chatTF;
	private ClientSocket cct;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChatClientFrame frame = new ChatClientFrame();
				
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ChatClientFrame() {
		setTitle("\uCC44\uD305\uD074\uB77C\uC774\uC5B8\uD2B8");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 331, 464);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		chatTA = new JTextArea();
		chatTA.setEditable(false);
		scrollPane.setViewportView(chatTA);
		
		chatTF = new JTextField();
		chatTF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String data = chatTF.getText();
				chatTF.setText("");
				if(data.trim().equals("")){
					JOptionPane.showMessageDialog(null, "내용을 입력하세요.");
				}
				
				//chatTA.append("나 : "+data+"\n");
				
				try {
					cct.send(data);
				} catch (Exception e1) {
					throw new RuntimeException(e1.getMessage());
					//생략된 RuntimeException을 상속받아 예외를 던진다.
				}
			
			}
		});
		contentPane.add(chatTF, BorderLayout.SOUTH);
		chatTF.setColumns(10);
		
		setVisible(true);
		chatTF.requestFocus();
		
		cct = new ClientSocket();
		cct.start();
				
	}
	
	/***********************ChatClientThread inner Class***************************/
	/*
	 *  - 클라이언트 소켓을 가지고있는 쓰레드 객체
	 *  - 클라이언트의 소켓을 사용해서 데이터 전송, 수신을 위한 쓰레드 클래스 
	 *  - 서버의 특정 Server_ClientSocket 객체와 통신하는 쓰레드 클래스
	 */
	public class ClientSocket extends Thread{
		private Socket socket;
		private DataInputStream in;	//소켓으로부터 데이터를 읽을 스트림
		private DataOutputStream out;	//소켓에 데이터를 쓸 스트림
		private String id;
		
		public ClientSocket(){
						
		}
		
		@Override
		public void run() {
			try {
				//클라이언트 소캣 생성	
				socket=new Socket("192.168.12.12", 8888);
				id = socket.getInetAddress().getHostAddress()+"["+socket.getLocalPort()+"]";
				//데이터 읽고 쓰는 스트림 연결
				in = new DataInputStream(socket.getInputStream());
				out = new DataOutputStream(socket.getOutputStream());
				
				while(true){
					//서버로 부터 데이터 읽기(올때까지 대기, blocking 된다.)
					String readStr = in.readUTF();
					
					//서버에 데이터 쓰기 -> UI에서 처리
					chatTA.append("- "+readStr+"\n");
					scrollPane.getVerticalScrollBar().setValue(scrollPane.getVerticalScrollBar().getMaximum());
				}	
			} catch (Exception e) {
				chatTA.append("<Error> "+e.getMessage());
			}
		}//run()
	
		public void send(String data) throws Exception {
			out.writeUTF(data);
			out.flush();
		}
		
	}

	/**************************************************/



}
