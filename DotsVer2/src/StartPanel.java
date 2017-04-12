import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.io.*;


public class StartPanel extends JPanel {
	//data
	private MainPanel mPanel;

	private Image title;

	private JButton BtnStart;
	private MListener mL;
	 	
	private JTextField txtUserName;
	private JButton btnUserName;
	private JLabel lblUserName;
	  
	private	AListener actionL;

	public static String userName;	//정적 변수로 선언하여 다른 클래스와 쉽게 공유가능
	            
	//method     
	public StartPanel(MainPanel pri) 
	{
		mPanel = pri;
		this.setPreferredSize(new Dimension(600,850));
		this.setBackground(Color.white);
		setLayout(null);
		
		mL= new MListener();
		actionL = new AListener();
		
        title = new ImageIcon("Title.png").getImage();
        
        
        
        BtnStart=new JButton();
        BtnStart.setIcon(new ImageIcon("BtnStart1.png"));
  		BtnStart.setBounds(225,660,150,70);
  		BtnStart.addMouseListener(mL);
  		add(BtnStart);
                
        lblUserName = new JLabel("Please Enter Your Name!");
        lblUserName.setBounds(90, 500, 420, 100);
        lblUserName.setFont(new Font("Verdana", Font.BOLD, 30));
        lblUserName.setHorizontalAlignment(SwingConstants.CENTER);
        add(lblUserName);
        
        txtUserName = new JTextField("User");
        txtUserName.setBounds(225, 600, 150, 40);
        txtUserName.setFont(new Font("verdana", Font.BOLD, 20));
        txtUserName.setHorizontalAlignment(SwingConstants.CENTER);
        txtUserName.addActionListener(actionL);
        add(txtUserName);
        
        btnUserName = new JButton("START");
        btnUserName.setBounds(320, 600, 80, 40);
        btnUserName.addActionListener(actionL);
        //add(btnUserName);
        
		userName = null;
		
	}//StartPanel()
	
	
	
	
	public void paintComponent(Graphics page)
	{
		super.paintComponent(page);
		//page.drawImage(img2,225,70,null);
		//page.drawImage(img1,85,180,null);	
		//page.drawImage(img5,365,180,null);
		//page.drawImage(img4,150,335,null);
		//page.drawImage(img3,290,335,null);	
		page.drawImage(title, 60, 100, null);
	}//paintComponent()
	
	
	
	
	
	//리스너 클래스
	private class AListener implements ActionListener{

		public void actionPerformed(ActionEvent event) {
			Object obj = event.getSource();
			
			if(obj == txtUserName){
				userName = txtUserName.getText();

			}
			else if(obj == btnUserName){
				userName = txtUserName.getText();
				mPanel.setPanelState(1);
			}
		}
		
	}//AListener class
	
	private class MListener implements MouseListener{
	
		public void mouseClicked(MouseEvent event){
			if(event.getSource()==BtnStart)
			{
				userName = txtUserName.getText();
				mPanel.setPanelState(1);
			}
		}
		public void mouseEntered(MouseEvent event) {BtnStart.setIcon(new ImageIcon("BtnStart2.png"));}
		public void mouseExited(MouseEvent event) {BtnStart.setIcon(new ImageIcon("BtnStart1.png"));}
		public void mousePressed(MouseEvent event) {}
	    public void mouseReleased(MouseEvent event) {
	    	userName = txtUserName.getText();
			mPanel.setPanelState(1);
	    }

	}// MListener class
	
	
	
	
}
