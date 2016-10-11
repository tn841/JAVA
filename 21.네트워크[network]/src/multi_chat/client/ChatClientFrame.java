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
					JOptionPane.showMessageDialog(null, "������ �Է��ϼ���.");
				}
				
				//chatTA.append("�� : "+data+"\n");
				
				try {
					cct.send(data);
				} catch (Exception e1) {
					throw new RuntimeException(e1.getMessage());
					//������ RuntimeException�� ��ӹ޾� ���ܸ� ������.
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
	 *  - Ŭ���̾�Ʈ ������ �������ִ� ������ ��ü
	 *  - Ŭ���̾�Ʈ�� ������ ����ؼ� ������ ����, ������ ���� ������ Ŭ���� 
	 *  - ������ Ư�� Server_ClientSocket ��ü�� ����ϴ� ������ Ŭ����
	 */
	public class ClientSocket extends Thread{
		private Socket socket;
		private DataInputStream in;	//�������κ��� �����͸� ���� ��Ʈ��
		private DataOutputStream out;	//���Ͽ� �����͸� �� ��Ʈ��
		private String id;
		
		public ClientSocket(){
						
		}
		
		@Override
		public void run() {
			try {
				//Ŭ���̾�Ʈ ��Ĺ ����	
				socket=new Socket("192.168.12.12", 8888);
				id = socket.getInetAddress().getHostAddress()+"["+socket.getLocalPort()+"]";
				//������ �а� ���� ��Ʈ�� ����
				in = new DataInputStream(socket.getInputStream());
				out = new DataOutputStream(socket.getOutputStream());
				
				while(true){
					//������ ���� ������ �б�(�ö����� ���, blocking �ȴ�.)
					String readStr = in.readUTF();
					
					//������ ������ ���� -> UI���� ó��
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
