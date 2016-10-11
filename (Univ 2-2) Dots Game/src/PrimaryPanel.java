//�⸻��� �ɹ��� - �ּ����� ���� �ޱ�!!!!!!!!!!
import java.awt.*;

import javax.swing.*;

import java.awt.event.*;



public class PrimaryPanel extends JPanel {	//JPanel�� ��� ���� UserDefined class
	//data
	private JPanel menuPanel, optionPanel;	//menu�κа� option�κ��� ������ Panel����
	private JButton[] btnMenu;				//��ư�� ������ ����ϱ����� ��ü �迭�� ����
	private MenuMouseListener menuMouseL;	//���콺������ ��ü ����
	
	private JButton btnColorSelect;			//�� ���� ��ư ����
	private JLabel lblPointSize;			//���� �׸��� ���� ũ�⸦ ǥ���ϴ� Label����
	private JTextField txtPointSize;		//���� �׸��� ���� ũ�⸦ ������ �� �ִ� TextField����
	private JCheckBox chkFill;				//������ �׸��� ǥ�õǴ� fill CheckBox ����
	private int nPointSize;					//pointũ�� ������ ���� ����
	private boolean bFill;					//fill�� ���É���� ������ ���� ����
	
	private MenuActionListener menuActionL;	//�׼Ǹ����� ��ü ����
	
	private DrawingPanel drawPanel;			//11.26 DrawingPanel Ŭ���� ��ü ����
	
	private Color selectedColor;			//11.26 ���� ���õ� ���� �����ϴ� ���� ����
	
	private JLabel lblColor;
	private JLabel lblMode;
	private JPanel panelColor;
	
