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
	public void run() {	//throw�� �̿��� ����ó���� �� �� ����. (������ ����) �θ� Ŭ���������� ��Ÿ�ӿ��ܸ� ������ ����
						//���������ڵ� ������ ������ �Ͼ �� �ִµ� �θ� ���� �� �аų� ���ƾ� ��
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
