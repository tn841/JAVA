import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
import java.util.*; //ArrayList ��������

//ArrayList�� ����� �����͸� ������� ������ �׸��� �׸��� ������ ������ Ŭ����
public class DrawingPanel extends JPanel 
{
	//data
	private ArrayList<DrawData> dataList;	//�޸𸮰� ����ϴ� �� ���� ������ �����ϱ����� ArrayList�� �����Ͽ�����, ArrayList�� ���ø��̴�.
	private int nDrawMode;					//��ο� ��带 ������ ���� ����

	private Point pt;						//����Ʈ ��ǥ�� ������ ��ü ����
	private int nPointSize;					//����Ʈ ũ�⸦ ������ ���� ����
	
	private PrimaryPanel primary;			//11.26����Ŭ������ �����ϱ����� ����
	
	private DrawMouseListener drawMouseL;	//���콺 ������ ��ü ����
	
	private Color selectedColor;			//11.26 ���õ� ���� ������ ��ü ����
	
	private Point pt1, pt2;					//11.26 ���� ����Ʈ�� �� ����Ʈ ���� ������ ��üpt1, pt2 ����
	
	private Point ptDrag1, ptDrag2;			//11.26 �巹���Ҷ��� ��ǥ���� ������ ��ü 2�� ����
	private boolean bDrag;					//11.26 �巹������ �ƴ��� �Ǵ��� boolean���� ����
	
	
	//method
	public DrawingPanel(PrimaryPanel panel){	//11.26�����ڿ� ����Ŭ���� ��ü�� �Ķ���ͷ� ����
		
		primary = panel;						//11.26 ����Ŭ����Primary�� �Ķ���ͷ� ������ �ڽ�(panel)�� ����!!
		drawMouseL = new DrawMouseListener();	//���콺 ������ ����
		this.addMouseListener(drawMouseL);		//���콺 ������ add
		this.addMouseMotionListener(drawMouseL);//11.26 ���콺 ��� ������ add
				
		dataList = new ArrayList<DrawData>();	//ArrayList ����
		
		//data �ʱ�ȭ
		nDrawMode = DrawConstants.NONE;			//test�� ���� POINT�� �ѰŰ� �ʱⰪ�� NULL����.
		pt = new Point();						//��ǥ�� ������ ��ü �ʱ�ȭ
		nPointSize = primary.getPointSize();		//11.26 ����Ʈ ������� ���� Ŭ�������� ������ ������ �ʱ�ȭ
		selectedColor = primary.getSelectedColor();	//11.26 selectedColor���� ����Ŭ�������� ������ ������ �ʱ�ȭ
		
		pt1 = new Point(); 						//11.26 ����
		pt2 = new Point(); 						//11.26 ����
		
		ptDrag1 = new Point();					//11.26 ����
		ptDrag2 = new Point();					//11.26 ����
		bDrag = false;							//11.26 ����
		
	}//DrawingPanel()
	
	
	
