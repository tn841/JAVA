
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
				//synchronized(){}밖에 쓰여진 코드는 동기화 되지 않는다.
				
				//synchronized()안에 쓰여진 코드는 동기화 된다. 근데 이런 코드 블락 단위의 동기화는 잘 쓰지 않는다.
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
