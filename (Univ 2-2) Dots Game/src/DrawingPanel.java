import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
import java.util.*; //ArrayList 쓰기위해

//ArrayList에 저장된 데이터를 기반으로 실제로 그림을 그리는 과정을 구현한 클래스
public class DrawingPanel extends JPanel 
{
	//data
	private ArrayList<DrawData> dataList;	//메모리가 허락하는 한 많은 도형을 저장하기위해 ArrayList로 선언하였으며, ArrayList는 템플릿이다.
	private int nDrawMode;					//드로우 모드를 저장할 변수 선언

	private Point pt;						//포인트 좌표를 저장할 객체 선언
	private int nPointSize;					//포인트 크기를 저장할 변수 선언
	
	private PrimaryPanel primary;			//11.26상위클래스와 연결하기위해 선언
	
	private DrawMouseListener drawMouseL;	//마우스 리스너 객체 선언
	
	private Color selectedColor;			//11.26 선택된 색을 저장한 객체 선언
	
	private Point pt1, pt2;					//11.26 시작 포인트와 끝 포인트 값을 저장할 객체pt1, pt2 선언
	
	private Point ptDrag1, ptDrag2;			//11.26 드레그할때의 좌표값을 저장할 객체 2개 선언
	private boolean bDrag;					//11.26 드레그인지 아닌지 판단할 boolean변수 선언
	
	
	//method
	public DrawingPanel(PrimaryPanel panel){	//11.26생성자에 상위클래스 객체를 파라미터로 전달
		
		primary = panel;						//11.26 상위클래스Primary에 파라미터로 전달한 자신(panel)을 대입!!
		drawMouseL = new DrawMouseListener();	//마우스 리스너 생성
		this.addMouseListener(drawMouseL);		//마우스 리스너 add
		this.addMouseMotionListener(drawMouseL);//11.26 마우스 모션 리스너 add
				
		dataList = new ArrayList<DrawData>();	//ArrayList 생성
		
		//data 초기화
		nDrawMode = DrawConstants.NONE;			//test를 위해 POINT로 한거고 초기값은 NULL값임.
		pt = new Point();						//좌표를 저장할 객체 초기화
		nPointSize = primary.getPointSize();		//11.26 포인트 사이즈는 상위 클래스에서 가져온 값으로 초기화
		selectedColor = primary.getSelectedColor();	//11.26 selectedColor값도 상위클래스에서 가져온 값으로 초기화
		
		pt1 = new Point(); 						//11.26 생성
		pt2 = new Point(); 						//11.26 생성
		
		ptDrag1 = new Point();					//11.26 생성
		ptDrag2 = new Point();					//11.26 생성
		bDrag = false;							//11.26 생성
		
	}//DrawingPanel()
	
	
	
