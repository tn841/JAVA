import java.io.Serializable;

public class ProductVO implements Serializable{
	
	/*
	 * 제품번호는 중복되지앟는다. 
	 */
	private int no;
	private String name;
	private int price;
	private String desc;
	public ProductVO() {
		// TODO Auto-generated constructor stub
	}
	public ProductVO(int no, String name, int price, String desc) {
		super();
		this.no = no;
		this.name = name;
		this.price = price;
		this.desc = desc;
	}
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return no+"\t"+name+"\t"+price+"\t"+desc;
	}

}
