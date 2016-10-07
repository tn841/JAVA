
public class CreateCustomThread extends Thread{
	@Override
	public void run(){
		int count=0;
		while(true){
			System.out.println("가. "+Thread.currentThread().getName()+" 쓰레드"+count++);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}
