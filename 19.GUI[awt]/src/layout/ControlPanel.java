package layout;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.Panel;

public class ControlPanel extends Panel{
	private NumberPanel numberP;
	private OptionPanel optionP;
	
	public ControlPanel(CalculatorFrame frame){
		numberP = new NumberPanel(frame);
		optionP = new OptionPanel(frame);
				
		this.setLayout(new GridLayout(2,0));
		
		
		this.add(optionP);
		this.add(numberP);
	}
}
