package korea.prince;

import korea.president.DJ;
import korea.president.YS;

public class DJChild extends DJ{
	public void access(){
		this.a = 1;
		this.b = 1;
	
		YS ys = new YS();
		ys.a = 1;
		
		YSChild yC = new YSChild();
		
	}
}