	//DrawMode와 PointSize는 primaryPanel에서 이벤트가 발생했을때 바뀌므로 상위클래스(primaryPanel)와 통신하기위해 set메소드가 필요하다!!!!!
	public void setDrawMode(int mode){nDrawMode = mode;}	//DrawMode 변경
	public void setPointSize(int size){nPointSize = size;}	//PointSize 변경
	
	
	public void paintComponent(Graphics page){	//그림을 그리는 paintComponent메소드
		super.paintComponent(page);				//부모에게 권한을 얻어 온다.
		
		page.drawRect(0, 0, 599, 479);			//테두리 표시를 위해 drawRect이용, 짤림 방지를 위해 -1해줌
		
		if(bDrag){								//11.26 bDrag가 true일때, 드래그인 경우를 처리 
			
			selectedColor = primary.getSelectedColor();	//11.26 상위클래스에서 설정된 색을 가져오고
			page.setColor(selectedColor);		//11.26 색을 설정한뒤
						
			switch(nDrawMode){					//DrawMode에 따라서 그림을 그린다.
			case DrawConstants.LINE:				//선을 그리는 경우
				page.drawLine(ptDrag1.x, ptDrag1.y, ptDrag2.x, ptDrag2.y);//11.26 drawLine으로 그린다
				break;
			case DrawConstants.RECT:				//사각형을 그리는 경우
				drawingRect(page, ptDrag1.x, ptDrag1.y, ptDrag2.x, ptDrag2.y);	//사각형을 그리는 별도의 메소드를 만들어 깔끔하게 처리.
				break;
			case DrawConstants.OVAL:				//원을 그리는 경우
				drawingOval(page, ptDrag1.x, ptDrag1.y, ptDrag2.x, ptDrag2.y);	//원을 그리는 별도의 메소드를 만들어 깔끔하게 처리.
				break;
		
			}//switch
		}//if
		
		
		//리스트에 저장된것을 하나씩 꺼내어 DrawMode및 좌표 정보에 따라 그림을 그림
		for(int i=0; i<dataList.size(); i++){			//리스트에 저장된 갯수 만큼의 그림을 그리기위해 dataList.size()만큼.
			DrawData tempData = dataList.get(i);		//리스트에 저장된 객체 하나를 가져와서 tempData에 저장
			page.setColor(tempData.getSelectedColor());	//11.26 상위클래스에서 선택된 색을 가져와 색을 설정.
			
			switch(tempData.getDrawMode()){				//리스트에서 가져온 객체의 DrwMode에 따라서.
			case DrawConstants.POINT:					//점 그리기
				page.fillOval(	tempData.getX()-tempData.getPointSize()/2,	//점이 찍히는 위치를 가운데로 하기위해 포인트 사이즈를 2로 나눈 값을 빼줌
								tempData.getY()-tempData.getPointSize()/2,	//점이 찍히는 위치를 가운데로 하기위해 포인트 사이즈를 2로 나눈 값을 빼줌
								tempData.getPointSize(), 					//점의 크기설정
								tempData.getPointSize());					//점의 크기설정
				break;
			case DrawConstants.LINE:					//선 그리기
				//리스트에서 가져온 객체의 (x1,y1) (x2,y2)좌표를 이용하여 선을 그림
				page.drawLine(tempData.getX1(), tempData.getY1(), tempData.getX2(), tempData.getY2());
				break;
			case DrawConstants.RECT:					//사각형 그리기
				drawingRect(page, tempData.getX1(), tempData.getY1(), tempData.getX2(), tempData.getY2());	//drawingRect함수 호출	
				break;
			case DrawConstants.OVAL:					//원 그리기
				drawingOval(page, tempData.getX1(), tempData.getY1(), tempData.getX2(), tempData.getY2());	//drawingOval함수 호출
				break;
			case DrawConstants.FREE:
				page.fillOval(tempData.getX()-(3/2), tempData.getY()-(3/2), 3, 3);	//점을 그린다. 원의 중심은 커서의 가운데
				break;
			}
		}//for
	}//paintComponent()
	
	
	//원이 그려지는 4가지 경우에 따라 원을 그려주는 drawingOval함수
	public void drawingOval(Graphics page, int x1, int y1, int x2, int y2){	//파라미터로 그릴수있는 권한, x1좌표, y1좌표, x2좌표, y2좌표를 받아 Oval을 조건에 따라 그려주는 함수
		if(x1>x2 && y1>y2) page.drawOval(x2, y2, (x1-x2), (y1-y2));	//작은거, 작은거, 큰거에서 작은거, 큰거에서 작은거
		else if(x1>x2 && y1<y2) page.drawOval(x2, y1, x1-x2, y2-y1);
		else if(x1<x2 && y1>y2)	page.drawOval(x1, y2, x2-x1, y1-y2);
		else if(x1<x2 && y1<y2) page.drawOval(x1, y1, x2-x1, y2-y1);
	}//drawingOval()
	
	//사각형이 그려지는 4가지 경우에 따라 사각형을 그려주는 drawingRect함수
	public void drawingRect(Graphics page, int x1, int y1, int x2, int y2){
		if(x1>x2 && y1>y2) page.drawRect(x2, y2, (x1-x2), (y1-y2));	//작은거, 작은거, 큰거에서 작은거, 큰거에서 작은거
		else if(x1>x2 && y1<y2) page.drawRect(x2, y1, x1-x2, y2-y1);
		else if(x1<x2 && y1>y2)	page.drawRect(x1, y2, x2-x1, y1-y2);
		else if(x1<x2 && y1<y2) page.drawRect(x1, y1, x2-x1, y2-y1);
	}//drawingRect()

	
	//리스너 클래스
	private class DrawMouseListener implements MouseListener, MouseMotionListener{	//마우스 리스너, 마우스 모션 리스너 구현

