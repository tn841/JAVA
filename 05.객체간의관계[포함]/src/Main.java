
public class Main {

	public static void main(String[] args) {
		Engine[] eng = new Engine[(int)(Math.random()*1000000)];
		
		System.out.println();
		for(int i=0; i<eng.length; i++){
			String tmp = "TYPE"+i;
			eng[i] = new Engine(tmp,i);
			eng[i].print();
		}
		
	}

}
