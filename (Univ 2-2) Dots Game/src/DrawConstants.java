import java.awt.*;

public class DrawConstants //상수를 관리하는 DrawConstants클래스
{
	//어차피 상수라(final)이라 값을 변경못하니까 get-set없이 접근하도록 public으로, 객체없이 클래스에 직접 접근하기 정적메소드(static)로..
	public static final int MENU_NUM = 6;												//메뉴의 갯수 
	
	public static final String[] MENU = {"POINT", "LINE", "RECT", "OVAL", "FREE", ""};	//메뉴버튼에 쓰일 상수 문자열 선언
	
	public static final Color MENU_ENTERED_BACKCOLOR = Color.cyan;						//Menu에 entered됬을때 backColor설정
	public static final Color MENU_ENTERED_FORECOLOR = new Color(255,0,0);				//Menu에 entered됬을때 foreColor설정
	public static final Color MENU_EXITED_BACKCOLOR = Color.white;						//Menu에 Exited됬을때 배경색 설정
	public static final Color MENU_EXITED_FORECOLOR = Color.black;						//Menu에 Exited됬을때 전경색 설정
	
	public static final int NONE = -1;	//의미 없는 값
	public static final int POINT = 0;	//POINT 메뉴의 인덱스
	public static final int LINE = 1;	//LINE 메뉴의 인덱스
	public static final int RECT = 2;	//RECT 메뉴의 인덱스
	public static final int OVAL = 3;	//OVAL 메뉴의 인덱스
	public static final int FREE = 4;

}// DrawConstants class
