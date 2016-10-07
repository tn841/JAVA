
public class SyncLowerThread extends Thread {
	private boolean isPlay;
	private Object m;
	
	public SyncLowerThread() {
		// TODO Auto-generated constructor stub
		isPlay = true;
	}
	
	public SyncLowerThread(Object m){
		this.m = m;
		isPlay = true;
	}
	public boolean isPlay() {
		return isPlay;
	}
	public void setPlay(boolean isPlay) {
		this.isPlay = isPlay;
	}
	
	@Override
	public void run() {
		try {
			while(isPlay){
				//synchronized(){}�ۿ� ������ �ڵ�� ����ȭ ���� �ʴ´�.
				
				//synchronized()�ȿ� ������ �ڵ�� ����ȭ �ȴ�. �ٵ� �̷� �ڵ� ��� ������ ����ȭ�� �� ���� �ʴ´�.
				synchronized(this.m){
					int num = 97;
					for (int i = 0; i < 26; i++) {
						System.out.print((char)num++);
					}
					Thread.sleep(100);
					System.out.println();
				}//synchronized()
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}//run()
}
