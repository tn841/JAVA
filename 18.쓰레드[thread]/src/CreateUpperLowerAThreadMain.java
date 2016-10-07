
public class CreateUpperLowerAThreadMain {

	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName()+" 쓰레드");
		CreateUpperAThread cuat = new CreateUpperAThread();
		CreateLowerAThread clat = new CreateLowerAThread();
		
		cuat.start();
		clat.start();
		
		System.out.println(Thread.currentThread().getName()+" 쓰레드 return");
	}

}
