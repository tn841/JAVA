package layout;

import java.awt.Button;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OptionPanel extends Panel{
	private Button btnBackSpace;
	private Button btnClear;
	private Button btnPM;
	private Button btnEqual;
	private Button btnOpenBracket;
	private Button btnCloseBracket;
	
	private CalculatorFrame frame;
	//private Button btn
	
	
	public OptionPanel(CalculatorFrame frame){
		this.frame = frame;
		
		btnBackSpace = new Button("<-");
		btnClear = new Button("CLEAR");
		btnPM = new Button("+/-");
		btnEqual = new Button("=");
		btnEqual.setActionCommand("equal");	//actionCommand를 붙여 줄 수 있다.
		
		btnOpenBracket = new Button("(");
		btnCloseBracket = new Button(")");
		
		LayoutManager mgr = new GridLayout(0, 6);
		this.setLayout(mgr);
		
		OptionBtnHandler optionBtnH = new OptionBtnHandler();
		btnBackSpace.addActionListener(optionBtnH);
		btnClear.addActionListener(optionBtnH);
		btnPM.addActionListener(optionBtnH);
		btnEqual.addActionListener(optionBtnH);
		btnCloseBracket.addActionListener(optionBtnH);
		btnOpenBracket.addActionListener(optionBtnH);
		
		this.add(btnBackSpace);
		this.add(btnClear);
		this.add(btnPM);
		this.add(btnEqual);
		this.add(btnOpenBracket);
		this.add(btnCloseBracket);
		
	}
	
	class OptionBtnHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource().equals(btnBackSpace)){
				System.out.println("<-");
				frame.getResultTA().append("<-");
			}
			else if(e.getSource().equals(btnClear)){
				System.out.println("Clear");
				
			}
			else if(e.getSource().equals(btnPM)){
				System.out.println("+/-");
				
			}
			else if(e.getSource().equals(btnEqual)){
				System.out.println("=");
				
			}
			else if(e.getSource().equals(btnOpenBracket)){
				frame.getResultTA().append("(");
			}
			else if(e.getSource().equals(btnCloseBracket)){
				frame.getResultTA().append(")");
			}
			
		}
		
	}
}
