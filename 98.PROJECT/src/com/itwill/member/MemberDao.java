package com.itwill.member;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;

/*
 * DAO(Data Access Object)
 * 	 - 멤버데이타를 저장하고있는 파일(테이블)에
 *     CRUD(Create,Read,Update,Delete) 작업을할수있는
 *     단위메쏘드를 가지고있는 클래스
 *   - MemberService의 요청(호출)을받아서 Data Accessing(File)에
 *     관련된 단위기능(insert,select,update,delete 메쏘드) 
 *     을 수행하는객체
 */
public class MemberDao {
	
	private File memberFile;
	
	public MemberDao()throws Exception {
		
		
		memberFile=new File("member.dat");
		if(!memberFile.exists()){
			memberFile.createNewFile();
			ObjectOutputStream oos=
					new ObjectOutputStream(
							new FileOutputStream(memberFile));
			oos.writeObject(new ArrayList<Member>());
			oos.close();
		}
	}
	/*
	 * 파일읽기(연결)
	 */
	private ArrayList<Member> readData() throws Exception{
		ObjectInputStream ois=
				new ObjectInputStream(
						new FileInputStream(memberFile));
		ArrayList<Member> memberList=
				(ArrayList<Member>)ois.readObject();
		return memberList;
	}
	/*
	 * 파일쓰기(연결해제)
	 */
	private void saveData(ArrayList<Member> memberList)throws Exception{
		ObjectOutputStream oos=
				new ObjectOutputStream(
						new FileOutputStream(memberFile));
		oos.writeObject(memberList);
		oos.flush();
		oos.close();
	}
	
	/*
	 * insert(create)
	 */
	public void insert(Member addMember)throws Exception{
		System.out.println("3.MemberDao insert");
		ArrayList<Member> memberList=(ArrayList<Member>)this.readData();
		memberList.add(addMember);
		saveData(memberList);
	}
	/*
	 * select(read): 멤버 1개 select
	 */
	public Member selectById(String id) throws Exception{
		System.out.println("3.MemberDao selectById");
		ArrayList<Member> memberList=this.readData();
		Member findMember=null;
		for (Member member : memberList) {
			if(member.getId().equals(id)){
				findMember=member;
				break;
			}
		}
		return findMember;
	}
	/*
	 * select(read): 멤버 여러개 select
	 */
	public ArrayList<Member> selectAll() throws Exception{
		System.out.println("3.MemberDao selectAll");
		ArrayList<Member> memberList=readData();
		return memberList;
	}
	/*
	 * update 
	 */
	public void update(Member updateMember){
		System.out.println("3.MemberDao update");
	}
	/*
	 * delete
	 */
	public void deleteById(String id) throws Exception{
		ArrayList<Member> memberList=
				(ArrayList<Member>)readData();
		for (Member member : memberList) {
			if(member.getId().equals(id)){
				memberList.remove(member);
				break;
			}
		}
		saveData(memberList);
	}
}










