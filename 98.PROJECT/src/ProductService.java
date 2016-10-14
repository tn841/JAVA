import java.util.ArrayList;

public class ProductService {
	private ProductDao productDao;
	//private MemberDao memberDao;
	public ProductService() throws Exception {
		productDao=new ProductDao();
	}
	
	
	/*
	 * 화면정의서에 기술된업무를 참조하여
	 * 메쏘드를 정의한다.
	 */
	/*
	 * 제품전체리스트
	 */
	public ArrayList<ProductVO> productList() throws Exception{
		
		ArrayList<ProductVO> productList=productDao.selectAll();
		return productList;
	}
	
	/*
	 * 제품상세보기
	 */
	public ProductVO productDetail(int no) throws Exception{
		ProductVO findProduct=productDao.selectByNo(no);
		return findProduct;
	}
	/*
	 * 제품수정
	 */
	
	
	
}
