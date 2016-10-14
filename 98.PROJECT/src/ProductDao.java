import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ProductDao {
	
	public ProductDao() throws Exception {
		init();
	}
	
	/*************copy & paste*************/	
	private File file;
	/*
	 * 초기화메쏘드
	 */
	private void init() throws Exception{
		file = new File("product.dat");
		if (!file.exists()) {
			file.createNewFile();
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
			oos.writeObject(new ArrayList<ProductVO>());
			oos.close();
		}
	}
	/*
	 * 파일읽기(연결)
	 */
	private ArrayList<ProductVO> readData() throws Exception {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
		ArrayList<ProductVO> productList = (ArrayList<ProductVO>) ois.readObject();
		return productList;
	}

	/*
	 * 파일쓰기(연결해제)
	 */
	private void saveData(ArrayList<ProductVO> productList) throws Exception {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
		oos.writeObject(productList);
		oos.flush();
		oos.close();
	}
	/****************************************/
	
	public void insert(ProductVO product)throws Exception{
		ArrayList<ProductVO> productList=
				(ArrayList<ProductVO>)this.readData();
		
		productList.add(product);
		
		this.saveData(productList);
		
	}
	public ProductVO selectByNo(int no) throws Exception{
		ProductVO findProduct=null;
		ArrayList<ProductVO> productList=this.readData();
		for (ProductVO productVO : productList) {
			if(productVO.getNo()==no){
				findProduct=productVO;
				break;
			}
		}
		
		return findProduct;
	}
	public void delete(int no) throws Exception{
		ArrayList<ProductVO> productList=this.readData();
		for (ProductVO productVO : productList) {
			if(productVO.getNo()==no){
				productList.remove(productVO);
				break;
			}
		}
		this.saveData(productList);
		
		
	}
	public void update(ProductVO updateProduct) throws Exception{
		ArrayList<ProductVO> productList=this.readData();
		for (ProductVO productVO : productList) {
			if(productVO.getNo()==updateProduct.getNo()){
				
				productVO.setName(updateProduct.getName());
				productVO.setPrice(updateProduct.getPrice());
				productVO.setDesc(updateProduct.getDesc());
			    break;
			}
		}
		this.saveData(productList);
		
		
	}
	public ArrayList<ProductVO> selectAll() throws Exception{
		ArrayList<ProductVO> productList = this.readData();
		
		return productList;
	}
	
	
	
	
	
	
	
	
	
	

}
