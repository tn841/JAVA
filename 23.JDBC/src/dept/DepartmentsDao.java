package dept;



import java.util.ArrayList;

/**
 * 
 * dept ���̺�� ���õ� ����Ͻ� �Ծ� �޼ҵ� ����
 *
 * @author  
 */
public interface DepartmentsDao {
	// �μ� ���
		public void insert(Department deparment) throws Exception;
		// �μ� ����
		public void update(Department deparment) throws Exception;
		
		// �μ���ȣ�� �μ����� ��ȯ
		public Department selectByNo(int deptno) throws Exception;
		// �μ� ��ü��� ��ȯ
		public ArrayList<Department> selectByAll() throws Exception;
		// ��������� ���� ��ü��� ��ȯ
		public ArrayList selectEmployees() throws Exception;
		
}






