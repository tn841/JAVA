package layout;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.List;
import java.awt.Panel;

public class PanelJoin extends Panel{
	Button joinB,cancleB;
	List leftL;
	public PanelJoin() {
		setBackground(Color.ORANGE);
		
		joinB=new Button("∞°¿‘");
		cancleB=new Button("√Îº“");
		leftL=new List();
		
		leftL.add("√÷∞Ê≥‡");
		leftL.add("±Ë¿∫»Ò");
		leftL.add("Ω≈∏Ìº˜");
		
		setLayout(new BorderLayout());
		add(joinB,BorderLayout.SOUTH);
		add(cancleB,BorderLayout.NORTH);
		add(leftL, BorderLayout.WEST);
		
	}
}
