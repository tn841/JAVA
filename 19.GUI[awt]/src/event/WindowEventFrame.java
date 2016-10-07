package event;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
/*
XXXEvent program방법
1. XXXEvent Source 선정(Frame)--> XXXEvent
2. XXXEvent Handler 클래스 작성
	 - XXXListener interface를 implements 한다
3. XXXEvent Source 와 XXXEvent Handler객체를 연결해준다.
   - xxxEventSource객체.addXXXListener(XXXEventHandler객체);
*/        
public class WindowEventFrame extends Frame{
	TextArea logTA;
	public WindowEventFrame() {
		logTA=new TextArea("*******event log******\n");
		add(logTA,BorderLayout.CENTER);
		
		//WindowEvent 처리
		this.addWindowListener(new WindowHandler());
		
		setSize(300, 400);
		setVisible(true);
	}
	/*******WindowHandler[WindowListener impl]******/
	public class WindowHandler implements WindowListener{
		public void windowOpened(WindowEvent e) {
			logTA.append("windowOpened\n");
		}
		public void windowClosing(WindowEvent e) {
			logTA.append("windowClosing\n");
//			//Terminates the currently running Java Virtual Machine.
			System.exit(0);
			
		}
		public void windowClosed(WindowEvent e) {
			logTA.append("windowClosed\n");
		}
		public void windowIconified(WindowEvent e) {
			logTA.append("windowIconified\n");
		}
		public void windowDeiconified(WindowEvent e) {
			logTA.append("windowDeiconified\n");
		}
		public void windowActivated(WindowEvent e) {
			logTA.append("windowActivated\n");
		}
		public void windowDeactivated(WindowEvent e) {
			logTA.append("windowDeactivated\n");
		}
	}	
	/************************************************/
	
	
	public static void main(String[] args) {
		new WindowEventFrame();

	}

}
