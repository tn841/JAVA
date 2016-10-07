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
Event program���

  1. XXXEvent Source ����(Frame)(� ������Ʈ���� �߻��ϴ� �̺�Ʈ�� ó���� ���ΰ�?)--> WindowEvent(ActionEvent)
  2. XXXEvent Handler �ۼ�(Ŭ����)-->XXXEvent Handler�ۼ� (�̺�Ʈ �ڵ鷯 Ŭ���� �ۼ�)
  3. XXXEvent Source �� XXXEvent Handler�� �������ش�.
  
  
  # XXXEvent Handler Ŭ���� �ۼ����
       1.XXXEvent�� �����Ҽ��ִ� XXXListener interface�� implement
       (WindowEvent)       (WindowListener)
  	   2.XXXListener �߻�޽�� ����..
	   (WindowListener)

*/


public class ActionEventFrame extends Frame {
	Panel southbuttonP;
	Button northB;
	Button southB1,southB2,southB3;
	
	
	
	public ActionEventFrame(){
		southbuttonP = new Panel();
		northB = new Button("�̺�Ʈ �ҽ�");
		
		southB1=new Button("�̺�Ʈ�ҽ�1");
		southB2=new Button("�̺�Ʈ�ҽ�2");
		southB3=new Button("�̺�Ʈ�ҽ�3");
		southbuttonP.setLayout(new FlowLayout());
		southbuttonP.add(southB1);
		southbuttonP.add(southB2);
		southbuttonP.add(southB3);
		
		
		LayoutManager mgr= new BorderLayout();	//borderLayout�� Frame�� ����Ʈ ���̾ƿ���
		this.setLayout(mgr);
		
		this.setTitle("�׼��̺�Ʈ");
				
		this.add(northB, BorderLayout.NORTH);
		add(southbuttonP, BorderLayout.SOUTH);
		
		
		ActionEventHandlerInnerClass aehic = new ActionEventHandlerInnerClass(); 
		northB.addActionListener(aehic);
		MultiEventSourceActionEventHandler msaeh = new MultiEventSourceActionEventHandler();
		southB1.addActionListener(msaeh);
		southB2.addActionListener(msaeh);
		southB3.addActionListener(msaeh);
		
		
		/****��� : actionEventSource��ü.addActionEventListener(AciontEventHandler ��ü); ***/
		
		//�ܺ� Ŭ���� �̿� 
		//northB.addActionListener(new ActionEventHandler(this));	//�ܺ� �ڵ鷯 Ŭ������ �̿��ϸ� ���ڷ� this�� �Ѱ������
		
		//�̳� Ŭ���� �̿�
		northB.addActionListener(new EventHandler());	//�̳� Ŭ������ �ڵ鸵�ϸ� ���ڸ� ���� �ѱ� �ʿ䰡 ����.
		
		
		this.setSize(300, 400);
		this.setVisible(true);	//���⼭ GUI������(�̺�Ʈ ������� ����Ʈ ������)�� ����
	}
	
	class EventHandler implements ActionListener{	//�̳� Ŭ����
		
		int count=1;
		
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println(e.getSource()+"dgdgdg");
			
			northB.setLabel("���� Ƚ�� : "+count++);
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
			 * ActionEvent�� �߻��ϸ� �����Ҹ޽��
			 */
			System.out.println("ActionEvent �����Ѹ޽�����:"+Thread.currentThread().getName());
			/*
			 * ActionEventFrame�� ���º���(Ÿ��Ʋ)
			 */
			count++;
			setTitle("��ưŬ��[inner]:"+count);
			setBackground(new Color(255, 255, 0));
		}
		
	}
	
	public static void main(String[] arg){
		new ActionEventFrame();
	}

	
}
