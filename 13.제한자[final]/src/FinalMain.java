
public class FinalMain {

	public static void main(String[] args) {
		FinalParent fp = new FinalParent();
		
		System.out.println(FinalChild.NORTH);	//final static ����� ���� �̷� ����� �����ϱ�� �ϳ� �ٶ������� ����..
		System.out.println(FinalParent.NORTH);
		
		FinalChild fc = new FinalChild();
		
		fc.cannotOverriding();
		fc.method3();
		
	}

}
