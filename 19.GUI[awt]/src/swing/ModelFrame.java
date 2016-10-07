package swing;

import java.awt.EventQueue;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class ModelFrame extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private ArrayList<Account> accountList;
	private DefaultTableModel tableModel;
	private Vector<String> colNames;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModelFrame frame = new ModelFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private void selelctAccountList(){
		/*
		 * Account List 얻기
		 */
		Account acc1 = new Account("1111", "BONG", 33000, 0.02);
		Account acc2 = new Account("2222", "AONG", 23000, 0.03);
		Account acc3 = new Account("3333", "DONG", 33000, 0.04);
		Account acc4 = new Account("4444", "FONG", 99000, 0.12);
		Account acc5 = new Account("5555", "HONG", 78000, 0.08);
		Account acc6 = new Account("6666", "CONG", 33000, 0.03);
		Account acc7 = new Account("7777", "DONG", 33000, 0.28);
		Account acc8 = new Account("8888", "ZONG", 33000, 0.68);
		Account acc9 = new Account("9999", "OONG", 22000, 0.88);
		
		accountList=new ArrayList<Account>();
		accountList.add(acc1);
		accountList.add(acc2);
		accountList.add(acc3);
		accountList.add(acc4);
		accountList.add(acc5);
		accountList.add(acc6);
		accountList.add(acc7);
		accountList.add(acc8);
		accountList.add(acc9);
		
		/*
		 * 열제목 구성
		 */
		colNames = new Vector<String>();
		colNames.add("번호");
		colNames.add("이름");
		colNames.add("잔고");
		colNames.add("이율");
		
		/*
		 * Data(Vector) 구성
		 */
		Vector<Vector<String>> data = new Vector<Vector<String>>();
		
		for (Account  account : accountList) {
			Vector<String> rowVector = new Vector<String>();
			rowVector.add(account.getNo());
			rowVector.add(account.getOwner());
			rowVector.add(Integer.toString(account.getBalance()));
			rowVector.add(account.getIyul()+"");
			
			data.add(rowVector);
		}
		
		/*
		 * Table Model 생성
		 */
		tableModel = new DefaultTableModel(data,colNames);
		
	}

	/**
	 * Create the frame.
	 */
	public ModelFrame() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 509, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(14, 12, 139, 231);
		contentPane.add(scrollPane);
		
		
		selelctAccountList();
		table = new JTable();
		table.setModel(tableModel);	//selelctAccountList()에서 table Model설정 하고 여기서 셋팅하여 보여줌
		
		/*
		 * Table 이벤트 처리
		 */
		table.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.println("select row"+table.getSelectedRow());
			}
		});
		
		
		
		
		table.getColumnModel().getColumn(3).setPreferredWidth(77);
		scrollPane.setViewportView(table);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(167, 12, 139, 231);
		contentPane.add(scrollPane_1);
	}
	
	
}
