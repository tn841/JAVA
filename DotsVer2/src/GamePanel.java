import java.awt.*;

import javax.swing.*;


public class GamePanel extends JPanel
{
	private GameScreen gameScreen;
	private MainPanel primary;	//상위 클래스
	
	//아이템 패널 만들어야함
	
	
	public GamePanel(MainPanel mPanel)
	{
		this.setPreferredSize(new Dimension(600,850));
		this.setBackground(new Color(0,162,232));
		//setLayout(new BorderLayout());
		setLayout(null);//Border레이아웃 없애고 setBounds로 배치시킴
		
		primary = mPanel;	//상위클래스 대입.
		
		
		//게임이 이루어지는 gameScreen
		gameScreen = new GameScreen(this);	//callUp을 위해 자신을 전달
		gameScreen.setBounds(30,150,DotConstants.IMG_SIZE*6,DotConstants.IMG_SIZE*6);
		//this.add(gameScreen, BorderLayout.CENTER);
		add(gameScreen);
		
		//점수 및 턴을 표시해주는 ScorePanel
		GameScreen.ScorePanel scPanel = gameScreen.new ScorePanel();//이너 클래스 선언
		scPanel.setBounds(30, 25, DotConstants.IMG_SIZE*6, 100);
		add(scPanel);
		
		//아이탬을 표시해주는  
		GameScreen.ItemPanel itPanel = gameScreen.new ItemPanel();
		itPanel.setBounds(30, 720, DotConstants.IMG_SIZE*6, 100);
		add(itPanel);
		
	}//GamePanel()
	
	public void setPanelState(int n){
		primary.setPanelState(n);
	}
	
	
	
}