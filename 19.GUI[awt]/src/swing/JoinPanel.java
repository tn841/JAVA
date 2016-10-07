package swing;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class JoinPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Create the panel.
	 */
	public JoinPanel() {
		setLayout(null);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(105, 49, 62, 18);
		add(lblId);
		
		JLabel lblPw = new JLabel("PW");
		lblPw.setBounds(105, 96, 62, 18);
		add(lblPw);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(105, 149, 62, 18);
		add(lblName);
		
		textField = new JTextField();
		textField.setBounds(209, 46, 116, 24);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(209, 93, 116, 24);
		add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(209, 146, 116, 24);
		add(textField_2);
		textField_2.setColumns(10);
		
		JButton button = new JButton("\uAC00\uC785");
		button.setBounds(93, 214, 105, 27);
		add(button);
		
		JButton btnNewButton = new JButton("\uCDE8\uC18C");
		btnNewButton.setBounds(230, 214, 105, 27);
		add(btnNewButton);

	}
}
