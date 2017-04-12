import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
import java.util.Collections;

public class GameScreen extends JPanel {
	//data
	AdminGamePlay admin;    // 점의 배열 리스트를 관리해서 게임 진행을 관리하는 객체 
	private MouseL mL;        //마우스리스너 
	private JLabel lblScore,lblturn;  // 점수 , 턴 표시 할 Jlabel
	private JButton btnItem1, btnItem2, btnItem3;
	private int Item_state; // 아이템이 눌린 상태 저장 
	private int turn; //turn을 저장함.
	public static int score;	//정적 변수 선언
	private int clickX,clickY; // clicked 했을 때 쓸 변수 
	private int startX,startY; // pressed 했을 때 쓸 변수
	private int nowX,nowY; //현재의 x,y 좌표 
	private boolean bRect; // 4각형 만들었는지 안만들었는지 여부 저장
	int k;//사각형 만들 시 한번만 judgearray에 넣기 위해서;
	private GamePanel gamePanel; //upcall을 위해서 선언
	private boolean item3; //item3가 사용되었는지 확인하는 변수

	
	
	//method
	public GameScreen(GamePanel gPanel){
		//this.setPreferredSize(new Dimension(540,540));
		this.setBackground(DotConstants.GAMEPANEL_FONT);
		admin = new AdminGamePlay();
		mL=new MouseL();  // 마우스 리스너 생성
		
		addMouseListener(mL); // 게임 스크린 패널에 마우스 리스너 mL add 
		addMouseMotionListener(mL); //게임 스크린 패널에 마우스모션 리스너 mL add
		Item_state=DotConstants.ITEM_OFF; // 아이템이 눌린 상태 저장 ( 초기화 므로 안눌린 상태)
		gamePanel = gPanel;	//callUp 연결
		bRect=false; k=0;
		item3 = false;	//처음에는 사용안됨으로 초기화
	} //생성자
	
	
	public void paintComponent(Graphics page)
	{
		super.paintComponent(page);
		for(int i=0;i<6;i++)
		for(int j=0;j<6;j++)
			page.drawImage(admin.getDotImg(i,j),admin.getDotX(i,j),admin.getDotY(i,j),null);
		
	}//paintComponent()
	
	public void checkScore(){ //  일정 점수가 넘는지 확인 합니다. (일정 점수가 넘을 시 item3을 setEnable 하기위해서)
		if(score>DotConstants.STANDARDSCORE && item3 == false){	//점수 조건이 충족되고 아이템이 사용되지 않았다면
			btnItem3.setEnabled(true);
			item3 = true;
		}
	}
	
