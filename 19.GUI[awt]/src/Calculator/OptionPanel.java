package Calculator;

import java.awt.Button;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

public class OptionPanel extends Panel{
	private Button btnBackSpace;
	private Button btnClear;
	private Button btnPlus;
	private Button btnSub;
	private Button btnMulti;
	private Button btnDiv;
	private Button btnOpenBracket;
	private Button btnCloseBracket;
	
	private CalculatorFrame frame;
	//private Button btn
	
	
	public OptionPanel(CalculatorFrame frame){
		this.frame = frame;
		
		btnBackSpace = new Button("<-");
		btnClear = new Button("CLEAR");
		btnPlus = new Button("+");
		btnSub = new Button("-");
		btnMulti = new Button("*");
		btnDiv = new Button("/");
		btnSub.setActionCommand("equal");	//actionCommand를 붙여 줄 수 있다.
		
		btnOpenBracket = new Button("(");
		btnCloseBracket = new Button(")");
		
		LayoutManager mgr = new GridLayout(0, 6);
		this.setLayout(mgr);
		
		OptionBtnHandler optionBtnH = new OptionBtnHandler();
		btnBackSpace.addActionListener(optionBtnH);
		btnClear.addActionListener(optionBtnH);
		btnPlus.addActionListener(optionBtnH);
		btnSub.addActionListener(optionBtnH);
		btnMulti.addActionListener(optionBtnH);
		btnDiv.addActionListener(optionBtnH);
//		btnCloseBracket.addActionListener(optionBtnH);
//		btnOpenBracket.addActionListener(optionBtnH);
		
		this.add(btnBackSpace);
		this.add(btnPlus);
		this.add(btnSub);
		this.add(btnMulti);
		this.add(btnDiv);
//		this.add(btnOpenBracket);
//		this.add(btnCloseBracket);
		this.add(btnClear);
		
	}
	
	class OptionBtnHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource().equals(btnBackSpace)){
				String tempStr = frame.getResultTA().getText();
				String lastStr = tempStr;
				int size = tempStr.length();
				lastStr.substring(size-1, size);
				if(lastStr.equals("+") || lastStr.equals("-") || lastStr.equals("*") ||lastStr.equals("/")){
					ControlPanel.operendState = true;
				}
				frame.getResultTA().setText(tempStr.substring(0, size-1));
			}
			else if(e.getSource().equals(btnClear)){
				System.out.println("Clear");
				frame.ClearResultTA();
				ControlPanel.inputArr.clear();
			}
			else{
				if(ControlPanel.operendState){
					HashMap<String, String> tempMap = new HashMap<String, String>();
					if(e.getSource().equals(btnPlus)){
						tempMap.put("operator", "+");
					}
					else if(e.getSource().equals(btnSub)){
						tempMap.put("operator", "-");	
					}
					else if(e.getSource().equals(btnMulti)){
						tempMap.put("operator", "*");
					}
					else if(e.getSource().equals(btnDiv)){
						tempMap.put("operator", "/");
					}
					
					String tempStr = frame.getResultTA().getText();		
					System.out.println("저장할 숫자 : "+Integer.parseInt(tempStr)+" 저장할 연산자 : "+tempMap.get("operator"));
					tempMap.put("number", tempStr);
					
					ControlPanel.inputArr.add(tempMap);
					
				
					
					ControlPanel.operendState = false;
					frame.getResultTA().setText("");
					/********ArrayList 확인*******/
					for(int i=0; i<ControlPanel.inputArr.size(); i++){
						System.out.println(ControlPanel.inputArr.get(i));
					}
				}
			}
			
			
			
		}
		
	}
}
