import java.util.Date;

public class ControlSleepClockThread extends Thread{
	
	private boolean isPlay;
	
	public boolean isPlay() {
		return isPlay;
	}


	public void setPlay(boolean isPlay) {
		this.isPlay = isPlay;
	}


	public ControlSleepClockThread(boolean isPlay) {
		super();
		this.isPlay = isPlay;
	}


	public ControlSleepClockThread() {
		isPlay = true;
	}
	
	
	@Override
	public void run() {	//throw를 이용한 예외처리는 할 수 없다. (재정의 위반) 부모 클래스에서는 런타임예외만 던졌기 때문
						//접근제어자도 재정의 위반이 일어날 수 있는데 부모 보다 더 넓거나 같아야 함
		while(isPlay){
			try {
				Date date = new Date();
				System.out.println(date.toLocaleString());
				
				Thread.sleep(900);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return;
	}//run()
}
