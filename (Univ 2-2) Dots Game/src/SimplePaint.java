import javax.swing.*;

//����̹� Ŭ������ SimplePaint Ŭ����
public class SimplePaint {

	public static void main(String[] args) {		//����
		JFrame frame = new JFrame("SimplePaint");	//JFrame��ü ���� �� ����
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//���� ���� ���� �˸�
		
		PrimaryPanel primary = new PrimaryPanel();	//primaryPanel ���� �� ����
		frame.getContentPane().add(primary);		//����, �ü���� �����ϴ� frame�� ���� ������ �����µ� getContentPane() -> primary������Ʈ�� add()�Ѵ�.
		
		frame.pack();								//frame�� pack()�ϰ�
		frame.setVisible(true);						//frame�� ���̵��� ����
	}

}


/* 	
  	�⸻��� 1�� : line by line���� �ּ��ޱ� - �̸��Ұ�
   	�⸻��� 2�� : Rect�� Oval �����ϱ� (fill ����) - �̸��ؿð�
   	�⸻��� 3,4�� : �Ⱦ˷���
 */