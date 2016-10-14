package com.itwill.member;

import java.util.ArrayList;

/*
 - ��������� ���� ����Ͻ�(����) ����� �����ϴ� ��ü
 - UI���� �̰�ü�� Ư������� ����ϼ� �����������Ѵ�.
 - ����Ͻ�(����)�޽�� ����� DataAccess�� �ʿ��Ѱ��
    MemberDao�� �����޽��(insert,select,update,delete)
    �� ����ؼ�(�޽��ȣ��) ����ó��
 - �������(����Ÿ)�� �������ʴ´�.
 */
public class MemberService {
	private MemberDao membeDao;
	public MemberService() throws Exception{
		membeDao=new MemberDao();
	}
	/*
	 * 1.ȸ������
	 */
	public boolean joinMember(Member addMember) throws Exception{
		System.out.println("2. MemberService.joinMember()");
		/*
		 * A  . ���̵��ߺ�üũ(DataSource(����)�б�)
		 * 	
		 * 	B-1. �ߺ����������� ����(DataSource(����)����) true return
		 *  
		 * 	B-2. �ߺ������� false return
		 * 
		 */
		boolean success=false;
		Member findMember=membeDao.selectById(addMember.getId());
		//findMember=new Member();
		if(findMember==null){
			//�ߺ��ȵ�
			membeDao.insert(addMember);
			success=true;
		}else{
			//�ߺ�
			success=false;
		}
		return success;
	}
	
	/*
	 * 2.�α���
	 */
	public boolean login(String id,String password) throws Exception{
		System.out.println("2.MemberService.login()");
		boolean isSuccess=false;
		/*
		 * A. id�� ���翩��(DataSouce(����)�б�)
		 *    
		 *    A-1. id �����ϸ� password�˻� 
		 *        - password��ġ�ϸ� true return
		 *        - password��ġ���������� false return
		 *        
		 *    A-2. id �������������� false return 
		 */
		Member findMember = membeDao.selectById(id);
		if(findMember==null){
			//id�������ϴ°��
			isSuccess=false;
		}else{
			//id�����ϴ°��
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
	 * 3.ȸ������(Ż��)
	 */
	
	
	
	/*
	 * 4.ȸ������
	 */
	
	
	/*
	 * 5.ȸ���˻�(���ʵ庰�ΰ˻�)
	 *   - 1��
	 *   - ������
	 /
	 *   
	 * 6.ȸ������Ʈ  
	 */
	public ArrayList<Member> getMemberList() throws Exception {
		return membeDao.selectAll();
		
	}
	
	
	
}
