package layout;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.LayoutManager;

public class BorderLayoutFrameMain extends Frame {
	private Button b1, b2, b3, b4, b5;

	public BorderLayoutFrameMain() {

		LayoutManager mgr = new BorderLayout();
		this.setLayout(mgr);

		b1 = new Button("SOUTH");
		b2 = new Button("NORTH");
		b3 = new Button("EAST");
		b4 = new Button("WEST");
		b5 = new Button("CENTER");

		this.add(b1, BorderLayout.SOUTH);
		this.add(b2, BorderLayout.NORTH);
		this.add(b3, BorderLayout.EAST);
		this.add(b4, BorderLayout.WEST);
		this.add(b5, BorderLayout.CENTER);

		this.setSize(300, 400);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new BorderLayoutFrameMain();
	}

}
