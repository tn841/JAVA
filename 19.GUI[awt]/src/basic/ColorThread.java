package basic;

import java.awt.Color;

public class ColorThread extends Thread {
	private Color c;
	private ChildFrame cf;

	public ColorThread() {
		c = new Color(255, 255, 255);
	}

	public ColorThread(ChildFrame f) {
		cf = f;
		c = f.getBackground();
	}

	@Override
	public void run() {
		int r, g, b;
		boolean cflag = true; // true이면 값증가, false면 값감소

		while (true) {
			r = (c.getRed());
			g = (c.getGreen());
			b = (c.getBlue());
			if (r == 0) {
				cflag = !cflag;
			}
			if (cflag) {
				if (r == 255) {
					r = 250;
				} else {
					r = (r + 5) % 255;
				}
				// g = (c.getGreen()+1)%255;
				// b = (c.getBlue()+1)%255;
			} else {
				if (r > 0) {
					r = (r - 5) % 255;
				} else {
					r = 255;
				}

				// g = (c.getGreen()-1)%255;
				// b = (c.getBlue()-1)%255;
			}

			c = new Color(r, g, b);
			System.out.println(r);
			cf.setBackground(c);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void start(ChildFrame cf) {
		cf.setBackground(c);
		this.start();
	}
}
