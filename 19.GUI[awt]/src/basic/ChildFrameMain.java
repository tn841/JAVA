package basic;

public class ChildFrameMain {

	public static void main(String[] args) {
		ChildFrame cf = new ChildFrame();

		Thread t = new Thread(cf); // runnable ������ Thread��ü�� ���� ���� �����Ѵ�..

		t.start();
		cf.colorChange();
	}

}
