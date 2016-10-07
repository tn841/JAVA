package com.itwill.cafe.post.UI;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.itwill.cafe.board.Board;
import com.itwill.cafe.board.BoardDao;
import com.itwill.cafe.board.BoardService;
import com.itwill.cafe.main.FirstPageFrame;
import com.itwill.cafe.main.FirstPageService;
import com.itwill.cafe.member.MemberVO;
import com.itwill.cafe.post.PostDao;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

public class FirstPagePostPanel extends JPanel {
	//게시글 전체 가져오는 서비스가 없어 postDao이용
	private PostDao postDao;
	private BoardService boardService;
	private FirstPageFrame firstpFrame;
	
	//컴포넌트들..
	private FirstPagePostItemPanel[] fppItemPanel;
	private JPanel panel;
	private ArrayList<Board> boardList;
	
	
	/**
	 * Create the panel.
	 * @throws Exception 
	 */
	public FirstPagePostPanel(FirstPageFrame fpFrame, MemberVO activeM) throws Exception {
		firstpFrame = fpFrame;
		/*********************************************/
		setBackground(new Color(255, 102, 153));
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane);
		
		panel = new JPanel();
		//panel.setPreferredSize(new Dimension(0, 5000));
		
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		scrollPane.setViewportView(panel);
		
		
		/*********************************************/
		
		
		/*
		 * 1. 게시판이 몇개인지 판단하여 Panel을 먼저 생성한다.
		 * 2. 각 게시판의 최근 5개의 게시글을 가지고와서 Table로 뿌려준다.
		 * 
		 */
		
		//1.
		boardService = new BoardService();
		
				
		if(activeM == null){
			boardList = boardService.selectByAuth(3);
		}else{
			boardList = boardService.selectByAuth(activeM.getAuth());
		}
		
		
		int boardCount = boardList.size();
		
		System.out.println("게시판 갯수 : "+boardCount);
		fppItemPanel = new FirstPagePostItemPanel[boardCount];
		
		for(int i=0; i<boardCount; i++){
			fppItemPanel[i] = new FirstPagePostItemPanel(fpFrame, boardList.get(i).getNo());
			//fppItemPanel[i].setLayout(new BorderLayout());
			//fppItemPanel[i].setSize(200,200);
			fppItemPanel[i].getTextField().setText(boardList.get(i).getBoardTitle());
			//fppItemPanel[i].setPreferredSize(new Dimension(480, fppItemPanel[i].lineCount*28));
			panel.add(fppItemPanel[i]);
			

		}
		
		
		//2.
				

	}
	
	public void reload() throws Exception{
		MemberVO activeM = FirstPageService.getActiveMember();
		panel.removeAll();
		if(activeM == null){
			boardList = boardService.selectByAuth(3);
		}else{
			boardList = boardService.selectByAuth(activeM.getAuth());
		}
		
		
		int boardCount = boardList.size();
		
		System.out.println("게시판 갯수 : "+boardCount);
		fppItemPanel = new FirstPagePostItemPanel[boardCount];
		
		for(int i=0; i<boardCount; i++){
			fppItemPanel[i] = new FirstPagePostItemPanel(firstpFrame, boardList.get(i).getNo());
			//fppItemPanel[i].setSize(200,200);
			fppItemPanel[i].getTextField().setText(boardList.get(i).getBoardTitle());
			panel.add(fppItemPanel[i]);
		}
	}
}
