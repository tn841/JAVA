import java.awt.*;

import javax.swing.*;


public class GamePanel extends JPanel
{
	private GameScreen gameScreen;
	private MainPanel primary;	//���� Ŭ����
	
	//������ �г� ��������
	
	
	public GamePanel(MainPanel mPanel)
	{
		this.setPreferredSize(new Dimension(600,850));
		this.setBackground(new Color(0,162,232));
		//setLayout(new BorderLayout());
		setLayout(null);//Border���̾ƿ� ���ְ� setBounds�� ��ġ��Ŵ
		
		primary = mPanel;	//����Ŭ���� ����.
		
		
		//������ �̷������ gameScreen
		gameScreen = new GameScreen(this);	//callUp�� ���� �ڽ��� ����
		gameScreen.setBounds(30,150,DotConstants.IMG_SIZE*6,DotConstants.IMG_SIZE*6);
		//this.add(gameScreen, BorderLayout.CENTER);
		add(gameScreen);
		
		//���� �� ���� ǥ�����ִ� ScorePanel
		GameScreen.ScorePanel scPanel = gameScreen.new ScorePanel();//�̳� Ŭ���� ����
		scPanel.setBounds(30, 25, DotConstants.IMG_SIZE*6, 100);
		add(scPanel);
		
		//�������� ǥ�����ִ�  
		GameScreen.ItemPanel itPanel = gameScreen.new ItemPanel();
		itPanel.setBounds(30, 720, DotConstants.IMG_SIZE*6, 100);
		add(itPanel);
		
	}//GamePanel()
	
	public void setPanelState(int n){
		primary.setPanelState(n);
	}
	
	
	
}