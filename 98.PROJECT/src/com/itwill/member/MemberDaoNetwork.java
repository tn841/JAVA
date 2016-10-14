package com.itwill.member;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class MemberDaoNetwork implements MemberDao{


	/*
	 * 서버로 부터 파일읽기(연결)
	 */
	private ArrayList<Member> readData() throws Exception{
		Socket socket = new Socket("192.168.12.31",9000);
		ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
		in.close();
		socket.close();
		return (ArrayList<Member>)in.readObject();	
	}
	/*
	 * 서버에 파일쓰기(연결해제)
	 */
	private void saveData(ArrayList<Member> memberList)throws Exception{
		Socket socket = new Socket("192.168.12.31", 9001);
		ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
		out.writeObject(memberList);
		out.flush();
		out.close();
		socket.close();
	}
	
	/*
	 * insert(create)
	 */
	/* (non-Javadoc)
	 * @see com.itwill.member.MemberDao#insert(com.itwill.member.Member)
	 */
	@Override
	public void insert(Member addMember)throws Exception{
		System.out.println("3.MemberDao insert");
		ArrayList<Member> memberList=(ArrayList<Member>)this.readData();
		memberList.add(addMember);
		saveData(memberList);
	}
	/*
	 * select(read): 멤버 1개 select
	 */
	/* (non-Javadoc)
	 * @see com.itwill.member.MemberDao#selectById(java.lang.String)
	 */
	@Override
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
	/* (non-Javadoc)
	 * @see com.itwill.member.MemberDao#selectAll()
	 */
	@Override
	public ArrayList<Member> selectAll() throws Exception{
		System.out.println("3.MemberDao selectAll");
		ArrayList<Member> memberList=readData();
		return memberList;
	}
	/*
	 * update 
	 */
	/* (non-Javadoc)
	 * @see com.itwill.member.MemberDao#update(com.itwill.member.Member)
	 */
	@Override
	public void update(Member updateMember){
		System.out.println("3.MemberDao update");
	}
	/*
	 * delete
	 */
	/* (non-Javadoc)
	 * @see com.itwill.member.MemberDao#deleteById(java.lang.String)
	 */
	@Override
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
