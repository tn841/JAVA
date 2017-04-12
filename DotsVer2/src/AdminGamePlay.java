import java.util.ArrayList;
import java.awt.Image;
import java.awt.Point;

public class AdminGamePlay {
	//data
	private ArrayList<Dot> dotList[];  // Dot 객체를 저장 할 ArrayList 배열 
	private int judgeArray[][];   // 눌린 점의 정보를 담는 2차원 배열
	private Point pt;
	private int panelMode;	//화면에 보여질 패널을 설정하는 변수
	private int count;     //눌린 점의 수를 세는 coun변수
	private int erasedRow; // 지워진 행 값 
	private int reasedCol;  // 지워진 열 값 
	
	//11.28
	private int delCount ;//닷 리스트 마다 없앨 점 카운트 
	private int delArray[];// 닷리스트마다 없앨 점의 수 넣음
	//method
	
	//생성자
	public AdminGamePlay(){
		count =0;
		delCount=0;
		dotList = new ArrayList[7];
		delArray=new int[6];  // ArrayList 배열 생성
		for(int i=0; i<6; i++){   // 객체 생성 (6 X 6 )
			dotList[i]= new ArrayList<Dot>();
			for(int j=0;j<6;j++){
				dotList[i].add(new Dot(i,j));
			}
		}
	
		judgeArray= new int[36][3];   // 1번째 열은 눌린 점의 행에 대한 정보, 2번째 열은 눌린 점의 열에 대한 정보,
		for(int i=0;i<36;i++)  		  // 3번째 열은 눌린 점의 색 정보를 담습니다.
		{
			for(int j=0;j<3;j++)
				judgeArray[i][j]=-1;   // 초기화 과정이므로 갖을 수 없는 수를 저장 합니다.
		}
	} // AdminGamePlay()
	
	
	//눌린 점과 같은 색이고 상,하,좌,우인 점만 누를 수 있도록 합니다.
	public void checkMoved(int row,int col)  //x 는 event.getX()/68 로 받은 변수 
	{
		
			for(int i=0;i<6;i++) 
				{
					for(int j=0;j<6;j++)
						{
							if(dotList[row].get(col).getDotColor()!=dotList[i].get(j).getDotColor())
									dotList[i].get(j).setBpressed(false);
						}
				} //같은 색깔 아닌건 안눌리게 하기
		
		if(row>0&&row<5)  // row : 1~4일 때  
			{
										if(col>0&&col<5)  // row :1~4일 때 && col : 1~4일 떄 
										{
											for(int i=0;i<6;i++)
												for(int j=0;j<6;j++)
												{
													if(j>row+1)
														dotList[j].get(i).setBpressed(false);
													if(j<row-1)
														dotList[j].get(i).setBpressed(false);
													if(i>col+1)
														dotList[j].get(i).setBpressed(false);
													if(i<col-1)
														dotList[j].get(i).setBpressed(false);
													if(i==col-1&&j==row-1)
														dotList[j].get(i).setBpressed(false);
													if(i==col-1&&j==row+1) // 대각선 
														dotList[j].get(i).setBpressed(false);
													if(i==col+1&&j==row+1) // 대각선
														dotList[j].get(i).setBpressed(false);
													if(i==col+1&&j==row-1) // 대각선 
														dotList[j].get(i).setBpressed(false);
												}
											
										}
										
										else if (col==0) // row: 1~4일 때 && col 가 0일 때
										{	
											for(int i=0;i<6;i++)
												for(int j=0;j<6;j++)
												{
													if(j>row+1)
														dotList[j].get(i).setBpressed(false);
													if(i>col+1)
														dotList[j].get(i).setBpressed(false);
													if(j<row-1)
														dotList[j].get(i).setBpressed(false);
													if(j==row-1&&i==col+1)
														dotList[j].get(i).setBpressed(false);
													if(j==row+1&&i==col+1)
														dotList[j].get(i).setBpressed(false);
												}
											
											
											
										}
									
										else if (col==5)//  row: 1~4일 때 && col 가 5일 때
										{
											for(int i=0;i<6;i++)
												for(int j=0;j<6;j++)
												{
													if(j>row+1)
														dotList[j].get(i).setBpressed(false);
													if(j<row-1)
														dotList[j].get(i).setBpressed(false);
													
													if(i<col-1)
														dotList[j].get(i).setBpressed(false);
													if(j==row+1&&i==col-1)
														dotList[j].get(i).setBpressed(false);
													if(j==row-1&&i==col-1)
														dotList[j].get(i).setBpressed(false);
												}
											
											
										}
				}
		else if( row ==0)// i=0
									{
										if(col>0&&col<5) // row :0일 때 && col : 1~4일 떄 
										{
										for(int i=0;i<6;i++)
												for(int j=0;j<6;j++)
												{
													if(j>row+1)
														dotList[j].get(i).setBpressed(false);
												
													if(i>col+1)
														dotList[j].get(i).setBpressed(false);
													if(i<col-1)
														dotList[j].get(i).setBpressed(false);
													if(j==row+1&&i==col-1)
														dotList[j].get(i).setBpressed(false);
													if(j==row+1&&i==col+1)
														dotList[j].get(i).setBpressed(false);
												}
											
									
										}
										else if(col==0) // row=0 && col =0
										{
											for(int i=0;i<6;i++)
												for(int j=0;j<6;j++)
												{
													if(j>row+1)
														dotList[j].get(i).setBpressed(false);
												
													if(i>col+1)
														dotList[j].get(i).setBpressed(false);
													if(j==row+1&&i==col+1)
														dotList[j].get(i).setBpressed(false);
													
												}
											
									
											
										}
										else if(col==5) // row=0 && col=5
										{
											for(int i=0;i<6;i++)
												for(int j=0;j<6;j++)
												{
													if(j>row+1)
														dotList[j].get(i).setBpressed(false);
												
													
													if(i<col-1)
														dotList[j].get(i).setBpressed(false);
													if(j==row+1&&i==col-1)
														dotList[j].get(i).setBpressed(false);
												}
											
										}
									}	
									
		else if(row==5)
									{
										if( col>0&&col<5){  //row : 5 && col= 1~4일 때 
										for(int i=0;i<6;i++)
												for(int j=0;j<6;j++)
												{
													
													if(j<row-1)
														dotList[j].get(i).setBpressed(false);
													if(i>col+1)
														dotList[j].get(i).setBpressed(false);
													if(i<col-1)
														dotList[j].get(i).setBpressed(false);
													if(j==row-1&&i==col+1)
														dotList[j].get(i).setBpressed(false);
													if(j==row-1&&i==col-1)
														dotList[j].get(i).setBpressed(false);
												}
										}
										else if(col==0) // row =5 && col=0
										{
										for(int i=0;i<6;i++)
												for(int j=0;j<6;j++)
												{
													
													if(j<row-1)
														dotList[j].get(i).setBpressed(false);
													if(i>col+1)
														dotList[j].get(i).setBpressed(false);
													if(j==row-1&&i==col+1)
														dotList[j].get(i).setBpressed(false);
													
												}
											
											
										}
										else if(col==5) // row=5 && col=5
										{
											for(int i=0;i<6;i++)
												for(int j=0;j<6;j++)
												{
												
													if(j<row-1)
														dotList[j].get(i).setBpressed(false);
													
													if(i<col-1)
														dotList[j].get(i).setBpressed(false);
													if(j==row-1&&i==col-1)
														dotList[j].get(i).setBpressed(false);
												}
											
											
										}
										
									}
							dotList[row].get(col).setBpressed(false); // 눌린 점에 대해서도 

	}
	public void uncheckMoved() //released했을때 다시 모든점을 누를수 있도록 눌린점을 초기화 합니다.
	{
		for(int i=0;i<6;i++) 
		{
			for(int j=0;j<6;j++)
			{
			
					dotList[i].get(j).setBpressed(true);
					dotList[i].get(j).setPressed(DotConstants.UNPRESSED);
			}
		}
		count=0;
		
	}
	public void resetBp(int row,int col)
	{
		for(int i=0;i<6;i++) 
		{
			for(int j=0;j<6;j++)
			{
				if(dotList[row].get(col).getDotColor()==dotList[i].get(j).getDotColor() )
					dotList[i].get(j).setBpressed(true);
				
			}
		}
	}
	
	
	public void addJudge(int x,int y,int color)  //눌린 점의 정보를 담습니다.
	{
		
		judgeArray[count][0]=y;
		judgeArray[count][1]=x;
		judgeArray[count][2]=color;
		System.out.printf("행: %d 열: %d 색: %d\n",judgeArray[count][0],judgeArray[count][1],judgeArray[count][2]);
		count++;
		
	
	}
	public void resetJudge()
	{

		for(int i=0;i<36;i++)
		{
			for(int j=0;j<3;j++)
				judgeArray[i][j]=-1;
		}
		count=0;
	}

