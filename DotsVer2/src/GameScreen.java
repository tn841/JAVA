import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
import java.util.Collections;

public class GameScreen extends JPanel {
	//data
	AdminGamePlay admin;    // ���� �迭 ����Ʈ�� �����ؼ� ���� ������ �����ϴ� ��ü 
	private MouseL mL;        //���콺������ 
	private JLabel lblScore,lblturn;  // ���� , �� ǥ�� �� Jlabel
	private JButton btnItem1, btnItem2, btnItem3;
	private int Item_state; // �������� ���� ���� ���� 
	private int turn; //turn�� ������.
	public static int score;	//���� ���� ����
	private int clickX,clickY; // clicked ���� �� �� ���� 
	private int startX,startY; // pressed ���� �� �� ����
	private int nowX,nowY; //������ x,y ��ǥ 
	private boolean bRect; // 4���� ��������� �ȸ�������� ���� ����
	int k;//�簢�� ���� �� �ѹ��� judgearray�� �ֱ� ���ؼ�;
	private GamePanel gamePanel; //upcall�� ���ؼ� ����
	private boolean item3; //item3�� ���Ǿ����� Ȯ���ϴ� ����

	
	
	//method
	public GameScreen(GamePanel gPanel){
		//this.setPreferredSize(new Dimension(540,540));
		this.setBackground(DotConstants.GAMEPANEL_FONT);
		admin = new AdminGamePlay();
		mL=new MouseL();  // ���콺 ������ ����
		
		addMouseListener(mL); // ���� ��ũ�� �гο� ���콺 ������ mL add 
		addMouseMotionListener(mL); //���� ��ũ�� �гο� ���콺��� ������ mL add
		Item_state=DotConstants.ITEM_OFF; // �������� ���� ���� ���� ( �ʱ�ȭ �Ƿ� �ȴ��� ����)
		gamePanel = gPanel;	//callUp ����
		bRect=false; k=0;
		item3 = false;	//ó������ ���ȵ����� �ʱ�ȭ
	} //������
	
	
	public void paintComponent(Graphics page)
	{
		super.paintComponent(page);
		for(int i=0;i<6;i++)
		for(int j=0;j<6;j++)
			page.drawImage(admin.getDotImg(i,j),admin.getDotX(i,j),admin.getDotY(i,j),null);
		
	}//paintComponent()
	
	public void checkScore(){ //  ���� ������ �Ѵ��� Ȯ�� �մϴ�. (���� ������ ���� �� item3�� setEnable �ϱ����ؼ�)
		if(score>DotConstants.STANDARDSCORE && item3 == false){	//���� ������ �����ǰ� �������� ������ �ʾҴٸ�
			btnItem3.setEnabled(true);
			item3 = true;
		}
	}
	
	public void setItemState(int STATE) //������ �гο���  ������ ���� ���¸� set�� 
	{
		Item_state=STATE;
	}//setItemState
	
	class ScorePanel extends JPanel implements Runnable
	{
		private Thread nThread;
	
		
		ScorePanel()
		{
			setBackground(DotConstants.GAMEPANEL_FONT);
			//setPreferredSize(new Dimension(100,300));
			setLayout(null);
			
			turn = 10;
			
			lblturn = new JLabel("turn : "+turn);
			lblturn.setBounds(0,0,250,100);
			lblturn.setForeground(Color.black);
			lblturn.setHorizontalAlignment(SwingConstants.CENTER);
			lblturn.setFont(new Font("VERDANA",Font.BOLD,35));
			add(lblturn);

			
			lblScore= new JLabel("SCORE : "+score);
			lblScore.setBounds(250,0,250,100);
			lblScore.setForeground(Color.black);
			lblScore.setHorizontalAlignment(SwingConstants.CENTER);
			lblScore.setFont(new Font("VERDANA",Font.BOLD,35));
			add(lblScore);
			
			nThread = null;
			
			this.start();
		}//scorePanel()
		
		public void start(){
			if(nThread == null) nThread = new Thread(this);
			nThread.start();
		}

		public void run() {
			try{
				while(true){
					lblScore.setText("SCORE : "+GameScreen.score);
					nThread.sleep(100);
					}
			}catch(Exception e){}
		}
		
		public void stop(){
			if(nThread != null) nThread.stop();
		}
		
	}//ScorePanel class
	
	class ItemPanel extends JPanel
	{
		private BtnAListener bL; // ��ư �׼� ������ 
		
