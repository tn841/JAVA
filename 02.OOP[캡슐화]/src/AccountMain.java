
public class AccountMain {
	public static void main(String[] arg){
		Account acc1 = new Account();
		Account acc2 = new Account();
		
		acc1.setAccountData("1111", "수민", 30000, 0.02);
		acc2.setAccountData("2222", "민수", 500000, 0.025);
			
		
		acc1.print();
		
		//입금
		acc1.saveMoney(3000);
		acc1.print();
		
		//출금1
		acc1.withdrawMoney(2000);
		acc1.print();
		
		//출금2
		acc1.withdrawMoney(80020);
		acc1.print();
		
		acc2.print();
		
		
		acc1.setOwer("켜켜");
		acc1.print();
		
		acc2.setIyul(0.06);
		acc2.print();
		
		int acc1Balance = acc1.getBalance();
		int acc2Balance = acc2.getBalance();
		System.out.println("acc1 balance :"+acc1Balance);
		System.out.println("acc2 balance :"+acc2Balance);
		
		
		double acc1Iyul = acc1.getIyul();
		double acc2Iyul = acc2.getIyul();
		System.out.println("acc1 iyul :"+acc1Iyul);
		System.out.println("acc2 iyul :"+acc2Iyul);

		
		
	}
}