	//method
	public PrimaryPanel(){
		this.setPreferredSize(new Dimension(630,630));	//â�� ũ�� ����
		this.setBackground(Color.white);				//�г��� ���� ����
		this.setLayout(null);							//�г��� ���̾ƿ��� ����
		
		menuMouseL = new MenuMouseListener();			//���콺 ������ ����
		menuActionL = new MenuActionListener(); 		//�׼� ������ ����
		
		menuPanel  = new JPanel();						//�޴���ư���� ��ġ��Į �޴��г� ����
		menuPanel.setBackground(Color.white);			//�޴��г� ����� ������� ����
		menuPanel.setBounds(10,10,400,100);				//�޴��г��� ��ġ �� ũ�� ����
		
		//�����̳��� ��迡 UI�� ���� - BorderFactory class�� �ִ�.(swing) 7.9�ܿ�
		menuPanel.setBorder(BorderFactory.createTitledBorder("MENU"));	//BorderFactoryŬ������ static method�� createTitledBorder("");
		menuPanel.setLayout(new GridLayout(2,3));		//�޴��г��� ���� �ƿ��� 2��3��¥�� GridLayout ����
		add(menuPanel);									//���� �гο� �޴��г��� add
		
		
		btnMenu = new JButton[DrawConstants.MENU_NUM];	//�迭�� ����, ����� ���Ŭ�������� ����
		for(int i =0; i<DrawConstants.MENU_NUM; i++){	//�Ŵ��� ������ŭ �ݺ��ϸ�..
			btnMenu[i] = new JButton(DrawConstants.MENU[i]);	//�޴���ư ����
			btnMenu[i].setBackground(DrawConstants.MENU_EXITED_BACKCOLOR);	//�޴���ư ���� ����
			btnMenu[i].setForeground(DrawConstants.MENU_EXITED_FORECOLOR);	//�޴���ư ����� ����
			btnMenu[i].addMouseListener(menuMouseL);	//addMouseListener ���콺������ add
			btnMenu[i].addActionListener(menuActionL);	//addActionListener �׼ȸ����� add
			menuPanel.add(btnMenu[i]);					//������ �޴���ư�� �޴��гο� add
		}
		
		
		
		optionPanel = new JPanel();						//�ɼǰ��� ������Ʈ���� ��ġ��ų �ɼ��г� ����
		optionPanel.setBackground(Color.white);			//�ɼ��г� ���� ������� ����
		optionPanel.setBounds(420, 10, 200, 100);		//�ɼ��г��� ��ġ �� ũ�� ����
		//�����̳��� ��迡 UI�� ���� - BorderFactory class�� �ִ�.(swing) 7.9
		optionPanel.setBorder(BorderFactory.createTitledBorder("OPTION"));
		optionPanel.setLayout(null);					//�ɼ��г��� Layout�� null�� ����
		add(optionPanel);								//�ɼ��г��� PrimaryPanel�� add��Ŵ
		
		btnColorSelect = new JButton("Color Select");	//Color Select ��ư�� ����
		btnColorSelect.setBounds(20, 20, 160, 35);		//Color Select��ư�� ��ġ ����
		btnColorSelect.addMouseListener(menuMouseL);	//Color Select��ư�� ���콺������ add
		btnColorSelect.setBackground(DrawConstants.MENU_EXITED_BACKCOLOR);	//Color Select��ư�� ���� ����
		btnColorSelect.setForeground(DrawConstants.MENU_EXITED_FORECOLOR);	//Color Select��ư�� ����� ����
		btnColorSelect.addActionListener(menuActionL);	//11.26 �׼� ������ add
		optionPanel.add(btnColorSelect);				//�ɼ� �гο� Color Select��ư add
		
		
		lblPointSize = new JLabel("Point Size   :");	//Point Size �� ����
		lblPointSize.setBounds(20, 60, 70, 30);			//Point Size���� ��ġ �� ũ�� ����
		lblPointSize.setVisible(false);					//Point��ư �������� ���̵��� �ϱ� ���� �ϴ� �Ⱥ��̰� ����
		optionPanel.add(lblPointSize);					//�ɼ� �гο� Point Size���� add
		
		nPointSize = 20;								//nPointSize���� �ʱ�ȭ
		
		txtPointSize = new JTextField();				//����Ʈ�� ũ�⸦ �Է¹޴� TextField ������Ʈ ����
		txtPointSize.setBounds(100, 60, 80, 30);		//TextField�� ��ġ �� ũ�� ����
		txtPointSize.setText(""+nPointSize);			//TextField�� ǥ���� ������ nPointSize�� ����
		txtPointSize.setVisible(false);					//Point��ư �������� ���̵��� �ϱ� ���� �ϴ� �Ⱥ��̰� ����
		optionPanel.add(txtPointSize);					//�ɼ� �гο� TextField�� add
		
		bFill = false;						
		
		chkFill = new JCheckBox("FILL");				//Fill������ �����ϴ� CheckBox������Ʈ ����
		chkFill.setBounds(20, 60, 140, 30);				//CheckBox�� ��ġ �� ũ�⼳��
		chkFill.setBackground(Color.white);				//CheckBox�� ���� ����
		chkFill.setHorizontalAlignment(SwingConstants.CENTER);	//CheckBox�� ���� ������ �߾����� ����
		chkFill.setSelected(bFill);						//üũ�ڽ� �ɼ� ����.(üũ �ȵ����� �ʱ�ȭ)	
		chkFill.setVisible(false);						//���簢�� �� ���� �׸����� ���̵��� �ϱ����� �ϴ� �Ⱥ��̰� ����
		optionPanel.add(chkFill);						//�ɼ��гο� CheckBox�� add
		
		//�׸��� �׷��ִ� drawPanel ����
		drawPanel = new DrawingPanel(this);				//11.26  ����Ŭ������ primaryŬ�������� ����Ŭ������ drawing�� �����Ҷ� '��(this)'�� �������ش�
		drawPanel.setBackground(Color.white);			//drawPanel�� ������ ������� ����
		drawPanel.setBounds(15, 140, 600, 480);			//drawPanel�� ��ġ �� ũ�� ����
		add(drawPanel);									//PrimaryPanel�� drawPanel�� add��Ŵ
		
		
		selectedColor = Color.black;					//11.26 selectedColor�� ���������� �ʱ�ȭ		
		
		
		
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
		return Integer.parseInt(txtPointSize.getText());	//String�� txtPointSize�� ���ڸ� ������ �����ϱ����� Intger.pareInt() ���� �޼ҵ带 ���
	}//11.26����Ŭ������ ����Ŭ������ PointSize���� ���� �� �ֵ���(������ ����) get�޼ҵ� �������
	
	
	public Color getSelectedColor(){
		return selectedColor;
	}//11.26����Ŭ������ ����Ŭ������selectedColor���� ���� �� �ֵ���(������ ����) get�޼ҵ� �������
	
	
	//������ Ŭ����
	private class MenuMouseListener implements MouseListener{	//MouseListener�� ������ ������ Ŭ����
		
