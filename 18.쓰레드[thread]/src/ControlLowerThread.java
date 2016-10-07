
public class ControlLowerThread extends Thread{
	private boolean isPlay;
	
	public ControlLowerThread() {
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
				int num = 97;
				for (int i = 0; i < 26; i++) {
					System.out.print((char)num++);
					Thread.sleep(100);
				}		
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}//run()
}
