import javax.swing.JOptionPane;

public class ControlSleepMain {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.out.println("1. main");
		
		for (int i = 0; i < 3; i++) {
			System.out.println((3-i)+"ÃÊ");
			Thread.sleep(1000);
		}
		
		ControlSleepClockThread csct = new ControlSleepClockThread();
		csct.start();
		
		
		
		System.out.println("2. main");
		JOptionPane.showMessageDialog(null, "3. main´ë±â");
		csct.setPlay(false);
		System.out.println("4. main return");
		
	}

}
