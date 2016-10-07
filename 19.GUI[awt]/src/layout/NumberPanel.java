package layout;

import java.awt.Button;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumberPanel extends Panel{
	private Button[] btnNum;
	private CalculatorFrame frame;
	
	public NumberPanel(CalculatorFrame frame) {
		this.frame = frame;
		
		btnNum = new Button[10];
		NumberBtnHandler numberBtnHandler = new NumberBtnHandler();
		for (int i = 0; i < btnNum.length; i++) {
			btnNum[i] = new Button(Integer.toString( (i+1)%10 ));
			btnNum[i].setActionCommand(Integer.toString( (i+1)%10 ));
			this.add(btnNum[i]);
			btnNum[i].addActionListener(numberBtnHandler);
		}
		
		this.setBackground(Color.gray);
		
		this.setLayout(new GridLayout(0, 3));
	}
	
	class NumberBtnHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			for(int i =0; i< 10 ; i++){
				if(e.getSource().equals(btnNum[i])){
					frame.getResultTA().append(e.getActionCommand());;
					
				}
			}
		}
	}
}
