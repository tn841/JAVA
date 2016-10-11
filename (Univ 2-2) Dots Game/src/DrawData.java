import java.awt.*;

//그림 그려지는 도형들의 데이터에 관한 클래스
public class DrawData {
	//data
	private int nDrawMode;	//그려지는 도형이 점인지 라인인지 사각형인지 원인지 판단하기위한 데이터 선언, "가장 중요"
	private Point pt;		//그려지는 포인트의 죄표값을 저장하는 Point클래스의 객체pt 선언
	private int nPointSize;	//그려지는 포인트의 크기를 저장하는 nPointSize변수 선언
	
	private Color selectedColor;	//11.26 색을 저장할 데이터 선언
	
	private Point pt1, pt2;	//11.26 라인을 그릴때 필요한 시작 포인트와 끝 포인트를 저장할 포인트 2개 선언
	
	
	//method
	//이름은 같지만 파라미터가 다른 생성자를 만듦. 자동으로 적절한 생성자가 호출된다(함수 오버로딩) 
	public DrawData(int mode, Point p, int size, Color c){	//포인트를 그릴때 호출되는 생성자
		nDrawMode = mode;	//드로우 모드값 설정
		pt = p;				//포인트 좌표 설정
		nPointSize = size;	//포인트 크기 설정
		selectedColor = c;	//11.26 파라미터로 Color를 받아 초기화
	}// DrawData() for Point, Pan
	
	public DrawData(int mode, Point p1, Point p2, Color c){	//라인과 사각형과 원을 그릴때 호출되는 생성자
		nDrawMode = mode;	//드로우 모드 설정
		pt1 = p1;			//시작 좌표값 설정
		pt2 = p2;			//끝 좌표값 설정
		selectedColor = c;	//색깔 설정
	}//11.26 DrawData() for Line, Rect, Oval

	public DrawData(int mode, Point p, Color c){
		nDrawMode = mode;
		pt = p;
		selectedColor = c;
	}// DrawData() for Free
	
	//private로 선언된 변수들의 값을 가져오거나(get), 변경(set)하기위한 get, set메소드 구현,
	public int getDrawMode() {return nDrawMode;}			//드로우 모드 값 반환
	public Point getPoint() {return pt;}					//포인트 좌표 반환
	
	public int getX() {return pt.x;}						//포인트의 x좌표 반환
	public int getY() {return pt.y;}						//포인트의 y좌표 반환
	public int getPointSize() {return nPointSize;}			//포인트 사이즈 값 반환
	public Color getSelectedColor() {return selectedColor;}	//11.26 색 반환 
	
	public Point getPoint1() {return pt1;}					//11.26 시작 포인트 좌표 반환
	public Point getPoint2() {return pt2;}					//11.26 끈 포인트 좌표 반환
	public int getX1(){return pt1.x;}						//시작 포인트의 x좌표 반환
	public int getY1(){return pt1.y;}						//시작 포인트의 y좌표 반환 
	public int getX2(){return pt2.x;}						//끝 포인트의 x좌표 반환
	public int getY2(){return pt2.y;}						//끝 포인트의 y좌표 반환
		
}// DrawData class
