package event;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class 익명내부클래스 extends JFrame{
	
	
	public 익명내부클래스(){
		JPanel panelBtn = new JPanel();
		JButton btn1 = new JButton("내부");
		JButton btn2 = new JButton("익명내부1");
		JButton btn3 = new JButton("익명내부2");
		
		panelBtn.setLayout(new FlowLayout());
		panelBtn.add(btn1);
		panelBtn.add(btn2);
		panelBtn.add(btn3);
		
		btnActionHandler actionH = new btnActionHandler();
		btn1.addActionListener(actionH);
		
		
		btn2.addActionListener(new ActionListener() {	/******익명 내부 클래스 $1****/
			public void actionPerformed(ActionEvent e) {
				System.out.println(e.getActionCommand());
				try {
					Thread.sleep(2000);	//이런 작업을 하면 안돼..
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}											/*****************************/
		});
		
		btn3.addActionListener(new ActionListener() {	/******익명 내부 클래스 $2****/
			public void actionPerformed(ActionEvent e) {
				System.out.println(e.getActionCommand());				
			}											/******************************/
		});
		
		this.getContentPane().add(panelBtn, BorderLayout.SOUTH);	//ContentPane()에 붙여한다.
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300,400);
		this.setVisible(true);
	}
	
	/****************내부 클래스(이벤트 핸들러)************************/
	public class btnActionHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("내부");
		}
	}
	/******************************************************************/
	
	public static void main(String[] args) {
		new 익명내부클래스();
	}

}
