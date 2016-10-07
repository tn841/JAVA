package com.itwill.cafe.member;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/*
 * 	DAO(Data Access Object)
 * 		- ��� �����͸� �����ϰ��ִ� ����(�Ǵ� ���̺�)�� CRUD �۾��� �Ҽ� �ִ� ���� �޼ҵ带 ������ �ִ� Ŭ����
 * 		- MemberService�� ��û�� �޾Ƽ� Data Accessing�� ���õ� ��������� �����ϴ� Ŭ����(insert,select,update,delete �޽��)
 */
public class MemberDao {
	public MemberDao() throws Exception {
		init();
	}
	/*******************************************************/
	/*******************************************************/
	/*******************************************************/
	private File memberFile;
	/*
	 * 	�ʱ�ȭ �޽��
	 */
	private void init() throws Exception{
		memberFile = new File("member.dat");
		if(!memberFile.exists()){//������ �������� ���� ���
			memberFile.createNewFile(); //������ �����. ������ ���? UI���� �˷�����Ѵ�. -> Execption ó��
			ObjectOutputStream oos = new ObjectOutputStream(
					new FileOutputStream(memberFile));
			ArrayList<MemberVO> memberList = new ArrayList<MemberVO>();
			memberList.add(new MemberVO(0, "admin", "������", "1111", false, "", 0, 0, 0,0));
			oos.writeObject(memberList);	//ù ������ �� ArrayList write �������
			
			oos.close();
		}	
	}
	
	/*
	 * 	���� �б�(����)
	 */
	private ArrayList<MemberVO> readFile() throws Exception{
		//������ �ҽ� ��ü�� �޸𸮿� �ε��ϱ�
		ObjectInputStream ois = new ObjectInputStream(
				new FileInputStream(memberFile));
		
		ArrayList<MemberVO> memberList = (ArrayList<MemberVO>)ois.readObject();
		return memberList;
	}

	
	/*
	 * 	���� ����(���� ����)
	 */
	private void saveData(ArrayList<MemberVO> memberList) throws Exception {
		//�޸��� �����͸� ���Ϸ� ����
		ObjectOutputStream oos = new ObjectOutputStream(
				new FileOutputStream(memberFile));
		oos.writeObject(memberList);
		oos.flush();
		oos.close();
	}
	/**********************************************************/
	/**********************************************************/
	/**********************************************************/
	

	/*
	 * insert(create)
	 */
	public void insert(MemberVO addMember) throws Exception{
		System.out.println("[3] Member insert");
		
		ArrayList<MemberVO> memberList = readFile();
		memberList.add(addMember);
		saveData(memberList);
	}
	
	/*
	 * 	select(read) : ��� 1�� select
	 */
	public MemberVO selectByNo(int no) throws Exception{
		System.out.println("[3] Member select by no");
		MemberVO findMember=null;
		ArrayList<MemberVO> memberList = readFile();
		for (MemberVO memberVO : memberList) {
			if(memberVO.getNo()==no){
				findMember = memberVO;
				break;
			}
		}
		return findMember;
	}
	
	public MemberVO selectById(String id) throws Exception{
		System.out.println("[3] Member select by id");
		MemberVO findMember = null;
		ArrayList<MemberVO> memberList = readFile();
		for (MemberVO memberVO : memberList) {
			if(memberVO.getId().equals(id)){
				findMember = memberVO;
				break;
			}
		}
		return findMember;
	}
	
	public MemberVO selectByName(String name) throws Exception{
		System.out.println("[3] Member select by name");
		MemberVO findMember = null;
		ArrayList<MemberVO> memberList = readFile();
		for (MemberVO memberVO : memberList) {
			if(memberVO.getName().equals(name)){
				findMember = memberVO;
				break;
			}
		}
		return findMember;
	}
	
	/*
	 * 	select(read) : ��� ������ select
	 */
	//��ü ��� Dao�� ȣ���ϴ� �������� ������ ���񽺿��� ������ ó��������Ѵ�.
	public ArrayList<MemberVO> selectAll() throws Exception{
		System.out.println("[3] Members selectAll");
		ArrayList<MemberVO> memberList = readFile();
		return memberList;
	}
	/*
	 * 	update
	 */
	public void update(MemberVO updateM) throws Exception{
		System.out.println("[3] Members update");
		ArrayList<MemberVO> memberList=this.readFile();
		for (MemberVO memberVO : memberList) {
			if(memberVO.getNo()==updateM.getNo()){
				
				memberVO.setEmail(updateM.getEmail());
				memberVO.setLogin(updateM.isLogin());
				memberVO.setName(updateM.getName());
				memberVO.setNo(updateM.getNo());
				memberVO.setPassword(updateM.getPassword());
				break;
			}
		}
		this.saveData(memberList);
		
	}
	
	public void updateAuth(MemberVO updateM) throws Exception{
		System.out.println("[3] Members update");
		ArrayList<MemberVO> memberList=this.readFile();
		for (MemberVO memberVO : memberList) {
			if(memberVO.getNo()==updateM.getNo()){
				memberVO.setAuth(updateM.getAuth());
				break;
			}
		}
		this.saveData(memberList);
	}
	
	public void updateLoginStatus(MemberVO updateM) throws Exception{
		System.out.println("[3] Members update");
		ArrayList<MemberVO> memberList=this.readFile();
		for (MemberVO memberVO : memberList) {
			if(memberVO.getNo()==updateM.getNo()){
				if(memberVO.isLogin()==false){
					memberVO.setLogin(true);
				}else{
					memberVO.setLogin(false);
				}
				break;
			}
		}
		this.saveData(memberList);
	}
	
	/*
	 * 	delete
	 */
	public void deleteById(String id) throws Exception{
		ArrayList<MemberVO> memberList=this.readFile();
		for (MemberVO memberVO : memberList) {
			if(memberVO.getId().equals(id)){
				memberList.remove(memberVO);
				break;
			}
		}
		this.saveData(memberList);
	}
	
}
