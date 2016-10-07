import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
����:
  1. Exception : MILD Error(ó�����)
  2. Error     : Error
  
  
  * Exception ����
   		1. RuntimeException    :ó�������ʾƵ� �ȴ� (�ڵ����� ó���ȴ�.)
   		    ==>���α׷����� �Ǽ������� Exception 
   		    ex> NullPointerException,ArrayIndexOutOfBoundsException
        2. �� RuntimeException :�ݵ�� ó���ؾ��Ѵ�.
        	==>���α׷������� ���� �Ͼ ���ɼ��� �ִ� Exception
  			ex> network,io,db,file

  *ó�����
     ex1>��´�.
     public void method(){
	 	
	     try{ 
	     
	     	�ͼ��� �߻������ڵ�;
	     	
		 }catch(ExceptionŬ���� e){
		 	�ͼ��� �߻������ڵ忡�� Exception�̹߻��ϸ�
		 	�����ϰԵ��ڵ�;
		 }
	 }
	 ex2> ������.
	 
	 	public void method()throws Exception {
	 	
	 		�ͼ��� �߻������ڵ�;
	 	
	 	}	
	 	
	 

*/
public class ExceptionThrowMain {

	public static void main(String[] args) throws RuntimeException,FileNotFoundException,SQLException{	//�ұ��� ó��
		// TODO Auto-generated method stub
		
		/************** ��Ÿ�� ���� *********/
		int[] iarr = new int[2];	
		//iarr[2] = 80;	//java.lang.ArrayIndexOutOfBoundsException
		
		String str = null;
		//int len = str.length();	//java.lang.NullPointerException
		
		//int result = 3/0;	//java.lang.ArithmeticException
		
		
		/***********��Ÿ�� ����************/
		//FileInputStream fin = new FileInputStream("a.txt");	//FileNotFoundException
		//DriverManager.getConnection("");	//SQLException
	}

}
