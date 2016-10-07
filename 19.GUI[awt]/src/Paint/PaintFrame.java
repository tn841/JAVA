package Paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class PaintFrame extends JFrame{
	
	
	
	
	public PaintFrame(){
		setSize(400,700);
		setVisible(true);
	}
	
	@Override
	public void paint(Graphics g) {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image penguinBack = toolkit.getImage("penguin_back.jpg");
		g.drawImage(penguinBack, 0, 0, this.getWidth(), getHeight(), this);
		//super.paint(g);
		System.out.println(Thread.currentThread().getName());
		
		g.drawString("문자 그리기", 50, 50);
		g.fillRect(50, 100, 50, 50);
		g.drawRect(50, 150, 50, 50);
		g.draw3DRect(50, 200, 50, 50, true);
		
		g.setColor(Color.red);
		g.drawOval(getWidth()/2, getHeight()/2, 150, 150);
		
		
		
		Image penguin1 = toolkit.getImage("penguin1.gif");
		Image penguin2 = toolkit.getImage("penguin2.gif");
		Image penguin3 = toolkit.getImage("penguin3.gif");
		
		g.drawImage(penguin1, 30, 350, this);
		g.drawImage(penguin2, 90, 350, this);
		g.drawImage(penguin3, 150, 350, this);
	}
	
	
	public static void main(String[] arg){
		new PaintFrame();
	}

}
