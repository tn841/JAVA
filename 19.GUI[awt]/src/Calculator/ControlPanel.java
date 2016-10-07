package Calculator;

import java.awt.GridLayout;
import java.awt.Panel;
import java.util.ArrayList;
import java.util.HashMap;

public class ControlPanel extends Panel{
	private NumberPanel numberP;
	private OptionPanel optionP;
	private String firstOperend="";	//첫 항
	private String secondOperend="";//둘째 항
	private String operation="";	//연산자
	private String resultStr="";	//결과
	int resultInt=0;
	
	public static boolean operendState;	//true면 연산자 사용 가능, false면 연산자 사용 불가능.
	public static ArrayList<HashMap<String, String>> inputArr;	//key => num  / key => operator
	
	
	public ControlPanel(CalculatorFrame frame){
		numberP = new NumberPanel(frame);
		optionP = new OptionPanel(frame);
		
		operendState = true;
		inputArr = new ArrayList<HashMap<String,String>>();
				
		this.setLayout(new GridLayout(2,0));

		
		this.add(optionP);
		this.add(numberP);
	}
	
	public boolean isFirstOperendEmpty(){	//비었으면 true
		if(firstOperend.trim().equals("")){
			return true;
		}
		else{
			return false;
		}
	}
}
