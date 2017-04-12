import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;


public class Dot {
	//data
	private int pX, pY;	//���� ��ǥ
	private int pColor;	//���� ����
	private int pPressed;	//���� ���� ����   0 �ȴ��� 1 ���� 
	private int pDownCount;	//�ؿ� ����� ����
	private Image dotImg;
	private boolean bPress; //������ �ִ��� ������ (true �� : ���� �� ���� , false �� : ���� �� ���� )  
	
	//method
	public Dot(){
		pX = 0;
		pY = 0;
		pColor = -1;
		pPressed = 0;
		pDownCount = 0;
		bPress=true;
		
	}//Dot() ������ 
	
	public Dot(int x, int y){
		pX = DotConstants.IMG_SIZE * x;   // x��ǥ ����
		pY = DotConstants.IMG_SIZE * y;   // y��ǥ ���� 
		pColor = (int)(Math.random()*6);	//�� 6���� �������� ����
		pPressed = DotConstants.UNPRESSED;	// ���� �ܰ� �̹Ƿ� �ȴ���
		pDownCount = 0;
		bPress=true;
		
	}//Dot(x, y)
	
	public Image getDotImg(){   // ���� �̹��� ��ȯ 
	 	dotImg = new ImageIcon(getDotColor()+"_"+pPressed+".png").getImage();
		return dotImg;}
	public int getDotColor(){return pColor;}  // ���� ���� ��ȯ 
	public void setDotColor(int color){pColor=color;} //���� ���� ����
	public int getDotX(){return pX;}  // ���� x��ǥ ��ȯ
	public int getDotY(){return pY;}  // ���� y��ǥ ��ȯ 
	public void setPressed(int k) { pPressed=k;}  // �� �������� ����
	public int getPressed(){return pPressed;}   // �� ���� ���� ��ȯ
	public void setBpressed(boolean a){bPress=a;}  
	public boolean getBpressed(){return bPress;} // ���� ������ �ִ��� ���� ��ȯ 
	
}// Dot class