		ItemPanel(){
			
			this.setBackground(DotConstants.GAMEPANEL_FONT);
			this.setLayout(null);
			bL=new BtnAListener();

			btnItem1 = new JButton("Same Color");
			btnItem1.setFont(new Font("Verdana", Font.BOLD, 20));
			btnItem1.setBounds(10, 10, 166, 80);
			btnItem1.addActionListener(bL);
			this.add(btnItem1);
						
			btnItem2 = new JButton("One Dot");
			btnItem2.setFont(new Font("Verdana", Font.BOLD, 20));
			btnItem2.setBounds(186, 10, 166, 80);
			btnItem2.addActionListener(bL);
			this.add(btnItem2);
			
			btnItem3 = new JButton("turn Plus");
			btnItem3.setFont(new Font("Verdana", Font.BOLD, 20));
			btnItem3.setBounds(362, 10, 166, 80);
			btnItem3.setEnabled(false);
			btnItem3.addActionListener(bL);

			this.add(btnItem3);
			
			
			
		}//ItemPanel ������

	
	}//ItemPanel class
	
	
	//Listener class ����
	private class MouseL implements MouseListener,MouseMotionListener
	{
		public void mouseClicked(MouseEvent event){
			if(Item_state==DotConstants.ITEM1_ON)
			{
				startX=event.getX();  
			     startY=event.getY();
				 admin.Item1(startX/DotConstants.IMG_SIZE,startY/DotConstants.IMG_SIZE,admin.getDotColor(startX/DotConstants.IMG_SIZE,startY/DotConstants.IMG_SIZE));
				 // ������ 1�� ���� ��ŵ�ϴ�. 
				 admin.setDelArray();//���� ���� ���� ���ϴ�. 
				 admin.restruct();
				 // ������ �籸��ȭ �մϴ�.(������ �� ���� �ִ� ������ ������ ������, ������ ��ŭ �ٽ� ���� �մϴ�.)
				 turn-=1; // �� 1 ���� 
				 admin.uncheckMoved(); // ������� �ٽ� ������ �ֵ��� �������� �ʱ�ȭ �մϴ�.
				 admin.resetJudge(); // ���� ���� ������ ���� �մϴ�. 
				 lblturn.setText("turn : "+turn);
				 checkScore(); // ������ ������ �Ѵ��� Ȯ���մϴ�. ( �������� ������ item3 ��ư ��� ����)
				 Item_state=DotConstants.ITEM_OFF;  //������ state�� ����� 
			 	
			 
			 repaint();
			}
			else if(Item_state==DotConstants.ITEM2_ON)
			{
			
				startX=event.getX();
				 startY=event.getY();
				 admin.addJudge(startX/DotConstants.IMG_SIZE,startY/DotConstants.IMG_SIZE,DotConstants.REMOVED);
				 admin.setDotColor(startX/DotConstants.IMG_SIZE,startY/DotConstants.IMG_SIZE,DotConstants.REMOVED);
				 admin.setDelArray();
				 admin.restruct();
				 turn-=1;
				 admin.uncheckMoved();
				 admin.resetJudge();
				 checkScore();
				 lblturn.setText("turn : "+turn);
				 Item_state=DotConstants.ITEM_OFF;  //������ state�� ����  
			 
			
			repaint();
			}//else if
			
			if(turn <= 0){//test
				//panelMode�� 2�� �����������!
				gamePanel.setPanelState(2);
				
				///////////////////////////////////////////////////////////////////////
				//�̶� ����ڿ� ������ vector�������� add!
				
				if(RankManager.vList.size() > 8){	//��ŷ�� 9�������ۿ� ǥ�ø��ϴµ� �� �̻� �� ��
					//System.out.println("����� 8���� ũ�� �� 9���� ����");
					String[] str = RankManager.vList.lastElement().split("-");
				
					if(Integer.parseInt(str[0]) < GameScreen.score){	//vector�� ������ ��ҿ� ������ ���ؼ� ���� ������ �� ũ�ٸ�
						int num = RankManager.vList.size()-1;
						RankManager.vList.setElementAt(GameScreen.score+"-"+StartPanel.userName, num);	//������ ����ϰ� ���� �����ϰ� ��ü
					}	
				}//if
				else{	
					//System.out.println("����� 8���ϴ� ����");
					RankManager.vList.add(GameScreen.score+"-"+StartPanel.userName);	//add
				}
				
				
				Collections.sort(RankManager.vList);	//vetor�� �����͵��� ������������ ����
				Collections.reverse(RankManager.vList);
				
				//����� add�ǰ� ���ĵǾ����� Ȯ��
				for(int i=0; i<RankManager.vList.size(); i++){
					System.out.println(RankManager.vList.get(i));
				}
				System.out.println("vector size : "+RankManager.vList.size());
				///////////////////////////////////////////////////////////////////////////
			}
			
		}//mouseClicked
		public void mousePressed(MouseEvent event){
			startX=event.getX();
			startY=event.getY();
			if(admin.getCheckMoved(startX/DotConstants.IMG_SIZE,startY/DotConstants.IMG_SIZE)==true&&admin.getPressed(startX/DotConstants.IMG_SIZE,startY/DotConstants.IMG_SIZE)==DotConstants.UNPRESSED)
			{ //�̵� ���� ���� Ȯ���ϰ�, ���� �� ���ȴ��� �˻� �մϴ�. 
			admin.addJudge(startX/DotConstants.IMG_SIZE,startY/DotConstants.IMG_SIZE,admin.getDotColor(startX/DotConstants.IMG_SIZE,startY/DotConstants.IMG_SIZE));
			//���� �� ���� ���� 
			admin.setPressed(startX/DotConstants.IMG_SIZE,startY/DotConstants.IMG_SIZE,1);
			//���� ���ȴٰ� ���� 
			admin.checkMoved(startX/DotConstants.IMG_SIZE,startY/DotConstants.IMG_SIZE);
	     	//���� ���� ���� ���̰� ��,��,��,���� ���� ���� �� �ֵ��� �մϴ�.
			repaint();
				}
			
			}
		
