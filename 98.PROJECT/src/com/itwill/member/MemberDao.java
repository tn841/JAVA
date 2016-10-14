package com.itwill.member;

import java.util.ArrayList;

public interface MemberDao {

	/*
	 * insert(create)
	 */
	void insert(Member addMember) throws Exception;

	/*
	 * select(read): ��� 1�� select
	 */
	Member selectById(String id) throws Exception;

	/*
	 * select(read): ��� ������ select
	 */
	ArrayList<Member> selectAll() throws Exception;

	/*
	 * update 
	 */
	void update(Member updateMember);

	/*
	 * delete
	 */
	void deleteById(String id) throws Exception;

}