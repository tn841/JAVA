import java.util.ArrayList;

public class ProductService {
	private ProductDao productDao;
	//private MemberDao memberDao;
	public ProductService() throws Exception {
		productDao=new ProductDao();
	}
	
	
	/*
	 * ȭ�����Ǽ��� ����Ⱦ����� �����Ͽ�
	 * �޽�带 �����Ѵ�.
	 */
	/*
	 * ��ǰ��ü����Ʈ
	 */
	public ArrayList<ProductVO> productList() throws Exception{
		
		ArrayList<ProductVO> productList=productDao.selectAll();
		return productList;
	}
	
	/*
	 * ��ǰ�󼼺���
	 */
	public ProductVO productDetail(int no) throws Exception{
		ProductVO findProduct=productDao.selectByNo(no);
		return findProduct;
	}
	/*
	 * ��ǰ����
	 */
	
	
	
}
