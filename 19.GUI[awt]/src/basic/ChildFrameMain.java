package basic;

public class ChildFrameMain {

	public static void main(String[] args) {
		ChildFrame cf = new ChildFrame();

		Thread t = new Thread(cf); // runnable 구현은 Thread객체를 새로 만들어서 실행한다..

		t.start();
		cf.colorChange();
	}

}
