/*
 * 쓰레드의 우선순위
 * 	- 쓰레드가 CPU점유권을 얻을 확률
 */
public class ControlPriorityMain {

	public static void main(String[] args) {
		ControlUpperThread cut = new ControlUpperThread();
		ControlLowerThread clt = new ControlLowerThread();
		
		int p1 = cut.getPriority();
		int p2 = clt.getPriority();
		
		System.out.println("Upper priority : "+p1);
		System.out.println("Lower priority : "+p2);
		
		cut.setPriority(7);
		clt.setPriority(2);
		
		cut.start();
		clt.start();
		
		System.out.println("main return");
	}

}
