package korea.president;

import america.president.Bush;

public class YS {
	public int a;
	protected int b;
	int c;
	private int d;
	
	public void access(){
		System.out.println("----------���� ��Ű��----------");
		DJ dj = new DJ();
		dj.a = 1;
		dj.b = 1;
		dj.c = 1;
		
		dj.a();
		dj.b();
		dj.c();
		
		System.out.println("----------�ٸ� ��Ű��----------");
		Bush bs = new Bush();
		bs.a = 1;
		bs.a();
		
	}
	
	public void a(){
		System.out.println("public void a()");
	}
	protected void b(){
		System.out.println("protected void b()");
	}
	void c(){
		System.out.println("void c()");
	}
	private void d(){
		System.out.println("private void d()");
	}
}
