/*
	
	for��
	     -����:
	       	       
	       for(1;2;3){
		       	//1.�ݺ�����(����,�ʱ�ȭ����)
		       	//2.�ݺ������� ���ǰ˻�(��������Ÿ)
		       	//3.�ݺ�������,��(++,--)
	       	 stmt1;
	       }
	       flow: 1--> 2(true)-->stmt1
	              --> 3 -->2(true)-->stmt1
	              --> 3 -->2(true)-->stmt1
	              --> 3 -->2(false)-->loop��������
	       
	       ex>
	       for(int i=0;i<10;i++){
	       	 stmt1;
	       }
	       
	       int i=0;
	       while(i<10){
	       	 stmt1;
	       	 i++;
	       }
	
	*/
public class ForTest {

	public static void main(String[] args) {

		System.out.println("1.---����----");
		for (int i = 0; i < 10; i++) {
			System.out.println("i=" + i);
		}
		System.out.println("2.---����---");

		for (int i = 10; i > 0; i--) {
			System.out.println("i=" + i);
		}
		System.out.println("3.¦�� ���(1~10)");
		for (int i = 0; i < 10; i++) {
			int su = i + 1;
			if (su % 2 == 0) {
				System.out.print(su + " ");
			}
		}
		System.out.println();
		System.out.println("4. 4�ǹ�� ���(1~100)");
		for (int i = 0; i < 100; i++) {
			int su = i + 1;
			if (su % 4 == 0) {
				System.out.print(su + " ");
			}
		}
		System.out.println();
		System.out.println("4. ù��°4�ǹ���� ���(1~100)");
		for (int i = 0; i < 100; i++) {
			int su = i + 1;
			if (su % 4 == 0) {
				System.out.print(su + " ");
				break;
			}
		}
		System.out.println("4. 4�ǹ�����ƴϸ� ��¾���(1~100)[continue]");
		for (int i = 0; i < 100; i++) {
			int su = i + 1;
			/*
			 * if(su%4!=0){ System.out.print("X "); }else{
			 * System.out.print(su+" "); }
			 */
			if (su % 4 != 0) {
				System.out.print("X ");
				continue;// �������Ǵ� �������ĸ� ���������ʰ� ��������������
			}
			System.out.print(su + " ");
		}
		System.out.println();
		System.out.println("5.Ȧ��,¦����(1~100)");

		int oddTot = 0;
		int evenTot = 0;
		for (int i = 0; i < 100; i++) {
			int su = i + 1;
			if (su % 2 == 0) {
				evenTot += su;
			} else {
				oddTot += su;
			}
		}
		System.out.println(">>Ȧ����:" + oddTot);
		System.out.println(">>¦����:" + evenTot);

		System.out.println("6.�������");
		int charCount = 0;
		for (int i = 0; i < 70000; i++) {	//65536
			char c = (char) i;
			System.out.print(c);
			charCount++;
			if (charCount % 100 == 0) {
				System.out.println();
			}
		}
		System.out.println();
	}
}
