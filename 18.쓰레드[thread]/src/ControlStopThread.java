
public class ControlStopThread extends Thread{
	private boolean isPlay;
	private int count;
	
	public ControlStopThread() {
		isPlay = true;
		count = 0;
	}
	
	@Override
	public void run() {
		
		while(isPlay){
			try{
				Thread.sleep(300);
				System.out.println(count);
				count++;
				if(count == 100){
					isPlay = false;
					System.out.println(">>>조건을 만족하면 종료");
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}
	}//run()
}
