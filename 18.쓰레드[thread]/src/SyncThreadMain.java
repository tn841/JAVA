
public class SyncThreadMain {

	public static void main(String[] args) {
		Object m = new Object();	//동기화를 제어할 뮤택스 객체 m  (모니터 객체, 동기화 객체)
									//모든 객체는 동기화를 제어할 Lock Flag를 갖고 있다.
									//어떤 쓰레드가 동기화 객체가 유휴상태일때 접근하면 해당 쓰레드는 동기화 객체의 Lock Flag를 획득 한다. 
		SyncLowerThread sltm = new SyncLowerThread();
		SyncLowerThread slt = new SyncLowerThread(sltm);
		SyncUpperThread sut = new SyncUpperThread(sltm);
		
		slt.start();
		sut.start();
	}

}
