package user;

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
		
		
		System.out.println("2. insert");
		
//		User user = new User("id1", "1234", "name1", "email1@email");
//		System.out.println(">> insert : "+userDao.insert(user));
		
		
		userList = userDao.selectUserList();
		
		for (User user2 : userList) {
			System.out.println(user2.getId()+"\t"+user2.getPw()+"\t"+user2.getName()+"\t"+user2.getEmail());
		}
		

	}

}
