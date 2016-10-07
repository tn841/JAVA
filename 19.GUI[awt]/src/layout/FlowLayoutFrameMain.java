package layout;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.LayoutManager;

public class FlowLayoutFrameMain extends Frame {
	private Button b1, b2, b3, b4, b5;

	public FlowLayoutFrameMain() {
		/*
		 * ��ġ������ ����
		 */
		LayoutManager mgr = new FlowLayout();
		setLayout(mgr);

		// ������Ʈ �غ�
		b1 = new Button("First");
		b2 = new Button("Second");
		b3 = new Button("Third");
		b4 = new Button("Fourth");
		b5 = new Button("Fifth");

		// �����̳ʿ� �߰�
		this.add(b1);
		this.add(b2);
		this.add(b3);
		this.add(b4);
		this.add(b5);

		// �����̳� ������ �� visible ����
		setSize(200, 400);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new FlowLayoutFrameMain();
	}

}
