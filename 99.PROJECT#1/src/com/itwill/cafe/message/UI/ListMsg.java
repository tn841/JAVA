package com.itwill.cafe.message.UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import com.itwill.cafe.message.MessageService;
import com.itwill.cafe.message.MessageVO;
import com.itwill.cafe.message.model.MessageTableModel;

public class ListMsg extends JDialog {
	private final JPanel contentPanel = new JPanel();
	private MessageService msgService = new MessageService();
	private Vector<String> columnNames;
	private JTable table;
	private MessageTableModel msgTableModel;
	private ArrayList<String> colNameList;
	
	
	
	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}
	private MessageVO msgVO;
	private JScrollPane scrollPane;
	public MessageVO getMsgVO() {
		return msgVO;
	}

	public void setMsgVO(MessageVO msgVO) {
		this.msgVO = msgVO;
	}

	/**
	 * Launch the application.
	 * @throws Exception 
	 */
	public static void main(String[] args)  {
		try {
			ListMsg dialog = new ListMsg();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void listRefreash(){
		
	}
	/**
	 * Create the dialog.
	 * @throws Exception 
	 */
	public ListMsg() throws Exception {
		setResizable(false);
		setTitle("\uCABD\uC9C0\uD568");
		
		setBounds(100, 100, 379, 480);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 362, 396);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 24, 311, 350);
		contentPanel.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int no =Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0)+"");
				try {
					msgVO = msgService.showMessage(no);
					
					msgService.updateChecked(msgVO);//클릭한 메시지를 열람한 것으로 설정
					
					ReceiveMsg receiveMsg =new ReceiveMsg(ListMsg.this);
					receiveMsg.setModal(true);
					receiveMsg.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					//findIdPwDialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
					receiveMsg.setVisible(true);
					
					/*
					 * 갱신
					 */
					reLoad();
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		
		/*
		 * TableModel 생성 //해줘야 갱신이 된다
		 */
		
		//
		colNameList = new ArrayList<String>();
		colNameList.add("No");
		colNameList.add("보낸사람");
		colNameList.add("제목");
		colNameList.add("받는사람");
		colNameList.add("열람여부");
		
		msgTableModel = new MessageTableModel(colNameList);	//직접 정의한 외부 클래스를 통해 모델 객체를 가져온다.
		table.setModel(msgTableModel.getDtModel());	//위에서 만든 모델 객체를 가지고 table에 적용한다.

		scrollPane.setViewportView(table);
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 396, 362, 33);
			getContentPane().add(buttonPane);
			buttonPane.setLayout(null);
			{
				JButton newMsgButton = new JButton("\uC791\uC131");
				newMsgButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						SendMsg sendMsg;
						try {
							sendMsg = new SendMsg();
							sendMsg.setModal(true);
							sendMsg.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
							sendMsg.setVisible(true);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});

				newMsgButton.setBounds(269, 5, 81, 23);
				newMsgButton.setActionCommand("Cancel");
				buttonPane.add(newMsgButton);
			}
		}
	}
	
	public void reLoad() throws Exception{
		colNameList = new ArrayList<String>();
		colNameList.add("번호");
		colNameList.add("보낸사람");
		colNameList.add("제목");
		colNameList.add("받는사람");
		colNameList.add("열람여부");
		
		msgTableModel = new MessageTableModel(colNameList);	//직접 정의한 외부 클래스를 통해 모델 객체를 가져온다.
		table.setModel(msgTableModel.getDtModel());	//위에서 만든 모델 객체를 가지고 table에 적용한다.

		scrollPane.setViewportView(table);
	}
}
