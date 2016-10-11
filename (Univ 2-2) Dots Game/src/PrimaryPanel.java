//기말고사 셤문제 - 주석으로 설명 달기!!!!!!!!!!
import java.awt.*;

import javax.swing.*;

import java.awt.event.*;



public class PrimaryPanel extends JPanel {	//JPanel을 상속 받은 UserDefined class
	//data
	private JPanel menuPanel, optionPanel;	//menu부분과 option부분을 구성할 Panel선언
	private JButton[] btnMenu;				//버튼을 여러개 사용하기위해 객체 배열로 선언
	private MenuMouseListener menuMouseL;	//마우스리스너 객체 선언
	
	private JButton btnColorSelect;			//색 선택 버튼 선언
	private JLabel lblPointSize;			//점을 그릴때 점의 크기를 표시하는 Label선언
	private JTextField txtPointSize;		//점을 그릴때 점의 크기를 설정할 수 있는 TextField선언
	private JCheckBox chkFill;				//도형을 그릴때 표시되는 fill CheckBox 선언
	private int nPointSize;					//point크기 저장할 변수 선언
	private boolean bFill;					//fill이 선택됬는지 저장할 변수 선언
	
	private MenuActionListener menuActionL;	//액션리스너 객체 선언
	
	private DrawingPanel drawPanel;			//11.26 DrawingPanel 클래스 객체 선언
	
	private Color selectedColor;			//11.26 현재 선택된 색을 저장하는 변수 선언
	
	private JLabel lblColor;
	private JLabel lblMode;
	private JPanel panelColor;
	
	//method
	public PrimaryPanel(){
		this.setPreferredSize(new Dimension(630,630));	//창의 크기 설정
		this.setBackground(Color.white);				//패널의 배경색 설정
		this.setLayout(null);							//패널의 레이아웃을 없앰
		
		menuMouseL = new MenuMouseListener();			//마우스 리스너 생성
		menuActionL = new MenuActionListener(); 		//액션 리스너 생성
		
		menuPanel  = new JPanel();						//메뉴버튼들을 배치시칼 메뉴패널 생성
		menuPanel.setBackground(Color.white);			//메뉴패널 배경을 흰색으로 설정
		menuPanel.setBounds(10,10,400,100);				//메뉴패널의 위치 및 크기 설정
		
		//컨테이너의 경계에 UI를 제공 - BorderFactory class가 있다.(swing) 7.9단원
		menuPanel.setBorder(BorderFactory.createTitledBorder("MENU"));	//BorderFactory클래스의 static method인 createTitledBorder("");
		menuPanel.setLayout(new GridLayout(2,3));		//메뉴패널의 레이 아웃을 2행3열짜리 GridLayout 설정
		add(menuPanel);									//현재 패널에 메뉴패널을 add
		
		
		btnMenu = new JButton[DrawConstants.MENU_NUM];	//배열을 생성, 상수는 상수클래스에서 관리
		for(int i =0; i<DrawConstants.MENU_NUM; i++){	//매뉴의 갯수만큼 반복하며..
			btnMenu[i] = new JButton(DrawConstants.MENU[i]);	//메뉴버튼 생성
			btnMenu[i].setBackground(DrawConstants.MENU_EXITED_BACKCOLOR);	//메뉴버튼 배경색 설정
			btnMenu[i].setForeground(DrawConstants.MENU_EXITED_FORECOLOR);	//메뉴버튼 전경색 설정
			btnMenu[i].addMouseListener(menuMouseL);	//addMouseListener 마우스리스너 add
			btnMenu[i].addActionListener(menuActionL);	//addActionListener 액셜리스너 add
			menuPanel.add(btnMenu[i]);					//생성한 메뉴버튼을 메뉴패널에 add
		}
		
		
		
		optionPanel = new JPanel();						//옵션관련 컴포넌트들을 배치시킬 옵션패널 생성
		optionPanel.setBackground(Color.white);			//옵션패널 색을 흰색으로 설정
		optionPanel.setBounds(420, 10, 200, 100);		//옵션패널의 위치 및 크기 설정
		//컨테이너의 경계에 UI를 제공 - BorderFactory class가 있다.(swing) 7.9
		optionPanel.setBorder(BorderFactory.createTitledBorder("OPTION"));
		optionPanel.setLayout(null);					//옵션패널의 Layout을 null로 설정
		add(optionPanel);								//옵셜패널을 PrimaryPanel에 add시킴
		
		btnColorSelect = new JButton("Color Select");	//Color Select 버튼을 생성
		btnColorSelect.setBounds(20, 20, 160, 35);		//Color Select버튼의 위치 설정
		btnColorSelect.addMouseListener(menuMouseL);	//Color Select버튼에 마우스리스너 add
		btnColorSelect.setBackground(DrawConstants.MENU_EXITED_BACKCOLOR);	//Color Select버튼의 배경색 설정
		btnColorSelect.setForeground(DrawConstants.MENU_EXITED_FORECOLOR);	//Color Select버튼의 전경색 설정
		btnColorSelect.addActionListener(menuActionL);	//11.26 액션 리스너 add
		optionPanel.add(btnColorSelect);				//옵션 패널에 Color Select버튼 add
		
		
		lblPointSize = new JLabel("Point Size   :");	//Point Size 라벨 생성
		lblPointSize.setBounds(20, 60, 70, 30);			//Point Size라벨의 위치 및 크기 설정
		lblPointSize.setVisible(false);					//Point버튼 누를때만 보이도록 하기 위해 일단 안보이게 설정
		optionPanel.add(lblPointSize);					//옵션 패널에 Point Size라벨을 add
		
		nPointSize = 20;								//nPointSize변수 초기화
		
		txtPointSize = new JTextField();				//포인트의 크기를 입력받는 TextField 컴포넌트 생성
		txtPointSize.setBounds(100, 60, 80, 30);		//TextField의 위치 및 크기 설정
		txtPointSize.setText(""+nPointSize);			//TextField가 표시할 값으로 nPointSize를 설정
		txtPointSize.setVisible(false);					//Point버튼 누를때만 보이도록 하기 위해 일단 안보이게 설정
		optionPanel.add(txtPointSize);					//옵션 패널에 TextField를 add
		
		bFill = false;						
		
		chkFill = new JCheckBox("FILL");				//Fill정보를 선택하는 CheckBox컴포넌트 생성
		chkFill.setBounds(20, 60, 140, 30);				//CheckBox의 위치 및 크기설정
		chkFill.setBackground(Color.white);				//CheckBox의 배경색 설정
		chkFill.setHorizontalAlignment(SwingConstants.CENTER);	//CheckBox의 수평 정렬을 중앙으로 설정
		chkFill.setSelected(bFill);						//체크박스 옵션 설정.(체크 안됨으로 초기화)	
		chkFill.setVisible(false);						//직사각형 및 원을 그릴때만 보이도록 하기위해 일단 안보이게 설정
		optionPanel.add(chkFill);						//옵션패널에 CheckBox를 add
		
		//그림을 그려주는 drawPanel 설정
		drawPanel = new DrawingPanel(this);				//11.26  상위클래스인 primary클래스에서 하위클래스인 drawing을 생성할때 '나(this)'를 전달해준다
		drawPanel.setBackground(Color.white);			//drawPanel의 배경색을 흰색으로 설정
		drawPanel.setBounds(15, 140, 600, 480);			//drawPanel의 위치 및 크기 설정
		add(drawPanel);									//PrimaryPanel에 drawPanel을 add시킴
		
		
		selectedColor = Color.black;					//11.26 selectedColor를 검정색으로 초기화		
		
		
		
		lblMode = new JLabel("MODE : NONE");
		lblMode.setBounds(30, 120, 100, 10);
		lblMode.setVisible(true);
		this.add(lblMode);
		
		lblColor = new JLabel("COLOR : ");
		lblColor.setBounds(150, 120, 50, 10);
		lblColor.setVisible(true);
		this.add(lblColor);
		
		panelColor = new JPanel();
		panelColor.setBounds(205, 120, 40, 10);
		panelColor.setBackground(Color.black);
		this.add(panelColor);
	}//PrimaryPanel()
	
