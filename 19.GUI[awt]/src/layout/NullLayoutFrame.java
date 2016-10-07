package layout;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;

/*
GUI ���α׷����
	1. �����̳��غ�(Frame,Dialog,Window)
   	2. ������Ʈ �غ� (Button,List,Canvas,TextArea,TextField)
	3. �����̳ʿ� ������Ʈ�� ���δ�(add)
   	4. �����̳��� ũ�⼳��
	5. �����̳� �����ֱ�.
*/

public class NullLayoutFrame extends Frame {
	private Button loginB;
	private Button cancleB;
	private TextField idTF;
	private TextField pwTF;
	private Label idL;
	private Label pwL;

	public NullLayoutFrame() {
		// 1. �����̳� �غ�

		// 2. ������Ʈ �غ�
		loginB = new Button("�α���");
		cancleB = new Button("���");
		idTF = new TextField();
		pwTF = new TextField();
		idL = new Label("ID");
		pwL = new Label("PW");

		this.setLayout(null); // �⺻������ �����ϰ� �ִ� ���̾ƿ� �Ŵ����� ����

		// 3. �����̳ʿ� ������Ʈ add
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

		// 4. �����̳� ũ�� ����
		this.setSize(300, 400);

		// 5. �����̳� �����ֱ�
		this.setVisible(true);

	}

	public static void main(String[] args) {
		new NullLayoutFrame(); // �ֽ����尡 �����ϰ� �� return ��, GUI�����尡 �׻� �����Ǹ鼭 �̺�Ʈ
								// ó������ ����Ѵ�.
	}
}
