
public class MainThreadCalled{
	public void main_called_method(){
		System.out.println("A. "+Thread.currentThread().getName()+" ������");
		System.out.println("B. "+Thread.currentThread().getName()+" ������ return");
		return;
	}
	

}
