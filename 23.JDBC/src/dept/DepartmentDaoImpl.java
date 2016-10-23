package dept;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

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
		String sql = "insert into DEPT values(?, ?, ?)";
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		pstmt.setInt(1, dept.getDeptno());
		pstmt.setString(2, dept.getDname());
		pstmt.setString(3, dept.getLoc());
		
		pstmt.executeUpdate();
	}

	@Override
	public void update(Department deparment) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Department selectByNo(int deptno) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Department> selectByAll() throws Exception {
		ArrayList<Department> deptList = new ArrayList<Department>();
		
		String sql = "select * from dept";
		Connection con = ConnectionFactory.getConnection();
		Statement stmt = con.createStatement();
		
		ResultSet rs = stmt.executeQuery(sql);
		
		while(rs.next()){
			deptList.add(new Department(rs.getInt(1), rs.getString(2), rs.getString(3)));
		}
		rs.close();
		stmt.close();
		con.close();
		
		
		return deptList;
	}


}