	public void setItemState(int STATE) //아이템 패널에서  아이템 눌린 상태를 set함 
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
		private BtnAListener bL; // 버튼 액션 리스너 
		
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
			
			
			
		}//ItemPanel 생성자

	
	}//ItemPanel class
	
	
	//Listener class 모음
	private class MouseL implements MouseListener,MouseMotionListener
	{
		public void mouseClicked(MouseEvent event){
			if(Item_state==DotConstants.ITEM1_ON)
			{
				startX=event.getX();  
			     startY=event.getY();
				 admin.Item1(startX/DotConstants.IMG_SIZE,startY/DotConstants.IMG_SIZE,admin.getDotColor(startX/DotConstants.IMG_SIZE,startY/DotConstants.IMG_SIZE));
				 // 아이템 1을 동작 시킵니다. 
				 admin.setDelArray();//없앤 점의 수를 셉니다. 
				 admin.restruct();
				 // 점들을 재구조화 합니다.(삭제된 점 위에 있는 점들을 밑으로 내리고, 삭제된 만큼 다시 생성 합니다.)
				 turn-=1; // 턴 1 감소 
				 admin.uncheckMoved(); // 모든점을 다시 누를수 있도록 눌린점을 초기화 합니다.
				 admin.resetJudge(); // 눌린 점의 정보를 삭제 합니다. 
				 lblturn.setText("turn : "+turn);
				 checkScore(); // 일정한 점수가 넘는지 확인합니다. ( 기준점수 증가시 item3 버튼 사용 가능)
				 Item_state=DotConstants.ITEM_OFF;  //아이템 state를 변경경 
			 	
			 
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
				 Item_state=DotConstants.ITEM_OFF;  //아이템 state를 변경  
			 
			
			repaint();
			}//else if
			
			if(turn <= 0){//test
				//panelMode를 2로 변경해줘야함!
				gamePanel.setPanelState(2);
				
				///////////////////////////////////////////////////////////////////////
				//이때 사용자와 점수를 vector마지막에 add!
				
				if(RankManager.vList.size() > 8){	//랭킹을 9개까지밖에 표시못하는데 그 이상 들어갈 때
					//System.out.println("싸이즈가 8보다 크다 즉 9부터 여기");
					String[] str = RankManager.vList.lastElement().split("-");
				
					if(Integer.parseInt(str[0]) < GameScreen.score){	//vector의 마지막 요소와 점수를 비교해서 현재 점수가 더 크다면
						int num = RankManager.vList.size()-1;
						RankManager.vList.setElementAt(GameScreen.score+"-"+StartPanel.userName, num);	//마지막 요소하고 현재 정보하고 교체
					}	
				}//if
				else{	
					//System.out.println("싸이즈가 8이하는 여기");
					RankManager.vList.add(GameScreen.score+"-"+StartPanel.userName);	//add
				}
				
				
				Collections.sort(RankManager.vList);	//vetor의 데이터들은 내림차순으로 정렬
				Collections.reverse(RankManager.vList);
				
				//제대로 add되고 정렬되었는지 확인
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
			{ //이동 가능 한지 확인하고, 점이 안 눌렸는지 검사 합니다. 
			admin.addJudge(startX/DotConstants.IMG_SIZE,startY/DotConstants.IMG_SIZE,admin.getDotColor(startX/DotConstants.IMG_SIZE,startY/DotConstants.IMG_SIZE));
			//눌린 점 정보 저장 
			admin.setPressed(startX/DotConstants.IMG_SIZE,startY/DotConstants.IMG_SIZE,1);
			//점이 눌렸다고 설정 
			admin.checkMoved(startX/DotConstants.IMG_SIZE,startY/DotConstants.IMG_SIZE);
	     	//눌린 점과 같은 색이고 상,하,좌,우인 점만 누를 수 있도록 합니다.
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
			 Item_state=DotConstants.ITEM_OFF;  //아이템 state를 변경 
			 	 
			 k=0;
			 repaint();
	
			bRect=false;
		}//if
			else{// 사각형을 만들지 못하였을 때 
			admin.removeDot();
			admin.setDelArray();
			admin.restruct();
			checkScore();
			if(admin.getCount()>1){
				turn -= 1;	// 마우스를 릴리즈할때마다 턴감소
			}
			
			admin.uncheckMoved(); 
			admin.resetJudge(); 
			
			lblturn.setText("turn : "+turn);
					
			repaint();
			}//else
			
			
			gamePanel.setBackground(new Color(0,162,232));
			
			if(turn <= 0){//test
				//panelMode를 2로 변경해줘야함!
				gamePanel.setPanelState(2);
				
				///////////////////////////////////////////////////////////////////////
				//이때 사용자와 점수를 vector마지막에 add!
				
				if(RankManager.vList.size() > 8){	//랭킹을 9개까지밖에 표시못하는데 그 이상 들어갈 때
					//System.out.println("싸이즈가 8보다 크다 즉 9부터 여기");
					String[] str = RankManager.vList.lastElement().split("-");
				
					if(Integer.parseInt(str[0]) < GameScreen.score){	//vector의 마지막 요소와 점수를 비교해서 현재 점수가 더 크다면
						int num = RankManager.vList.size()-1;
						RankManager.vList.setElementAt(GameScreen.score+"-"+StartPanel.userName, num);	//마지막 요소하고 현재 정보하고 교체
					}	
				}//if
				else{	
					//System.out.println("싸이즈가 8이하는 여기");
					RankManager.vList.add(GameScreen.score+"-"+StartPanel.userName);	//add
				}
				
				
				Collections.sort(RankManager.vList);	//vetor의 데이터들은 내림차순으로 정렬
				Collections.reverse(RankManager.vList);
				
				//제대로 add되고 정렬되었는지 확인
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
			if(admin.getCheckMoved( nowX/DotConstants.IMG_SIZE ,nowY/DotConstants.IMG_SIZE) == true // getCheckMoved는 눌린 점에서 좌,우,상,하로 움직 일 수 있는지 확인합니다.(true-움직일수있음 ,false-움직일수 없음)
					 && admin.getPressed(nowX/DotConstants.IMG_SIZE, nowY/DotConstants.IMG_SIZE) == 0) // getPressed 메소드는 눌렸던 점인지 아닌지 확인합니다. (0 안눌린점 , 1 눌린점 )
			{
				admin.setPressed(nowX/DotConstants.IMG_SIZE, nowY/DotConstants.IMG_SIZE, 1);
				admin.addJudge(nowX/DotConstants.IMG_SIZE, nowY/DotConstants.IMG_SIZE, 
				admin.getDotColor(nowX/DotConstants.IMG_SIZE, nowY/DotConstants.IMG_SIZE));
				admin.resetBp(nowX/DotConstants.IMG_SIZE,nowY/DotConstants.IMG_SIZE);
				admin.checkMoved(nowX/DotConstants.IMG_SIZE, nowY/DotConstants.IMG_SIZE);			
			}
			

			if(admin.getCount()>3 &&admin.getCheckMoved(nowX/DotConstants.IMG_SIZE,nowY/DotConstants.IMG_SIZE)==true &&	//이동가능한 점이고
					admin.getPressed(nowX/DotConstants.IMG_SIZE,nowY/DotConstants.IMG_SIZE)==1&& //눌렸던 점이면
					((admin.recentRow()!=nowX/DotConstants.IMG_SIZE)|| // 가장 최근에 눌린 점의 바로 전 점과 같은지 비교합니다.
					(admin.recentCol()!=nowY/DotConstants.IMG_SIZE))){ // 가장 최근에 눌린 점의 바로 전 점과 같은지 비교 합니다. 
			
					
				if( k==0) /*&& (근데 여기서 눌린점이 바로전에 눌린 점과 judgeArray인덱스 차이가 3이상 나야됨, 조건 추가해야함)*/	 
										//사각형이 되려면 눌린점이 최소 4개 이상이여야함  >1 을 >3으로 수정함, 
				{
						admin.addJudge(nowX/DotConstants.IMG_SIZE, nowY/DotConstants.IMG_SIZE, 
						admin.getDotColor(nowX/DotConstants.IMG_SIZE, nowY/DotConstants.IMG_SIZE));	
						bRect=admin.judgeCheck();
						System.out.println(bRect);
						
						//모바일 게임 에서 처럼 사각형이 만들어지면 배경색이 그 색으로 바뀜.
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
				//여기에는 첫번째 아이템이 눌렸을때 상황을 구현
				setItemState(DotConstants.ITEM1_ON);
				btnItem1.setEnabled(false);
				
			}
			else if(obj == btnItem2){
				//두번째 아이템
				setItemState(DotConstants.ITEM2_ON);
				btnItem2.setEnabled(false);
			}
			else if(obj == btnItem3){
				turn+=5; 
				lblturn.setText("turn : "+turn);
				btnItem3.setEnabled(false);
				//세번재 아이템
			}
		}//actionPerformed()
		
	}//BtnAListener class


	
	

}

