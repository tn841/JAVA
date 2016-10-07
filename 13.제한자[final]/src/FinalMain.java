
public class FinalMain {

	public static void main(String[] args) {
		FinalParent fp = new FinalParent();
		
		System.out.println(FinalChild.NORTH);	//final static 상수에 대한 이런 사용은 가능하기는 하나 바람직하지 않음..
		System.out.println(FinalParent.NORTH);
		
		FinalChild fc = new FinalChild();
		
		fc.cannotOverriding();
		fc.method3();
		
	}

}
