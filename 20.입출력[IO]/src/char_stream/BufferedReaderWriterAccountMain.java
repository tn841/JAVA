package char_stream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;

import byte_stream.Account;

public class BufferedReaderWriterAccountMain {

	public static void main(String[] args) throws Exception{
		System.out.println("-------------------ArrayList---------------");
		Account acc1 = new Account("1111", "BONG", 33000, 0.02);
		Account acc2 = new Account("2222", "AONG", 23000, 0.03);
		Account acc3 = new Account("3333", "DONG", 33000, 0.04);
		Account acc4 = new Account("4444", "FONG", 99000, 0.12);
		Account acc5 = new Account("5555", "HONG", 78000, 0.08);
		Account acc6 = new Account("6666", "CONG", 33000, 0.03);
		Account acc7 = new Account("7777", "DONG", 33000, 0.28);
		Account acc8 = new Account("8888", "DONG", 33000, 0.68);
		Account acc9 = new Account("9999", "DONG", 22000, 0.88);
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
		System.out.println("-----AccountList write--------");
		BufferedWriter bw=
				new BufferedWriter(
						new FileWriter("accountList.txt"));
		
		PrintWriter pw = new PrintWriter(
				new FileWriter("accountPrintList.txt"));
		
		
		
		for (Account account : accountList) {
			String accountStr=
					account.getNo()+" "
					+account.getOwer()+" "
					+account.getBalance()+" "
					+account.getIyul();
			
			bw.write(accountStr);
			bw.newLine();
			
			pw.println(account);
			
			//PrintStream cout = System.out;
		}
		
		
		bw.flush();
		bw.close();
		
		pw.flush();
		pw.close();
		System.out.println("-----AccountList read--------");
		BufferedReader br=
				new BufferedReader(
						new FileReader("accountList.txt"));
		ArrayList<Account> readAccountList=new ArrayList<Account>();
		while (true) {
			String accountStr=br.readLine();
			if(accountStr==null)break;
			System.out.println(accountStr);
			String[] accountStrArray=accountStr.split(" ");
			String noStr=accountStrArray[0];
			String nameStr= accountStrArray[1];
			String balanceStr=accountStrArray[2];
			String lyulStr=accountStrArray[3];
			
			readAccountList.add(
					new Account(
							noStr,
							nameStr,
							Integer.parseInt(balanceStr),
							Double.parseDouble(lyulStr)));
		}

		for (Account account : readAccountList) {
			account.print();
		}
	}

}
