import java.util.Comparator;

public class OuterClass2Main {

	public static void main(String[] args) {
		OuterClass2 oc2 = new OuterClass2();
		
		oc2.outer_annonymous_local_inner_class();
		
		Comparator cp = new Comparator(){	//Comparator �������̽��� ������ �͸��� �̳�Ŭ����-> �������̽��� ���������Ƿ� Overriding�� �������

			@Override
			public int compare(Object o1, Object o2) {
				return 0;
			}
			
		};	//Collection �������� Comparator Ŭ������ ���� ������ ���ŷο��� ���� �� �ִ�.
		
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
