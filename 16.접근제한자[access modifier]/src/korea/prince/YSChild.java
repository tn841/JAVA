package korea.prince;

import america.president.Bush;
import korea.president.DJ;
import korea.president.YS;

public class YSChild extends YS{
	
	public void access(){
		DJ dj = new DJ();
		dj.a = 1;
		dj.a();
		
		YS ys = new YS();	//��� �ܼ��� �θ��� ��ü�� ������ �� ��ü ��ü�� ChildŬ������ ��Ӱ��踦 �̷�� ���� �ƴϴ�.
		ys.a = 1;
		System.out.println(ys);
		
		
		this.a = 1;		
		System.out.println(this);
		this.b = 1;	//Child�� ��������鼭 ����� �̷�����µ�, �̶� ��Ӱ��谡 �ξ�����, this�� ���� protected����� ���� �����ϴ�.
		
		
		//protected ����� ���Ե� Ŭ������ �����ϴ� ���� ���Ǿ���.
		//protected�� ���� API�� ����ϴ� ����� �˰� ������ ��.
		//� �θ� Ŭ������ ��� �ް�, protected����� ���� �Ϸ��� this.�� ���ؼ� ��������.

		
	}
}
