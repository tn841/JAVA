package dept;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.itwill.jdbc.common.ConnectionFactory;

public class DepartmentDaoImpl implements DepartmentsDao {

	/*
	 * 	이름     널        유형           
		------ -------- ------------ 
		DEPTNO NOT NULL NUMBER(2)    
		DNAME           VARCHAR2(14) 
		LOC             VARCHAR2(13) 
	 */
	@Override
	public void insert(Department dept) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try{
			//1. con 얻기
			con = ConnectionFactory.getConnection();
			
			//2. con 사용
			pstmt = con.prepareStatement(DeptSQL.INSERT);

			pstmt.setInt(1, dept.getDeptno());
			pstmt.setString(2, dept.getDname());
			pstmt.setString(3, dept.getLoc());
			
			pstmt.executeUpdate();
		
			//ConnectionFactory.releaseConnection(con);
		}catch(Exception e){
			//ConnectionFactory.releaseConnection(con);
			
		}finally {
			/*
			 *  - exception 발생여부와 관계없이 항상 실행되는 block
			 *  - return 보다 우선한다.
			 *  - Connection은 매우 중요한 자원이므로 메소드 호출 후 항상 release해준다.
			 */
			
			if(pstmt != null){
				pstmt.close();
			}
			//3. con 해제
			if(con != null){
				ConnectionFactory.releaseConnection(con);
			}
		}
	}

	@Override
	public void update(Department dept) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = ConnectionFactory.getConnection();
			pstmt = con.prepareStatement(DeptSQL.UPDATE);
			
			pstmt.setString(1, dept.getDname());
			pstmt.setString(2, dept.getLoc());
			pstmt.setInt(3, dept.getDeptno());
			
			pstmt.executeUpdate();
			
			
		}catch(Exception e){
			
		}finally{
			if(pstmt != null){
				pstmt.close();
			}
			
			if(con != null){
				con.close();
			}
		}
	}

	@Override
	public Department selectByNo(int deptno) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Department findDept = null;
		
		try{
			con = ConnectionFactory.getConnection();
			pstmt = con.prepareStatement(DeptSQL.SELECT_BY_NO);
			
			pstmt.setInt(1, deptno);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				findDept = new Department(rs.getInt(1), rs.getString(2), rs.getString(3));
			}
			
		}finally{
			if(rs!=null)
				rs.close();
			if(pstmt!=null)
				pstmt.close();
			if(con!=null)
				ConnectionFactory.releaseConnection(con);
		}
		

		return findDept;
	}

	@Override
	public ArrayList<Department> selectByAll() throws Exception {
		ArrayList<Department> deptList = new ArrayList<Department>();
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		try{
			con = ConnectionFactory.getConnection();
			stmt = con.createStatement();
			
			rs = stmt.executeQuery(DeptSQL.SELECT_ALL);
			
			while(rs.next()){
				deptList.add(new Department(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
	
		}finally {
			if(rs!= null){
				rs.close();
			}
			
			if(stmt!= null){
				stmt.close();
			}
			
			if(con != null){
				ConnectionFactory.releaseConnection(con);
			}
		}
		
		
		
		return deptList;
	}


	
	// 사원정보(부서명포함) 전체목록 반환
	@Override
	public ArrayList<HashMap<String, Object>> selectEmployees() throws Exception {
		
		ArrayList<HashMap<String, Object>> empList =	new ArrayList<HashMap<String, Object>>();
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try{
			con=ConnectionFactory.getConnection();
			pstmt=con.prepareStatement(DeptSQL.SELECT_EMP_DEPT);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				
				int empno=rs.getInt("empno");
				String ename=rs.getString("ename");
				String job=rs.getString("job");
				String dname=rs.getString("dname");
				String loc=rs.getString("loc");
				
				HashMap<String, Object> rowMap = new HashMap<String, Object>();
				rowMap.put("empno", empno);
				rowMap.put("ename", ename);
				rowMap.put("job", job);
				rowMap.put("dname", dname);
				rowMap.put("loc", loc);
				empList.add(rowMap);
				
			}
			
		}finally {
			if(con!=null)
				ConnectionFactory.releaseConnection(con);
		}
		
		
		return empList;
	}
	


}
