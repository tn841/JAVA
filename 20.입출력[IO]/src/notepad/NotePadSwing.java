package notepad;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class NotePadSwing extends JFrame {
	JTextArea noteTA;
	
	public NotePadSwing(){
		noteTA = new JTextArea();
		
		JScrollPane sp = new JScrollPane(noteTA);
		
		//JFrame�� ������Ʈ���� ���� root Panel(ContentPanel)�� ������ �־ layout���ý� �Ʒ��� ���� �ؾ��Ѵ�.
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(sp, BorderLayout.CENTER);
		
		
		JMenuBar menuBar=new JMenuBar();
		JMenu fileMenu=new JMenu("����");
		JMenu editMenu=new JMenu("����");
		JMenuItem newItem=new JMenuItem("������",KeyEvent.VK_N);
		JMenuItem openItem=new JMenuItem("����");
		JMenuItem saveItem=new JMenuItem("����");
		JMenuItem exitItem=new JMenuItem("����");
		
		
		fileMenu.add(newItem);
		fileMenu.add(openItem);
		fileMenu.add(saveItem);
		fileMenu.insertSeparator(3);
		fileMenu.add(exitItem);
		
		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		
		
		setJMenuBar(menuBar);
		
		this.setTitle("���� �޸���");
		this.setSize(300,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new NotePadSwing();
	}

}
