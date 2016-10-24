package dept;



import java.util.ArrayList;

/**
 * 
 * dept 테이블과 관련된 비즈니스 규약 메소드 선언
 *
 * @author  
 */
public interface DepartmentsDao {
	// 부서 등록
		public void insert(Department deparment) throws Exception;
		// 부서 변경
		public void update(Department deparment) throws Exception;
		
		// 부서번호로 부서정보 반환
		public Department selectByNo(int deptno) throws Exception;
		// 부서 전체목록 반환
		public ArrayList<Department> selectByAll() throws Exception;
		// 사원정보에 따른 전체목록 반환
		public ArrayList selectEmployees() throws Exception;
		
}






