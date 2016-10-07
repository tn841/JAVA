import javax.swing.JOptionPane;

public class ControlStopMain {

	public static void main(String[] args) {
		System.out.println("1. main");
		
		ControlStopThread cst = new ControlStopThread();
		cst.start();
		
		JOptionPane.showMessageDialog(null, "1. Thread.stop()");
		cst.stop();
		
		ControlUpperThread ut = new ControlUpperThread();
		ControlLowerThread lt = new ControlLowerThread();
		ut.start();
		lt.start();
		
		JOptionPane.showMessageDialog(null, "2. Thread,stop()");
		ut.stop();
		lt.stop();
		
		
		System.out.println("99. main");
	}

}
