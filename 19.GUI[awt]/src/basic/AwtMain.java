package basic;

import java.awt.Color;
import java.awt.Frame;

import javax.swing.JFrame;

/*
GUI ���α׷����
	1. �����̳��غ�(Frame,Dialog,Window)
    2. ������Ʈ �غ� (Button,List,Canvas,TextArea,TextField)
	3. �����̳ʿ� ������Ʈ�� ��ģ��(add)
	4. �����̳��� ũ�⼳��
	5. �����̳� �����ֱ�.
*/

public class AwtMain {
	public static void main(String[] args)  {
		// 1. �����̳� �غ�(Frame, Dialog, Window)
		Frame frame = new Frame();
		JFrame jf = new JFrame();

		frame.setBackground(new Color(255, 255, 155));
		// 4. �����̳� ũ�� ����
		frame.setSize(300, 400);

		// 5. �����̳� �����ֱ�
		frame.setVisible(true);

		/*
		 * Container.setVisible(true); - ȣ�� �� GUI������(event������)�� ���������. - GUI�������
		 * ���Ѵ���ϸ鼭 �̺�Ʈ�� �׷���ó���� �Ѵ�.
		 */

	}
}