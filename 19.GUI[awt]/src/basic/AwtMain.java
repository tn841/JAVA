package basic;

import java.awt.Color;
import java.awt.Frame;

import javax.swing.JFrame;

/*
GUI 프로그램방법
	1. 컨테이너준비(Frame,Dialog,Window)
    2. 컴포넌트 준비 (Button,List,Canvas,TextArea,TextField)
	3. 컨테이너에 컴포넌트를 부친다(add)
	4. 컨테이너의 크기설정
	5. 컨테이너 보여주기.
*/

public class AwtMain {
	public static void main(String[] args)  {
		// 1. 컨테이너 준비(Frame, Dialog, Window)
		Frame frame = new Frame();
		JFrame jf = new JFrame();

		frame.setBackground(new Color(255, 255, 155));
		// 4. 컨테이너 크기 설정
		frame.setSize(300, 400);

		// 5. 컨테이너 보여주기
		frame.setVisible(true);

		/*
		 * Container.setVisible(true); - 호출 시 GUI쓰레드(event쓰레드)가 만들어진다. - GUI쓰레드는
		 * 무한대기하면서 이벤트와 그래픽처리를 한다.
		 */

	}
}