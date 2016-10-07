package com.itwill.cafe.member;

import java.util.ArrayList;

import com.itwill.cafe.main.FirstPageService;



/*
 	- 멤버 관리를 위한 비즈니스클래스
 	- UI클래스에서 이 서비스객체를 사용하여 기능을 수행
 	- 비즈니스 메소드 실행 시 Data Access가 필요하면 MemberDao의 단위 메소드(insert, select, update, delete)를 사용
 	- 멤버변수를 가지지않는다.(데이터없음)
 */
public class MemberService {	//관리자 기능은 따로 구현하는 것이 유지보수 확장성에 좋음
	
	private MemberDao memberDao;	//데이터 접근시 사용하는 Dao 객체

	public MemberService() throws Exception{
		memberDao = new MemberDao();
	}
	
	/*
	 * 	1. 회원가입
	 */
	public boolean joinMember(MemberVO m) throws Exception{
		/*
		 * 	1) 아이디 중복 체크 (DATA파일 읽어서)
		 * 
		 * 	2-1) 중복아니면 가입되고 (DATA 저장) return true;
		 * 
		 * 	2-2) 중복되면 이미 있는 id입니다. return false;
		 */
		System.out.println("[2] MemberService.joinMember");
		ArrayList<MemberVO> memberList = memberDao.selectAll();
		for (MemberVO memberVO : memberList) {
			if(memberVO.getId().equals(m.getId())){
				return false;
			}
		}
		m.setNo(returnLastNo()+1);
		memberDao.insert(m);
		return true;
	}
	
	/*
	 * 	2. 로그인
	 */
	public boolean login(String id, String pw) throws Exception{
		/*
		 * 	1) id의 존재 여부 (DATA파일 읽어서 확인)
		 * 	
		 * 	2-1) id존재하면 pw검사
		 * 		- pw일치
		 * 		- pw불일치
		 * 
		 * 	2-2) id존재하지 않으면 return false;
		 */
		MemberVO memberVO=memberDao.selectById(id);
		if(memberVO==null){
			return false;
		}else{
			if(memberVO.matchPassword(pw)){
				FirstPageService.setActiveMember(memberVO);
				return true;
			}else{
				return false;
			}
		}
	}
	
	/*
	 * 	3. 회원 탈퇴
	 */
	public boolean deleteMember() throws Exception{
		System.out.println(FirstPageService.getActiveMember());
		memberDao.deleteById(FirstPageService.getActiveMember().getId());
		return true;
	}
	
	/*
	 * 	4. 회원 정보 수정
	 */
	public boolean modifyMember(MemberVO m) throws Exception{
		m.setNo(FirstPageService.activeMember.getNo());
		memberDao.update(m);
		return true;
	}
	
	/*
	 * 	5. 회원 검색(각 필드별로 검색 - 회원명, 권한, ..)
	 * 	 - 1명
	 * 	 - 여러명
	 */
	public ArrayList<MemberVO> getMemberList() throws Exception{
		ArrayList<MemberVO> memberList = memberDao.selectAll();
		return memberList;
	}
	
	/*
	 * 현재 로그인한 회원 검색
	 */
	public MemberVO findLoginMember() throws Exception {
		ArrayList<MemberVO> memberList = memberDao.selectAll();
		MemberVO memberVOTmp=null;
		for (MemberVO memberVO : memberList) {
			if(memberVO.isLogin()==true){
				memberVOTmp=memberVO;
			}
		}
		return memberVOTmp;
	}
	
	/*
	 * 로그아웃
	 */
	public boolean logout() throws Exception{
		//memberDao.updateLoginStatus(new MemberVO(findLoginMember().getNo(), "", "", "", false, "", 0, 0, 0, 0));
		FirstPageService.setActiveMember(null);
		return true;
	}
	
	/*
	 * 아이디, 비밀번호 찾기
	 */
	public MemberVO findidpass(MemberVO m) throws Exception{
		MemberVO memberVOTmp=memberDao.selectByName(m.getName());
		if(memberVOTmp.matchbirth(m.getBirth())&&memberVOTmp.matchEMail(m.getEmail())){
			return memberVOTmp;
		}
		return null;
	}
	
	/*
	 * 권한 설정 메쏘드
	 */
	public void setAuth(String id, int auth) throws Exception{
		memberDao.updateAuth(new MemberVO(memberDao.selectById(id).getNo(), "", "", "", false, "", 0, auth, 0, 0));
	}
	
	/*
	 * 	6.아이디로 회원 객체 반환
	 */
	public MemberVO returnMember(String id)throws Exception{
		return memberDao.selectById(id);
	}
	
	/*
	 * 회원 객체들 중 마지막 객체의 고유번호 반환 메쏘드
	 */
	public int returnLastNo() throws Exception{
		ArrayList<MemberVO> memberList = memberDao.selectAll();
			return memberList.get(memberList.size()-1).getNo();
	}
	
	public boolean removeById(String id) throws Exception{
        memberDao.deleteById(id);
        return true;
    }
}