	public Image getDotImg(int i, int j)//이미지를 반환하는 메소드
	{
		return dotList[i].get(j).getDotImg();
	}
	public void setDotColor(int i,int j,int color) { dotList[i].get(j).setDotColor(color);} // 점의 색을 설정함.


	public int getDotColor(int i, int j)//점 색을 반환한는 메소드
	{
		return dotList[i].get(j).getDotColor();
	}
	public int getDotX(int i, int j)//점 x좌표를 반환하는 메소드
	{
		return dotList[i].get(j).getDotX();
	}

	public int getDotY(int i, int j)//점의 y 좌표를 반환하는 메소드
	{
		return dotList[i].get(j).getDotY();
	}
	public void setPressed(int i, int j, int k) {dotList[i].get(j).setPressed(k);}  // k 를 전달 해서  변수 pPressed(0:눌리지 않음,
																					// 1: 눌림 ) 
	public int getPressed(int i,int j){return dotList[i].get(j).getPressed();}  //  점이 눌렸는지 안눌렸는지 검사하는 메소드
	public boolean getCheckMoved(int i, int j){ return dotList[i].get(j).getBpressed();} // 이동 가능 한지 검사하는 메소드
	
	public void removeDot() // 점을 삭제합니다. 
	{
		int row;
		int col;
		if(count>1){
		for(int i=0;i<count;i++)
			{
				col=judgeArray[i][0];
				row=judgeArray[i][1];
				dotList[row].get(col).setDotColor(6);
				
				
			}//for
		}//if
		
		
	}
	
