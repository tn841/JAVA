package dept;

public class DeptSQL {
	public final static String INSERT=
	"insert into dept(deptno,dname,loc) values(?,?,?)";
	
	public final static String UPDATE=
	"update dept set dname=?,loc=? where deptno = ?";
	
	public final static String SELECT_BY_NO=
	"select deptno ,dname,loc from dept where deptno=?";
	
	public final static String SELECT_BY_NAME=
	"select deptno ,dname,loc from dept where dname=?";
	
	public final static String SELECT_BY_LOC=
	"select deptno ,dname,loc from dept where loc=?";
	
	public final static String SELECT_ALL=
	"select deptno ,dname,loc from dept";
	
	public final static String SELECT_EMP_DEPT=
	"select e.empno,e.ename,e.job,d.dname,d.loc from emp e natural join dept d";

}
