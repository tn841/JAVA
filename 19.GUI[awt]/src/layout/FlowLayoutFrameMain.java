package layout;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.LayoutManager;

public class FlowLayoutFrameMain extends Frame {
	private Button b1, b2, b3, b4, b5;

	public FlowLayoutFrameMain() {
		/*
		 * 배치관리자 설정
		 */
		LayoutManager mgr = new FlowLayout();
		setLayout(mgr);

		// 컴포넌트 준비
		b1 = new Button("First");
		b2 = new Button("Second");
		b3 = new Button("Third");
		b4 = new Button("Fourth");
		b5 = new Button("Fifth");

		// 컨테이너에 추가
		this.add(b1);
		this.add(b2);
		this.add(b3);
		this.add(b4);
		this.add(b5);

		// 컨테이너 사이즈 및 visible 설정
		setSize(200, 400);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new FlowLayoutFrameMain();
	}

}
