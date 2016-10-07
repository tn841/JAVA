/*
 * 오버라이딩(재정의) - Overriding
 *   1. 상속관계에서 발생하는 메쏘드의 재정의 기법이다
 *   2. 자바의 다형성 기법중의하나이다.
 *   
 *   -형태 : 부모클래스에정의 된 메쏘드의 이름,리턴타입,인자가
 *          동일한 메쏘드를 자식클래스에 정의(재정의)하는것
 * 
 *   - ex> public class Super{
 *   			public void print(){
 *   			}		
 *   		}
 *        
 *        public class Sub extends Super{
 *        		public void print(){
 *        		}
 *        }
 * 
 */

public class OverridingMain {

	public static void main(String[] args) {
		Overriding ol = new Overriding();
		ol.method1();
		ol.method2();
		System.out.println("------------------------------------");
		
		OverridingChild oc = new OverridingChild();
		oc.method1();
		oc.method2();	//재정의된 메소드 호출
		oc.method3();
		
		//왜 굳이 같은 이름의 메소드를 이용해서 재정의를 해야하나?
		//그냥 메소드이름을 다르게 하면 되지 않나?
		
	}

}