	//DrawMode�� PointSize�� primaryPanel���� �̺�Ʈ�� �߻������� �ٲ�Ƿ� ����Ŭ����(primaryPanel)�� ����ϱ����� set�޼ҵ尡 �ʿ��ϴ�!!!!!
	public void setDrawMode(int mode){nDrawMode = mode;}	//DrawMode ����
	public void setPointSize(int size){nPointSize = size;}	//PointSize ����
	
	
	public void paintComponent(Graphics page){	//�׸��� �׸��� paintComponent�޼ҵ�
		super.paintComponent(page);				//�θ𿡰� ������ ��� �´�.
		
		page.drawRect(0, 0, 599, 479);			//�׵θ� ǥ�ø� ���� drawRect�̿�, ©�� ������ ���� -1����
		
		if(bDrag){								//11.26 bDrag�� true�϶�, �巡���� ��츦 ó�� 
			
			selectedColor = primary.getSelectedColor();	//11.26 ����Ŭ�������� ������ ���� ��������
			page.setColor(selectedColor);		//11.26 ���� �����ѵ�
						
			switch(nDrawMode){					//DrawMode�� ���� �׸��� �׸���.
			case DrawConstants.LINE:				//���� �׸��� ���
				page.drawLine(ptDrag1.x, ptDrag1.y, ptDrag2.x, ptDrag2.y);//11.26 drawLine���� �׸���
				break;
			case DrawConstants.RECT:				//�簢���� �׸��� ���
				drawingRect(page, ptDrag1.x, ptDrag1.y, ptDrag2.x, ptDrag2.y);	//�簢���� �׸��� ������ �޼ҵ带 ����� ����ϰ� ó��.
				break;
			case DrawConstants.OVAL:				//���� �׸��� ���
				drawingOval(page, ptDrag1.x, ptDrag1.y, ptDrag2.x, ptDrag2.y);	//���� �׸��� ������ �޼ҵ带 ����� ����ϰ� ó��.
				break;
		
			}//switch
		}//if
		
		
		//����Ʈ�� ����Ȱ��� �ϳ��� ������ DrawMode�� ��ǥ ������ ���� �׸��� �׸�
		for(int i=0; i<dataList.size(); i++){			//����Ʈ�� ����� ���� ��ŭ�� �׸��� �׸������� dataList.size()��ŭ.
			DrawData tempData = dataList.get(i);		//����Ʈ�� ����� ��ü �ϳ��� �����ͼ� tempData�� ����
			page.setColor(tempData.getSelectedColor());	//11.26 ����Ŭ�������� ���õ� ���� ������ ���� ����.
			
			switch(tempData.getDrawMode()){				//����Ʈ���� ������ ��ü�� DrwMode�� ����.
			case DrawConstants.POINT:					//�� �׸���
				page.fillOval(	tempData.getX()-tempData.getPointSize()/2,	//���� ������ ��ġ�� ����� �ϱ����� ����Ʈ ����� 2�� ���� ���� ����
								tempData.getY()-tempData.getPointSize()/2,	//���� ������ ��ġ�� ����� �ϱ����� ����Ʈ ����� 2�� ���� ���� ����
								tempData.getPointSize(), 					//���� ũ�⼳��
								tempData.getPointSize());					//���� ũ�⼳��
				break;
			case DrawConstants.LINE:					//�� �׸���
				//����Ʈ���� ������ ��ü�� (x1,y1) (x2,y2)��ǥ�� �̿��Ͽ� ���� �׸�
				page.drawLine(tempData.getX1(), tempData.getY1(), tempData.getX2(), tempData.getY2());
				break;
			case DrawConstants.RECT:					//�簢�� �׸���
				drawingRect(page, tempData.getX1(), tempData.getY1(), tempData.getX2(), tempData.getY2());	//drawingRect�Լ� ȣ��	
				break;
			case DrawConstants.OVAL:					//�� �׸���
				drawingOval(page, tempData.getX1(), tempData.getY1(), tempData.getX2(), tempData.getY2());	//drawingOval�Լ� ȣ��
				break;
			case DrawConstants.FREE:
				page.fillOval(tempData.getX()-(3/2), tempData.getY()-(3/2), 3, 3);	//���� �׸���. ���� �߽��� Ŀ���� ���
				break;
			}
		}//for
	}//paintComponent()
	
	
	//���� �׷����� 4���� ��쿡 ���� ���� �׷��ִ� drawingOval�Լ�
	public void drawingOval(Graphics page, int x1, int y1, int x2, int y2){	//�Ķ���ͷ� �׸����ִ� ����, x1��ǥ, y1��ǥ, x2��ǥ, y2��ǥ�� �޾� Oval�� ���ǿ� ���� �׷��ִ� �Լ�
		if(x1>x2 && y1>y2) page.drawOval(x2, y2, (x1-x2), (y1-y2));	//������, ������, ū�ſ��� ������, ū�ſ��� ������
		else if(x1>x2 && y1<y2) page.drawOval(x2, y1, x1-x2, y2-y1);
		else if(x1<x2 && y1>y2)	page.drawOval(x1, y2, x2-x1, y1-y2);
		else if(x1<x2 && y1<y2) page.drawOval(x1, y1, x2-x1, y2-y1);
	}//drawingOval()
	
	//�簢���� �׷����� 4���� ��쿡 ���� �簢���� �׷��ִ� drawingRect�Լ�
	public void drawingRect(Graphics page, int x1, int y1, int x2, int y2){
		if(x1>x2 && y1>y2) page.drawRect(x2, y2, (x1-x2), (y1-y2));	//������, ������, ū�ſ��� ������, ū�ſ��� ������
		else if(x1>x2 && y1<y2) page.drawRect(x2, y1, x1-x2, y2-y1);
		else if(x1<x2 && y1>y2)	page.drawRect(x1, y2, x2-x1, y1-y2);
		else if(x1<x2 && y1<y2) page.drawRect(x1, y1, x2-x1, y2-y1);
	}//drawingRect()

	
	//������ Ŭ����
	private class DrawMouseListener implements MouseListener, MouseMotionListener{	//���콺 ������, ���콺 ��� ������ ����

