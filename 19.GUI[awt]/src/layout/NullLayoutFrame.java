package layout;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;

/*
GUI 프로그램방법
	1. 컨테이너준비(Frame,Dialog,Window)
   	2. 컴포넌트 준비 (Button,List,Canvas,TextArea,TextField)
	3. 컨테이너에 컴포넌트를 붙인다(add)
   	4. 컨테이너의 크기설정
	5. 컨테이너 보여주기.
*/

public class NullLayoutFrame extends Frame {
	private Button loginB;
	private Button cancleB;
	private TextField idTF;
	private TextField pwTF;
	private Label idL;
	private Label pwL;

	public NullLayoutFrame() {
		// 1. 컨테이너 준비

		// 2. 컴포넌트 준비
		loginB = new Button("로그인");
		cancleB = new Button("취소");
		idTF = new TextField();
		pwTF = new TextField();
		idL = new Label("ID");
		pwL = new Label("PW");

		this.setLayout(null); // 기본적으로 동작하고 있는 레이아웃 매니저를 제거

		// 3. 컨테이너에 컴포넌트 add
		this.add(loginB);
		loginB.setBounds(50, 300, 100, 50);
		this.add(cancleB);
		cancleB.setBounds(150, 300, 100, 50);

		idTF.setBounds(100, 100, 150, 20);
		this.add(idTF);
		pwTF.setBounds(100, 130, 150, 20);
		pwTF.setEchoCharacter('*');
		this.add(pwTF);

		idL.setBounds(50, 100, 50, 20);
		this.add(idL);
		pwL.setBounds(50, 130, 50, 20);
		this.add(pwL);

		// 4. 컨테이너 크기 지정
		this.setSize(300, 400);

		// 5. 컨테이너 보여주기
		this.setVisible(true);

	}

	public static void main(String[] args) {
		new NullLayoutFrame(); // 주스레드가 동작하고 곧 return 됨, GUI쓰레드가 항상 유지되면서 이벤트
								// 처리등을 담당한다.
	}
}
