package dept;

public class DepartmentDaoImplMain {

	public static void main(String[] args) throws Exception {
		DepartmentsDao deptDao = new DepartmentDaoImpl();
		
		deptDao.insert(null);
		deptDao.selectByNo(0);
		deptDao.update(null);
		deptDao.selectByAll();
	}

}
