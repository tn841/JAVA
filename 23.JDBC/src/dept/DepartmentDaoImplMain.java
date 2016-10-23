package dept;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class DepartmentDaoImplMain {

	public static void main(String[] args) throws Exception {
		/*
		 �̸�     ��        ����           
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
		System.out.print("\n>> ���� ������ �μ� ��ȣ : ");
		String input = in.readLine();
		System.out.print(">> ���� : ");
		String loc = in.readLine();
		
		
		Department dept = new Department(Integer.parseInt(input), input+"DEPT", loc);
		
		deptDao.insert(dept);
		deptList = deptDao.selectByAll();
		for (Department temp_dept : deptList) {
			System.out.println(temp_dept.getDeptno()+"\t"+temp_dept.getDname()+"\t"+temp_dept.getLoc());
		}
		
		
		
		
		deptDao.selectByNo(0);
		deptDao.update(null);
	}

}
