import java.awt.* ;
import java.util.* ;
import java.awt.event.* ;

import javax.swing.* ;
import javax.swing.Box.Filler ;

public class MapPanel extends JPanel {
	
	// data
	private Image					Background ;
	
	private JLabel [ ]				img ;
	
	private JLabel [ ]				blank ;
	
	public int						pX [ ] ;
	
	public int						pY [ ] ;
	
	public String					name [ ] ;
	
	public ArrayList < NationData >	nation ;		// ArrayList ¼±¾ð
													
	private MListener				mL ;
	
	private PrimaryPanel			pPanel ;
	
	public boolean					canDrawLine ;
	
	ArrayList < NationData >		drawingLine ;
	
	// method
	public MapPanel ( PrimaryPanel primary ) {
	
		pPanel = primary ;// upcall
		
		this.setLayout ( null ) ;
		canDrawLine = false ;
		
		mL = new MListener ( ) ;
		this.addMouseListener ( mL ) ;
		
		Background = Toolkit.getDefaultToolkit ( ).createImage ( "./img/asia.png" ) ;
		
		pX = new int [ ] { 355 , 299 , 275 , 107 , 176 , 363 , 71 , 416 , 219 , 362 , 177 , 307 , 242 , 264 , 222 , 230 , 138 , 95 , 89 , 39 , 334 , 338 , 297 , 136 } ;
		pY = new int [ ] { 156 , 231 , 149 , 187 , 81 , 75 , 287 , 156 , 314 , 336 , 269 , 445 , 332 , 315 , 275 , 405 , 251 , 217 , 368 , 404 , 131 , 255 , 255 , 224 } ;
		name = new String [ ] { "Korea" , "Gwan" , "Beijing" , "Tibet" , "MongGoal" , "Vladi" , "India" , "Japan" , "Tai" , "Pil" , "Miyanma" , "Indo4" , "Kambo" , "Baetman" , "Laos" , "Malaysia" , "Bangla" , "Nepal" , "Srilangca" , "Moldive" , "Noth_Korea" , "Taiwan" , "HongKong" , "Butane" } ;
		
		nation = new ArrayList < NationData > ( ) ;	// ArrayList»ý¼º
		
		img = new JLabel [ 25 ] ;
		for ( int i = 0 ; i < 25 ; i ++ ) {
			img [ i ] = new JLabel ( ) ;
			img [ i ].setVisible ( false ) ;
			add ( img [ i ] ) ;
		}
		
		// ÇÑ±¹
		img [ MapConstants.KOREA ].setIcon ( new ImageIcon ( "./img/Korea.png" ) ) ;	// korea
		img [ MapConstants.KOREA ].setBounds ( 337 , 138 , 47 , 35 ) ;
		
		// ±¤Àú¿ì
		img [ MapConstants.GWAN ].setIcon ( new ImageIcon ( "./img/Gwan.png" ) ) ;
		img [ MapConstants.GWAN ].setBounds ( 185 , 180 , 170 , 100 ) ;
		
		// º£ÀÌÂ¡
		img [ MapConstants.BEIJING ].setIcon ( new ImageIcon ( "./img/beijing.png" ) ) ;
		img [ MapConstants.BEIJING ].setBounds ( 180 , 36 , 180 , 180 ) ;
		
		// Æ¼ºª
		img [ MapConstants.TIBET ].setIcon ( new ImageIcon ( "./img/tibet.png" ) ) ;
		img [ MapConstants.TIBET ].setBounds ( 10 , 64 , 200 , 150 ) ;
		
		// ¸ù°ñ
		img [ MapConstants.MONGOAL ].setIcon ( new ImageIcon ( "./img/mong.png" ) ) ;
		img [ MapConstants.MONGOAL ].setBounds ( 72 , 29 , 200 , 100 ) ;
		
		// ºí¶óµðº¸½ºÅå
		img [ MapConstants.VLADI ].setIcon ( new ImageIcon ( "./img/vladi.png" ) ) ;
		img [ MapConstants.VLADI ].setBounds ( 67 , 4 , 350 , 100 ) ;
		
		// ÀÎµµ
		img [ MapConstants.INDIA ].setIcon ( new ImageIcon ( "./img/india.png" ) ) ;
		img [ MapConstants.INDIA ].setBounds ( 0 , 164 , 170 , 200 ) ;
		
		// ÀÏº»
		img [ MapConstants.JAPAN ].setIcon ( new ImageIcon ( "./img/japan.png" ) ) ;
		img [ MapConstants.JAPAN ].setBounds ( 370 , 94 , 100 , 100 ) ;
		
		// ÅÂ±¹
		img [ MapConstants.TAI ].setIcon ( new ImageIcon ( "./img/tai.png" ) ) ;
		img [ MapConstants.TAI ].setBounds ( 192 , 278 , 100 , 100 ) ;
		
		// ÇÊ¸®ÇÉ
		img [ 9 ].setIcon ( new ImageIcon ( "./img/pil.png" ) ) ;
		img [ 9 ].setBounds ( 327 , 288 , 100 , 100 ) ;
		
		// ¹Ì¾á¸¶
		img [ 10 ].setIcon ( new ImageIcon ( "./img/miyan.png" ) ) ;
		img [ 10 ].setBounds ( 152 , 212 , 100 , 140 ) ;
		
		// ÀÎµµ³×½Ã¾Æ
		img [ 11 ].setIcon ( new ImageIcon ( "./img/indo4.png" ) ) ;
		img [ 11 ].setBounds ( 185 , 378 , 300 , 100 ) ;
		
		// Ä¯º¸µð¾Æ
		img [ 12 ].setIcon ( new ImageIcon ( "./img/kambo.png" ) ) ;
		img [ 12 ].setBounds ( 229 , 294 , 80 , 80 ) ;
		
		// ³²º£Æ®³²
		img [ 13 ].setIcon ( new ImageIcon ( "./img//Sbaet.png" ) ) ;
		img [ 13 ].setBounds ( 218 , 248 , 80 , 120 ) ;
		
		// ¶ó¿À½º
		img [ 14 ].setIcon ( new ImageIcon ( "./img/laos.png" ) ) ;
		img [ 14 ].setBounds ( 209 , 250 , 80 , 80 ) ;
		
		// ¸»·¹ÀÌ½Ã¾Æ
		img [ 15 ].setIcon ( new ImageIcon ( "./img/malaysia.png" ) ) ;
		img [ 15 ].setBounds ( 218 , 358 , 150 , 80 ) ;
		
		// ¹æ±Û¶óµ¥½Ã
		img [ 16 ].setIcon ( new ImageIcon ( "./img/bangla.png" ) ) ;
		img [ 16 ].setBounds ( 125 , 230 , 40 , 40 ) ;
		
		// ³×ÆÈ
		img [ 17 ].setIcon ( new ImageIcon ( "./img/nepal.png" ) ) ;
		img [ 17 ].setBounds ( 70 , 200 , 70 , 30 ) ;
		
		// ½º¸®¶ûÄ«
		img [ 18 ].setIcon ( new ImageIcon ( "./img/srilanka.png" ) ) ;
		img [ 18 ].setBounds ( 81 , 338 , 20 , 60 ) ;
		
		// ¸ôµðºê
		img [ 19 ].setIcon ( new ImageIcon ( "./img/maldive.png" ) ) ;
		img [ 19 ].setBounds ( 36 , 365 , 30 , 60 ) ;
		
		// ºÏÇÑ
		img [ 20 ].setIcon ( new ImageIcon ( "./img/Nkorea.png" ) ) ;
		img [ 20 ].setBounds ( 319 , 100 , 50 , 50 ) ;
		
		// ´ë¸¸
		img [ 21 ].setIcon ( new ImageIcon ( "./img/taiwan.png" ) ) ;
		img [ 21 ].setBounds ( 330 , 231 , 40 , 40 ) ;
		
		// È«Äá
		img [ 22 ].setIcon ( new ImageIcon ( "./img/hongkong.png" ) ) ;
		img [ 22 ].setBounds ( 280 , 215 , 80 , 80 ) ;
		
		// ºÎÅº
		img [ 23 ].setIcon ( new ImageIcon ( "./img/butane.png" ) ) ;
		img [ 23 ].setBounds ( 126 , 181 , 80 , 80 ) ;
		
		blank = new JLabel [ 25 ] ;
		for ( int i = 0 ; i < 25 ; i ++ ) {
			blank [ i ] = new JLabel ( ) ;
			blank [ i ].addMouseListener ( mL ) ;
			/*
			 * if(i%4 == 0){ blank[i].setBackground(Color.orange); } else if(i%4
			 * == 1){ blank[i].setBackground(Color.red); } else if(i%4 ==
			 * 2){blank[i].setBackground(Color.green);} else if(i%4 ==
			 * 3){blank[i].setBackground(Color.cyan);}
			 * else{blank[i].setBackground(Color.magenta);}
			 */
			
			// null1[i].setBackground(null);
			add ( blank [ i ] ) ;
		}
		blank [ 0 ].setBounds ( 337 , 138 , 47 , 30 ) ;
		blank [ 1 ].setBounds ( 185 , 195 , 140 , 85 ) ;	// ±¤Àú¿ì
		blank [ 2 ].setBounds ( 220 , 56 , 110 , 180 ) ;	// º£ÀÌÂ¡
		blank [ 3 ].setBounds ( 10 , 94 , 200 , 100 ) ;	// Æ¼ºª
		blank [ 4 ].setBounds ( 72 , 50 , 200 , 80 ) ;	// ¸ù°ñ
		blank [ 5 ].setBounds ( 67 , 4 , 350 , 100 ) ;
		blank [ 6 ].setBounds ( 0 , 225 , 130 , 125 ) ;	// ÀÎµµ
		blank [ 7 ].setBounds ( 370 , 94 , 100 , 100 ) ;
		blank [ 8 ].setBounds ( 192 , 278 , 45 , 100 ) ;	// ÅÂ±¹
		blank [ 9 ].setBounds ( 327 , 288 , 80 , 100 ) ;	// ÇÊ¸®ÇÉ
		blank [ 10 ].setBounds ( 152 , 212 , 75 , 140 ) ;	// ¹Ì¾á¸¶
		blank [ 11 ].setBounds ( 185 , 410 , 300 , 70 ) ;	// ÀÎµµ³×½Ã¾Æ
		blank [ 12 ].setBounds ( 230 , 310 , 30 , 30 ) ;	// Ä¯º¸µð¾Æ
		blank [ 13 ].setBounds ( 218 , 248 , 55 , 120 ) ;	// º£Æ®³²
		blank [ 14 ].setBounds ( 209 , 250 , 80 , 80 ) ;
		blank [ 15 ].setBounds ( 218 , 368 , 150 , 70 ) ;	// ¸»·¹ÀÌ½Ã¾Æ
		blank [ 16 ].setBounds ( 125 , 230 , 40 , 40 ) ;
		blank [ 17 ].setBounds ( 70 , 185 , 70 , 40 ) ;	// ³×ÆÈ
		blank [ 18 ].setBounds ( 81 , 338 , 20 , 60 ) ;	// ½º¸®¶ûÄ«
		blank [ 19 ].setBounds ( 36 , 365 , 30 , 60 ) ;
		blank [ 20 ].setBounds ( 319 , 100 , 50 , 50 ) ;
		blank [ 21 ].setBounds ( 330 , 231 , 40 , 40 ) ;
		blank [ 22 ].setBounds ( 280 , 215 , 80 , 80 ) ;
		blank [ 23 ].setBounds ( 126 , 181 , 80 , 80 ) ;
		
		repaint ( ) ;
		
	}// mapPanel()
	
