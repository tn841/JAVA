public class GajunTV implements GajunOnOff, GajunVolume {
		
		public void func1() {
			System.out.println("func1()");
		}

		@Override
		public void up() {
			System.out.println("tv.up()");
		}

		@Override
		public void donw() {
			// TODO Auto-generated method stub
			System.out.println("tv.down()");
		}

		@Override
		public void on() {
			// TODO Auto-generated method stub
			System.out.println("tv.on()");
		}

		@Override
		public void off() {
			// TODO Auto-generated method stub
			System.out.println("tv.off()");
		}
	}