
public class GajunFactoryMain {

	public static void main(String[] args) {
		GajunTV tv1 = new GajunTV();
		GajunTV tv2 = new GajunTV();
		
		GajunAudio audio = new GajunAudio();
		
		GajunMp3 mp1 = new GajunMp3();
		GajunMp3 mp2 = new GajunMp3();
		
		GajunOnOff[] gajunArr = new GajunOnOff[5];
		gajunArr[0] = tv1;
		gajunArr[1] = tv2;
		gajunArr[2] = audio;
		gajunArr[3] = mp1;
		gajunArr[4] = mp2;	//상위로의 캐스팅 - 문제없다.
		
		System.out.println("-------------검사---------------");
		
		//검사의 행위를 정의한 GajunTest클래스 객체를 통해서 검사를 진행한다. (유지 보수 확장성)
		GajunTest gt = new GajunTest();	
		gt.gajunArr = gajunArr;
		gt.test();
		
		/*GajunOnOff[] ga = gajunArr;
		
		for (int i = 0; i < ga.length; i++) {
			ga[i].on();
			GajunVolume tempGajun = (GajunVolume)ga[i];	//강제 캐스팅 (볼륨 검사를 위해)
			tempGajun.up();
			tempGajun.donw();
			ga[i].off();
			System.out.println("--------------출고------------");
		}
		 */		
	}

	
}