	public void setDelArray(){ // 없어진 점의 수를 셉니다.
		for(int i=0;i<6;i++)
		{
			delCount=0;
			for(int j=0;j<6;j++)
			{
				if(dotList[i].get(j).getDotColor()==DotConstants.REMOVED)
				{
					delCount++;
					GameScreen.score++; //지워지는 점만큼 점수 증가
				}
			}
			delArray[i]=delCount;
		}
	}//setDelArray
	
	public void restruct(){ // 삭제 된 점 위에 있는 점을 밑으로 내리고, 삭제된 만큼 점을 새로 생성합니다. 
		int k=4;
		for(int i=0;i<6;i++)
		{
			
			for(int j=5;j>0;j--)
			{
				k=j-1;
				while(k>=0)
				{
					if(dotList[i].get(j).getDotColor()==6)
					{
						if(dotList[i].get(k).getDotColor()!=6)
						{
							dotList[i].get(j).setDotColor(dotList[i].get(k).getDotColor());
							dotList[i].get(k).setDotColor(DotConstants.REMOVED);
							dotList[i].get(j-1).setDotColor(DotConstants.REMOVED);
							
							break;
						}
						else{ k--;
						}
					}
					else{ break;}
				}	
			}
			for(int l=0;l<delArray[i];l++)
			{
				dotList[i].set(l,new Dot(i,l));
			}
		}
	}//restruct
	
	public int getCount(){ return count;} // 누른 점의 수 반환
	
	
	public void Item1(int i,int j,int color){   //Item1 사용 시 아이템 동작 
		
		for(int a=0;a<6;a++)
			for(int b=0;b<6;b++)
			{
				
				if(dotList[a].get(b).getDotColor()==color)
				{
					dotList[a].get(b).setDotColor(DotConstants.REMOVED);
				}
			}
		
		
	}
	public boolean judgeCheck()     // 눌린 점을 저장하고 있는 judgeArray에 
									// 같은 위치의 점이 한번 더 저장되었는지 확인합니다.
									// (사각형이 만들어지는지 판단하는 메소드) 

	{
		for(int i=0;i<count-1;i++)
		{
			for(int j=i+1;j<count;j++)
			{
				if(judgeArray[i][0]==judgeArray[j][0]&&judgeArray[i][1]==judgeArray[j][1])
					return true;
					
			}
		}
		return false;
	}
	public int recentRow()// judgeArray(눌린 점에 대한 정보)의 가장 최근에 들어간 점의 행값 
	{
		return judgeArray[count-2][1];
	}
	public int recentCol()// judgeArray(눌린 점에 대한 정보)의 가장 최근에 들어간 점의 열값  
	{

		return judgeArray[count-2][0];
	}
}
