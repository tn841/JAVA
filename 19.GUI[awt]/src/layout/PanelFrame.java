package layout;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextField;

public class PanelFrame extends Frame {
	Panel southP;
	TextField southTF;
	Button southB;
	
	PanelJoin joinP;
	
	public PanelFrame() {
		southTF=new TextField(25);
		southB=new Button("Àü¼Û");
		
		southP=new Panel();
		southP.setBackground(Color.PINK);
		southP.setLayout(new FlowLayout());
		southP.add(southTF);
		southP.add(southB);
		
		joinP=new PanelJoin();
		
		
		this.setLayout(new BorderLayout());
		this.add(southP,BorderLayout.SOUTH);
		this.add(joinP, BorderLayout.CENTER);
		
		setSize(300, 400);
		setVisible(true);
		
	}

	public static void main(String[] args) {
		new PanelFrame();
	}

}
