package com.itwill.cafe.member;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/*
 * 	DAO(Data Access Object)
 * 		- 멤버 데이터를 저장하고있는 파일(또는 테이블)에 CRUD 작업을 할수 있는 단위 메소드를 가지고 있는 클래스
 * 		- MemberService의 요청을 받아서 Data Accessing에 관련된 단위기능을 수행하는 클래스(insert,select,update,delete 메쏘드)
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
	 * 	초기화 메쏘드
	 */
	private void init() throws Exception{
		memberFile = new File("member.dat");
		if(!memberFile.exists()){//파일이 존재하지 않을 경우
			memberFile.createNewFile(); //파일을 만든다. 실패할 경우? UI까지 알려줘야한다. -> Execption 처리
			ObjectOutputStream oos = new ObjectOutputStream(
					new FileOutputStream(memberFile));
			ArrayList<MemberVO> memberList = new ArrayList<MemberVO>();
			memberList.add(new MemberVO(0, "admin", "관리자", "1111", false, "", 0, 0, 0,0));
			oos.writeObject(memberList);	//첫 생성시 빈 ArrayList write 해줘야함
			
			oos.close();
		}	
	}
	
	/*
	 * 	파일 읽기(연결)
	 */
	private ArrayList<MemberVO> readFile() throws Exception{
		//데이터 소스 전체를 메모리에 로드하기
		ObjectInputStream ois = new ObjectInputStream(
				new FileInputStream(memberFile));
		
		ArrayList<MemberVO> memberList = (ArrayList<MemberVO>)ois.readObject();
		return memberList;
	}

	
	/*
	 * 	파일 쓰기(연결 해제)
	 */
	private void saveData(ArrayList<MemberVO> memberList) throws Exception {
		//메모리의 데이터를 파일로 쓰기
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
	 * 	select(read) : 멤버 1개 select
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
	 * 	select(read) : 멤버 여러개 select
	 */
	//전체 출력 Dao를 호출하는 권한적인 문제는 서비스에서 적절히 처리해줘야한다.
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
