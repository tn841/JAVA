package event;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.LayoutManager;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/*
Event program방법

  1. XXXEvent Source 선정(Frame)(어떤 컴포넌트에서 발생하는 이벤트를 처리할 것인가?)--> WindowEvent(ActionEvent)
  2. XXXEvent Handler 작성(클래스)-->XXXEvent Handler작성 (이벤트 핸들러 클래스 작성)
  3. XXXEvent Source 와 XXXEvent Handler를 연결해준다.
  
  
  # XXXEvent Handler 클래스 작성방법
       1.XXXEvent를 감지할수있는 XXXListener interface를 implement
       (WindowEvent)       (WindowListener)
  	   2.XXXListener 추상메쏘드 구현..
	   (WindowListener)

*/


public class ActionEventFrame extends Frame {
	Panel southbuttonP;
	Button northB;
	Button southB1,southB2,southB3;
	
	
	
	public ActionEventFrame(){
		southbuttonP = new Panel();
		northB = new Button("이벤트 소스");
		
		southB1=new Button("이벤트소스1");
		southB2=new Button("이벤트소스2");
		southB3=new Button("이벤트소스3");
		southbuttonP.setLayout(new FlowLayout());
		southbuttonP.add(southB1);
		southbuttonP.add(southB2);
		southbuttonP.add(southB3);
		
		
		LayoutManager mgr= new BorderLayout();	//borderLayout은 Frame의 디폴트 레이아웃임
		this.setLayout(mgr);
		
		this.setTitle("액션이벤트");
				
		this.add(northB, BorderLayout.NORTH);
		add(southbuttonP, BorderLayout.SOUTH);
		
		
		ActionEventHandlerInnerClass aehic = new ActionEventHandlerInnerClass(); 
		northB.addActionListener(aehic);
		MultiEventSourceActionEventHandler msaeh = new MultiEventSourceActionEventHandler();
		southB1.addActionListener(msaeh);
		southB2.addActionListener(msaeh);
		southB3.addActionListener(msaeh);
		
		
		/****방식 : actionEventSource객체.addActionEventListener(AciontEventHandler 객체); ***/
		
		//외부 클래스 이용 
		//northB.addActionListener(new ActionEventHandler(this));	//외부 핸들러 클래스를 이용하면 인자로 this를 넘겨줘야함
		
		//이너 클래스 이용
		northB.addActionListener(new EventHandler());	//이너 클래스로 핸들링하면 인자를 따로 넘길 필요가 없다.
		
		
		this.setSize(300, 400);
		this.setVisible(true);	//여기서 GUI쓰레드(이벤트 쓰레드와 페인트 쓰레드)가 생성
	}
	
	class EventHandler implements ActionListener{	//이너 클래스
		
		int count=1;
		
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println(e.getSource()+"dgdgdg");
			
			northB.setLabel("눌린 횟수 : "+count++);
		}
		
	}
	
	/*****MultiEventSourceActionEventHandler[inner member class]****/
	public class MultiEventSourceActionEventHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			Object eventSource = e.getSource();
			int r=0,g=0,b=0;
			if(eventSource.equals(southB1)){
				System.out.println("button1");
				r=255;
				g=0;
				b=0;
			}else if(eventSource.equals(southB2)){
				System.out.println("button2");
				r=0;
				g=255;
				b=0;
			}else if(eventSource.equals(southB3)){
				System.out.println("button3");
				r=0;
				g=0;
				b=255;
			}
			setBackground(new Color(r, g, b));
		}
		
	}
	
	
	
	/*****ActionEventHandlerInnerClass[inner member class]****/
	public class ActionEventHandlerInnerClass implements ActionListener{
		int count;
		@Override
		public void actionPerformed(ActionEvent e) {
			/*
			 * ActionEvent가 발생하면 실행할메쏘드
			 */
			System.out.println("ActionEvent 에의한메쏘드실행:"+Thread.currentThread().getName());
			/*
			 * ActionEventFrame의 상태변경(타이틀)
			 */
			count++;
			setTitle("버튼클릭[inner]:"+count);
			setBackground(new Color(255, 255, 0));
		}
		
	}
	
	public static void main(String[] arg){
		new ActionEventFrame();
	}

	
}
