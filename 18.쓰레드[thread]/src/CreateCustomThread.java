
public class CreateCustomThread extends Thread{
	@Override
	public void run(){
		int count=0;
		while(true){
			System.out.println("��. "+Thread.currentThread().getName()+" ������"+count++);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}
