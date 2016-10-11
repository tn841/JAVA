import javax.swing.*;

//드라이버 클래스인 SimplePaint 클래스
public class SimplePaint {

	public static void main(String[] args) {		//메인
		JFrame frame = new JFrame("SimplePaint");	//JFrame객체 선언 및 생성
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//정상 종료 됨을 알림
		
		PrimaryPanel primary = new PrimaryPanel();	//primaryPanel 선언 및 생성
		frame.getContentPane().add(primary);		//먼저, 운영체제가 관리하는 frame에 대한 권한을 가져온뒤 getContentPane() -> primary컴포넌트를 add()한다.
		
		frame.pack();								//frame을 pack()하고
		frame.setVisible(true);						//frame이 보이도록 설정
	}

}


/* 	
  	기말고사 1번 : line by line으로 주석달기 - 미리할것
   	기말고사 2번 : Rect와 Oval 구현하기 (fill 무시) - 미리해올것
   	기말고사 3,4번 : 안알려줌
 */