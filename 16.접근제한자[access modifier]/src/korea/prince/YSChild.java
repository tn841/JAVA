package korea.prince;

import america.president.Bush;
import korea.president.DJ;
import korea.president.YS;

public class YSChild extends YS{
	
	public void access(){
		DJ dj = new DJ();
		dj.a = 1;
		dj.a();
		
		YS ys = new YS();	//얘는 단순한 부모의 객체일 뿐이지 이 객체 자체가 Child클래스와 상속관계를 이루는 것은 아니다.
		ys.a = 1;
		System.out.println(ys);
		
		
		this.a = 1;		
		System.out.println(this);
		this.b = 1;	//Child가 만들어지면서 상속이 이루어지는데, 이때 상속관계가 맺어지며, this를 통해 protected멤버에 접근 가능하다.
		
		
		//protected 멤버가 포함된 클래스를 정의하는 일은 거의없다.
		//protected가 사용된 API를 사용하는 방법만 알고 있으면 됨.
		//어떤 부모 클래스를 상속 받고, protected멤버에 접근 하려면 this.를 통해서 접근하자.

		
	}
}