		public void mouseReleased(MouseEvent event)
		{ 
			if(bRect==true)
			{
				startX=event.getX();
				startY=event.getY();
				
				admin.Item1(startX/DotConstants.IMG_SIZE,startY/DotConstants.IMG_SIZE,admin.getDotColor(startX/DotConstants.IMG_SIZE,startY/DotConstants.IMG_SIZE));
			 admin.setDelArray();
			 admin.restruct();
			 turn-=1;
			 admin.uncheckMoved();
			 admin.resetJudge();
			 checkScore();
			 lblturn.setText("turn : "+turn);
			 Item_state=DotConstants.ITEM_OFF;  //������ state�� ���� 
			 	 
			 k=0;
			 repaint();
	
			bRect=false;
		}//if
			else{// �簢���� ������ ���Ͽ��� �� 
			admin.removeDot();
			admin.setDelArray();
			admin.restruct();
			checkScore();
			if(admin.getCount()>1){
				turn -= 1;	// ���콺�� �������Ҷ����� �ϰ���
			}
			
			admin.uncheckMoved(); 
			admin.resetJudge(); 
			
			lblturn.setText("turn : "+turn);
					
			repaint();
			}//else
			
			
			gamePanel.setBackground(new Color(0,162,232));
			
			if(turn <= 0){//test
				//panelMode�� 2�� �����������!
				gamePanel.setPanelState(2);
				
				///////////////////////////////////////////////////////////////////////
				//�̶� ����ڿ� ������ vector�������� add!
				
				if(RankManager.vList.size() > 8){	//��ŷ�� 9�������ۿ� ǥ�ø��ϴµ� �� �̻� �� ��
					//System.out.println("����� 8���� ũ�� �� 9���� ����");
					String[] str = RankManager.vList.lastElement().split("-");
				
					if(Integer.parseInt(str[0]) < GameScreen.score){	//vector�� ������ ��ҿ� ������ ���ؼ� ���� ������ �� ũ�ٸ�
						int num = RankManager.vList.size()-1;
						RankManager.vList.setElementAt(GameScreen.score+"-"+StartPanel.userName, num);	//������ ����ϰ� ���� �����ϰ� ��ü
					}	
				}//if
				else{	
					//System.out.println("����� 8���ϴ� ����");
					RankManager.vList.add(GameScreen.score+"-"+StartPanel.userName);	//add
				}
				
				
				Collections.sort(RankManager.vList);	//vetor�� �����͵��� ������������ ����
				Collections.reverse(RankManager.vList);
				
				//����� add�ǰ� ���ĵǾ����� Ȯ��
				for(int i=0; i<RankManager.vList.size(); i++){
					System.out.println(RankManager.vList.get(i));
				}
				System.out.println("vector size : "+RankManager.vList.size());
				///////////////////////////////////////////////////////////////////////////
			}
		}//released()
		
		
		public void mouseEntered(MouseEvent event){}
		public void mouseExited(MouseEvent event){}
		
