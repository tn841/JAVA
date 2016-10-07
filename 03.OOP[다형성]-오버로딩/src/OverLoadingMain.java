
public class OverLoadingMain {

	public static void main(String[] args) {
		OverLoading ol=new OverLoading();
		ol.method();
		ol.method(1);
		ol.method(1,2);
		ol.method("KIM","LEE");
		ol.method("KIM",34);
		ol.method("KIM");
	}

}
