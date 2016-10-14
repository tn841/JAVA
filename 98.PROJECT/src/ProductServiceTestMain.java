import java.util.ArrayList;

public class ProductServiceTestMain {

	public static void main(String[] args) throws Exception{
		ProductService productService=new ProductService();
		System.out.println("-------力前府胶飘------");
		ArrayList<ProductVO> productList=productService.productList();
		System.out.println(productList);
		System.out.println("-------力前惑技------");
		ProductVO product=productService.productDetail(3);
		System.out.println(product);
		System.out.println(productService.productDetail(2));
		
	}

}
