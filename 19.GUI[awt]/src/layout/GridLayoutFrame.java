package layout;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.LayoutManager;

public class GridLayoutFrame extends Frame {
	Button[] btnArr;
	Button btnEqual;

	public GridLayoutFrame() {

		btnArr = new Button[10];
		for (int i = 0; i < btnArr.length; i++) {
			btnArr[i] = new Button(new String(Integer.toString(i)));
		}
		btnEqual = new Button("=");

		LayoutManager mgr = new GridLayout(0, 6); // 6��¥�� ���� �˾Ƽ� �׸��带 ����ش�. ������
													// 5�ȼ���
		this.setLayout(mgr);

		for (int i = 0; i < btnArr.length; i++) {
			this.add(btnArr[i]);
		}

		this.setSize(200, 200);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new GridLayoutFrame();
	}

}
