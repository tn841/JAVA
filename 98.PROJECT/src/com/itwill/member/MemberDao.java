package com.itwill.member;

import java.util.ArrayList;

public interface MemberDao {

	/*
	 * insert(create)
	 */
	void insert(Member addMember) throws Exception;

	/*
	 * select(read): ¸â¹ö 1°³ select
	 */
	Member selectById(String id) throws Exception;

	/*
	 * select(read): ¸â¹ö ¿©·¯°³ select
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