	public int getPointSize(){
		return Integer.parseInt(txtPointSize.getText());	//String인 txtPointSize의 숫자를 정수로 리턴하기위해 Intger.pareInt() 정적 메소드를 사용
	}//11.26하위클래스가 상위클래스의 PointSize값을 받을 수 있도록(업콜을 위한) get메소드 만들어줌
	
	
	public Color getSelectedColor(){
		return selectedColor;
	}//11.26하위클래스가 상위클래스의selectedColor값을 받을 수 있도록(업콜을 위한) get메소드 만들어줌
	
	
	//리스너 클래스
	private class MenuMouseListener implements MouseListener{	//MouseListener를 구현한 리스너 클래스
		
		public void mouseClicked(MouseEvent arg0) {}			//Clicked 이벤트 핸들러

		public void mouseEntered(MouseEvent event) {			//Entered 이벤트 핸들러
			Object obj = event.getSource();						//Object객체인 obj에 이벤트가 발생한 객체를 저장.
			
			if(obj == btnColorSelect){							//이벤트가 발생한 객체가 btnColorSelect 컴포넌트 이면,
				btnColorSelect.setBackground(DrawConstants.MENU_ENTERED_BACKCOLOR);	//btnColorSelect의 배경색을 변경
				btnColorSelect.setForeground(DrawConstants.MENU_ENTERED_FORECOLOR);	//btnColorSelect의 전경색을 변경
			}
			else{												//이벤트가 발생한 객체가 btnMenu[] 일 경우,
				for(int i=0; i<DrawConstants.MENU_NUM; i++){	//Menu의 갯수 만큼 반복하며
					if(obj == btnMenu[i]){						//이벤트가 발생한 메뉴버튼을 찾아
						btnMenu[i].setBackground(DrawConstants.MENU_ENTERED_BACKCOLOR);	//btnMenu[i]의 배경색을 변경
						btnMenu[i].setForeground(DrawConstants.MENU_ENTERED_FORECOLOR);	//btnMenu[i]의 전경색을 변경
						break;									//for문이 돌다가 어떤 버튼에서 obj에 해당되는 버튼을 찾았으면 더이상 찾을 것이 없으므로 break; 걸어줌
					}//if
				}//for
			}
		}//mouseEntered()

