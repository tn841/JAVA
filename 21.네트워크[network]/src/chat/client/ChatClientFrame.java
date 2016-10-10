package chat.client;

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
import java.awt.event.ActionEvent;

public class ChatClientFrame extends JFrame {

	private JPanel contentPane;
	private JTextArea chatTA;
	private JTextField chatTF;
	private ChatClientThread cct;

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
		
		JScrollPane scrollPane = new JScrollPane();
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
				
				chatTA.append("나 : "+data+"\n");
				
				cct.send(data);
			
			}
		});
		contentPane.add(chatTF, BorderLayout.SOUTH);
		chatTF.setColumns(10);
		
		setVisible(true);
		chatTF.requestFocus();
		
		cct = new ChatClientThread(this);
		cct.start();
				
	}

	public JTextField getChatTF() {
		return chatTF;
	}

	public JTextArea getChatTA() {
		return chatTA;
	}

	public void setChatTA(JTextArea chatTA) {
		this.chatTA = chatTA;
	}

	public void setChatTF(JTextField chatTF) {
		this.chatTF = chatTF;
	}

}
