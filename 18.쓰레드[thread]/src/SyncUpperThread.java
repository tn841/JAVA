
public class SyncUpperThread extends Thread {
	private boolean isPlay;
	private Object m;
	
	public SyncUpperThread(Object m){
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
				synchronized(this.m){
					int num = 65;
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
