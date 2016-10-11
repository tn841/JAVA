import javax.swing.JFrame ;

public class Driver {
	
	public static void main ( String [ ] args ) {
	
		JFrame frame = new JFrame ( ) ;
		frame.setDefaultCloseOperation ( JFrame.EXIT_ON_CLOSE ) ;
		
		PrimaryPanel primary = new PrimaryPanel ( ) ;
		
		frame.getContentPane ( ).add ( primary ) ;
		frame.pack ( ) ;
		frame.setVisible ( true ) ;
		Thread t = new Thread ( ) {
			
			public void run ( ) {
			
				while ( true ) {
					frame.repaint ( ) ;
					primary.repaint ( ) ;
					primary.mPanel.repaint ( ) ;
					try {
						Thread.sleep ( 17 ) ;
					}
					catch ( InterruptedException e ) {
						e.printStackTrace ( ) ;
					}
				}
			}
		} ;
		t.start ( ) ;
	}
	
}
