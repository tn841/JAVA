import java.util.Timer;
import java.util.TimerTask;

/*
�ݺ���
     stmt1;
     while(���ǹ�){
		 //���ǹ�--> ��������Ÿ�� ��ȯ�ϴ� ��(���ͷ�,����) 
		stmt2;
	 }
	 stmt3;
 	 
	 �����帧  stmt1 --> ���ǽ��� ����Ÿ�� true�ε��� stmt2�� �ݺ����� --> stmt3
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
