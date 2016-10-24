package s_product;

public class SProductSQL {
	public static final String INSERT_STRING = "INSERT INTO s_product VALUES (?, ?, ?, ?,to_date(?,'yy/mm/dd'))";
	public static final String INSERT_DATE = "INSERT INTO s_product VALUES (?, ?, ?, ?, ?)";
	public static final String INSERT_SEQ_SYSDATE = "INSERT INTO s_product VALUES (s_product_id_seq.nextval, ?, ?, ?,sysdate)";
	
}
