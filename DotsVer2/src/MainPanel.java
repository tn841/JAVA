import java.awt.*;
import java.io.FileNotFoundException;

import javax.swing.*;

public class MainPanel extends JPanel implements Runnable {
	//data
	private StartPanel start;
	private GamePanel game;
	private RankPanel rank;
	
	private Thread nThread;
	private boolean exitFlag; 	//1�̸� ����
	
	
	//test
	private int panelMode;	//0=startPanel, 1=gamePanel, 2=rankPanel, 3=����
	
	
	
	//method
	public MainPanel() throws Exception{
		this.setPreferredSize(new Dimension(600,850));
		this.setBackground(Color.white);
		this.setLayout(null);
		
	
		panelMode =0;	//panelState�� ���� ȭ�鿡 ǥ�õǴ� �г��� �ٲ�.
		nThread = null;	//cg�� ȸ������ �ʵ��� �ϱ�����
		exitFlag = false;	//�ʱ�ȭ
		
		
		start = new StartPanel(this);	//�Ķ���ͷ� �ڽ��� ����
		game = new GamePanel(this);		//�Ķ���ͷ� �ڽ��� ����
		rank = new RankPanel(this);		//�Ķ���ͷ� �ڽ��� ����
		
		start.setBounds(0, 0, 600, 850);
		game.setBounds(0, 0, 600, 850);
		rank.setBounds(0, 0, 600, 850);
		
		this.add(start);
		this.add(game);
		this.add(rank);
		
		
		
		start();	//������ ����
		
	
	}//MainPanel()
	
	public int getPanelState() {return panelMode;}
	public void setPanelState(int n){
		panelMode = n;
	}//setPanelState()
	
	
	public void init() throws Exception{
		start = new StartPanel(this);	//�Ķ���ͷ� �ڽ��� ����
		game = new GamePanel(this);		//�Ķ���ͷ� �ڽ��� ����
		rank = new RankPanel(this);		//�Ķ���ͷ� �ڽ��� ����
	}
	
	
	//������ ���� �޼ҵ�
	public void start(){
		if(nThread == null) nThread = new Thread(this);	//������ ����, �Ķ���ͷ� runnable�� ������ �����.
		nThread.start();	//������ ��ŸƮ
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
					nThread.sleep(50);	//ȭ����ȯ�� Ȯ���ϴ� ��
				}//it
				
				else if(exitFlag = true){
					System.out.println("Exit!!");
					System.exit(0);//����
					break;
				}//else if
			}//while
		}catch(Exception e){}
		
	}
	
	public void stop() {
		if(nThread != null) nThread.stop(); //null�� �ƴҶ��� �����.
	}
}//MainPanel class

