import java.awt.*;

//�׸� �׷����� �������� �����Ϳ� ���� Ŭ����
public class DrawData {
	//data
	private int nDrawMode;	//�׷����� ������ ������ �������� �簢������ ������ �Ǵ��ϱ����� ������ ����, "���� �߿�"
	private Point pt;		//�׷����� ����Ʈ�� ��ǥ���� �����ϴ� PointŬ������ ��üpt ����
	private int nPointSize;	//�׷����� ����Ʈ�� ũ�⸦ �����ϴ� nPointSize���� ����
	
	private Color selectedColor;	//11.26 ���� ������ ������ ����
	
	private Point pt1, pt2;	//11.26 ������ �׸��� �ʿ��� ���� ����Ʈ�� �� ����Ʈ�� ������ ����Ʈ 2�� ����
	
	
	//method
	//�̸��� ������ �Ķ���Ͱ� �ٸ� �����ڸ� ����. �ڵ����� ������ �����ڰ� ȣ��ȴ�(�Լ� �����ε�) 
	public DrawData(int mode, Point p, int size, Color c){	//����Ʈ�� �׸��� ȣ��Ǵ� ������
		nDrawMode = mode;	//��ο� ��尪 ����
		pt = p;				//����Ʈ ��ǥ ����
		nPointSize = size;	//����Ʈ ũ�� ����
		selectedColor = c;	//11.26 �Ķ���ͷ� Color�� �޾� �ʱ�ȭ
	}// DrawData() for Point, Pan
	
	public DrawData(int mode, Point p1, Point p2, Color c){	//���ΰ� �簢���� ���� �׸��� ȣ��Ǵ� ������
		nDrawMode = mode;	//��ο� ��� ����
		pt1 = p1;			//���� ��ǥ�� ����
		pt2 = p2;			//�� ��ǥ�� ����
		selectedColor = c;	//���� ����
	}//11.26 DrawData() for Line, Rect, Oval

	public DrawData(int mode, Point p, Color c){
		nDrawMode = mode;
		pt = p;
		selectedColor = c;
	}// DrawData() for Free
	
	//private�� ����� �������� ���� �������ų�(get), ����(set)�ϱ����� get, set�޼ҵ� ����,
	public int getDrawMode() {return nDrawMode;}			//��ο� ��� �� ��ȯ
	public Point getPoint() {return pt;}					//����Ʈ ��ǥ ��ȯ
	
	public int getX() {return pt.x;}						//����Ʈ�� x��ǥ ��ȯ
	public int getY() {return pt.y;}						//����Ʈ�� y��ǥ ��ȯ
	public int getPointSize() {return nPointSize;}			//����Ʈ ������ �� ��ȯ
	public Color getSelectedColor() {return selectedColor;}	//11.26 �� ��ȯ 
	
	public Point getPoint1() {return pt1;}					//11.26 ���� ����Ʈ ��ǥ ��ȯ
	public Point getPoint2() {return pt2;}					//11.26 �� ����Ʈ ��ǥ ��ȯ
	public int getX1(){return pt1.x;}						//���� ����Ʈ�� x��ǥ ��ȯ
	public int getY1(){return pt1.y;}						//���� ����Ʈ�� y��ǥ ��ȯ 
	public int getX2(){return pt2.x;}						//�� ����Ʈ�� x��ǥ ��ȯ
	public int getY2(){return pt2.y;}						//�� ����Ʈ�� y��ǥ ��ȯ
		
}// DrawData class
