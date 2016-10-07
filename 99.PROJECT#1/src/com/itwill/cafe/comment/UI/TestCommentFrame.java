package com.itwill.cafe.comment.UI;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import com.itwill.cafe.comment.Comment;
import com.itwill.cafe.comment.CommentService;
import com.itwill.cafe.member.MemberService;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TestCommentFrame extends JFrame {
	CommentService cServ = new CommentService();
	GridBagLayout gridB = new GridBagLayout();
	
	private int heightOfPostPanel = 782;
	private int heightOfCmtPanel = 672;
	private int startHeightOfCmtOutPanel = 155;
	private int cmtCount = 0;
	
	private JPanel contentPane;
	private JPanel cmtPanel;
	private JTextArea cmtOutTA;
	private JScrollPane scrollPane_2;
	private JPanel postPanel;
	private JScrollPane scrollPane_1;
	private JPanel cmtInputP;
	private JTextArea cmtInputTA;
	private JScrollPane scrollPane;
	private JButton cmtInputB;

	private ArrayList<JPanel> outputPanelList = new ArrayList<JPanel>();
	private ArrayList<JTextArea> outputTAList = new ArrayList<JTextArea>();
	private ArrayList<JButton> updateBList = new ArrayList<JButton>();
	private ArrayList<JButton> deleteBList = new ArrayList<JButton>();
	private ArrayList<JLabel> nameList = new ArrayList<JLabel>();
	private ArrayList<JLabel> timeList = new ArrayList<JLabel>();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestCommentFrame frame = new TestCommentFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public TestCommentFrame() throws Exception {
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 920, 840);
		setTitle("댓글 Test");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
//		게시판 패널
		postPanel = new JPanel();
		postPanel.setBounds(0, 0, 540, 160);
		contentPane.add(postPanel);
		postPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uAC8C\uC2DC\uAE00 \uC601\uC5ED");
		lblNewLabel.setBounds(24, 20, 84, 15);
		postPanel.add(lblNewLabel);
		
		
//		코멘트 패널
		cmtPanel = new JPanel();
		
		cmtPanel.setLayout(gridB);
		scrollPane_1 = new JScrollPane(cmtPanel);
		scrollPane_1.setBounds(10, 100, 870, 690);
		postPanel.add(scrollPane_1);
		cmtPanel.setToolTipText("\uB313\uAE00\uC601\uC5ED");

		
//		댓글입력 패널
		cmtInputP = new JPanel();
		cmtInputP.setLayout(null);
		cmtInputP.setPreferredSize(new Dimension(840, 200));
		this.geneGbInputP(cmtInputP);
		
		
//		댓글입력 란
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 600, 180);
		cmtInputP.add(scrollPane);
		
		cmtInputTA = new JTextArea();
		scrollPane.setViewportView(cmtInputTA);
		
		
//		댓글입력 버튼
		cmtInputB = new JButton("\uB313\uAE00\uC785\uB825");
		cmtInputB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					geneGbOutputP();
					geneGbInputP(cmtInputP);
				} catch (Exception e1) {
					throw new RuntimeException(e1.getMessage());
				}
			}
		});
		cmtInputB.setBounds(620, 10, 200, 180);
		cmtInputP.add(cmtInputB);
		cmtOutTA = new JTextArea();
		
		reGenerate();
	}
	
	
	
	
	/***********************************************************/
	/***************** GridBgLayout Constraints ****************/
	/***********************************************************/
	
	
//	댓글 입력 패널 
	public void geneGbInputP(JPanel cmtInputP){
		GridBagConstraints gBagCons = new GridBagConstraints();
		gBagCons.anchor = GridBagConstraints.SOUTH;
		gBagCons.fill = GridBagConstraints.HORIZONTAL;
		gBagCons.insets = new Insets(5, 5, 5, 5);
		gBagCons.gridx = 0;
		gBagCons.gridy = cmtCount+1;
		gBagCons.gridwidth = 1;
		gBagCons.gridheight = 1;
		cmtPanel.add(cmtInputP,gBagCons);
		
//		cmtPanel.updateUI();
	}
	
