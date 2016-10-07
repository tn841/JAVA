
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
		gajunArr[4] = mp2;	//�������� ĳ���� - ��������.
		
		System.out.println("-------------�˻�---------------");
		
		//�˻��� ������ ������ GajunTestŬ���� ��ü�� ���ؼ� �˻縦 �����Ѵ�. (���� ���� Ȯ�强)
		GajunTest gt = new GajunTest();	
		gt.gajunArr = gajunArr;
		gt.test();
		
		/*GajunOnOff[] ga = gajunArr;
		
		for (int i = 0; i < ga.length; i++) {
			ga[i].on();
			GajunVolume tempGajun = (GajunVolume)ga[i];	//���� ĳ���� (���� �˻縦 ����)
			tempGajun.up();
			tempGajun.donw();
			ga[i].off();
			System.out.println("--------------���------------");
		}
		 */		
	}

	
}
