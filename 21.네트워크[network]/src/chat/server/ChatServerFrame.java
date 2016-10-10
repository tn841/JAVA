package chat.server;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

/**
 * @author stu
 *
 */
public class ChatServerFrame extends JFrame {

	private JPanel contentPane;
	private JTextField chatTF;
	private ChatServerThread cst;
	private JTextArea chatTA;
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
		setTitle("Chat Server");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 323, 431);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		chatTF = new JTextField();
		chatTF.setBounds(5, 357, 295, 24);
		contentPane.add(chatTF);
		chatTF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String data = chatTF.getText();
				chatTF.setText("");
				if(data.trim().equals("")){
					JOptionPane.showMessageDialog(null, "내용을 입력하세요.");
					return;
				}
				System.out.println(data);
				
				chatTA.append("나 : "+data+"\n");
				
				cst.send(data);
				
			}
		});
		chatTF.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(5, 5, 295, 352);
		contentPane.add(scrollPane);
		
		chatTA = new JTextArea();
		scrollPane.setViewportView(chatTA);
		chatTA.setEditable(false);
		
		setVisible(true);
		chatTF.requestFocus();
		
		/***********쓰레드 시작************/
		cst = new ChatServerThread(this);
		cst.start();
		//서버 소캣은 생성되었고, 클라이언트가 소켓요청하면 소켓을 만들어서 전달후, 데이터가 들어올때까지 blocking
		/***********쓰레드 시작************/
	}

	public JTextArea getChatTA() {
		return chatTA;
	}

	public void setChatTA(JTextArea chatTA) {
		this.chatTA = chatTA;
	}

}
