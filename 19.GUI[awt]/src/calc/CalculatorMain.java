package calc;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CalculatorMain extends Frame {
	Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,equalB,btnClear,bPlus,bSub,bMulti,bDiv;
	TextArea resultsTA, displayTA;
	ArrayList<String> arrList ;
	
	
	GridPanel gPanel;
	DisplayPanel dPanel;

	
	public CalculatorMain() {
		arrList = new ArrayList<String>();
		
		resultsTA = new TextArea(1,1);
		 displayTA = new TextArea(1,2);
		
		
		resultsTA.setForeground(Color.magenta);
		 displayTA.setForeground(Color.gray);
		
		resultsTA.setFont(new Font("Sanserif", Font.BOLD, 20));
		 displayTA.setFont(new Font("Default", Font.PLAIN, 14));
		
	
		
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
		equalB.setEnabled(isCalc);	//'='버튼은 처음에 비활성
		
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
		resultsTA.setText("");
		 displayTA.setText("");
	}
	
	
	String firstNum="";
	int firstNumInt=0;
	String operator="";
	String secondNum="";
	int secondNumInt=0;
	String resultStr="";
	int resultInt=0;
	String oldStr="";
	
	boolean isCalc = false;
	
	int status=0;
	/*
	ArrayList이용.. 횟수 제한 없이 연산을 할 수 있다.
	연산이 가능한지 불가능한지는  isCalc 변수를 통해 판단한다.
	연산이 가능할 때만 '='버튼이 활성화 된다.
	
	 - 초기상태 : isCalc = false, ArrayList = 비었음, 연산자 비활성
	 - 숫자눌림 : isCalc = true,  ArrayList = [숫자1], 연산자 활성
	 - 또 숫자 눌림 : isCalc = true, ArrayList = [숫자12], 연산자 활성
	 - 연산자 눌림 : isCalc = false, ArrayList = [숫자12] [연산자1] , 연산자 비활성
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
			
			this.add( displayTA);
			this.add(resultsTA);
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
		public void actionPerformed(ActionEvent e) {
			String cmd=e.getActionCommand();	//이벤트가 발생한 객체의 Command를 가지고 온다
			//System.out.print(cmd);
			
	
			try{
				Integer.parseInt(cmd);	//cmd를 정수로 파싱한다. 이때 예외가 발생하면  숫자가 아니라는 것->(catch문으로..)
				//System.out.println("숫자임돠");
				isCalc = true;
				operatorOn();
				
				//숫자를 ArrayList에 넣는다. 마지막 인덱스에 숫자가 들어있는경우 그 숫자에 append한 숫자로 대체 한다.
				try{
					Integer.parseInt(arrList.get(arrList.size()-1));
					if(arrList.size() != 0){
						String tempStr = arrList.get(arrList.size()-1)+cmd;
						arrList.set(arrList.size()-1, tempStr);
						resultsTA.setText(tempStr);
					}
					else{
						arrList.add(cmd);
						
					}
				}catch(Exception ex2){	//마지막 인덱스에 숫자가 아닌 연산자가 들어있는 경우 그냥  add한다.
					arrList.add(cmd);
					resultsTA.setText(cmd);
				}
				
			}catch(Exception ex){
				//System.out.println("숫자 아님");
				if(cmd.equals("+") || cmd.equals("-") || cmd.equals("*") || cmd.equals("/")){	//사칙연산자인경우
					isCalc = false;	//식이 불완전하므로 '='는 비활성화
					operatorOff();	//연산자는 연속해서 못쓰기 때문에 연산자 전체 비활성화
					
					//연산자가 눌리기전  arrlist에 있는 값들을 먼저 계산한다.
					if(arrList.size()>2){
						if(arrList.get(1).equals("+")){
							resultInt = Integer.parseInt(arrList.get(0)) + Integer.parseInt(arrList.get(2));
						}
						else if(arrList.get(1).equals("-")){
							resultInt = Integer.parseInt(arrList.get(0)) - Integer.parseInt(arrList.get(2));
						}
						else if(arrList.get(1).equals("*")){
							resultInt = Integer.parseInt(arrList.get(0)) * Integer.parseInt(arrList.get(2));
						}
						else if(arrList.get(1).equals("/")){
							resultInt = Integer.parseInt(arrList.get(0)) / Integer.parseInt(arrList.get(2));
						}
						
						
						 displayTA.append(" "+ arrList.get(2) +" "+cmd);
						System.out.println("앞선 계산결과 : "+Integer.parseInt(arrList.get(0))+arrList.get(1)+Integer.parseInt(arrList.get(2))+" = "+resultInt);
						arrList.clear();
						arrList.add(Integer.toString(resultInt));
						resultsTA.setText(Integer.toString(resultInt));
					}
					else{
						 displayTA.setText(arrList.get(0)+" "+cmd);
					}
					
					//연산자를 arrlist에 추가한다.
					
					arrList.add(cmd);
				}
				else if(cmd.equals("=")){
					if(arrList.size()<2){
						resultsTA.setText(arrList.get(0));
					}
					else{
						//resultTA.setText("");
						if(arrList.get(1).equals("+")){
							resultInt = Integer.parseInt(arrList.get(0)) + Integer.parseInt(arrList.get(2));
						}
						else if(arrList.get(1).equals("-")){
							resultInt = Integer.parseInt(arrList.get(0)) - Integer.parseInt(arrList.get(2));
						}
						else if(arrList.get(1).equals("*")){
							resultInt = Integer.parseInt(arrList.get(0)) * Integer.parseInt(arrList.get(2));
						}
						else if(arrList.get(1).equals("/")){
							try{
								resultInt = Integer.parseInt(arrList.get(0)) / Integer.parseInt(arrList.get(2));
							}catch(Exception e3){
								resultsTA.setText("0으로 나눌 수 없습니다.");
								return;
							}
						}
						 displayTA.append(" "+ arrList.get(2) +" "+cmd);
						resultsTA.setText(Integer.toString(resultInt));
						arrList.clear();
						arrList.add(Integer.toString(resultInt));
						isCalc = false;
					}
				}// "="
				else if(cmd.equals("Clear")){
					arrList.clear();
					operatorOff();
					isCalc = false;
					resultsTA.setText("");
					 displayTA.setText("");
				}
				
				
				
			}
			
		
			for(String temp:arrList){
				System.out.println(temp);
			}
			System.out.println("===============\n");
			equalB.setEnabled(isCalc);	// '='버튼 활성화 여부
			
		}
		
	}//ButtonHandler
	/**************************************/
	
	
	public static void main(String[] args) {
		new CalculatorMain();
	}

}
