package event;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionEventHandler implements ActionListener{
	ActionEventFrame aEF;
	int count ;
	
	public ActionEventHandler() {
	
	}
	
	public ActionEventHandler(ActionEventFrame frame) {
		this.aEF = frame;
		count = 0;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		count++;
		aEF.setTitle("¥≠∑»¿Ω : "+count);
		aEF.setBackground(new Color((int)(Math.random()*255) ,(int)(Math.random()*255), (int)(Math.random()*255)));
		System.out.println(e.getSource()+Thread.currentThread().getName());
	}

}
