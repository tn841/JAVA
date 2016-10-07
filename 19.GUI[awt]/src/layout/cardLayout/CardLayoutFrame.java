package layout.cardLayout;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class CardLayoutFrame extends JFrame implements ActionListener{
	JPanel parentP;
	CardLayout cardLayout;
	
	Button prevB;
	Button nextB;
	Button firstB;
	Button secondB;
	Button thirdB;
	
	Panel buttonP;
	
	Card1Panel card1;
	Card2Panel card2;
	Card3Panel card3;
	
	public CardLayoutFrame(){
		
		/**********카드레이아웃 적용된 parent Panel**************/
		parentP = new JPanel();
		cardLayout = new CardLayout();
		parentP.setLayout(cardLayout);
		parentP.setBackground(Color.orange);
		
		buttonP = new Panel();
		buttonP.setBackground(Color.green);
		buttonP.setLayout(new FlowLayout());
		
		/***********버튼 생성*************/
		prevB = new Button(" < ");
		nextB = new Button(" > ");
		firstB = new Button(" 1 ");
		secondB = new Button(" 2 ");
		thirdB = new Button(" 3 ");
		
		buttonP.add(prevB);
		buttonP.add(firstB);
		buttonP.add(secondB);
		buttonP.add(thirdB);
		buttonP.add(nextB);
		
		prevB.addActionListener(this);
		nextB.addActionListener(this);
		firstB.addActionListener(this);
		secondB.addActionListener(this);
		thirdB.addActionListener(this);
		
		
		//prevB.addActionListener();
		
		/***********카드 패널들*************/
		card1 = new Card1Panel();
		card2 = new Card2Panel();
		card3 = new Card3Panel();
		
		parentP.add(card1, "card1");
		parentP.add(card2, "card2");
		parentP.add(card3, "card3");
		
		
		
		this.getContentPane().add(buttonP, BorderLayout.SOUTH);
		this.getContentPane().add(parentP, BorderLayout.CENTER);
		setSize(300, 400);
		setVisible(true);
		
	
		
	}
	

	public static void main(String[] args) {
		new CardLayoutFrame();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == firstB){
			cardLayout.first(parentP);
		}
		else if(e.getSource() == secondB){
			cardLayout.show(parentP, "card2");
		}
		else if(e.getSource() == thirdB){
			cardLayout.show(parentP, "card3");
		}
		else if(e.getSource() == prevB){
			cardLayout.previous(parentP);
		}
		else if(e.getSource() == nextB){
			cardLayout.next(parentP);
		}
	}

}
