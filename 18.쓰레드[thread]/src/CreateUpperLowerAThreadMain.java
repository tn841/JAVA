
public class CreateUpperLowerAThreadMain {

	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName()+" ������");
		CreateUpperAThread cuat = new CreateUpperAThread();
		CreateLowerAThread clat = new CreateLowerAThread();
		
		cuat.start();
		clat.start();
		
		System.out.println(Thread.currentThread().getName()+" ������ return");
	}

}
