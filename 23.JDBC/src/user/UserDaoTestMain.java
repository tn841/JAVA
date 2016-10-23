package user;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class UserDaoTestMain {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		UserDao userDao = new UserDao();
		
		ArrayList<User> userList = new ArrayList<User>();
		
		System.out.println("1. select all");
		userList = userDao.selectUserList();
		
		for (User user : userList) {
			System.out.println(user.getId()+"\t"+user.getPw()+"\t"+user.getName()+"\t"+user.getEmail());
		}
		
		int rand = 	(int)(Math.random()*10000);
		System.out.println("\n2. insert id="+rand);
		User user = new User("id"+rand, "1234", 
				"user"+rand, 
				"email||USERINFO_SEQ.CURRVAL");		
		
		System.out.println(">> insert : "+userDao.insert(user));
		
		
		userList = userDao.selectUserList();
		for (User user2 : userList) {
			System.out.println(user2.getId()+"\t"+user2.getPw()+"\t"+user2.getName()+"\t"+user2.getEmail());
		}
		
		System.out.println("\n3. update id="+rand);
		userDao.update("id"+rand, "email"+rand+"@email.com");
		userList = userDao.selectUserList();
		for (User user2 : userList) {
			System.out.println(user2.getId()+"\t"+user2.getPw()+"\t"+user2.getName()+"\t"+user2.getEmail());
		}
		
		
		System.out.println("\n4. delete id="+rand);
		int deleteRow = userDao.delete("id"+rand);
		System.out.println(">> delete row : "+ deleteRow);
		userList = userDao.selectUserList();
		for (User user2 : userList) {
			System.out.println(user2.getId()+"\t"+user2.getPw()+"\t"+user2.getName()+"\t"+user2.getEmail());
		}
		
		
		BufferedReader in2 = new BufferedReader(new InputStreamReader(System.in));
		System.out.print(">> 삭제할 id를 입력하세요:");
		String inStr = in2.readLine();
		
		userDao.delete(inStr);
		
		System.out.println(">> 확인");
		userList = userDao.selectUserList();
		for (User user2 : userList) {
			System.out.println(user2.getId()+"\t"+user2.getPw()+"\t"+user2.getName()+"\t"+user2.getEmail());
		}
	}

}
