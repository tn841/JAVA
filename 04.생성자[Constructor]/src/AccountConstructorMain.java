
public class AccountConstructorMain {
	public static void main(String[] arg){
		
		Account acc1 = new Account("1111", "가나다", 100000, 0.02);
		Account acc2 = new Account("2222", "라마바", 200000, 0.025);
		Account acc3 = new Account("3333", "사아자", 300000, 0.027);
		Account acc4 = new Account("4444", "차카타", 400000, 0.05);
		
		acc1.print();
		acc2.print();
		acc3.print();
		acc4.print();
		
		
		Account[] acc = new Account[4];
	}//main
}