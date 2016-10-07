package Calculator;

import java.awt.Button;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class NumberPanel extends Panel{
	private Button[] btnNum;
	private Button btnEnter;
	private Button btnNull;
	
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
		
		btnEnter = new Button("=");
		btnNull = new Button("");
		
		btnEnter.addActionListener(numberBtnHandler);
		
		this.add(btnEnter);
		this.add(btnNull);
		
		this.setBackground(Color.gray);
		
		this.setLayout(new GridLayout(0, 3));
	}
	
	class NumberBtnHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource().equals(btnEnter)){
				if(ControlPanel.operendState){
					if(ControlPanel.inputArr.size()==0){
						System.out.println("그냥 출력");
					}
					else{
						//계산하여 결과 출력
						HashMap<String, String> hm = new HashMap<String, String>();
						String totalStr = frame.getResultTA().getText();
						
						hm.put("number", totalStr);
						
						ControlPanel.inputArr.add(hm);
						for(int i=0; i<ControlPanel.inputArr.size(); i++){
							if(ControlPanel.inputArr.get(i).get("operator")==null){
								System.out.println(ControlPanel.inputArr.get(i)+"지금까지 계산하기");
							}
							else{
								System.out.println(ControlPanel.inputArr.get(i));
							}
						}
					}
				}
				else{
					System.out.println("식이 잘못 되었습니다.");
				}
			}
			
			for(int i =0; i< 10 ; i++){
				if(e.getSource().equals(btnNum[i])){
					frame.getResultTA().append(e.getActionCommand());
					ControlPanel.operendState = true;
				}
			}
		}
	}//BtnHandler
	
	
	
	
}
