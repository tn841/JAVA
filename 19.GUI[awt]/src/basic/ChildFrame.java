package basic;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;

public class ChildFrame extends Frame implements Runnable {

	private Button b1;

	public ChildFrame() {
		b1 = new Button(" ");
		setLayout(null);
		this.add(b1);
		b1.setBounds(50, 50, 50, 50);

		this.setSize(300, 400);
		this.setBackground(new Color(255, 155, 255));
		this.setVisible(true);

	}

	public void colorChange() {
		ColorThread ct = new ColorThread(this);
		ct.start();
	}

	@Override
	public void run() {
		int num = 0;
		while (true) {
			try {
				if (num % 3 == 0) {
					// this.setBackground(new Color(0, 255, 255));
				}
				if (num % 3 == 1) {
					// this.setBackground(new Color(255, 0, 255));
					// this.setSize(500,500);
				}
				if (num % 3 == 2) {
					// this.setBackground(new Color(255, 255, 0));
					// this.setSize(600,500);
				}
				num++;
				Dimension d = this.getSize();
				d.setSize(d.getWidth() + 2, d.getHeight() + 2);
				// this.setSize(d);

				b1.setBounds((int) (Math.random() * this.getSize().getWidth()),
						(int) (Math.random() * this.getSize().getHeight()), 50, 50);

				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
