package com.itwill.cafe.comment.UI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.itwill.cafe.comment.Comment;
import com.itwill.cafe.comment.CommentService;
import com.itwill.cafe.main.FirstPageService;

public class CommentPanel extends JPanel{
	GridBagLayout gridB = new GridBagLayout();
	CommentService cServ;
	
	private int cmtCount = 0;
	
	private JPanel contentPane;
	private JPanel cmtPanel;
	private JTextArea cmtOutTA;
	private JScrollPane scrollPane_2;
	private JPanel postPanel;
	public JScrollPane scrollPane_commentPanel;
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
	private ArrayList<JButton> reDatList = new ArrayList<JButton>();
	
	int postNo;
	public CommentPanel(int postNo) throws Exception {
		cServ = new CommentService();
		this.postNo = postNo;
		
		
//		코멘트 패널
		scrollPane_commentPanel = new JScrollPane(this);
		this.setLayout(gridB);
		scrollPane_commentPanel.setBounds(0, 300, 544, 177);
//		postPanel.add(scrollPane_1);
		setToolTipText("\uB313\uAE00\uC601\uC5ED");
		
		this.setBackground(new Color(153,153,255));
		
		
//		댓글입력 패널
		cmtInputP = new JPanel();
		cmtInputP.setLayout(null);
		cmtInputP.setPreferredSize(new Dimension(515, 80));
		cmtInputP.setBackground(new Color(153,153,255));
		this.geneGbInputP(cmtInputP);
		
		
//		댓글입력 란
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 455, 80);
		cmtInputP.add(scrollPane);
		
		cmtInputTA = new JTextArea();
		scrollPane.setViewportView(cmtInputTA);
		
		
//		댓글입력 버튼
		cmtInputB = new JButton("입력");
		
		cmtInputB.setFont(new Font("굴림", Font.PLAIN, 10));
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
		cmtInputB.setBounds(458,5, 55, 70);
		cmtInputP.add(cmtInputB);
		cmtOutTA = new JTextArea();
		
		reGenerate(postNo);
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
		this.add(cmtInputP,gBagCons);
		
//		cmtPanel.updateUI();
	}
	