//	댓글 출력 패널
	public void geneGbOutputP() throws Exception{
		GridBagConstraints gBagCons = new GridBagConstraints();
		//댓글 출력 패널 생성
		JPanel outP = new JPanel();
		outP.setLayout(null);
		outP.setPreferredSize(new Dimension(840, 200));
		
		//댓글 출력 텍스트에어리어 생성
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 30, 600, 160);
		outP.add(scrollPane);
		JTextArea outTA = new JTextArea();
		outTA.setFont(new Font("굴림", Font.PLAIN, 14));
		outTA.setEditable(false);
		scrollPane.setViewportView(outTA);
		
		
		//쓴 댓글 읽어오고 저장하기
		Comment tempCmt = cServ.writeComment(cServ.findeLoginMemberName(), cmtInputTA.getText(),1);	//PostNo need
		String name = cServ.getName(tempCmt);
		String time = cServ.getTime(tempCmt);
		String cmtContent = cServ.getComment(tempCmt);
		outTA.setText(cmtContent);
		cmtInputTA.setText("");
		cmtInputTA.requestFocus();
		
		//작성자 라벨
		JLabel nameL = new JLabel(name);
		nameL.setBounds(10, 10, 50, 20);
		nameL.setFont(new Font("굴림", Font.BOLD|Font.ITALIC, 12));
		outP.add(nameL);
		
		//날짜 라벨
		JLabel timeL = new JLabel(time);
		timeL.setBounds(70, 10, 100, 20);
		timeL.setFont(new Font("굴림", Font.ITALIC, 12));
		outP.add(timeL);
		
		//수정 버튼
		JButton cmtUpdateB = new JButton("수정");
		cmtUpdateB.setBounds(625, 35, 190, 70);
		outP.add(cmtUpdateB);
		cmtUpdateB.addActionListener(updateBAction);
		
		//삭제 버튼
		JButton cmtDeleteB = new JButton("삭제");
		cmtDeleteB.setBounds(625, 115, 190, 70);
		outP.add(cmtDeleteB);
		cmtDeleteB.addActionListener(deleteBAction);
		
		//멤버변수 ArrayList에 저장
		timeList.add(timeL);
		nameList.add(nameL);		
		updateBList.add(cmtUpdateB);
		deleteBList.add(cmtDeleteB);
		outputTAList.add(outTA);
		outputPanelList.add(outP);
		
		gBagCons.anchor = GridBagConstraints.NORTH;
		gBagCons.fill = GridBagConstraints.HORIZONTAL;
		gBagCons.insets = new Insets(5, 5, 5, 5);
		gBagCons.gridx = 0;
		gBagCons.gridy = (cmtCount);
		gBagCons.gridwidth = 1;
		gBagCons.gridheight = 1;
		cmtPanel.add(outputPanelList.get(cmtCount),gBagCons);
		cmtCount++;
		cmtPanel.updateUI();
	}
	
	
	
	
	/***********************************************************/
	/******************* Button Event Action *******************/
	/***********************************************************/
	
	ActionListener updateBAction= new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				int cmtCountTemp = updateBList.indexOf(e.getSource());
				if (e.getActionCommand().equals("수정")) {
					JButton b1 = updateBList.get(cmtCountTemp);
					b1.setText("수정완료");
					JTextArea tATemp = outputTAList.get(cmtCountTemp); 
					tATemp.setEditable(true);
					tATemp.requestFocus();
					tATemp.selectAll();
				}else if(e.getActionCommand().equals("수정완료")){
					JButton b1 = updateBList.get(cmtCountTemp);
					b1.setText("수정");
					JTextArea tATemp = outputTAList.get(cmtCountTemp); 
					//Data File 에 댓글 코멘트 Update
					cServ.updateComment(tATemp.getText(), cServ.getCmtNoByAction(cmtCountTemp,1));	//PostNo need
					tATemp.setEditable(false);
					cmtInputTA.requestFocus();
				}
			}catch (Exception e1) {
					throw new RuntimeException(e1.getMessage());
			}
		}
	};
	
	ActionListener deleteBAction= new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				int cmtCountTemp = deleteBList.indexOf(e.getSource());
				JPanel p1 = outputPanelList.get(cmtCountTemp);
				cmtPanel.remove(p1);
				outputPanelList.remove(cmtCountTemp);
				outputTAList.remove(cmtCountTemp);
				updateBList.remove(cmtCountTemp);
				deleteBList.remove(cmtCountTemp);
				nameList.remove(cmtCountTemp);
				timeList.remove(cmtCountTemp);
				cmtInputTA.requestFocus();
				cServ.deleteComment(cServ.getCmtNoByAction(cmtCountTemp,1));	//PostNo need
				reOrder();
				cmtCount--;
				cmtPanel.updateUI();

			}catch (Exception e1) {
					throw new RuntimeException(e1.getMessage());
			}
		}
	};
	
	//삭제에 따른 댓글들 Layout위치 reorder....
	public void reOrder(){
		int recount=0;
		for (JPanel aaa : outputPanelList) {
			GridBagConstraints gBagCons = new GridBagConstraints();
			gBagCons.anchor = GridBagConstraints.NORTH;
			gBagCons.fill = GridBagConstraints.HORIZONTAL;
			gBagCons.insets = new Insets(5, 5, 5, 5);
			gBagCons.gridx = 0;
			gBagCons.gridy = recount;
			gBagCons.gridwidth = 1;
			gBagCons.gridheight = 1;
			cmtPanel.add(outputPanelList.get(recount),gBagCons);
			recount++;
		}
	}
	
	//show aection regenerate
	public void reGenerate() throws Exception{
		ArrayList<Comment> cmtList = cServ.allComments();
		cmtCount = 0;
		for (Comment comment : cmtList) {
			GridBagConstraints gBagCons = new GridBagConstraints();
			//댓글 출력 패널 생성
			JPanel outP = new JPanel();
			outP.setLayout(null);
			outP.setPreferredSize(new Dimension(840, 200));
			
			//댓글 출력 텍스트에어리어 생성
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 30, 600, 160);
			outP.add(scrollPane);
			JTextArea outTA = new JTextArea();
			outTA.setFont(new Font("굴림", Font.PLAIN, 14));
			outTA.setEditable(false);
			scrollPane.setViewportView(outTA);
			
			
			//쓴 댓글 읽어오고 저장하기
			String name = cServ.getName(comment);
			String time = cServ.getTime(comment);
			String cmtContent = cServ.getComment(comment);
			outTA.setText(cmtContent);
			cmtInputTA.setText("");
			cmtInputTA.requestFocus();
			
			//작성자 라벨
			JLabel nameL = new JLabel(name);
			nameL.setBounds(10, 10, 50, 20);
			nameL.setFont(new Font("굴림", Font.BOLD|Font.ITALIC, 12));
			outP.add(nameL);
			
			//날짜 라벨
			JLabel timeL = new JLabel(time);
			timeL.setBounds(70, 10, 100, 20);
			timeL.setFont(new Font("굴림", Font.ITALIC, 12));
			outP.add(timeL);
			
			//수정 버튼
			JButton cmtUpdateB = new JButton("수정");
			cmtUpdateB.setBounds(625, 35, 190, 70);
			outP.add(cmtUpdateB);
			if (cServ.findeLoginMemberName().equals(comment.getWriterName())) {
				cmtUpdateB.setVisible(true);
			}else{
				cmtUpdateB.setVisible(false);
			}
			cmtUpdateB.addActionListener(updateBAction);
			
			//삭제 버튼
			JButton cmtDeleteB = new JButton("삭제");
			cmtDeleteB.setBounds(625, 115, 190, 70);
			outP.add(cmtDeleteB);
			if (cServ.findeLoginMemberName().equals(comment.getWriterName())) {
				cmtDeleteB.setVisible(true);
			}else{
				cmtDeleteB.setVisible(false);
			}
			cmtDeleteB.addActionListener(deleteBAction);
			
			//멤버변수 ArrayList에 저장
			timeList.add(timeL);
			nameList.add(nameL);		
			updateBList.add(cmtUpdateB);
			deleteBList.add(cmtDeleteB);
			outputTAList.add(outTA);
			outputPanelList.add(outP);
			
			gBagCons.anchor = GridBagConstraints.NORTH;
			gBagCons.fill = GridBagConstraints.HORIZONTAL;
			gBagCons.insets = new Insets(5, 5, 5, 5);
			gBagCons.gridx = 0;
			gBagCons.gridy = (cmtCount);
			gBagCons.gridwidth = 1;
			gBagCons.gridheight = 1;
			cmtPanel.add(outputPanelList.get(cmtCount),gBagCons);
			cmtCount++;
			outP.updateUI();
		}
		geneGbInputP(cmtInputP);
		cmtInputP.updateUI();
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
