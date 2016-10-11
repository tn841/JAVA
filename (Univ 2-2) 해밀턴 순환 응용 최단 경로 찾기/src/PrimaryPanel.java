import java.awt.* ;

import javax.swing.* ;

import java.awt.event.* ;
import java.util.ArrayList ;

public class PrimaryPanel extends JPanel {
	
	public JPanel					InputPanel , OutputPanel ;
	
	private JButton					btnStart , btnClear ;
	
	private JLabel					lblTotal ;
	
	public JLabel [ ]				lblInfo ;
	
	private JLabel [ ]				lblDesti ;
	
	private String [ ]				StringInput		= { "" , "" , "방문 목적지 : " } ;
	
	private String [ ]				Transportation	= { "이동수단" , "걸어서" , "자전거로" , "자동차로" , "비행기" , "전투기" } ;
	
	private JComboBox				box ;
	
	private MouseActionL			MouseL ;
	
	private ArrayList < String >	path ;
	
	public MapPanel					mPanel ;
	
	private NationData				temp ;
	
	private TSP_Basic				tsp ;
	
	public PrimaryPanel ( ) {
	
		setBackground ( Color.white ) ;
		setLayout ( null ) ;
		setPreferredSize ( new Dimension ( 800 , 600 ) ) ;
		
		mPanel = new MapPanel ( this ) ;// upcall
		mPanel.setBounds ( 0 , 100 , 500 , 500 ) ;
		add ( mPanel ) ;
		
		MouseL = new MouseActionL ( ) ;
		path = new ArrayList < String > ( ) ;
		tsp = new TSP_Basic ( ) ;
		
		path.add ( "Korea" ) ;
		path.add ( "Japan" ) ;
		path.add ( "China" ) ;
		
		InputPanel = new JPanel ( ) ;
		InputPanel.setBackground ( new Color ( 255 , 255 , 158 ) ) ;
		InputPanel.setLayout ( null ) ;
		InputPanel.setBounds ( 0 , 0 , 1000 , 100 ) ;
		add ( InputPanel ) ;
		
		OutputPanel = new JPanel ( ) ;
		OutputPanel.setBackground ( Color.orange ) ;
		OutputPanel.setLayout ( null ) ;
		OutputPanel.setBounds ( 500 , 100 , 300 , 500 ) ;
		add ( OutputPanel ) ;
		
		btnStart = new JButton ( "길 찾 기" ) ;
		btnStart.setBounds ( 0 , 400 , 100 , 50 ) ;
		btnStart.addActionListener ( MouseL ) ;
		OutputPanel.add ( btnStart ) ;
		
		btnClear = new JButton ( "초 기 화" ) ;
		btnClear.setBounds ( 100 , 400 , 100 , 50 ) ;
		btnClear.addActionListener ( MouseL ) ;
		OutputPanel.add ( btnClear ) ;
		
		lblInfo = new JLabel [ 3 ] ;
		for ( int i = 0 ; i < 3 ; i ++ ) {
			lblInfo [ i ] = new JLabel ( StringInput [ i ] ) ;
			lblInfo [ i ].setFont ( new Font ( "Helvetica" , Font.BOLD , 16 ) ) ;
			lblInfo [ i ].setBounds ( 20 , 60 , 1000 , 30 ) ;
			InputPanel.add ( lblInfo [ i ] ) ;
		}
		
		lblDesti = new JLabel [ 24 ] ;
		for ( int i = 0 ; i < 24 ; i ++ ) {
			lblDesti [ i ] = new JLabel ( "" ) ;
			lblDesti [ i ].setFont ( new Font ( "Helvetica" , Font.BOLD , 16 ) ) ;
			lblDesti [ i ].setBounds ( 20 , ( i + 1 ) * 30 , 300 , 30 ) ;
			OutputPanel.add ( lblDesti [ i ] ) ;
		}
		
		lblTotal = new JLabel ( "총 이동거리 : " ) ;
		lblTotal.setFont ( new Font ( "Helvetica" , Font.BOLD , 16 ) ) ;
		lblTotal.setBounds ( 20 , 300 , 300 , 40 ) ;
		OutputPanel.add ( lblTotal ) ;
		
		box = new JComboBox ( Transportation ) ;
		box.setBounds ( 20 , 350 , 80 , 30 ) ;
		box.setVisible ( false ) ;
		OutputPanel.add ( box ) ;
	}
	
	private class MouseActionL implements ActionListener {
		
		public void actionPerformed ( ActionEvent event ) {
		
			Object obj = event.getSource ( ) ;
			
			if ( obj == btnStart ) {
				box.setVisible ( true ) ;
				
				for ( int i = 0 ; i < mPanel.nation.size ( ) ; i ++ ) {
					temp = mPanel.nation.get ( i ) ;
					System.out.println ( temp.pX + " " + temp.pY + " " + temp.name + " " + temp.index ) ;
				}// for
				ArrayList < Nation > toMyNations = new ArrayList < Nation > ( ) ;
				for ( NationData nd : mPanel.nation ) {
					toMyNations.add ( new Nation ( nd.pX , nd.pY , nd.name ) ) ;
				}
				tsp.setData ( toMyNations ) ;
				tsp.calcHamiltonianPath ( ) ;
				int dis = ( int ) ( tsp.getMinDistance ( ) * 100 ) ;
				lblTotal.setText ( "총 이동거리 : " + ( ( double ) dis ) / 100 * 13 + "km" ) ;
				String [ ] savingPath = tsp.getVisitOrder ( ) ;
				for ( int i = 0 ; i < 24 ; i ++ ) {
					if ( i < savingPath.length ) {
						lblDesti [ i ].setText ( savingPath [ i ] ) ;
					}
					else {
						lblDesti [ i ].setText ( "" ) ;
					}
				}
				mPanel.setClear2 ( ) ;
				ArrayList < NationData > temp = new ArrayList < NationData > ( ) ;
				for ( String s : savingPath ) {
					for ( NationData n : mPanel.nation )
						
						if ( s.equalsIgnoreCase ( n.name ) ) {
							temp.add ( n ) ;
							break ;
						}
				}
				mPanel.setDrawData ( temp ) ;
				mPanel.canDrawLine = true ;
				
			}
			else if ( obj == btnClear ) {
				mPanel.setClear ( ) ;	// 초기화
				lblInfo [ 2 ].setText ( "방문 목적지 : " ) ;
				mPanel.canDrawLine = false ;
				mPanel.repaint ( ) ;
				for ( int i = 0 ; i < 24 ; i ++ ) {
					lblDesti [ i ].setText ( "" ) ;
				}
				lblTotal.setText ( "총 이동거리 : " ) ;
			}// if
			
		}// actionPerformed()
	}// MouseActionL
	
}
