import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;


public class Dot {
	//data
	private int pX, pY;	//점의 좌표
	private int pColor;	//점의 색상
	private int pPressed;	//점의 눌린 여부   0 안눌림 1 눌림 
	private int pDownCount;	//밑에 빈공간 갯수
	private Image dotImg;
	private boolean bPress; //눌릴수 있는지 없는지 (true 시 : 누를 수 있음 , false 시 : 누를 수 없음 )  
	
	//method
	public Dot(){
		pX = 0;
		pY = 0;
		pColor = -1;
		pPressed = 0;
		pDownCount = 0;
		bPress=true;
		
	}//Dot() 생성자 
	
	public Dot(int x, int y){
		pX = DotConstants.IMG_SIZE * x;   // x좌표 설정
		pY = DotConstants.IMG_SIZE * y;   // y좌표 설정 
		pColor = (int)(Math.random()*6);	//색 6가지 랜덤으로 생성
		pPressed = DotConstants.UNPRESSED;	// 생성 단계 이므로 안눌림
		pDownCount = 0;
		bPress=true;
		
	}//Dot(x, y)
	
	public Image getDotImg(){   // 점의 이미지 반환 
	 	dotImg = new ImageIcon(getDotColor()+"_"+pPressed+".png").getImage();
		return dotImg;}
	public int getDotColor(){return pColor;}  // 점의 색깔 반환 
	public void setDotColor(int color){pColor=color;} //점의 색깔 설정
	public int getDotX(){return pX;}  // 점의 x좌표 반환
	public int getDotY(){return pY;}  // 점의 y좌표 반환 
	public void setPressed(int k) { pPressed=k;}  // 점 눌린여부 설정
	public int getPressed(){return pPressed;}   // 점 눌린 여부 반환
	public void setBpressed(boolean a){bPress=a;}  
	public boolean getBpressed(){return bPress;} // 점을 누를수 있는지 여부 반환 
	
}// Dot class

