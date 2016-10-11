import java.util.ArrayList ;
import java.util.Random ;

class Nation {
	
	private final String	name ;
	
	private final double	x , y ;
	
	Nation ( final double x , final double y , final String name ) {
	
		this.x = x ;
		this.y = y ;
		this.name = name ;
	}
	
	public String getName ( ) {
	
		return this.name ;
	}
	
	public double getX ( ) {
	
		return this.x ;
	}
	
	public double getY ( ) {
	
		return this.y ;
	}
}

public class TSP_Basic {
	
	private ArrayList < ArrayList < Nation >>	A ;
	
	private double [ ][ ]						D ;
	
	private int [ ][ ]							P ;
	
	private double								minDistance ;
	
	private int									n ;
	
	private String [ ]							name ;
	
	private ArrayList < Nation >				nations ;
	
	private ArrayList < ArrayList < Double >>	W ;
	
	public TSP_Basic ( ) {
	
	}
	
	private double calcDistance ( final int to , final int from , final double toX , final double toY , final double fromX , final double fromY ) {
	
		if ( to == from ) { return 0 ; }
		return Math.sqrt ( ( ( toX - fromX ) * ( toX - fromX ) ) + ( ( toY - fromY ) * ( toY - fromY ) ) ) ;
	}
	
	public void calcHamiltonianPath ( ) {
	
		for ( int k = 1 ; k <= ( this.n - 2 ) ; k ++ ) {
			for ( int subsetIndex = 0 ; subsetIndex < this.A.size ( ) ; subsetIndex ++ ) {
				if ( this.A.get ( subsetIndex ).size ( ) == k ) {
					for ( int i = 0 ; i < this.n ; i ++ ) {
						if ( ( i == 0 ) || ( this.A.get ( subsetIndex ).size ( ) == 0 ) || this.A.get ( subsetIndex ).indexOf ( nations.get ( i ) ) != - 1 ) {
							continue ;
						}
						int index , minIndex = 0 ;
						double minValue = Double.MAX_VALUE ;
						double [ ] aryMin = new double [ this.A.get ( subsetIndex ).size ( ) ] ;
						for ( int j = 0 ; j < this.A.get ( subsetIndex ).size ( ) ; j ++ ) {
							aryMin [ j ] = this.W.get ( i ).get ( this.getIndex ( this.A.get ( subsetIndex ).get ( j ) ) ) + this.D [ this.getIndex ( this.A.get ( subsetIndex ).get ( j ) ) ] [ this.findIndex ( this.A.get ( subsetIndex ) , new Nation [ ] { this.A.get ( subsetIndex ).get ( j ) } , 1 ) ] ;
						}
						for ( index = 0 ; index < aryMin.length ; index ++ ) {
							if ( minValue > aryMin [ index ] ) {
								minValue = aryMin [ index ] ;
								minIndex = index ;
							}
						}
						this.D [ i ] [ subsetIndex ] = minValue ;
						this.P [ i ] [ subsetIndex ] = minIndex ;
					}
				}
			}
		}
		int index , minIndex = 0 ;
		double minValue = Double.MAX_VALUE ;
		double [ ] aryMin = new double [ this.nations.size ( ) - 1 ] ;
		for ( int j = 1 ; j < this.nations.size ( ) ; j ++ ) {
			aryMin [ j - 1 ] = this.W.get ( 0 ).get ( j ) + this.D [ j ] [ this.findIndex ( this.nations , new Nation [ ] { this.nations.get ( 0 ) , this.nations.get ( j ) } , 2 ) ] ;
		}
		for ( index = 0 ; index < aryMin.length ; index ++ ) {
			if ( minValue > aryMin [ index ] ) {
				minValue = aryMin [ index ] ;
				minIndex = index ;
			}
		}
		this.D [ 0 ] [ this.D [ 0 ].length - 1 ] = minValue ;
		this.P [ 0 ] [ this.P [ 0 ].length - 1 ] = minIndex ;
		this.minDistance = this.D [ 0 ] [ this.D [ 0 ].length - 1 ] ;
		findPath ( ) ;
	}
	
	private void findPath ( ) {
	
		int rowPoint = 0 , colPoint = A.size ( ) - 1 ;
		ArrayList < Nation > filter = new ArrayList < Nation > ( ) ;
		for ( Nation nation : nations ) {
			if ( nations.get ( 0 ) != nation ) filter.add ( nation ) ;
		}
		int nameIndex = 1 ;
		while ( filter.size ( ) != 0 ) {
			int tempRow = rowPoint , tempCol = colPoint ;
			name [ nameIndex ] = A.get ( tempCol ).get ( P [ tempRow ] [ tempCol ] ).getName ( ) ;
			nameIndex ++ ;
			colPoint = findIndex ( filter , new Nation [ ] { A.get ( tempCol ).get ( P [ tempRow ] [ tempCol ] ) } , 1 ) ;
			rowPoint = getIndex ( A.get ( tempCol ).get ( P [ tempRow ] [ tempCol ] ) ) ;
			filter.remove ( A.get ( tempCol ).get ( P [ tempRow ] [ tempCol ] ) ) ;
		}
		name [ 0 ] = nations.get ( 0 ).getName ( ) ;
		name [ nameIndex ] = name [ 0 ] ;
	}
	
