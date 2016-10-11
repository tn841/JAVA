package client;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] arg) {
		
		JFrame frame = new JFrame("FTP_Client"); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ClientComponent primary = new ClientComponent();  

		frame.getContentPane().add(primary);  
		
		frame.pack();
		frame.setVisible(true);
		frame.setResizable(false);
	}
}