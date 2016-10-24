package dept;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class DepartmentDaoImplMain {

	public static void main(String[] args) throws Exception {
		/*
		 이름     널        유형           
		------ -------- ------------ 
		DEPTNO NOT NULL NUMBER(2)    
		DNAME           VARCHAR2(14) 
		LOC             VARCHAR2(13) 
		 */
		DepartmentsDao deptDao = new DepartmentDaoImpl();
		ArrayList<Department> deptList = new ArrayList<Department>();
		
		deptList = deptDao.selectByAll();
		for (Department temp_dept : deptList) {
			System.out.println(temp_dept.getDeptno()+"\t"+temp_dept.getDname()+"\t"+temp_dept.getLoc());
		}
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("\n>> 새로 생성할 부서 번호 : ");
		String input = in.readLine();
		System.out.print(">> 지역 : ");
		String loc = in.readLine();
		
		
		Department dept = new Department(Integer.parseInt(input), input+"DEPT", loc);
		
		deptDao.insert(dept);
		deptList = deptDao.selectByAll();
		for (Department temp_dept : deptList) {
			System.out.println(temp_dept.getDeptno()+"\t"+temp_dept.getDname()+"\t"+temp_dept.getLoc());
		}
		
		
		System.out.println("------5.select emp_dept list");
		
		ArrayList<HashMap<String, Object>> empMapList =	deptDao.selectEmployees();
		for (HashMap<String, Object> rowMap : empMapList) {
			int empno=(int)rowMap.get("empno");
			String ename=(String)rowMap.get("ename");
			String job=(String)rowMap.get("job");
			String dname=(String)rowMap.get("dname");
			String loc2=(String)rowMap.get("loc");
			System.out.println(empno+"\t"+ename+"\t"+job+"\t"+dname+"\t"+loc2);
		}
		
		
		
		
		
		
		deptDao.selectByNo(0);
		deptDao.update(null);
		
		
		
		
		
	}

}