	public void setDrawData ( ArrayList < NationData > nds ) {
	
		drawingLine = nds ;
	}
	
	public void setClear ( ) {
	
		nation.clear ( ) ;
		
		for ( int i = 0 ; i < 25 ; i ++ ) {
			img [ i ].setVisible ( false ) ;
		}
	}
	
	public void setClear2 ( ) {
	
		for ( int i = 0 ; i < 25 ; i ++ ) {
			img [ i ].setVisible ( false ) ;
		}
	}
	
	public void paintComponent ( Graphics page ) {
	
		super.paintComponent ( page ) ;
		
		page.drawImage ( Background , 0 , 0 , null ) ;
		if ( canDrawLine ) {
			for ( int i = 0 ; i < drawingLine.size ( ) ; i ++ ) {
				page.drawLine ( drawingLine.get ( i ).pX , drawingLine.get ( i ).pY , drawingLine.get ( ( i + 1 ) % drawingLine.size ( ) ).pX , drawingLine.get ( ( i + 1 ) % drawingLine.size ( ) ).pY ) ;
				page.fillOval ( drawingLine.get ( i ).pX - 5 , drawingLine.get ( i ).pY - 5 , 10 , 10 ) ;
			}
		}
	}// paintComponent()
	
	private class MListener implements MouseListener {
		