		@Override
		public void mouseExited(MouseEvent event) {				//Exited 이벤트 핸들러
			Object obj = event.getSource();						//이벤트가 발생한 객체를 obj에 저장.
			
			if(obj == btnColorSelect){							//obj가 ColorSelect버튼이면
				btnColorSelect.setBackground(DrawConstants.MENU_EXITED_BACKCOLOR);	//ColorSelect버튼의 배경색을 변경
				btnColorSelect.setForeground(DrawConstants.MENU_EXITED_FORECOLOR);	//ColorSelect버튼의 전경색을 변경
			}
			else{												//이벤트가 발생한 객체가 btnMenu[] 일 경우,
				for(int i=0; i<DrawConstants.MENU_NUM; i++){	//Menu의 갯수 만큼 반복하며
					if(obj == btnMenu[i]){						//이벤트가 발생한 메뉴버튼을 찾아
						btnMenu[i].setBackground(DrawConstants.MENU_EXITED_BACKCOLOR);	//btnMenu[i]의 배경색을 변경
						btnMenu[i].setForeground(DrawConstants.MENU_EXITED_FORECOLOR);	//btnMenu[i]의 전경색을 변경
						break;									//어떤 버튼에서 해당 버튼을 찾았으면 더이상 찾을 것이 없으므로 break; 걸어줌
					}//if
				}//for
			}//else
		}

		@Override
		public void mousePressed(MouseEvent event) {}			//Pressed 이벤트 핸들러

		@Override
		public void mouseReleased(MouseEvent arg0) {}			//Released 이벤트 핸들러
	}//MouseListener class
	
	
	private class MenuActionListener implements ActionListener	//ActionListener로 구현한 리스너 클래스
	{
		public void actionPerformed(ActionEvent event){			//actionPerformed 이벤트 핸들러
			Object obj = event.getSource();						//이벤트가 발생한 객체를 obj에 저장
			
			if(obj == btnColorSelect){							//11.26 colorSelect 버튼이 눌렸는지 판단
				selectedColor = JColorChooser.showDialog(drawPanel, "Color Select", selectedColor);	//11.26 ColorChooser 대화상자 띄우기, 파라미터로 해당클래스 객체와, 문자열과, 선택된 색을 전달!
				panelColor.setBackground(selectedColor);
			}
			else{												//버튼컴포넌트가 눌린 경우
				for(int i=0; i<DrawConstants.MENU_NUM; i++)		//눌린 버튼을 찾아서
				{
					if(obj == btnMenu[i]){
						drawPanel.setDrawMode(i);				//눌러진 버튼을 찾으면, drawMode를 그 버튼의 값으로 바꿔준다. 
						
						switch(i) {								//drawMode값에 따라 switch문 실행
						case DrawConstants.POINT:				//drawMode가 POINT인경우,
							chkFill.setVisible(false);				//chkFill컴포넌트는 안보이게 설정
							lblPointSize.setVisible(true);			//lblPointSize컴포넌트는 보이게 설정
							txtPointSize.setVisible(true);			//txtPointSize컴포넌트는 보이게 설정
							lblMode.setText("MODE : POINT");
							break;									//switch문 빠져나감.
						case DrawConstants.LINE:				//drawMode가 LINE인경우,	
							chkFill.setVisible(false);				//chkFill컴포넌트는 안보이게 설정
							lblPointSize.setVisible(false);			//lblPointSize컴포넌트는 안보이게 설정
							txtPointSize.setVisible(false);			//txtPointSize컴포넌트는 안보이게 설정
							lblMode.setText("MODE : LINE");
							break;
						case DrawConstants.OVAL: 				//drawMode가 OVAL인경우와 break가 없으므로 계속 실행하여 RECT인 경우 까지,
							chkFill.setVisible(true);				//chkFill컴포넌트는 보이게 설정			
							lblPointSize.setVisible(false);			//lblPointSize컴포넌트는 안보이게 설정
							txtPointSize.setVisible(false);			//txtPointSize컴포넌트는 안보이게 설정
							lblMode.setText("MODE : OVAL");
							break;
						case DrawConstants.RECT:
							chkFill.setVisible(true);				//chkFill컴포넌트는 보이게 설정			
							lblPointSize.setVisible(false);			//lblPointSize컴포넌트는 안보이게 설정
							txtPointSize.setVisible(false);			//txtPointSize컴포넌트는 안보이게 설정
							lblMode.setText("MODE : RECT");
							break;
						case DrawConstants.FREE:
							chkFill.setVisible(false);				//chkFill컴포넌트는 안보이게 설정			
							lblPointSize.setVisible(false);			//lblPointSize컴포넌트는 안보이게 설정
							txtPointSize.setVisible(false);			//txtPointSize컴포넌트는 안보이게 설정
							lblMode.setText("MODE : FREE");
							break;
						}//switch
					}//if
				}//for
			}//else
		}//actionPerformed
	}//MenuActionListener class
	
}//private class Style

