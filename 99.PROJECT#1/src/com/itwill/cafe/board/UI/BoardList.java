package com.itwill.cafe.board.UI;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import javax.swing.event.ListDataListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.itwill.cafe.board.Board;
import com.itwill.cafe.board.BoardDao;
import com.itwill.cafe.board.BoardService;
import com.itwill.cafe.main.FirstPageFrame;
import com.itwill.cafe.main.FirstPageService;
import com.itwill.cafe.member.MemberVO;

public class BoardList extends JPanel {
	
	//서비스가 구현되지 않아 Dao를 사용하였음
	private BoardDao boardDao;
	private Listm listModel;
	private BoardService boardService;
	private ArrayList<Board> allBoard;
	private JList<Board> list;
	private FirstPageFrame firstpFrame;
	
	/**
	 * Create the panel.
	 * @throws Exception 
	 */
	public BoardList(FirstPageFrame fpFrame) throws Exception {
		firstpFrame = fpFrame;
		setBackground(new Color(0, 204, 204));
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 12, 130, 247);
		add(scrollPane);
		
		
		//BoardDao로 부터 모든 게시판 리스트 가져오기?? 권한 따져서 가지고 오는 게 더 나을듯..
		boardDao = new BoardDao();
		boardService = new BoardService();
		allBoard = boardDao.allBoard(); 
		
		
		//listModel 객체 생성
		listModel = new Listm(allBoard);
		
		/************************************************/
		list = new JList<Board>();
		list.setModel(listModel);

		list.addMouseListener(new MouseListener() {
			
			public void mouseReleased(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

				System.out.println(list.getSelectedValue().getBoardTitle()+list.getSelectedValue().getBoardAuth()+"게시판고유번호"+list.getSelectedValue().getNo());
				int no = list.getSelectedValue().getNo();
				init(no);
			}
		});
		/************************************************/
		scrollPane.setViewportView(list);

	}
	
	public void init(int no){
		try {
			if(firstpFrame.getBoardDefaultViewPanel() == null){
				System.out.println("게시판이 없으므로 생성합니다. BoardList에서..");
				BoardDefaultViewPanel bdvPanle = new BoardDefaultViewPanel(firstpFrame, no);
				firstpFrame.getPostParentCard().add(bdvPanle, "전환패널");
			}
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		
		firstpFrame.getPostCL().show(firstpFrame.getPostParentCard(), "전환패널");
		try {
			boardDao.selectByNo(no);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public void reLoad() throws Exception{
		listModel = new Listm(allBoard);
		list.setModel(listModel);
	}
	
	
	
	/*
	 * listModel 내부 클래스
	 */
	public class Listm implements ListModel<Board>{
		private ArrayList<Board> boardList;
		private ArrayList<String> boardTitle;
		//생성자
		public Listm(ArrayList<Board> arrList) throws Exception {
			/*
			 * 현재 접속한 유저의 권한을 확인하여 
			 * 보여질 게시판만 boardList에 담는다.
			 */ 
			boardList = new ArrayList<Board>();
			MemberVO activeMember = FirstPageService.getActiveMember();
			if(activeMember == null){
				System.out.println("비회원입니다.");
				boardList = boardService.selectByAuth(3);
				System.out.println("볼 수 있는 게시판 갯수:"+boardList.size());
			}else{
				System.out.println("회원입니다. 현재권한 : "+FirstPageService.getActiveMember().getAuth());
				boardList = boardService.selectByAuth(FirstPageService.getActiveMember().getAuth());
			}
			
			
			boardTitle = new ArrayList<String>();
			for (Board board : arrList) {
				boardTitle.add(board.getBoardTitle());
			}
		}
		
		@Override
		public int getSize() {
			// TODO Auto-generated method stub
			return boardList.size();
		}

		@Override
		public Board getElementAt(int index) {
			// TODO Auto-generated method stub
			return boardList.get(index);
		}

		@Override
		public void addListDataListener(ListDataListener l) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void removeListDataListener(ListDataListener l) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
