import java.util.ArrayList;

public class ProductServiceTestMain {

	public static void main(String[] args) throws Exception{
		ProductService productService=new ProductService();
		System.out.println("-------��ǰ����Ʈ------");
		ArrayList<ProductVO> productList=productService.productList();
		System.out.println(productList);
		System.out.println("-------��ǰ��------");
		ProductVO product=productService.productDetail(3);
		System.out.println(product);
		System.out.println(productService.productDetail(2));
		
	}

}
