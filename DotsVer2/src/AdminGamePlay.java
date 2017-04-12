import java.util.ArrayList;
import java.awt.Image;
import java.awt.Point;

public class AdminGamePlay {
	//data
	private ArrayList<Dot> dotList[];  // Dot ��ü�� ���� �� ArrayList �迭 
	private int judgeArray[][];   // ���� ���� ������ ��� 2���� �迭
	private Point pt;
	private int panelMode;	//ȭ�鿡 ������ �г��� �����ϴ� ����
	private int count;     //���� ���� ���� ���� coun����
	private int erasedRow; // ������ �� �� 
	private int reasedCol;  // ������ �� �� 
	
	//11.28
	private int delCount ;//�� ����Ʈ ���� ���� �� ī��Ʈ 
	private int delArray[];// �帮��Ʈ���� ���� ���� �� ����
	//method
	
	//������
	public AdminGamePlay(){
		count =0;
		delCount=0;
		dotList = new ArrayList[7];
		delArray=new int[6];  // ArrayList �迭 ����
		for(int i=0; i<6; i++){   // ��ü ���� (6 X 6 )
			dotList[i]= new ArrayList<Dot>();
			for(int j=0;j<6;j++){
				dotList[i].add(new Dot(i,j));
			}
		}
	
		judgeArray= new int[36][3];   // 1��° ���� ���� ���� �࿡ ���� ����, 2��° ���� ���� ���� ���� ���� ����,
		for(int i=0;i<36;i++)  		  // 3��° ���� ���� ���� �� ������ ����ϴ�.
		{
			for(int j=0;j<3;j++)
				judgeArray[i][j]=-1;   // �ʱ�ȭ �����̹Ƿ� ���� �� ���� ���� ���� �մϴ�.
		}
	} // AdminGamePlay()
	
	
	//���� ���� ���� ���̰� ��,��,��,���� ���� ���� �� �ֵ��� �մϴ�.
	public void checkMoved(int row,int col)  //x �� event.getX()/68 �� ���� ���� 
	{
		
			for(int i=0;i<6;i++) 
				{
					for(int j=0;j<6;j++)
						{
							if(dotList[row].get(col).getDotColor()!=dotList[i].get(j).getDotColor())
									dotList[i].get(j).setBpressed(false);
						}
				} //���� ���� �ƴѰ� �ȴ����� �ϱ�
		
		if(row>0&&row<5)  // row : 1~4�� ��  
			{
										if(col>0&&col<5)  // row :1~4�� �� && col : 1~4�� �� 
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
													if(i==col-1&&j==row+1) // �밢�� 
														dotList[j].get(i).setBpressed(false);
													if(i==col+1&&j==row+1) // �밢��
														dotList[j].get(i).setBpressed(false);
													if(i==col+1&&j==row-1) // �밢�� 
														dotList[j].get(i).setBpressed(false);
												}
											
										}
										
										else if (col==0) // row: 1~4�� �� && col �� 0�� ��
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
									
										else if (col==5)//  row: 1~4�� �� && col �� 5�� ��
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
										if(col>0&&col<5) // row :0�� �� && col : 1~4�� �� 
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
										if( col>0&&col<5){  //row : 5 && col= 1~4�� �� 
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
							dotList[row].get(col).setBpressed(false); // ���� ���� ���ؼ��� 

	}
	public void uncheckMoved() //released������ �ٽ� ������� ������ �ֵ��� �������� �ʱ�ȭ �մϴ�.
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
	
	
	public void addJudge(int x,int y,int color)  //���� ���� ������ ����ϴ�.
	{
		
		judgeArray[count][0]=y;
		judgeArray[count][1]=x;
		judgeArray[count][2]=color;
		System.out.printf("��: %d ��: %d ��: %d\n",judgeArray[count][0],judgeArray[count][1],judgeArray[count][2]);
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

	public Image getDotImg(int i, int j)//�̹����� ��ȯ�ϴ� �޼ҵ�
	{
		return dotList[i].get(j).getDotImg();
	}
	public void setDotColor(int i,int j,int color) { dotList[i].get(j).setDotColor(color);} // ���� ���� ������.


	public int getDotColor(int i, int j)//�� ���� ��ȯ�Ѵ� �޼ҵ�
	{
		return dotList[i].get(j).getDotColor();
	}
	public int getDotX(int i, int j)//�� x��ǥ�� ��ȯ�ϴ� �޼ҵ�
	{
		return dotList[i].get(j).getDotX();
	}

	public int getDotY(int i, int j)//���� y ��ǥ�� ��ȯ�ϴ� �޼ҵ�
	{
		return dotList[i].get(j).getDotY();
	}
	public void setPressed(int i, int j, int k) {dotList[i].get(j).setPressed(k);}  // k �� ���� �ؼ�  ���� pPressed(0:������ ����,
																					// 1: ���� ) 
	public int getPressed(int i,int j){return dotList[i].get(j).getPressed();}  //  ���� ���ȴ��� �ȴ��ȴ��� �˻��ϴ� �޼ҵ�
	public boolean getCheckMoved(int i, int j){ return dotList[i].get(j).getBpressed();} // �̵� ���� ���� �˻��ϴ� �޼ҵ�
	
	public void removeDot() // ���� �����մϴ�. 
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
	
	public void setDelArray(){ // ������ ���� ���� ���ϴ�.
		for(int i=0;i<6;i++)
		{
			delCount=0;
			for(int j=0;j<6;j++)
			{
				if(dotList[i].get(j).getDotColor()==DotConstants.REMOVED)
				{
					delCount++;
					GameScreen.score++; //�������� ����ŭ ���� ����
				}
			}
			delArray[i]=delCount;
		}
	}//setDelArray
	
	public void restruct(){ // ���� �� �� ���� �ִ� ���� ������ ������, ������ ��ŭ ���� ���� �����մϴ�. 
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
	
	public int getCount(){ return count;} // ���� ���� �� ��ȯ
	
	
	public void Item1(int i,int j,int color){   //Item1 ��� �� ������ ���� 
		
		for(int a=0;a<6;a++)
			for(int b=0;b<6;b++)
			{
				
				if(dotList[a].get(b).getDotColor()==color)
				{
					dotList[a].get(b).setDotColor(DotConstants.REMOVED);
				}
			}
		
		
	}
	public boolean judgeCheck()     // ���� ���� �����ϰ� �ִ� judgeArray�� 
									// ���� ��ġ�� ���� �ѹ� �� ����Ǿ����� Ȯ���մϴ�.
									// (�簢���� ����������� �Ǵ��ϴ� �޼ҵ�) 

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
	public int recentRow()// judgeArray(���� ���� ���� ����)�� ���� �ֱٿ� �� ���� �ప 
	{
		return judgeArray[count-2][1];
	}
	public int recentCol()// judgeArray(���� ���� ���� ����)�� ���� �ֱٿ� �� ���� ����  
	{

		return judgeArray[count-2][0];
	}
}
