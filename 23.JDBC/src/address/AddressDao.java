package address;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.itwill.jdbc.common.ConnectionFactory;
import com.itwill.jdbc.common.ConnectionPool;

/*
 DAO(Data Access Object)
  - DataSource(DB,File,기존시스템)의 연결작업을 한다.
  - address table에 접근해서 Cread Read Update Delete(CRUD)
    에를 하는 단위메쏘드를 가지고있는 클래스
  - 비지니스객체(Service,Manager)가 사용해서 업무를 구현   
 */
public class AddressDao {
	
	public void insert(int no,String id,String name,String phone,String address) throws Exception{
		String driverClass="oracle.jdbc.driver.OracleDriver";
		String url="jdbc:oracle:thin:@210.16.214.203:1521:XE";
		String user="user21";
		String pass="user21";
		String insertSQL="insert into address values(?,?,?,?,?)";
		/*
		이름      널        유형           
		------- -------- ------------ 
		NO      NOT NULL NUMBER(4)    
		ID               VARCHAR2(6)  
		NAME             VARCHAR2(20) 
		PHONE            VARCHAR2(15) 
		ADDRESS          VARCHAR2(60)
		 */
	
		Class.forName(driverClass);
		Connection con=DriverManager.getConnection(url, user, pass);
		PreparedStatement pstmt=con.prepareStatement(insertSQL);
		pstmt.setInt(1, no);
		pstmt.setString(2, id);
		pstmt.setString(3, name);
		pstmt.setString(4, phone);
		pstmt.setString(5, address);
		
		int insertRowCount = pstmt.executeUpdate();
		System.out.println(">> "+insertRowCount+" insert");
		
		pstmt.close();
		con.close();
		
		
	}
	
	
	public int insert(AddressDTO addrDTO) throws Exception{
		String sql = "insert into address values(address_no_seq.nextval,?,?,?,?)";
		Connection con = ConnectionFactory.getConnection();		
		PreparedStatement pstmt = con.prepareStatement(sql);
		/*
		이름      널        유형           
		------- -------- ------------ 
		NO      NOT NULL NUMBER(4)    
		ID               VARCHAR2(6)  
		NAME             VARCHAR2(20) 
		PHONE            VARCHAR2(15) 
		ADDRESS          VARCHAR2(60)
		 */
		//pstmt.setInt(1, addrDTO.getNo());
		pstmt.setString(1, addrDTO.getId());
		pstmt.setString(2, addrDTO.getName());
		pstmt.setString(3, addrDTO.getPhone());
		pstmt.setString(4, addrDTO.getAddress());
		
		int insertRowCount = pstmt.executeUpdate();
		System.out.println(">> "+insertRowCount+" insert");
		pstmt.close();
		
		con.close();
		
		return insertRowCount;
		
	}
	
	
	public int delete(int no) throws Exception{
		String sql = "delete from address where no = "+Integer.toString(no);
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		int deleteRow = pstmt.executeUpdate();
		System.out.println(">>> delete : "+deleteRow);
		ConnectionPool.getInstance().releaseConnection(con);
		return deleteRow;
		
	}
	
	public int update(int no, String addr) throws Exception{
		String sql = "update address set address = ? where no = ?";
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1, addr);
		pstmt.setInt(2, no);
		
		boolean isResultSet = pstmt.execute();
		int updateRowCount = 0;
		if(!isResultSet){
			updateRowCount = pstmt.getUpdateCount();
		}
		System.out.println(">>> update : "+updateRowCount);
		ConnectionPool.getInstance().releaseConnection(con);
		return updateRowCount;
	}
	
	public AddressDTO selectOne(int no) throws Exception{
		String sql = "select * from address where no = ?";
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		/*
		이름      널        유형           
		------- -------- ------------ 
		NO      NOT NULL NUMBER(4)    
		ID               VARCHAR2(6)  
		NAME             VARCHAR2(20) 
		PHONE            VARCHAR2(15) 
		ADDRESS          VARCHAR2(60)
		 */
		pstmt.setInt(1, no);
		
		boolean isResultSet = pstmt.execute();
		AddressDTO one = null;
		
		if(isResultSet){
			ResultSet rs = pstmt.getResultSet();
			while(rs.next()){
				one = new AddressDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));	
			}
			rs.close();
		}
		pstmt.close();
		con.close();
		return one;
	}
	
	public ArrayList<AddressDTO> selectAll() throws Exception{
		ArrayList<AddressDTO> addrList = new ArrayList<AddressDTO>();
		
		String sql = "select * from address order by no";
		Connection con = ConnectionFactory.getConnection();
		Statement stmt = con.createStatement();
		
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()){
			addrList.add(new AddressDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
		}
		rs.close();
		stmt.close();
		con.close();
		
		return addrList;
	}
}
