
public class SyncThreadMain {

	public static void main(String[] args) {
		Object m = new Object();	//����ȭ�� ������ ���ý� ��ü m  (����� ��ü, ����ȭ ��ü)
									//��� ��ü�� ����ȭ�� ������ Lock Flag�� ���� �ִ�.
									//� �����尡 ����ȭ ��ü�� ���޻����϶� �����ϸ� �ش� ������� ����ȭ ��ü�� Lock Flag�� ȹ�� �Ѵ�. 
		SyncLowerThread sltm = new SyncLowerThread();
		SyncLowerThread slt = new SyncLowerThread(sltm);
		SyncUpperThread sut = new SyncUpperThread(sltm);
		
		slt.start();
		sut.start();
	}

}