//	댓글 출력 패널
	public void geneGbOutputP() throws Exception{
		GridBagConstraints gBagCons = new GridBagConstraints();
		//댓글 출력 패널 생성
		JPanel outP = new JPanel();
		outP.setBackground(new Color(153,153,255));
		outP.setLayout(null);
		outP.setPreferredSize(new Dimension(515, 70));
		
		//댓글 출력 텍스트에어리어 생성
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 20, 455, 50);
		outP.add(scrollPane);
		JTextArea outTA = new JTextArea();
		outTA.setBackground(new Color(204,204,255));
		outTA.setFont(new Font("굴림", Font.PLAIN, 10));
		outTA.setEditable(false);
		scrollPane.setViewportView(outTA);
		
		
		//쓴 댓글 읽어오고 저장하기
		Comment tempCmt = cServ.writeComment(cServ.findeLoginMemberName(), cmtInputTA.getText(),postNo);	//PostNo need
		String name = cServ.getName(tempCmt);
		String time = cServ.getTime(tempCmt);
		String cmtContent = cServ.getComment(tempCmt);
		outTA.setText(cmtContent);
		cmtInputTA.setText("");
		cmtInputTA.requestFocus();
		
		//작성자 라벨
		JLabel nameL = new JLabel(name);
		nameL.setForeground(Color.BLUE);
		nameL.setBounds(0, 0, 50, 20);
		nameL.setFont(new Font("굴림", Font.BOLD|Font.ITALIC, 10));
		outP.add(nameL);
		
		//날짜 라벨
		JLabel timeL = new JLabel(time);
		timeL.setBounds(60, 0, 100, 20);
		timeL.setForeground(new Color(51, 51, 255));
		timeL.setFont(new Font("굴림", Font.ITALIC, 10));
		outP.add(timeL);
		
		//댓글 답글
		JButton reDat = new JButton("Re");
		reDat.setBounds(170, 0, 50, 20);
		reDat.setFont(new Font("굴림",Font.PLAIN,8));
		reDat.addActionListener(reDatAction);
		outP.add(reDat);
		
		
		
		//수정 버튼
		JButton cmtUpdateB = new JButton("수정");
		cmtUpdateB.setBackground(new Color(204,204,255));
		cmtUpdateB.setForeground(new Color(153, 153, 204));
		cmtUpdateB.setFont(new Font("굴림", Font.BOLD, 8));
		cmtUpdateB.setBounds(460, 5, 50, 25);
		outP.add(cmtUpdateB);
		cmtUpdateB.addActionListener(updateBAction);
		
		//삭제 버튼
		JButton cmtDeleteB = new JButton("삭제");
		cmtDeleteB.setFont(new Font("굴림", Font.BOLD, 8));
		cmtDeleteB.setBackground(new Color(204,204,255));
		cmtDeleteB.setForeground(new Color(153, 153, 204));
		cmtDeleteB.setBounds(460, 40, 50, 25);
		outP.add(cmtDeleteB);
		cmtDeleteB.addActionListener(deleteBAction);
		
		//멤버변수 ArrayList에 저장
		timeList.add(timeL);
		nameList.add(nameL);		
		updateBList.add(cmtUpdateB);
		deleteBList.add(cmtDeleteB);
		outputTAList.add(outTA);
		outputPanelList.add(outP);
		reDatList.add(reDat);
		
		gBagCons.anchor = GridBagConstraints.NORTH;
		gBagCons.fill = GridBagConstraints.HORIZONTAL;
		gBagCons.insets = new Insets(5, 5, 5, 5);
		gBagCons.gridx = 0;
		gBagCons.gridy = (cmtCount);
		gBagCons.gridwidth = 1;
		gBagCons.gridheight = 1;
		add(outputPanelList.get(cmtCount),gBagCons);
		cmtCount++;
		this.updateUI();
	}
	
	
	
	
	/***********************************************************/
	/******************* Button Event Action *******************/
	/***********************************************************/
	
	ActionListener updateBAction= new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				int cmtCountTemp = updateBList.indexOf(e.getSource());
				if (e.getActionCommand().equals("입력")) {
					JButton b1 = updateBList.get(cmtCountTemp);
					b1.setText("리수");
					JTextArea tATemp = outputTAList.get(cmtCountTemp); 
					//Data File 에 댓글 코멘트 Update
					cServ.updateComment(("*"+tATemp.getText()), cServ.getCmtNoByAction(cmtCountTemp,postNo));	//PostNo need
					tATemp.setBackground(new Color(204,204,255));
					tATemp.setEditable(false);
					cmtInputTA.requestFocus();
				}
				
				else if(e.getActionCommand().equals("리수")){
					JButton b1 = updateBList.get(cmtCountTemp);
					b1.setText("입력");
					JTextArea tATemp = outputTAList.get(cmtCountTemp); 
					tATemp.setEditable(true);
					tATemp.setBackground(Color.white);
					tATemp.requestFocus();
					tATemp.selectAll();
				}
				else if (e.getActionCommand().equals("수정")) {
					JButton b1 = updateBList.get(cmtCountTemp);
					b1.setText("완료");
					JTextArea tATemp = outputTAList.get(cmtCountTemp); 
					tATemp.setEditable(true);
					tATemp.setBackground(Color.white);
					tATemp.requestFocus();
					tATemp.selectAll();
				}else if(e.getActionCommand().equals("완료")){
					JButton b1 = updateBList.get(cmtCountTemp);
					b1.setText("수정");
					JTextArea tATemp = outputTAList.get(cmtCountTemp); 
					//Data File 에 댓글 코멘트 Update
					cServ.updateComment(tATemp.getText(), cServ.getCmtNoByAction(cmtCountTemp,postNo));	//PostNo need
					tATemp.setBackground(new Color(204,204,255));
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
				remove(p1);
				outputPanelList.remove(cmtCountTemp);
				outputTAList.remove(cmtCountTemp);
				updateBList.remove(cmtCountTemp);
				deleteBList.remove(cmtCountTemp);
				nameList.remove(cmtCountTemp);
				timeList.remove(cmtCountTemp);
				reDatList.remove(cmtCountTemp);
				cmtInputTA.requestFocus();
				cServ.deleteComment(cServ.getCmtNoByAction(cmtCountTemp,postNo));	//PostNo need
				reOrder();
				cmtCount--;
				updateUI();

			}catch (Exception e1) {
					throw new RuntimeException(e1.getMessage());
			}
		}
	};
	
	
	
	//리뎃 메쏘드
