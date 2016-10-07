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
		
		//JFrame은 컴포넌트들을 담을 root Panel(ContentPanel)을 가지고 있어서 layout셋팅시 아래와 같이 해야한다.
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(sp, BorderLayout.CENTER);
		
		
		JMenuBar menuBar=new JMenuBar();
		JMenu fileMenu=new JMenu("파일");
		JMenu editMenu=new JMenu("편집");
		JMenuItem newItem=new JMenuItem("새파일",KeyEvent.VK_N);
		JMenuItem openItem=new JMenuItem("열기");
		JMenuItem saveItem=new JMenuItem("저장");
		JMenuItem exitItem=new JMenuItem("종료");
		
		
		fileMenu.add(newItem);
		fileMenu.add(openItem);
		fileMenu.add(saveItem);
		fileMenu.insertSeparator(3);
		fileMenu.add(exitItem);
		
		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		
		
		setJMenuBar(menuBar);
		
		this.setTitle("심플 메모장");
		this.setSize(300,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new NotePadSwing();
	}

}
