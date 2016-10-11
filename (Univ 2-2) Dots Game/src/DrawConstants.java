import java.awt.*;

public class DrawConstants //����� �����ϴ� DrawConstantsŬ����
{
	//������ �����(final)�̶� ���� ������ϴϱ� get-set���� �����ϵ��� public����, ��ü���� Ŭ������ ���� �����ϱ� �����޼ҵ�(static)��..
	public static final int MENU_NUM = 6;												//�޴��� ���� 
	
	public static final String[] MENU = {"POINT", "LINE", "RECT", "OVAL", "FREE", ""};	//�޴���ư�� ���� ��� ���ڿ� ����
	
	public static final Color MENU_ENTERED_BACKCOLOR = Color.cyan;						//Menu�� entered������ backColor����
	public static final Color MENU_ENTERED_FORECOLOR = new Color(255,0,0);				//Menu�� entered������ foreColor����
	public static final Color MENU_EXITED_BACKCOLOR = Color.white;						//Menu�� Exited������ ���� ����
	public static final Color MENU_EXITED_FORECOLOR = Color.black;						//Menu�� Exited������ ����� ����
	
	public static final int NONE = -1;	//�ǹ� ���� ��
	public static final int POINT = 0;	//POINT �޴��� �ε���
	public static final int LINE = 1;	//LINE �޴��� �ε���
	public static final int RECT = 2;	//RECT �޴��� �ε���
	public static final int OVAL = 3;	//OVAL �޴��� �ε���
	public static final int FREE = 4;

}// DrawConstants class
