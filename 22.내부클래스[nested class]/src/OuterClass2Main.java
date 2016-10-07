import java.util.Comparator;

public class OuterClass2Main {

	public static void main(String[] args) {
		OuterClass2 oc2 = new OuterClass2();
		
		oc2.outer_annonymous_local_inner_class();
		
		Comparator cp = new Comparator(){	//Comparator 인터페이스를 구현한 익명의 이너클래스-> 인터페이스를 구현했으므로 Overriding을 해줘야함

			@Override
			public int compare(Object o1, Object o2) {
				return 0;
			}
			
		};	//Collection 연습에서 Comparator 클래스를 따로 구현한 번거로움을 줄일 수 있다.
		
		Object oc = new Object(){
			
		};
		
		Comparable ccp = new Comparable(){
			@Override
			public int compareTo(Object o) {
				// TODO Auto-generated method stub
				return 0;
			}
		};
		
	}

}
