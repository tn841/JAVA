import javax.swing.JFrame;


public class MainFrame {
	
	public static void main(String[] args) throws Exception {
		JFrame frame = new JFrame("Dots");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		MainPanel primary = new MainPanel();
		frame.getContentPane().add(primary);
	
		frame.setResizable(false);	//창크기 변경 안되게
		
		frame.pack();
		frame.setVisible(true);
	}

}