		public void mouseClicked(MouseEvent arg0) {}			//Clicked �̺�Ʈ �ڵ鷯

		public void mouseEntered(MouseEvent event) {			//Entered �̺�Ʈ �ڵ鷯
			Object obj = event.getSource();						//Object��ü�� obj�� �̺�Ʈ�� �߻��� ��ü�� ����.
			
			if(obj == btnColorSelect){							//�̺�Ʈ�� �߻��� ��ü�� btnColorSelect ������Ʈ �̸�,
				btnColorSelect.setBackground(DrawConstants.MENU_ENTERED_BACKCOLOR);	//btnColorSelect�� ������ ����
				btnColorSelect.setForeground(DrawConstants.MENU_ENTERED_FORECOLOR);	//btnColorSelect�� ������� ����
			}
			else{												//�̺�Ʈ�� �߻��� ��ü�� btnMenu[] �� ���,
				for(int i=0; i<DrawConstants.MENU_NUM; i++){	//Menu�� ���� ��ŭ �ݺ��ϸ�
					if(obj == btnMenu[i]){						//�̺�Ʈ�� �߻��� �޴���ư�� ã��
						btnMenu[i].setBackground(DrawConstants.MENU_ENTERED_BACKCOLOR);	//btnMenu[i]�� ������ ����
						btnMenu[i].setForeground(DrawConstants.MENU_ENTERED_FORECOLOR);	//btnMenu[i]�� ������� ����
						break;									//for���� ���ٰ� � ��ư���� obj�� �ش�Ǵ� ��ư�� ã������ ���̻� ã�� ���� �����Ƿ� break; �ɾ���
					}//if
				}//for
			}
		}//mouseEntered()

		@Override
		public void mouseExited(MouseEvent event) {				//Exited �̺�Ʈ �ڵ鷯
			Object obj = event.getSource();						//�̺�Ʈ�� �߻��� ��ü�� obj�� ����.
			
			if(obj == btnColorSelect){							//obj�� ColorSelect��ư�̸�
				btnColorSelect.setBackground(DrawConstants.MENU_EXITED_BACKCOLOR);	//ColorSelect��ư�� ������ ����
				btnColorSelect.setForeground(DrawConstants.MENU_EXITED_FORECOLOR);	//ColorSelect��ư�� ������� ����
			}
			else{												//�̺�Ʈ�� �߻��� ��ü�� btnMenu[] �� ���,
				for(int i=0; i<DrawConstants.MENU_NUM; i++){	//Menu�� ���� ��ŭ �ݺ��ϸ�
					if(obj == btnMenu[i]){						//�̺�Ʈ�� �߻��� �޴���ư�� ã��
						btnMenu[i].setBackground(DrawConstants.MENU_EXITED_BACKCOLOR);	//btnMenu[i]�� ������ ����
						btnMenu[i].setForeground(DrawConstants.MENU_EXITED_FORECOLOR);	//btnMenu[i]�� ������� ����
						break;									//� ��ư���� �ش� ��ư�� ã������ ���̻� ã�� ���� �����Ƿ� break; �ɾ���
					}//if
				}//for
			}//else
		}