		public void mouseDragged(MouseEvent event){	
			nowX=event.getX();
			nowY=event.getY();
		//	System.out.println(admin.getCheckMoved(startX/68,startY/68));
			if(admin.getCheckMoved( nowX/DotConstants.IMG_SIZE ,nowY/DotConstants.IMG_SIZE) == true // getCheckMoved�� ���� ������ ��,��,��,�Ϸ� ���� �� �� �ִ��� Ȯ���մϴ�.(true-�����ϼ����� ,false-�����ϼ� ����)
					 && admin.getPressed(nowX/DotConstants.IMG_SIZE, nowY/DotConstants.IMG_SIZE) == 0) // getPressed �޼ҵ�� ���ȴ� ������ �ƴ��� Ȯ���մϴ�. (0 �ȴ����� , 1 ������ )
			{
				admin.setPressed(nowX/DotConstants.IMG_SIZE, nowY/DotConstants.IMG_SIZE, 1);
				admin.addJudge(nowX/DotConstants.IMG_SIZE, nowY/DotConstants.IMG_SIZE, 
				admin.getDotColor(nowX/DotConstants.IMG_SIZE, nowY/DotConstants.IMG_SIZE));
				admin.resetBp(nowX/DotConstants.IMG_SIZE,nowY/DotConstants.IMG_SIZE);
				admin.checkMoved(nowX/DotConstants.IMG_SIZE, nowY/DotConstants.IMG_SIZE);			
			}
			

			if(admin.getCount()>3 &&admin.getCheckMoved(nowX/DotConstants.IMG_SIZE,nowY/DotConstants.IMG_SIZE)==true &&	//�̵������� ���̰�
					admin.getPressed(nowX/DotConstants.IMG_SIZE,nowY/DotConstants.IMG_SIZE)==1&& //���ȴ� ���̸�
					((admin.recentRow()!=nowX/DotConstants.IMG_SIZE)|| // ���� �ֱٿ� ���� ���� �ٷ� �� ���� ������ ���մϴ�.
					(admin.recentCol()!=nowY/DotConstants.IMG_SIZE))){ // ���� �ֱٿ� ���� ���� �ٷ� �� ���� ������ �� �մϴ�. 
			
					
				if( k==0) /*&& (�ٵ� ���⼭ �������� �ٷ����� ���� ���� judgeArray�ε��� ���̰� 3�̻� ���ߵ�, ���� �߰��ؾ���)*/	 
										//�簢���� �Ƿ��� �������� �ּ� 4�� �̻��̿�����  >1 �� >3���� ������, 
				{
						admin.addJudge(nowX/DotConstants.IMG_SIZE, nowY/DotConstants.IMG_SIZE, 
						admin.getDotColor(nowX/DotConstants.IMG_SIZE, nowY/DotConstants.IMG_SIZE));	
						bRect=admin.judgeCheck();
						System.out.println(bRect);
						
						//����� ���� ���� ó�� �簢���� ��������� ������ �� ������ �ٲ�.
						switch(admin.getDotColor(nowX/DotConstants.IMG_SIZE, nowY/DotConstants.IMG_SIZE)){
						case DotConstants.BLUE:
							gamePanel.setBackground(Color.BLUE);							
							break;
						case DotConstants.GREEN:
							gamePanel.setBackground(Color.green);
							break;
						case DotConstants.PURPLE:
							gamePanel.setBackground(new Color(163,73,164));
							break;
						case DotConstants.ORANGE:
							gamePanel.setBackground(Color.orange);
							break;
						case DotConstants.YELLOW:
							gamePanel.setBackground(Color.yellow);
							break;
						case DotConstants.RED:
							gamePanel.setBackground(Color.red);
							break;
						}//switch
						
						k++;
				}
			}//if
			
			repaint();
			
		}//MouseDragged()
		
		public void mouseMoved(MouseEvent event){}	

	}//MouseListener class
	
	

	
	private class BtnAListener implements ActionListener{

		public void actionPerformed(ActionEvent event) {
			Object obj = event.getSource();
			
			if(obj == btnItem1){
				//���⿡�� ù��° �������� �������� ��Ȳ�� ����
				setItemState(DotConstants.ITEM1_ON);
				btnItem1.setEnabled(false);
				
			}
			else if(obj == btnItem2){
				//�ι�° ������
				setItemState(DotConstants.ITEM2_ON);
				btnItem2.setEnabled(false);
			}
			else if(obj == btnItem3){
				turn+=5; 
				lblturn.setText("turn : "+turn);
				btnItem3.setEnabled(false);
				//������ ������
			}
		}//actionPerformed()
		
	}//BtnAListener class


	
	

}