		public void mouseClicked(MouseEvent event) {	//11.26 ���콺�� Ŭ���Ǿ��� �� �̺�Ʈ�� �ڵ鸵�Ѵ�. 
						
			if(nDrawMode == DrawConstants.POINT){		//11.26 DrawMode�� Point�϶�
				nPointSize = primary.getPointSize();	//11.26 ����Ŭ�������� ����Ʈ ũ�Ⱚ�� �����´� (upcall)
														//���� Ŭ�������� ����Ŭ������ ���ϴ� ���� upcall�̶�� �Ѵ�. ��������δ� downcall �����̴�.
				selectedColor = primary.getSelectedColor();	//11.26 ����Ŭ�������� ���� ������ �����´�
				
				dataList.add(new DrawData(nDrawMode, event.getPoint(), nPointSize, selectedColor));	//���� Ŭ�������� ������ ���� ���� �����͵��� ArrayList�� �����Ѵ�.
																									//���� �Ҷ� DrawData��ü�� �����Ͽ� ����.
				repaint();								//ArrayList�� �����͸� �־����Ƿ� repaint() �޼ҵ� ȣ���Ͽ� �ٽ� �׸��� �׷���.
			}//if
			
		}//mouesClicked()

		public void mouseEntered(MouseEvent event) {}	//���콺�� Entered�Ǿ��� �� �̺�Ʈ�ڵ鸵
		
		public void mouseExited(MouseEvent event) {}	//���콺�� Exited�Ǿ��� �� �̺�Ʈ �ڵ鸵

		public void mousePressed(MouseEvent event) {	//���콺�� ������ �� �̺�Ʈ �ڵ鸵, �� ���� ���� �簢���� ���� �׸��� �����.
			if(nDrawMode == DrawConstants.LINE ||
				nDrawMode == DrawConstants.RECT || 
				nDrawMode == DrawConstants.OVAL)
			{
				pt1 = event.getPoint();			//���� ��ǥ�� ����.
				
				//dragó���� ����
				ptDrag1 = event.getPoint();		//ptDrag1���� ���� ��ǥ�� ����
				bDrag = true;					//bDrag���� Ȱ��ȭ
			}//if
			else if(nDrawMode == DrawConstants.FREE){
				pt = event.getPoint();
				selectedColor = primary.getSelectedColor();
				dataList.add(new DrawData(nDrawMode, pt, selectedColor));
				repaint();
			}
		}//11.26 mousePressed()

		public void mouseReleased(MouseEvent event) {		//���콺�� �������� �� �̺�Ʈ �ڵ鸵, �� ���� �� �� �簢��&���� ��츦 ���� ���� ó��
			if(nDrawMode == DrawConstants.LINE){			//���� ���
				pt2 = event.getPoint();						//�������� ���� ��ǥ���� ����.
				
				selectedColor = primary.getSelectedColor();	//���� Ŭ�������� ���� ������ ������.
				dataList.add(new DrawData(nDrawMode, pt1, pt2, selectedColor));	//11.26 ���ο� �ʿ��� ������(��ο� ���, ������, ����, ��)�� �Ķ���ͷ��ϴ� DrawData��ü�� �����Ͽ� Arraylist�� add.
				bDrag = false; 								//11.26 drag�� �������� �˸�
				repaint();									//����� �����͸� �ٽ� �׸�
			}//if
			else if(nDrawMode == DrawConstants.RECT ||		//�簢��&�� �� ���
					nDrawMode == DrawConstants.OVAL ){
				bDrag = false;								//drag�� �������� �˸�
				pt2 = event.getPoint();						//�������� ���� ��ǥ���� ����.
				selectedColor = primary.getSelectedColor();	//���� Ŭ�������� ���� ������ ������
				dataList.add(new DrawData( nDrawMode, pt1, pt2, selectedColor));	//DrawData�� �����Ͽ� �Ķ���ͷ� ������ ������ ���, ArrayList�� add.
				
				repaint(); //����� �����͸� �ٽ� �׸�
			}//else if
			else if(nDrawMode == DrawConstants.FREE){
				pt = event.getPoint();
				selectedColor = primary.getSelectedColor();
				dataList.add(new DrawData(nDrawMode, pt, selectedColor));
				repaint();
			}
				
		}//11.26 mouseReleased()
		
		public void mouseDragged(MouseEvent event){	//�巹���� ��, �� ���� �������⸸ �ϸ� �ȴ�. �����͸� ������ �ʿ�� ����.
			if(		nDrawMode == DrawConstants.LINE || 
					nDrawMode == DrawConstants.RECT ||
					nDrawMode == DrawConstants.OVAL){	//11.26 ��ǥ ������ ������ �ʿ����
				ptDrag2 = event.getPoint();		//�� ��ǥ ���� ��������
				repaint();						//�ٷιٷ� �ٽ� �׸� (������ ����.)
			}
			else if(nDrawMode == DrawConstants.FREE){
				pt = event.getPoint();
				selectedColor = primary.getSelectedColor();
				dataList.add(new DrawData(nDrawMode, pt, selectedColor));
				repaint();
			}
		}//11.26 mouseDragged()
		
		public void mouseMoved(MouseEvent event){}		//���콺�� Moved�Ҷ� �̺�Ʈ �ڵ鸵
		
	}// DrawMouseListener class

}// DrawingPanel class
