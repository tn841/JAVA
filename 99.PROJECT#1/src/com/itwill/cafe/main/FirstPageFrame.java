package com.itwill.cafe.main;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.itwill.cafe.board.UI.BoardDefaultViewPanel;
import com.itwill.cafe.board.UI.BoardList;
import com.itwill.cafe.member.UI.DefaultInfoPanel;
import com.itwill.cafe.member.UI.MemberInfoPanel;
import com.itwill.cafe.member.UI.MemberManagerDialog;
import com.itwill.cafe.post.UI.FirstPagePostPanel;
import com.itwill.cafe.post.UI.PostListtingPanel;

public class FirstPageFrame extends JFrame {

	private JPanel contentPane;
	private DefaultInfoPanel defaultInfoPanel;
	private MemberInfoPanel memberInfoPanel;
	private JPanel cardParent;
	private CardLayout cl;
	private JPanel PostParentCard;
	private JPanel defaulPanel;
	private CardLayout postCL;
	private BoardDefaultViewPanel boardDefaultViewPanel;
	
	public BoardDefaultViewPanel getBoardDefaultViewPanel() {
		return boardDefaultViewPanel;
	}

	public void setBoardDefaultViewPanel(BoardDefaultViewPanel boardDefaultViewPanel) {
		this.boardDefaultViewPanel = boardDefaultViewPanel;
	}

	private FirstPageService fpService;
	private BoardList boardList;
	private FirstPagePostPanel firstPagePostPanel;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FirstPageFrame frame = new FirstPageFrame();
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
	public FirstPageFrame() throws Exception {
		setResizable(false);
		setTitle("Simple Java Cafe");
		fpService = new FirstPageService();//처음 초기화 (activemember가 null임)
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 736, 532);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 732, 503);
		contentPane.add(scrollPane);
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setBackground(new Color(204, 204, 255));
		panel.setForeground(new Color(255, 204, 153));
		panel.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("\uAC8C\uC2DC\uD310 \uB9AC\uC2A4\uD2B8");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel_3.setBounds(14, 191, 154, 31);
		panel.add(lblNewLabel_3);
		
		cardParent = new JPanel();
		cardParent.setBounds(14, 12, 154, 177);
		panel.add(cardParent);
		cardParent.setBackground(Color.ORANGE);
		cl = new CardLayout();
		cardParent.setLayout(cl);
		
		
		defaultInfoPanel = new DefaultInfoPanel(this);
		cardParent.add(defaultInfoPanel, "default");
		memberInfoPanel = new MemberInfoPanel(this);
		cardParent.add(memberInfoPanel, "memberInfo");
		
		cl.show(cardParent, "default");
		
		boardList = new BoardList(this);
		boardList.setBounds(14, 218, 154, 271);
		panel.add(boardList);
		
		postCL = new CardLayout(0, 0);
		PostParentCard = new JPanel();
		PostParentCard.setBounds(172, 12, 544, 477);
		panel.add(PostParentCard);
		PostParentCard.setLayout(postCL);
		
		defaulPanel = new JPanel();
		PostParentCard.add(defaulPanel, "기본패널");
		defaulPanel.setLayout(null);
		
		
		
		firstPagePostPanel = new FirstPagePostPanel(this, FirstPageService.getActiveMember());
		firstPagePostPanel.setBounds(0, 146, 534, 319);
		//firstPagePostPanel.setLayout(new BorderLayout());
		defaulPanel.add(firstPagePostPanel);
		
		JPanel mainbanner = new JPanel();
		mainbanner.setBackground(new Color(186, 85, 211));
		mainbanner.setBounds(0, 0, 544, 143);
		defaulPanel.add(mainbanner);
		mainbanner.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Simple Java Cafe");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 30));
		lblNewLabel.setBounds(55, 5, 387, 126);
		mainbanner.add(lblNewLabel);
		
		JLabel label = new JLabel("");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MemberManagerDialog mmd;
				try {
					mmd = new MemberManagerDialog();
					mmd.setVisible(true);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		label.setBounds(706, 0, 62, 18);
		panel.add(label);
		
	}
	

	
	public FirstPagePostPanel getFirstPagePostPanel() {
		return firstPagePostPanel;
	}

	public void setFirstPagePostPanel(FirstPagePostPanel firstPagePostPanel) {
		this.firstPagePostPanel = firstPagePostPanel;
	}

	public BoardList getBoardList() {
		return boardList;
	}

	public void setBoardList(BoardList boardList) {
		this.boardList = boardList;
	}

	public void refreash(){	//새로고침
		boardList.repaint();
	}
	
	public JPanel getPostParentCard() {
		return PostParentCard;
	}

	public void setPostParentCard(JPanel postParentCard) {
		PostParentCard = postParentCard;
	}

	public CardLayout getPostCL() {
		return postCL;
	}

	public void setPostCL(CardLayout postCL) {
		this.postCL = postCL;
	}

	public JPanel getCardParent() {
		return cardParent;
	}

	public void setCardParent(JPanel cardParent) {
		this.cardParent = cardParent;
	}

	public CardLayout getCl() {
		return cl;
	}

	public void setCl(CardLayout cl) {
		this.cl = cl;
	}
	
	public DefaultInfoPanel getDefaultInfoPanel() {
		return defaultInfoPanel;
	}

	public void setDefaultInfoPanel(DefaultInfoPanel defaultInfoPanel) {
		this.defaultInfoPanel = defaultInfoPanel;
	}

	public MemberInfoPanel getMemberInfoPanel() {
		return memberInfoPanel;
	}

	public void setMemberInfoPanel(MemberInfoPanel memberInfoPanel) {
		this.memberInfoPanel = memberInfoPanel;
	}
}
