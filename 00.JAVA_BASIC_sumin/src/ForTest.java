/*
	
	for문
	     -형식:
	       	       
	       for(1;2;3){
		       	//1.반복변수(선언,초기화가능)
		       	//2.반복변수의 조건검사(논리형데이타)
		       	//3.반복변수증,감(++,--)
	       	 stmt1;
	       }
	       flow: 1--> 2(true)-->stmt1
	              --> 3 -->2(true)-->stmt1
	              --> 3 -->2(true)-->stmt1
	              --> 3 -->2(false)-->loop빠져나감
	       
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

		System.out.println("1.---증가----");
		for (int i = 0; i < 10; i++) {
			System.out.println("i=" + i);
		}
		System.out.println("2.---감소---");

		for (int i = 10; i > 0; i--) {
			System.out.println("i=" + i);
		}
		System.out.println("3.짝수 출력(1~10)");
		for (int i = 0; i < 10; i++) {
			int su = i + 1;
			if (su % 2 == 0) {
				System.out.print(su + " ");
			}
		}
		System.out.println();
		System.out.println("4. 4의배수 출력(1~100)");
		for (int i = 0; i < 100; i++) {
			int su = i + 1;
			if (su % 4 == 0) {
				System.out.print(su + " ");
			}
		}
		System.out.println();
		System.out.println("4. 첫번째4의배수만 출력(1~100)");
		for (int i = 0; i < 100; i++) {
			int su = i + 1;
			if (su % 4 == 0) {
				System.out.print(su + " ");
				break;
			}
		}
		System.out.println("4. 4의배수가아니면 출력안함(1~100)[continue]");
		for (int i = 0; i < 100; i++) {
			int su = i + 1;
			/*
			 * if(su%4!=0){ System.out.print("X "); }else{
			 * System.out.print(su+" "); }
			 */
			if (su % 4 != 0) {
				System.out.print("X ");
				continue;// 현재실행되는 문장이후를 실행하지않고 다음루프를실행
			}
			System.out.print(su + " ");
		}
		System.out.println();
		System.out.println("5.홀수,짝수합(1~100)");

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
		System.out.println(">>홀수합:" + oddTot);
		System.out.println(">>짝수합:" + evenTot);

		System.out.println("6.문자출력");
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
