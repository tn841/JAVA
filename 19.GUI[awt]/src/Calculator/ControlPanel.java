package Calculator;

import java.awt.GridLayout;
import java.awt.Panel;
import java.util.ArrayList;
import java.util.HashMap;

public class ControlPanel extends Panel{
	private NumberPanel numberP;
	private OptionPanel optionP;
	private String firstOperend="";	//ù ��
	private String secondOperend="";//��° ��
	private String operation="";	//������
	private String resultStr="";	//���
	int resultInt=0;
	
	public static boolean operendState;	//true�� ������ ��� ����, false�� ������ ��� �Ұ���.
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
	
	public boolean isFirstOperendEmpty(){	//������� true
		if(firstOperend.trim().equals("")){
			return true;
		}
		else{
			return false;
		}
	}
}
