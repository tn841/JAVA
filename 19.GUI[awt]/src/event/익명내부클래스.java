package event;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class �͸���Ŭ���� extends JFrame{
	
	
	public �͸���Ŭ����(){
		JPanel panelBtn = new JPanel();
		JButton btn1 = new JButton("����");
		JButton btn2 = new JButton("�͸���1");
		JButton btn3 = new JButton("�͸���2");
		
		panelBtn.setLayout(new FlowLayout());
		panelBtn.add(btn1);
		panelBtn.add(btn2);
		panelBtn.add(btn3);
		
		btnActionHandler actionH = new btnActionHandler();
		btn1.addActionListener(actionH);
		
		
		btn2.addActionListener(new ActionListener() {	/******�͸� ���� Ŭ���� $1****/
			public void actionPerformed(ActionEvent e) {
				System.out.println(e.getActionCommand());
				try {
					Thread.sleep(2000);	//�̷� �۾��� �ϸ� �ȵ�..
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}											/*****************************/
		});
		
		btn3.addActionListener(new ActionListener() {	/******�͸� ���� Ŭ���� $2****/
			public void actionPerformed(ActionEvent e) {
				System.out.println(e.getActionCommand());				
			}											/******************************/
		});
		
		this.getContentPane().add(panelBtn, BorderLayout.SOUTH);	//ContentPane()�� �ٿ��Ѵ�.
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300,400);
		this.setVisible(true);
	}
	
	/****************���� Ŭ����(�̺�Ʈ �ڵ鷯)************************/
	public class btnActionHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("����");
		}
	}
	/******************************************************************/
	
	public static void main(String[] args) {
		new �͸���Ŭ����();
	}

}