	private int findIndex ( final ArrayList < Nation > nations , final Nation [ ] exNation , final int count ) {
	
		int point = 0 ;
		if ( ( nations.size ( ) - exNation.length ) != 0 ) {
			final Nation [ ] temp = new Nation [ nations.size ( ) - exNation.length ] ;
			for ( int i = 0 ; i < temp.length ; i ++ ) {
				if ( count == 1 ) {
					if ( ! nations.get ( point ).equals ( exNation [ 0 ] ) ) {
						temp [ i ] = nations.get ( point ) ;
					}
					else {
						i -- ;
					}
				}
				else {
					if ( ! nations.get ( point ).equals ( exNation [ 0 ] ) && ! nations.get ( point ).equals ( exNation [ 1 ] ) ) {
						temp [ i ] = nations.get ( point ) ;
					}
					else {
						i -- ;
					}
				}
				point ++ ;
			}
			for ( int i = 0 ; i < this.A.size ( ) ; i ++ ) {
				if ( this.A.get ( i ).size ( ) == temp.length ) {
					int j ;
					for ( j = 0 ; j < temp.length ; j ++ ) {
						if ( ! this.A.get ( i ).get ( j ).equals ( temp [ j ] ) ) {
							break ;
						}
					}
					if ( j == temp.length ) { return i ; }
				}
			}
		}
		else {
			return 0 ;
		}
		return - 1 ;
	}
	
	private ArrayList < ArrayList < Nation >> getAllSubSet ( final ArrayList < Nation > nations ) {
	
		final ArrayList < ArrayList < Nation >> result = new ArrayList < ArrayList < Nation >> ( ) ;
		final int i = 1 << nations.size ( ) ;
		for ( int j = 0 ; j < i ; j ++ ) {
			result.add ( this.getSubSet ( nations , j ) ) ;
		}
		return result ;
	}
	
	private int getIndex ( final Nation nation ) {
	
		return this.nations.indexOf ( nation ) ;
	}
	
	private int getIndexByName ( String name ) {
	
		for ( Nation nation : nations ) {
			if ( nation.getName ( ).equalsIgnoreCase ( name ) ) return nations.indexOf ( nation ) ;
		}
		return - 1 ;
	}
	
	public double getMinDistance ( ) {
	
		System.out.println ( this.minDistance ) ;
		return this.minDistance ;
	}
	
	private ArrayList < Nation > getSubSet ( final ArrayList < Nation > nations , int k ) {
	
		final ArrayList < Nation > subSet = new ArrayList < Nation > ( ) ;
		int index = 0 ;
		while ( k > 0 ) {
			if ( ( k & 1 ) == 1 ) {
				subSet.add ( nations.get ( index ) ) ;
			}
			k = k >> 1 ;
			index ++ ;
		}
		return subSet ;
	}
	
	public String [ ] getVisitOrder ( ) {
	
		for ( int [ ] aryDouble : P ) {
			for ( int d : aryDouble ) {
				System.out.print ( " " + d + " " ) ;
			}
			System.out.println ( "" ) ;
		}
		for ( String print : name ) {
			System.out.println ( print ) ;
		}
		double distance = 0 ;
		for ( int i = 0 ; i < n ; i ++ ) {
			distance += W.get ( getIndexByName ( name [ i ] ) ).get ( getIndexByName ( name [ i + 1 ] ) ) ;
		}
		System.out.println ( distance ) ;
		return this.name ;
	}
	
	public void setData ( final ArrayList < Nation > nations ) {
	
		this.minDistance = 0 ;
		this.n = nations.size ( ) ;
		this.name = new String [ n + 1 ] ;
		this.W = new ArrayList < ArrayList < Double > > ( ) ;
		for ( int i = 0 ; i < this.n ; i ++ ) {
			this.W.add ( new ArrayList < Double > ( ) ) ;
			for ( int j = 0 ; j < this.n ; j ++ ) {
				this.W.get ( i ).add ( this.calcDistance ( i , j , nations.get ( i ).getX ( ) , nations.get ( i ).getY ( ) , nations.get ( j ).getX ( ) , nations.get ( j ).getY ( ) ) ) ;
				System.out.print ( " " + this.W.get ( i ).get ( this.W.get ( i ).size ( ) - 1 ) + " " ) ;
			}
			System.out.println ( "" ) ;
		}
		this.P = new int [ this.n ] [ ( int ) Math.pow ( 2 , this.n - 1 ) ] ;
		this.D = new double [ this.n ] [ ( int ) Math.pow ( 2 , this.n - 1 ) ] ;
		for ( int i = 1 ; i < this.n ; i ++ ) {
			this.D [ i ] [ 0 ] = this.W.get ( i ).get ( 0 ) ;
		}
		
		this.nations = nations ;
		final Nation start = nations.remove ( 0 ) ;
		this.A = this.sortBySize ( this.getAllSubSet ( nations ) ) ;
		nations.add ( 0 , start ) ;
	}
	
	private ArrayList < ArrayList < Nation >> sortBySize ( final ArrayList < ArrayList < Nation >> nations ) {
	
		for ( int i = 0 ; i < ( nations.size ( ) - 1 ) ; i ++ ) {
			for ( int j = i + 1 ; j < nations.size ( ) ; j ++ ) {
				if ( nations.get ( i ).size ( ) > nations.get ( j ).size ( ) ) {
					final ArrayList < Nation > temp1 = nations.get ( j ) ;
					final ArrayList < Nation > temp2 = nations.get ( i ) ;
					nations.remove ( j ) ;
					nations.remove ( i ) ;
					nations.add ( i , temp1 ) ;
					nations.add ( j , temp2 ) ;
				}
			}
		}
		return nations ;
	}
}
