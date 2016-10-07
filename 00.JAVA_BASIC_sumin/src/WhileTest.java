import java.util.Timer;
import java.util.TimerTask;

/*
반복문
     stmt1;
     while(조건문){
		 //조건문--> 논리형데이타를 반환하는 식(리터럴,변수) 
		stmt2;
	 }
	 stmt3;
 	 
	 실행흐름  stmt1 --> 조건식의 데이타가 true인동안 stmt2를 반복실행 --> stmt3
*/
public class WhileTest {

	public static void main(String[] args) {
		
		Timer timer = new Timer();
		TimerTask task = new TimerTask(){
		int temp = 1;
		
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				
				if(temp<Integer.MAX_VALUE && temp>0)
				{
					temp = temp<<1;
					System.out.println(temp);
				}
				else{
					timer.cancel();
				}
			}
			
		};

		timer.schedule(task, 1000, 1000);
		
		
		//System.out.println("stmt99");
		
	}

}
