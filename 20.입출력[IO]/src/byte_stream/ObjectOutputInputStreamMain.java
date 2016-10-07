package byte_stream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class ObjectOutputInputStreamMain {

	public static void main(String[] args) throws Exception{
		
		ObjectOutputStream oos = new ObjectOutputStream(
				new FileOutputStream("account.ser"));
		
		Account writeAcc = new Account("123", "kim", 10000, 0.02);
		
		oos.writeObject(writeAcc);	//객체 write시 직렬화(Serialization)된다.
		/*
		 * java.io.NotSerializableException
		 */
		oos.close();
		System.out.println(">>Account 객체 저장완료");
		
		ObjectInputStream ois = new ObjectInputStream(
				new FileInputStream("account.ser"));
		
		Account acccc2 = (Account) ois.readObject();	//객체 read시 역직렬화(Deserialization)된다.
		acccc2.print();
		ois.close();
		
	
		System.out.println("---------------ArrayList---------------");
		Account acc1 = new Account("1111", "BONG", 33000, 0.02);
		Account acc2 = new Account("2222", "AONG", 23000, 0.03);
		Account acc3 = new Account("3333", "DONG", 33000, 0.04);
		Account acc4 = new Account("4444", "FONG", 99000, 0.12);
		Account acc5 = new Account("5555", "HONG", 78000, 0.08);
		Account acc6 = new Account("6666", "CONG", 33000, 0.03);
		Account acc7 = new Account("7777", "DONG", 33000, 0.28);
		Account acc8 = new Account("8888", "ZONG", 33000, 0.68);
		Account acc9 = new Account("9999", "OONG", 22000, 0.88);
		ArrayList<Account> accountList=new ArrayList<Account>();
		accountList.add(acc1);
		accountList.add(acc2);
		accountList.add(acc3);
		accountList.add(acc4);
		accountList.add(acc5);
		accountList.add(acc6);
		accountList.add(acc7);
		accountList.add(acc8);
		accountList.add(acc9);
		
		ObjectOutputStream oos2 = new ObjectOutputStream(
				new FileOutputStream("Acc_ArrList.ser"));
		
		oos2.writeObject(accountList);
		oos2.close();
		
		ObjectInputStream ois2 = new ObjectInputStream(
				new FileInputStream("Acc_ArrList.ser"));
		
		ArrayList<Account> accList2 = (ArrayList<Account>) ois2.readObject();
		ois2.close();
		for(Account temp : accList2){
			temp.print();
		}
		
		
	}
	
	

}