		public void mouseClicked(MouseEvent event) {	//11.26 마우스가 클릭되었을 때 이벤트를 핸들링한다. 
						
			if(nDrawMode == DrawConstants.POINT){		//11.26 DrawMode가 Point일때
				nPointSize = primary.getPointSize();	//11.26 상위클래스에서 포인트 크기값을 가져온다 (upcall)
														//하위 클래스에서 상위클래스를 콜하는 것을 upcall이라고 한다. 통상적으로는 downcall 구조이다.
				selectedColor = primary.getSelectedColor();	//11.26 상위클래스에서 색깔 정보를 가져온다
				
				dataList.add(new DrawData(nDrawMode, event.getPoint(), nPointSize, selectedColor));	//상위 클래스에서 가져온 점에 관한 데이터들을 ArrayList에 저장한다.
																									//저장 할때 DrawData객체를 생성하여 저장.
				repaint();								//ArrayList에 데이터를 넣었으므로 repaint() 메소드 호출하여 다시 그림을 그려줌.
			}//if
			
		}//mouesClicked()

		public void mouseEntered(MouseEvent event) {}	//마우스가 Entered되었을 때 이벤트핸들링
		
		public void mouseExited(MouseEvent event) {}	//마우스가 Exited되어을 때 이벤트 핸들링

		public void mousePressed(MouseEvent event) {	//마우스가 눌렸을 때 이벤트 핸들링, 이 때는 선과 사각형과 원을 그리는 경우임.
			if(nDrawMode == DrawConstants.LINE ||
				nDrawMode == DrawConstants.RECT || 
				nDrawMode == DrawConstants.OVAL)
			{
				pt1 = event.getPoint();			//시작 좌표를 저장.
				
				//drag처리를 위해
				ptDrag1 = event.getPoint();		//ptDrag1에도 시작 좌표를 저장
				bDrag = true;					//bDrag변수 활성화
			}//if
			else if(nDrawMode == DrawConstants.FREE){
				pt = event.getPoint();
				selectedColor = primary.getSelectedColor();
				dataList.add(new DrawData(nDrawMode, pt, selectedColor));
				repaint();
			}
		}//11.26 mousePressed()

		public void mouseReleased(MouseEvent event) {		//마우스가 떼어졌을 때 이벤트 핸들링, 이 때는 선 과 사각형&원인 경우를 각각 따로 처리
			if(nDrawMode == DrawConstants.LINE){			//선인 경우
				pt2 = event.getPoint();						//떼어졌을 때의 좌표값을 저장.
				
				selectedColor = primary.getSelectedColor();	//상위 클래스에서 색깔 정보를 가져옴.
				dataList.add(new DrawData(nDrawMode, pt1, pt2, selectedColor));	//11.26 라인에 필요한 데이터(드로우 모드, 시작점, 끝점, 색)를 파라미터로하는 DrawData객체를 생성하여 Arraylist에 add.
				bDrag = false; 								//11.26 drag가 끝났음을 알림
				repaint();									//저장된 데이터를 다시 그림
			}//if
			else if(nDrawMode == DrawConstants.RECT ||		//사각형&원 인 경우
					nDrawMode == DrawConstants.OVAL ){
				bDrag = false;								//drag가 끝났음을 알림
				pt2 = event.getPoint();						//떠어졌을 때의 좌표값을 저장.
				selectedColor = primary.getSelectedColor();	//상위 클래스에서 색깔 정보를 가져옴
				dataList.add(new DrawData( nDrawMode, pt1, pt2, selectedColor));	//DrawData를 생성하여 파라미터로 도형의 정보를 담고, ArrayList에 add.
				
				repaint(); //저장된 데이터를 다시 그림
			}//else if
			else if(nDrawMode == DrawConstants.FREE){
				pt = event.getPoint();
				selectedColor = primary.getSelectedColor();
				dataList.add(new DrawData(nDrawMode, pt, selectedColor));
				repaint();
			}
				
		}//11.26 mouseReleased()
		
		public void mouseDragged(MouseEvent event){	//드레그할 때, 이 때는 보여지기만 하면 된다. 데이터를 저장할 필요는 없다.
			if(		nDrawMode == DrawConstants.LINE || 
					nDrawMode == DrawConstants.RECT ||
					nDrawMode == DrawConstants.OVAL){	//11.26 좌표 데이터 저장은 필요없다
				ptDrag2 = event.getPoint();		//끝 좌표 값을 가져오고
				repaint();						//바로바로 다시 그림 (저장은 없다.)
			}
			else if(nDrawMode == DrawConstants.FREE){
				pt = event.getPoint();
				selectedColor = primary.getSelectedColor();
				dataList.add(new DrawData(nDrawMode, pt, selectedColor));
				repaint();
			}
		}//11.26 mouseDragged()
		
		public void mouseMoved(MouseEvent event){}		//마우스가 Moved할때 이벤트 핸들링
		
	}// DrawMouseListener class

}// DrawingPanel class
