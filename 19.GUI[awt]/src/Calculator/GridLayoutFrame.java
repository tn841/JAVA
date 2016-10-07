package Calculator;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GridLayoutFrame extends Frame {
	Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,equalB,btnClear,bPlus,bSub,bMulti,bDiv;
	TextArea displayTA, resultTA;
	
	
	GridPanel gPanel;
	DisplayPanel dPanel;

	
	public GridLayoutFrame() {
		
		displayTA = new TextArea(1,1);
		resultTA = new TextArea(1,2);
		
		
		b1=new Button("1");
		b2=new Button("2");
		b3=new Button("3");
		b4=new Button("4");
		b5=new Button("5");
		b6=new Button("6");
		b7=new Button("7");
		b8=new Button("8");
		b9=new Button("9");
		btnClear = new Button("Clear");
		b0=new Button("0");
		equalB=new Button("=");
		bPlus = new Button("+");
		bSub = new Button("-");
		bMulti = new Button("*");
		bDiv = new Button("/");
		
		
		
		gPanel = new GridPanel();
		dPanel = new DisplayPanel();
	
		this.setTitle("GUI계산기");
		//equalB.setActionCommand("result");
		/*
		 * LayoutManager(GridLayout)
		 */
		this.setLayout(new BorderLayout());
		
		this.add(gPanel, BorderLayout.CENTER);
		this.add(dPanel, BorderLayout.NORTH);
		
		
		
		//event
		ButtonHandler bh=new ButtonHandler();
		b1.addActionListener(bh);
		b2.addActionListener(bh);
		b3.addActionListener(bh);
		b4.addActionListener(bh);
		b5.addActionListener(bh);
		b6.addActionListener(bh);
		b7.addActionListener(bh);
		b8.addActionListener(bh);
		b9.addActionListener(bh);
		btnClear.addActionListener(bh);
		b0.addActionListener(bh);
		equalB.addActionListener(bh);
		
		bPlus.addActionListener(bh);
		bSub.addActionListener(bh);
		bMulti.addActionListener(bh);
		bDiv.addActionListener(bh);
		
		setSize(300, 400);
		setVisible(true);
	}
	
	public void operatorOn(){
		bPlus.setEnabled(true);
		bSub.setEnabled(true);
		bMulti.setEnabled(true);
		bDiv.setEnabled(true);
	}
	
	public void operatorOff(){
		bPlus.setEnabled(false);
		bSub.setEnabled(false);
		bMulti.setEnabled(false);
		bDiv.setEnabled(false);
	}
	
	public void clear(){
		operatorOff();
		status = 0;
		firstNum = "";
		secondNum = "";
		resultInt = 0;
		displayTA.setText("");
		resultTA.setText(" ");
	}
	
	
	String firstNum="";
	int firstNumInt=0;
	String operator="";
	String secondNum="";
	int secondNumInt=0;
	String resultStr="";
	int resultInt=0;
	String oldStr="";
	
	int status=0;
	/*
	0:첫번째항누적?? status가 0이면 첫번재 항에 계속 누적한다. 연산자가 눌리면 그 순간 status를 1로 바꾸어 두번째 항임을 알린다.
	1:두번째항누적
	*/
	/**************************************/
	public class OperatorPanel extends Panel{	// 사칙연산자 패널

		public OperatorPanel(){
			
			this.setLayout(new GridLayout(0, 4));
			
			this.add(bPlus);
			this.add(bSub);
			this.add(bMulti);
			this.add(bDiv);
			
			bPlus.setEnabled(false);
			bSub.setEnabled(false);
			bMulti.setEnabled(false);
			bDiv.setEnabled(false);
		}

	}
	
	
	
	public class DisplayPanel extends Panel{	//결과 화면 패널
		OperatorPanel oPanel;
		
		public DisplayPanel(){
			oPanel = new OperatorPanel();
			this.setLayout(new GridLayout(3, 0));
			
			
			
			this.add(displayTA);
			this.add(resultTA);
			this.add(oPanel);
		}
	}
	
	public class GridPanel extends Panel{	//연산자 패널과 결과화면 패널을 묶은 그리드 패널
		
		public GridPanel(){
			GridLayout gl=new GridLayout(0,3);
			setLayout(gl);
			
			add(b1);
			add(b2);
			add(b3);
			add(b4);
			add(b5);
			add(b6);
			add(b7);
			add(b8);
			add(b9);
			add(btnClear);
			add(b0);
			add(equalB);
		}
	}
	
	public class ButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e){
			String cmd=e.getActionCommand();	//이벤트가 발생한 객체의 Command를 가지고 온다
			System.out.print(cmd+" ");
			
			if(cmd.equals("+") || cmd.equals("-") || cmd.equals("*") || cmd.equals("/") ){
				if(cmd.equals("+")){
					operator = "+";
					displayTA.append(" + ");
				}else if(cmd.equals("-")){
					operator = "-";		
					displayTA.append(" - ");
				}else if(cmd.equals("*")){
					operator = "*";			
					displayTA.append(" * ");
				}else if(cmd.equals("/")){
					operator = "/";	
					displayTA.append(" / ");
				}
				status = 1;
				operatorOff();
				oldStr = displayTA.getText();
				System.out.println("asdfasdf:"+oldStr);
			}
			else if(cmd.equals("=")){
				try{
					firstNumInt = Integer.parseInt(firstNum);
					secondNumInt = Integer.parseInt(secondNum);
				}catch(Exception ex){
					clear();
					resultTA.setText("식에 오류가 있습니다.");
					System.out.println(ex.getMessage());
				}
				if(operator.equals("+"))
					resultInt = firstNumInt + secondNumInt;
				else if(operator.equals("*"))
					resultInt = firstNumInt * secondNumInt;
				else if(operator.equals("-"))
					resultInt = firstNumInt - secondNumInt;
				else if(operator.equals("/"))
					resultInt = firstNumInt / secondNumInt;	
				
				resultTA.append(Integer.toString(resultInt)+"  ");
			}
			else if(cmd.equals("Clear")){
				clear();
				
				return;
			}
			else{
				for(int i = 0; i<10; i++){
					if(cmd.equals(Integer.toString(i)) && status == 0){
						firstNum = firstNum + Integer.toString(i);
						displayTA.setText(firstNum);
						operatorOn();
						break;
					}
					else if(cmd.equals(i+"") && status == 1){
						secondNum = secondNum + Integer.toString(i);
						displayTA.setText(oldStr+secondNum);
						
						operatorOff();
						break;
					}
				}
			}
			

			System.out.println("first : "+firstNum + " second : "+secondNum+" 결과 : "+resultInt);
		
		}
		
	}//ButtonHandler
	/**************************************/
	
	
	public static void main(String[] args) {
		new GridLayoutFrame();
	}

}
