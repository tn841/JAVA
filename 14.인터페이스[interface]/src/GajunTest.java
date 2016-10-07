                                                
public class GajunTest {                        
	public GajunOnOff[] gajunArr;          
	
	public void test(){
		for (int i = 0; i < gajunArr.length; i++) {
			gajunArr[i].on();
			GajunVolume temp = (GajunVolume)gajunArr[i];
			temp.up();
			temp.donw();
			gajunArr[i].off();
			System.out.println("---------------гу╟щ-------------");
		}
	}
}                                               
                                                


