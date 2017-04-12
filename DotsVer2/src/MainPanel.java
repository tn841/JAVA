import java.awt.*;
import java.io.FileNotFoundException;

import javax.swing.*;

public class MainPanel extends JPanel implements Runnable {
	//data
	private StartPanel start;
	private GamePanel game;
	private RankPanel rank;
	
	private Thread nThread;
	private boolean exitFlag; 	//1이면 종료
	
	
	//test
	private int panelMode;	//0=startPanel, 1=gamePanel, 2=rankPanel, 3=종료
	
	
	
	//method
	public MainPanel() throws Exception{
		this.setPreferredSize(new Dimension(600,850));
		this.setBackground(Color.white);
		this.setLayout(null);
		
	
		panelMode =0;	//panelState에 따라 화면에 표시되는 패널이 바뀜.
		nThread = null;	//cg가 회수하지 않도록 하기위해
		exitFlag = false;	//초기화
		
		
		start = new StartPanel(this);	//파라미터로 자신을 전달
		game = new GamePanel(this);		//파라미터로 자신을 전달
		rank = new RankPanel(this);		//파라미터로 자신을 전달
		
		start.setBounds(0, 0, 600, 850);
		game.setBounds(0, 0, 600, 850);
		rank.setBounds(0, 0, 600, 850);
		
		this.add(start);
		this.add(game);
		this.add(rank);
		
		
		
		start();	//스레드 시작
		
	
	}//MainPanel()
	
	public int getPanelState() {return panelMode;}
	public void setPanelState(int n){
		panelMode = n;
	}//setPanelState()
	
	
	public void init() throws Exception{
		start = new StartPanel(this);	//파라미터로 자신을 전달
		game = new GamePanel(this);		//파라미터로 자신을 전달
		rank = new RankPanel(this);		//파라미터로 자신을 전달
	}
	
	
	//스레드 관련 메소드
	public void start(){
		if(nThread == null) nThread = new Thread(this);	//스레드 생성, 파라미터로 runnable을 전달해 줘야함.
		nThread.start();	//쓰레드 스타트
	}

	
	public void run() {
		try{
			while(true){
				
				if(exitFlag == false){
					switch(panelMode)
					{
					case DotConstants.START_MODE:				
						start.setVisible(true);
						game.setVisible(false);
						rank.setVisible(false);
						
						break;
						
					case DotConstants.GAME_MODE:				
						start.setVisible(false);
						game.setVisible(true);
						rank.setVisible(false);			
						
						break;
						
					case DotConstants.RANK_MODE:
											
						start.setVisible(false);
						game.setVisible(false);
						rank.setVisible(true);
						break;
						
					case DotConstants.EXIT_MODE:
						exitFlag = true;
						break;
					}//switch
					nThread.sleep(50);	//화면전환을 확인하는 빈도
				}//it
				
				else if(exitFlag = true){
					System.out.println("Exit!!");
					System.exit(0);//종료
					break;
				}//else if
			}//while
		}catch(Exception e){}
		
	}
	
	public void stop() {
		if(nThread != null) nThread.stop(); //null이 아닐때만 멈춘다.
	}
}//MainPanel class