		@Override
		public void mousePressed(MouseEvent event) {}			//Pressed �̺�Ʈ �ڵ鷯

		@Override
		public void mouseReleased(MouseEvent arg0) {}			//Released �̺�Ʈ �ڵ鷯
	}//MouseListener class
	
	
	private class MenuActionListener implements ActionListener	//ActionListener�� ������ ������ Ŭ����
	{
		public void actionPerformed(ActionEvent event){			//actionPerformed �̺�Ʈ �ڵ鷯
			Object obj = event.getSource();						//�̺�Ʈ�� �߻��� ��ü�� obj�� ����
			
			if(obj == btnColorSelect){							//11.26 colorSelect ��ư�� ���ȴ��� �Ǵ�
				selectedColor = JColorChooser.showDialog(drawPanel, "Color Select", selectedColor);	//11.26 ColorChooser ��ȭ���� ����, �Ķ���ͷ� �ش�Ŭ���� ��ü��, ���ڿ���, ���õ� ���� ����!
				panelColor.setBackground(selectedColor);
			}
			else{												//��ư������Ʈ�� ���� ���
				for(int i=0; i<DrawConstants.MENU_NUM; i++)		//���� ��ư�� ã�Ƽ�
				{
					if(obj == btnMenu[i]){
						drawPanel.setDrawMode(i);				//������ ��ư�� ã����, drawMode�� �� ��ư�� ������ �ٲ��ش�. 
						
						switch(i) {								//drawMode���� ���� switch�� ����
						case DrawConstants.POINT:				//drawMode�� POINT�ΰ��,
							chkFill.setVisible(false);				//chkFill������Ʈ�� �Ⱥ��̰� ����
							lblPointSize.setVisible(true);			//lblPointSize������Ʈ�� ���̰� ����
							txtPointSize.setVisible(true);			//txtPointSize������Ʈ�� ���̰� ����
							lblMode.setText("MODE : POINT");
							break;									//switch�� ��������.
						case DrawConstants.LINE:				//drawMode�� LINE�ΰ��,	
							chkFill.setVisible(false);				//chkFill������Ʈ�� �Ⱥ��̰� ����
							lblPointSize.setVisible(false);			//lblPointSize������Ʈ�� �Ⱥ��̰� ����
							txtPointSize.setVisible(false);			//txtPointSize������Ʈ�� �Ⱥ��̰� ����
							lblMode.setText("MODE : LINE");
							break;
						case DrawConstants.OVAL: 				//drawMode�� OVAL�ΰ��� break�� �����Ƿ� ��� �����Ͽ� RECT�� ��� ����,
							chkFill.setVisible(true);				//chkFill������Ʈ�� ���̰� ����			
							lblPointSize.setVisible(false);			//lblPointSize������Ʈ�� �Ⱥ��̰� ����
							txtPointSize.setVisible(false);			//txtPointSize������Ʈ�� �Ⱥ��̰� ����
							lblMode.setText("MODE : OVAL");
							break;
						case DrawConstants.RECT:
							chkFill.setVisible(true);				//chkFill������Ʈ�� ���̰� ����			
							lblPointSize.setVisible(false);			//lblPointSize������Ʈ�� �Ⱥ��̰� ����
							txtPointSize.setVisible(false);			//txtPointSize������Ʈ�� �Ⱥ��̰� ����
							lblMode.setText("MODE : RECT");
							break;
						case DrawConstants.FREE:
							chkFill.setVisible(false);				//chkFill������Ʈ�� �Ⱥ��̰� ����			
							lblPointSize.setVisible(false);			//lblPointSize������Ʈ�� �Ⱥ��̰� ����
							txtPointSize.setVisible(false);			//txtPointSize������Ʈ�� �Ⱥ��̰� ����
							lblMode.setText("MODE : FREE");
							break;
						}//switch
					}//if
				}//for
			}//else
		}//actionPerformed
	}//MenuActionListener class
	
}//private class Style

