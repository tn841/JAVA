import java.util.ArrayList;

public class ProductDaoTestMain {

	public static void main(String[] args)throws Exception {
		
		ProductDao produtDao=new ProductDao();
		System.out.println("-----insert--------");
		/*
		produtDao.insert(new ProductVO(1,"NOTE 7",900000,"NOTE 7 좋아요"));
		produtDao.insert(new ProductVO(2,"NOTE 5",900000,"NOTE 5 좋아요"));
		produtDao.insert(new ProductVO(3,"NOTE 8",990000,"NOTE 8 좋아요"));
		*/
		System.out.println("-----selectByNo--------");
		ProductVO findProduct=produtDao.selectByNo(3);
		System.out.println(findProduct);
		System.out.println("-----selectAll--------");
		ArrayList<ProductVO> productList=produtDao.selectAll();
		for (ProductVO productVO : productList) {
			System.out.println(productVO);
		}
		System.out.println("-----delete--------");
		produtDao.delete(1);
		productList=produtDao.selectAll();
		for (ProductVO productVO : productList) {
			System.out.println(productVO);
		}
		System.out.println("-----update--------");
		ProductVO updateProduct=new ProductVO(3, "GALAXY 7", 250000, "방수기능!!");
		produtDao.update(updateProduct);
		System.out.println(produtDao.selectByNo(3));
	}

}