//	public void reDatmethod(){
	public void reDatStart(){
		
	}
	
	
	ActionListener reDatAction = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			int count = 0;
			count = reDatList.indexOf(e.getSource());
			
			//댓글 출력 패널 생성
			JPanel outP = new JPanel();
			outP.setBackground(new Color(153,153,255));
			outP.setLayout(null);
			outP.setPreferredSize(new Dimension(495, 70));
			
			//댓글 출력 텍스트에어리어 생성
			scrollPane = new JScrollPane();
			scrollPane.setBounds(20, 20, 435, 50);
			outP.add(scrollPane);
			JTextArea outTA = new JTextArea();
			outTA.setBackground(new Color(255,255,255));
			outTA.setFont(new Font("굴림", Font.PLAIN, 10));
			outTA.setEditable(true);
			scrollPane.setViewportView(outTA);
			
			//코멘트 객체에 저장하기
			Comment tempCmt;
			try {
				tempCmt = cServ.reWriteCmt(cServ.findeLoginMemberName(), "*",postNo,count);
				String name = cServ.getName(tempCmt);
				String time = cServ.getTime(tempCmt);
				String cmtContent = cServ.getComment(tempCmt);
				outTA.setText("");
				outTA.requestFocus();
//				outTA.selectAll();
				//날짜 라벨
				JLabel timeL = new JLabel(time);
				timeL.setBounds(80, 0, 100, 20);
				timeL.setForeground(new Color(51, 51, 255));
				timeL.setFont(new Font("굴림", Font.ITALIC, 10));
				outP.add(timeL);
				timeList.add(count+1,timeL);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}	//PostNo need
			cmtInputTA.setText("");
			
			//작성자 라벨
			JLabel nameL;
			try {
				nameL = new JLabel(cServ.findeLoginMemberName());
				nameL.setForeground(Color.BLUE);
				nameL.setBounds(20, 0, 50, 20);
				nameL.setFont(new Font("굴림", Font.BOLD|Font.ITALIC, 10));
				outP.add(nameL);
				nameList.add(count+1,nameL);		
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			//댓글 답글
			JButton reDat = new JButton("Re");
			reDat.setBounds(190, 0, 50, 20);
			reDat.setFont(new Font("굴림",Font.PLAIN,8));
			reDat.addActionListener(reDatAction);
			outP.add(reDat);
			
			
			//수정 버튼
			JButton cmtUpdateB = new JButton("입력");
			cmtUpdateB.setBackground(new Color(204,204,255));
			cmtUpdateB.setForeground(new Color(153, 153, 204));
			cmtUpdateB.setFont(new Font("굴림", Font.BOLD, 8));
			cmtUpdateB.setBounds(460, 5, 50, 25);
			outP.add(cmtUpdateB);
			cmtUpdateB.addActionListener(updateBAction);
			
			//삭제 버튼
			JButton cmtDeleteB = new JButton("삭제");
			cmtDeleteB.setFont(new Font("굴림", Font.BOLD, 8));
			cmtDeleteB.setBackground(new Color(204,204,255));
			cmtDeleteB.setForeground(new Color(153, 153, 204));
			cmtDeleteB.setBounds(460, 40, 50, 25);
			outP.add(cmtDeleteB);
			cmtDeleteB.addActionListener(deleteBAction);
			
			//멤버변수 ArrayList에 저장
			updateBList.add(count+1,cmtUpdateB);
			deleteBList.add(count+1,cmtDeleteB);
			outputTAList.add(count+1,outTA);
			outputPanelList.add(count+1,outP);
			reDatList.add(count+1,reDat);
			cmtCount++;
			geneGbInputP(cmtInputP);
			reOrder();
			outTA.requestFocus();
			updateUI();
			
			
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
			add(outputPanelList.get(recount),gBagCons);
			recount++;
		}
	}
	
	//show by action, regenerate
	public void reGenerate(int postNo) throws Exception{	// postNo need
		ArrayList<Comment> cmtList = cServ.findCommentsByPostNo(postNo);
		cmtCount = 0;
		
		for (Comment comment : cmtList) {
			GridBagConstraints gBagCons = new GridBagConstraints();
			if (comment.getCmtContent() == null || comment.getCmtContent().length()==0) {
				//댓글 출력 패널 생성
				JPanel outP = new JPanel();
				outP.setLayout(null);
				outP.setBackground(new Color(153,153,255));
				outP.setPreferredSize(new Dimension(515,70));

				//댓글 출력 텍스트에어리어 생성
				scrollPane = new JScrollPane();
				scrollPane.setBounds(0, 20, 455, 50);
				outP.add(scrollPane);
				JTextArea outTA = new JTextArea();
				outTA.setBackground(new Color(204,204,255));
				outTA.setFont(new Font("굴림", Font.PLAIN, 10));
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
				nameL.setForeground(Color.BLUE);
				nameL.setBounds(0, 0, 50, 20);
				nameL.setFont(new Font("굴림", Font.BOLD|Font.ITALIC, 10));
				outP.add(nameL);

				//날짜 라벨
				JLabel timeL = new JLabel(time);
				timeL.setForeground(new Color(51, 51, 255));
				timeL.setBounds(60,0,100,20);
				timeL.setFont(new Font("굴림", Font.ITALIC, 10));
				outP.add(timeL);

				//댓글 답글
				JButton reDat = new JButton("Re");
				reDat.setBounds(170, 0, 50, 20);
				reDat.setFont(new Font("굴림",Font.PLAIN,8));
				reDat.addActionListener(reDatAction);
				outP.add(reDat);

				//수정 버튼
				JButton cmtUpdateB = new JButton("수정");
				cmtUpdateB.setFont(new Font("굴림", Font.BOLD, 8));
				cmtUpdateB.setBounds(460,5,50,25);
				cmtUpdateB.setBackground(new Color(204,204,255));
				cmtUpdateB.setForeground(new Color(153, 153, 204));
				outP.add(cmtUpdateB);
				if (cServ.findeLoginMemberName()==null) {
					if (comment.getWriterName().equals("비회원")) {
						cmtUpdateB.setVisible(true);
					}else{
						cmtUpdateB.setVisible(false);
					}
				}else{
					if (cServ.findeLoginMemberName().equals(comment.getWriterName())) {
						cmtUpdateB.setVisible(true);
					}else{
						cmtUpdateB.setVisible(false);
					}
				}
				cmtUpdateB.addActionListener(updateBAction);

				//삭제 버튼
				JButton cmtDeleteB = new JButton("삭제");
				cmtDeleteB.setForeground(new Color(153, 153, 204));
				cmtDeleteB.setBackground(new Color(204,204,255));
				cmtDeleteB.setFont(new Font("굴림", Font.BOLD, 8));
				cmtDeleteB.setBounds(460,40,50,25);
				outP.add(cmtDeleteB);

				if (cServ.findeLoginMemberName()==null) {
					if (comment.getWriterName().equals("비회원")) {
						cmtDeleteB.setVisible(true);
					}else{
						cmtDeleteB.setVisible(false);
					}
				}else{
					if (cServ.findeLoginMemberName().equals(comment.getWriterName())) {
						cmtDeleteB.setVisible(true);
					}else{
						cmtDeleteB.setVisible(false);
					}
				}

				cmtDeleteB.addActionListener(deleteBAction);

				//멤버변수 ArrayList에 저장
				timeList.add(timeL);
				nameList.add(nameL);		
				updateBList.add(cmtUpdateB);
				deleteBList.add(cmtDeleteB);
				outputTAList.add(outTA);
				outputPanelList.add(outP);
				reDatList.add(reDat);

				gBagCons.anchor = GridBagConstraints.NORTH;
				gBagCons.fill = GridBagConstraints.HORIZONTAL;
				gBagCons.insets = new Insets(5, 5, 5, 5);
				gBagCons.gridx = 0;
				gBagCons.gridy = (cmtCount);
				add(outputPanelList.get(cmtCount),gBagCons);
				cmtCount++;
				outP.updateUI();
			}
			
			else if (comment.getCmtContent().length()!=0 && comment.getCmtContent().charAt(0)!='*') {
				//댓글 출력 패널 생성
				JPanel outP = new JPanel();
				outP.setLayout(null);
				outP.setBackground(new Color(153,153,255));
				outP.setPreferredSize(new Dimension(515,70));

				//댓글 출력 텍스트에어리어 생성
				scrollPane = new JScrollPane();
				scrollPane.setBounds(0, 20, 455, 50);
				outP.add(scrollPane);
				JTextArea outTA = new JTextArea();
				outTA.setBackground(new Color(204,204,255));
				outTA.setFont(new Font("굴림", Font.PLAIN, 10));
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
				nameL.setForeground(Color.BLUE);
				nameL.setBounds(0, 0, 50, 20);
				nameL.setFont(new Font("굴림", Font.BOLD|Font.ITALIC, 10));
				outP.add(nameL);

				//날짜 라벨
				JLabel timeL = new JLabel(time);
				timeL.setForeground(new Color(51, 51, 255));
				timeL.setBounds(60,0,100,20);
				timeL.setFont(new Font("굴림", Font.ITALIC, 10));
				outP.add(timeL);

				//댓글 답글
				JButton reDat = new JButton("Re");
				reDat.setBounds(170, 0, 50, 20);
				reDat.setFont(new Font("굴림",Font.PLAIN,8));
				reDat.addActionListener(reDatAction);
				outP.add(reDat);

				//수정 버튼
				JButton cmtUpdateB = new JButton("수정");
				cmtUpdateB.setFont(new Font("굴림", Font.BOLD, 8));
				cmtUpdateB.setBounds(460,5,50,25);
				cmtUpdateB.setBackground(new Color(204,204,255));
				cmtUpdateB.setForeground(new Color(153, 153, 204));
				outP.add(cmtUpdateB);
				if (cServ.findeLoginMemberName()==null) {
					if (comment.getWriterName().equals("비회원")) {
						cmtUpdateB.setVisible(true);
					}else{
						cmtUpdateB.setVisible(false);
					}
				}else{
					if (cServ.findeLoginMemberName().equals(comment.getWriterName())) {
						cmtUpdateB.setVisible(true);
					}else{
						cmtUpdateB.setVisible(false);
					}
				}
				cmtUpdateB.addActionListener(updateBAction);

				//삭제 버튼
				JButton cmtDeleteB = new JButton("삭제");
				cmtDeleteB.setForeground(new Color(153, 153, 204));
				cmtDeleteB.setBackground(new Color(204,204,255));
				cmtDeleteB.setFont(new Font("굴림", Font.BOLD, 8));
				cmtDeleteB.setBounds(460,40,50,25);
				outP.add(cmtDeleteB);

				if (cServ.findeLoginMemberName()==null) {
					if (comment.getWriterName().equals("비회원")) {
						cmtDeleteB.setVisible(true);
					}else{
						cmtDeleteB.setVisible(false);
					}
				}else{
					if (cServ.findeLoginMemberName().equals(comment.getWriterName())) {
						cmtDeleteB.setVisible(true);
					}else{
						cmtDeleteB.setVisible(false);
					}
				}

				cmtDeleteB.addActionListener(deleteBAction);

				//멤버변수 ArrayList에 저장
				timeList.add(timeL);
				nameList.add(nameL);		
				updateBList.add(cmtUpdateB);
				deleteBList.add(cmtDeleteB);
				outputTAList.add(outTA);
				outputPanelList.add(outP);
				reDatList.add(reDat);

				gBagCons.anchor = GridBagConstraints.NORTH;
				gBagCons.fill = GridBagConstraints.HORIZONTAL;
				gBagCons.insets = new Insets(5, 5, 5, 5);
				gBagCons.gridx = 0;
				gBagCons.gridy = (cmtCount);
				add(outputPanelList.get(cmtCount),gBagCons);
				cmtCount++;
				outP.updateUI();
			}else{
				//reDat regenerate
				
				//댓글 출력 패널 생성
				JPanel outP = new JPanel();
				outP.setLayout(null);
				outP.setBackground(new Color(153,153,255));
				outP.setPreferredSize(new Dimension(495, 70));

				//댓글 출력 텍스트에어리어 생성
				scrollPane = new JScrollPane();
				scrollPane.setBounds(20, 20, 435, 50);
				outP.add(scrollPane);
				JTextArea outTA = new JTextArea();
				outTA.setBackground(new Color(204,204,255));
				outTA.setFont(new Font("굴림", Font.PLAIN, 10));
				outTA.setEditable(false);
				scrollPane.setViewportView(outTA);

				//쓴 댓글 읽어오고 저장하기
				String name = cServ.getName(comment);
				String time = cServ.getTime(comment);
				String cmtContent = cServ.getComment(comment).substring(1);
				outTA.setText(cmtContent);
				cmtInputTA.setText("");
				cmtInputTA.requestFocus();

				//작성자 라벨
				JLabel nameL = new JLabel(name);
				nameL.setForeground(Color.BLUE);
				nameL.setBounds(20, 0, 50, 20);
				nameL.setFont(new Font("굴림", Font.BOLD|Font.ITALIC, 10));
				outP.add(nameL);

				//날짜 라벨
				JLabel timeL = new JLabel(time);
				timeL.setForeground(new Color(51, 51, 255));
				timeL.setBounds(80,0,100,20);
				timeL.setFont(new Font("굴림", Font.ITALIC, 10));
				outP.add(timeL);

				//댓글 답글
				JButton reDat = new JButton("Re");
				reDat.setBounds(190, 0, 50, 20);
				reDat.setFont(new Font("굴림",Font.PLAIN,8));
				reDat.addActionListener(reDatAction);
				outP.add(reDat);

				//수정 버튼
				JButton cmtUpdateB = new JButton("리수");
				cmtUpdateB.setFont(new Font("굴림", Font.BOLD, 8));
				cmtUpdateB.setBounds(460,5,50,25);
				cmtUpdateB.setBackground(new Color(204,204,255));
				cmtUpdateB.setForeground(new Color(153, 153, 204));
				outP.add(cmtUpdateB);
				if (cServ.findeLoginMemberName()==null) {
					if (comment.getWriterName().equals("비회원")) {
						cmtUpdateB.setVisible(true);
					}else{
						cmtUpdateB.setVisible(false);
					}
				}else{
					if (cServ.findeLoginMemberName().equals(comment.getWriterName())) {
						cmtUpdateB.setVisible(true);
					}else{
						cmtUpdateB.setVisible(false);
					}
				}
				cmtUpdateB.addActionListener(updateBAction);

				//삭제 버튼
				JButton cmtDeleteB = new JButton("삭제");
				cmtDeleteB.setForeground(new Color(153, 153, 204));
				cmtDeleteB.setBackground(new Color(204,204,255));
				cmtDeleteB.setFont(new Font("굴림", Font.BOLD, 8));
				cmtDeleteB.setBounds(460,40,50,25);
				outP.add(cmtDeleteB);

				if (cServ.findeLoginMemberName()==null) {
					if (comment.getWriterName().equals("비회원")) {
						cmtDeleteB.setVisible(true);
					}else{
						cmtDeleteB.setVisible(false);
					}
				}else{
					if (cServ.findeLoginMemberName().equals(comment.getWriterName())) {
						cmtDeleteB.setVisible(true);
					}else{
						cmtDeleteB.setVisible(false);
					}
				}

				cmtDeleteB.addActionListener(deleteBAction);

				//멤버변수 ArrayList에 저장
				timeList.add(timeL);
				nameList.add(nameL);		
				updateBList.add(cmtUpdateB);
				deleteBList.add(cmtDeleteB);
				outputTAList.add(outTA);
				outputPanelList.add(outP);
				reDatList.add(reDat);

				gBagCons.anchor = GridBagConstraints.NORTH;
				gBagCons.fill = GridBagConstraints.HORIZONTAL;
				gBagCons.insets = new Insets(5, 5, 5, 5);
				gBagCons.gridx = 0;
				gBagCons.gridy = (cmtCount);
				add(outputPanelList.get(cmtCount),gBagCons);
				cmtCount++;
				outP.updateUI();
				
			}
			
		}
		geneGbInputP(cmtInputP);
		cmtInputP.updateUI();
	}
	
}
