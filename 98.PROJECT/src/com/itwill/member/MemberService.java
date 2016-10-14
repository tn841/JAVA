package com.itwill.member;

import java.util.ArrayList;

/*
 - 멤버관리를 위한 비즈니스(업무) 기능을 제공하는 객체
 - UI에서 이객체의 특정기능을 사용하서 업무를수행한다.
 - 비즈니스(업무)메쏘드 실행시 DataAccess가 필요한경우
    MemberDao의 단위메쏘드(insert,select,update,delete)
    를 사용해서(메쏘드호출) 업무처리
 - 멤버변수(데이타)를 가지지않는다.
 */
public class MemberService {
	private MemberDao membeDao;
	public MemberService() throws Exception{
		membeDao=new MemberDao();
	}
	/*
	 * 1.회원가입
	 */
	public boolean joinMember(Member addMember) throws Exception{
		System.out.println("2. MemberService.joinMember()");
		/*
		 * A  . 아이디중복체크(DataSource(파일)읽기)
		 * 	
		 * 	B-1. 중복되지않으면 가입(DataSource(파일)저장) true return
		 *  
		 * 	B-2. 중복됐으면 false return
		 * 
		 */
		boolean success=false;
		Member findMember=membeDao.selectById(addMember.getId());
		//findMember=new Member();
		if(findMember==null){
			//중복안됨
			membeDao.insert(addMember);
			success=true;
		}else{
			//중복
			success=false;
		}
		return success;
	}
	
	/*
	 * 2.로그인
	 */
	public boolean login(String id,String password) throws Exception{
		System.out.println("2.MemberService.login()");
		boolean isSuccess=false;
		/*
		 * A. id의 존재여부(DataSouce(파일)읽기)
		 *    
		 *    A-1. id 존재하면 password검사 
		 *        - password일치하면 true return
		 *        - password일치하지않으면 false return
		 *        
		 *    A-2. id 존재하지않으면 false return 
		 */
		Member findMember = membeDao.selectById(id);
		if(findMember==null){
			//id안존재하는경우
			isSuccess=false;
		}else{
			//id존재하는경우
			if(findMember.matchPassword(password)){
				isSuccess=true;
			}else{
				isSuccess=false;
			}
		}
		//return true;
		return isSuccess;
	}
	/*
	 * 3.회원삭제(탈퇴)
	 */
	
	
	
	/*
	 * 4.회원수정
	 */
	
	
	/*
	 * 5.회원검색(각필드별로검색)
	 *   - 1명
	 *   - 여러명
	 /
	 *   
	 * 6.회원리스트  
	 */
	public ArrayList<Member> getMemberList() throws Exception {
		return membeDao.selectAll();
		
	}
	
	
	
}
