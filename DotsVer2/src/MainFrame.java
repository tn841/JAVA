import javax.swing.JFrame;


public class MainFrame {
	
	public static void main(String[] args) throws Exception {
		JFrame frame = new JFrame("Dots");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		MainPanel primary = new MainPanel();
		frame.getContentPane().add(primary);
	
		frame.setResizable(false);	//âũ�� ���� �ȵǰ�
		
		frame.pack();
		frame.setVisible(true);
	}

}
