import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.swing.*;

public class RankPanel extends JPanel implements Runnable{
	//data
	private JLabel lblScores;
	private JLabel lblHighScore;
	private JLabel lblMyScore;
	private JPanel panelRank;
	private JButton btnExit;
	
	private int nHighScore;
	private int nMyScore;
	
	private MainPanel primary;
	
	private BAListener btnL;
	private MListener mouseL;
	

	private JLabel[] lblArray;
	private JLabel[] lblName;
	private JLabel[] lblScore;
	//파일입출력
	private RankManager rManager;
	
	private Thread nThread;	

	private String userName;
	private int nScore;
	
	private JLabel lblNewHS;
	
	//method
	public RankPanel(MainPanel mPanel) throws FileNotFoundException
	{
		this.setPreferredSize(new Dimension(600,850));
		this.setBackground(DotConstants.RANKPANEL_BACK);
		this.setLayout(null);
		
		
		primary = mPanel;	//상위 클래스와 연결
		
		lblNewHS = new JLabel(new ImageIcon("newHS.png"));
		lblNewHS.setBounds(80, 330, 460, 180);
		lblNewHS.setVisible(false);
//		this.add(lblNewHS);
		
		nHighScore = 0;
		nMyScore = 0;
		btnL = new BAListener();
		mouseL = new MListener();
		
		
		this.addMouseListener(mouseL);
				
		lblScores = new JLabel("SCORES");
		lblScores.setBounds(50, 20, 500, 130);
		lblScores.setForeground(DotConstants.RANKPANEL_COLOR1);
		lblScores.setFont(new Font("Verdana",Font.BOLD,80));
		lblScores.setHorizontalAlignment(SwingConstants.CENTER);
		lblScores.setVerticalAlignment(SwingConstants.CENTER);
		this.add(lblScores);
		
		lblHighScore = new JLabel("HighScore : "+nHighScore);
		lblHighScore.setBounds(50, 145, 240, 100);
		lblHighScore.setForeground(DotConstants.RANKPANEL_COLOR2);
		lblHighScore.setFont(new Font("Verdana",Font.BOLD,28));
		lblHighScore.setVerticalAlignment(SwingConstants.CENTER);
		lblHighScore.setHorizontalAlignment(SwingConstants.CENTER);
		this.add(lblHighScore);
		
		lblMyScore = new JLabel("MyScore : "+nMyScore);
		lblMyScore.setBounds(300, 145, 240, 100);
		lblMyScore.setForeground(new Color(255,130,40));
		lblMyScore.setFont(new Font("Verdana",Font.BOLD,28));
		lblMyScore.setVerticalAlignment(SwingConstants.CENTER);
		lblMyScore.setHorizontalAlignment(SwingConstants.CENTER);
		this.add(lblMyScore);
		
		panelRank = new JPanel();
		panelRank.setLayout(null);
		panelRank.setBounds(50, 250, 500, 500);
		panelRank.setBackground(DotConstants.RANKPANEL_COLOR1);
		this.add(panelRank);
		//panelRank에 파일입출력 클래스을 이용해 순위 데이터 표시
		
		lblArray = new JLabel[9];
		for(int i=0; i<9; i++){
			lblArray[i] = new JLabel("");
			lblArray[i].setFont(new Font("Verdana", Font.BOLD, 28));
			lblArray[i].setBounds(10, 20+(i*50), 100, 50);
			lblArray[i].setHorizontalAlignment(SwingConstants.CENTER);
			lblArray[i].setForeground(DotConstants.RANKPANEL_COLOR2);
			this.panelRank.add(lblArray[i]);
		}
		
		
		lblName = new JLabel[9];
		for(int i=0; i<9; i++){
			lblName[i] = new JLabel("");
			lblName[i].setFont(new Font("Verdana", Font.BOLD, 28));
			lblName[i].setBounds(135, 20+(i*50), 190, 50);
			lblName[i].setHorizontalAlignment(SwingConstants.CENTER);
			lblName[i].setForeground(DotConstants.RANKPANEL_COLOR2);
			this.panelRank.add(lblName[i]);
		}
		
		lblScore = new JLabel[9];
		for(int i=0; i<9; i++){
			lblScore[i] = new JLabel("");
			lblScore[i].setFont(new Font("Verdana", Font.BOLD, 28));
			lblScore[i].setBounds(340, 20+(i*50), 150, 50);
			lblScore[i].setHorizontalAlignment(SwingConstants.CENTER);
			lblScore[i].setForeground(DotConstants.RANKPANEL_COLOR2);
			this.panelRank.add(lblScore[i]);
		}
	
	
		
		btnExit = new JButton("EXIT");
		btnExit.setForeground(DotConstants.RANKPANEL_COLOR2);
		btnExit.setBackground(new Color(181,230,29));
		btnExit.setFont(new Font("Verdana", Font.ITALIC, 23));
		btnExit.setBounds(440, 760, 100, 60);
		btnExit.addActionListener(btnL);
		this.add(btnExit);
		
	
		nThread = null;
		
		//파일입출력
		rManager = new RankManager();
		
		rManager.readFile();
		start();
		
	}//RankPanel()
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
	}
	
		
	
	//리스너 클래스
	private class BAListener implements ActionListener{

		public void actionPerformed(ActionEvent event) {
			Object obj = event.getSource();
			
			
			if(obj == btnExit){
								
				primary.setPanelState(3);
				
			}
		}//actionPerformed()
		
	}//BAListener class
	
	private class MListener implements MouseListener{

		public void mouseClicked(MouseEvent arg0) {}
		public void mouseEntered(MouseEvent event) {
			Object obj = event.getSource();
			if(obj != null) rManager.writeFile();	//vector에 있는 랭킹 정보를 파일에 쓰기
			
			

		}
		public void mouseExited(MouseEvent event) {}
		public void mousePressed(MouseEvent arg0) {}
		public void mouseReleased(MouseEvent arg0) {}
	}
	
	public void start(){
		if(nThread == null) nThread = new Thread(this);
		nThread.start();
	}
	
	public void run() {
		
		try{
			while(true){
				
				lblMyScore.setText("MyScore : "+GameScreen.score);
												
				for(int i =0; i<RankManager.vList.size(); i++){	//vector크기만큼 반복
					String[] str2 = new String[2];
					str2 = RankManager.vList.get(i).split("-");
					nScore = Integer.parseInt(str2[0]);
					userName = str2[1];
					
					if(i==0){
						lblHighScore.setText("HighScore : "+nScore);
						if(GameScreen.score == nScore){
//							System.out.println("신기록 경신!!!");
							lblNewHS.setVisible(true);
						}
					}
					
					lblArray[i].setText(""+(i+1));
					lblName[i].setText(userName);
					lblScore[i].setText(""+nScore);
					
					//현재 게임의 점수와 사용자이름은 빨강색으로 강조해줌!
					
					if(nScore == GameScreen.score && StartPanel.userName.equalsIgnoreCase(userName) == true){
							lblArray[i].setForeground(new Color(255,130,40));
							lblName[i].setForeground(new Color(255,130,40));
							lblScore[i].setForeground(new Color(255,130,40));
					}//if
				
					
					
					
				}//for
				
				nThread.sleep(300);
				
			}//while
			
			
		}catch(Exception e){}
		
	
	}
	
	public void stop(){
		if(nThread != null) nThread.stop();
	}
}
