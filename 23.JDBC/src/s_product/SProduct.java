package s_product;

import java.sql.Date;

/*
 이름         널        유형            
---------- -------- ------------- 
ID         NOT NULL NUMBER(7)     
NAME                VARCHAR2(50)  
SHORT_DESC          VARCHAR2(255) 
PRICE               NUMBER(10,3)  
IPGO_DATE           DATE       
 */
public class SProduct {
	private int id;
	private String namel;
	private String short_desc;
	private int price;
	private Date ipgo_date;
	
		
	
	public SProduct(int id, String namel, String short_desc, int price, Date ipgo_date) {
		super();
		this.id = id;
		this.namel = namel;
		this.short_desc = short_desc;
		this.price = price;
		this.ipgo_date = ipgo_date;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNamel() {
		return namel;
	}
	public void setNamel(String namel) {
		this.namel = namel;
	}
	public String getShort_desc() {
		return short_desc;
	}
	public void setShort_desc(String short_desc) {
		this.short_desc = short_desc;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Date getIpgo_date() {
		return ipgo_date;
	}
	public void setIpgo_date(Date ipgo_date) {
		this.ipgo_date = ipgo_date;
	}
}
