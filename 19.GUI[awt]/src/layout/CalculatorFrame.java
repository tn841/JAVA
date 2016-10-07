package layout;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.LayoutManager;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorFrame extends Frame{
	private ControlPanel controlP;
	
	private Panel resultP;
	private TextField resultTF;
	private TextArea resultTA;
	
	
	public TextArea getResultTA() {
		return resultTA;
	}




	public void setResultTA(TextArea resultTA) {
		this.resultTA = resultTA;
	}




	public CalculatorFrame() {
		
		
		resultP = new Panel();
		resultTF = new TextField();
		resultTA = new TextArea(2, 1);
		controlP = new ControlPanel(this);
		
		LayoutManager mgr = new BorderLayout();
		this.setLayout(mgr);
		
		//°á°ú 
		this.add(resultTA,BorderLayout.NORTH);
		
		
		
		
		this.setTitle("GUI Calculator");
		this.setSize(300,300);
		this.setVisible(true);
		
	//	this.add(optionP,BorderLayout.CENTER);
	//	this.add(numberP,BorderLayout.CENTER);
		this.add(controlP);
	}
	
	
	
	
	public static void main(String[] args) {
		new CalculatorFrame(); 
	}

}