		@ Override
		public void mouseClicked ( MouseEvent event ) {
		
			// TODO Auto-generated method stub
			Object obj = event.getSource ( ) ;
			
			System.out.println ( obj ) ;
			Point p = new Point ( ) ;
			
			p = event.getPoint ( ) ;
			
			for ( int i = 0 ; i < 25 ; i ++ ) {
				if ( obj == blank [ i ] ) {
					img [ i ].setVisible ( true ) ;
					
					nation.add ( new NationData ( pX [ i ] , pY [ i ] , name [ i ] , i ) ) ;
					pPanel.lblInfo [ 2 ].setText ( pPanel.lblInfo [ 2 ].getText ( ) + " - " + name [ i ] ) ;
				}
			}// for
			System.out.println ( "Size of ArrayList" + nation.size ( ) ) ;
			
		}
		
		@ Override
		public void mouseEntered ( MouseEvent event ) {
		
			// TODO Auto-generated method stub
		}
		
		@ Override
		public void mouseExited ( MouseEvent event ) {
		
			// TODO Auto-generated method stub
			
		}
		
		@ Override
		public void mousePressed ( MouseEvent event ) {
		
			// TODO Auto-generated method stub
			
		}
		
		@ Override
		public void mouseReleased ( MouseEvent event ) {
		
			// TODO Auto-generated method stub
			
		}
		
	}
	
}
