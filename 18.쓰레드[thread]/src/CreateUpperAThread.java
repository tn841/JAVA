
public class CreateUpperAThread extends Thread {
	@Override
	public void run() {
		try {
			while (true) {
				Thread.sleep(100);
				System.out.print("A");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
