package multi_chat.client;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.StringTokenizer;

import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import multi_chat.common.ChatProtocol;

public class ChatClientFrame extends JFrame {

	private JPanel contentPane;
	private JTextArea chatTA;
	private JTextField chatTF;
	private ClientSocket cct;
	private JScrollPane scrollPane;
	private JList clientList;
	private Object seletedList;
	private JPanel panel;
	private JButton popupBtn;


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
		setBounds(100, 100, 527, 467);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
				contentPane.setLayout(null);
				
				popupBtn = new JButton("\uADD3\uC18D\uB9D0");
				popupBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JList temp = (JList)seletedList;
						
						
					}
				});
				popupBtn.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseExited(MouseEvent e) {
						popupBtn.setVisible(false);
					}
				});
				popupBtn.setBounds(0, 0, 89, 34);
				popupBtn.setVisible(false);
				contentPane.add(popupBtn);
				
				panel = new JPanel();
				panel.setBounds(0, 0, 509, 419);
				contentPane.add(panel);
				panel.setLayout(new BorderLayout(0, 0));
				
				scrollPane = new JScrollPane();
				panel.add(scrollPane, BorderLayout.CENTER);
				
				chatTA = new JTextArea();
				chatTA.setEditable(false);
				scrollPane.setViewportView(chatTA);
				
				clientList = new JList();
				panel.add(clientList, BorderLayout.WEST);
				clientList.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						
						if(e.getButton() == 3){
		
							System.out.println("클릭!");
							popupBtn.setBounds(e.getX(), e.getY(), 100, 30);
							popupBtn.setVisible(true);
							System.out.println(e.getSource());
							seletedList = e.getSource();
							JList temp = (JList)seletedList;
							System.out.println(temp.getName());
						}
					}
					
				});
				clientList.setFont(new Font("돋움", Font.PLAIN, 14));
				
				chatTF = new JTextField();
				panel.add(chatTF, BorderLayout.SOUTH);
				chatTF.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String data = chatTF.getText();
						chatTF.setText("");
						if(data.trim().equals("")){
							JOptionPane.showMessageDialog(null, "내용을 입력하세요.");
						}
						
						//chatTA.append("나 : "+data+"\n");
						
						try {
							cct.send(ChatProtocol.PLAIN_MESSAGE+"|"+data);
						} catch (Exception e1) {
							throw new RuntimeException(e1.getMessage());
							//생략된 RuntimeException을 상속받아 예외를 던진다.
						}
					
					}
				});
				chatTF.setColumns(10);
				chatTF.requestFocus();
				
				
		
		setVisible(true);
		
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
						chatTA.append("- "+data+"\n");
						break;
					case "1":
						System.out.println(data);
						String[] dataArr = data.split("#");
						for (int i = 0; i < dataArr.length; i++) {
							clientList.setModel(new AbstractListModel() {
								String[] values = dataArr;
								public int getSize() {
									return values.length;
								}
								public Object getElementAt(int index) {
									return values[index];
								}
							});
						}
						break;
					case "2":
						//scsManger.sendWhisper();
						break;

					default:
						break;
					}
					
					
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
}
