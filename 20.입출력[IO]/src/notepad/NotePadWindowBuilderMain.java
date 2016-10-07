package notepad;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Color;

public class NotePadWindowBuilderMain extends JFrame {

	private JPanel contentPane;
	private JTextArea chatTA;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NotePadWindowBuilderMain frame = new NotePadWindowBuilderMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public NotePadWindowBuilderMain() {
		setTitle("\uC2EC\uD50C \uBA54\uBAA8\uC7A5");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		chatTA = new JTextArea();
		chatTA.setToolTipText("\uD234\uD301\uC785\uB2C8\uB2E4.");
		chatTA.setBackground(new Color(255, 182, 193));
		scrollPane.setViewportView(chatTA);
	}

}
