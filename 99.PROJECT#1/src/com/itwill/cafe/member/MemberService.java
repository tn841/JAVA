package com.itwill.cafe.member;

import java.util.ArrayList;

import com.itwill.cafe.main.FirstPageService;



/*
 	- ��� ������ ���� ����Ͻ�Ŭ����
 	- UIŬ�������� �� ���񽺰�ü�� ����Ͽ� ����� ����
 	- ����Ͻ� �޼ҵ� ���� �� Data Access�� �ʿ��ϸ� MemberDao�� ���� �޼ҵ�(insert, select, update, delete)�� ���
 	- ��������� �������ʴ´�.(�����;���)
 */
public class MemberService {	//������ ����� ���� �����ϴ� ���� �������� Ȯ�强�� ����
	
	private MemberDao memberDao;	//������ ���ٽ� ����ϴ� Dao ��ü

	public MemberService() throws Exception{
		memberDao = new MemberDao();
	}
	
	/*
	 * 	1. ȸ������
	 */
	public boolean joinMember(MemberVO m) throws Exception{
		/*
		 * 	1) ���̵� �ߺ� üũ (DATA���� �о)
		 * 
		 * 	2-1) �ߺ��ƴϸ� ���Եǰ� (DATA ����) return true;
		 * 
		 * 	2-2) �ߺ��Ǹ� �̹� �ִ� id�Դϴ�. return false;
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
	 * 	2. �α���
	 */
	public boolean login(String id, String pw) throws Exception{
		/*
		 * 	1) id�� ���� ���� (DATA���� �о Ȯ��)
		 * 	
		 * 	2-1) id�����ϸ� pw�˻�
		 * 		- pw��ġ
		 * 		- pw����ġ
		 * 
		 * 	2-2) id�������� ������ return false;
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
	 * 	3. ȸ�� Ż��
	 */
	public boolean deleteMember() throws Exception{
		System.out.println(FirstPageService.getActiveMember());
		memberDao.deleteById(FirstPageService.getActiveMember().getId());
		return true;
	}
	
	/*
	 * 	4. ȸ�� ���� ����
	 */
	public boolean modifyMember(MemberVO m) throws Exception{
		m.setNo(FirstPageService.activeMember.getNo());
		memberDao.update(m);
		return true;
	}
	
	/*
	 * 	5. ȸ�� �˻�(�� �ʵ庰�� �˻� - ȸ����, ����, ..)
	 * 	 - 1��
	 * 	 - ������
	 */
	public ArrayList<MemberVO> getMemberList() throws Exception{
		ArrayList<MemberVO> memberList = memberDao.selectAll();
		return memberList;
	}
	
	/*
	 * ���� �α����� ȸ�� �˻�
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
	 * �α׾ƿ�
	 */
	public boolean logout() throws Exception{
		//memberDao.updateLoginStatus(new MemberVO(findLoginMember().getNo(), "", "", "", false, "", 0, 0, 0, 0));
		FirstPageService.setActiveMember(null);
		return true;
	}
	
	/*
	 * ���̵�, ��й�ȣ ã��
	 */
	public MemberVO findidpass(MemberVO m) throws Exception{
		MemberVO memberVOTmp=memberDao.selectByName(m.getName());
		if(memberVOTmp.matchbirth(m.getBirth())&&memberVOTmp.matchEMail(m.getEmail())){
			return memberVOTmp;
		}
		return null;
	}
	
	/*
	 * ���� ���� �޽��
	 */
	public void setAuth(String id, int auth) throws Exception{
		memberDao.updateAuth(new MemberVO(memberDao.selectById(id).getNo(), "", "", "", false, "", 0, auth, 0, 0));
	}
	
	/*
	 * 	6.���̵�� ȸ�� ��ü ��ȯ
	 */
	public MemberVO returnMember(String id)throws Exception{
		return memberDao.selectById(id);
	}
	
	/*
	 * ȸ�� ��ü�� �� ������ ��ü�� ������ȣ ��ȯ �޽��
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
