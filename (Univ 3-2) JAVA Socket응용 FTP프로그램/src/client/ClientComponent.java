package client;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;

import javax.swing.*;

public class ClientComponent extends JPanel {

	Main main;

	private ImageIcon FileIcon = new ImageIcon("res/File.PNG");
	private ImageIcon File2Icon = new ImageIcon("res/File2.PNG");
	private JTextField IPBox, IDBox, PWBox, passiveBox, LocalDir, ServerMkD, ServerRMD, ServerPDW;

	private JPanel LocalPanel;
	private JPanel LocalPPanel;
	private JPanel ServerPanel;
	private JPanel ServerDPanel;
	private JPanel ServerFPanel;
	private JPanel IPPanel;
	private JPanel MsgPanel;
	private JPanel SclPanel;

	private JPanel jp_label, jp_label2, j3, j4;
	private JPanel LocalFPanel;
	private JScrollPane scroll, scroll2, scroll3, scroll4;

	private FtpClient ftpC;
	private ListenThread lt;

	private String str, str3;

	public static ArrayList<String> dirList = new ArrayList<String>();
	public static String source = "./";
	public String WelMSG = "Welcome!";
	public String ByeMSG = "Good Bye!";

	File dir;
	File[] fileList;

	String[] content;

	public String IPAddress = "", ID = "", PW = "", MODE = "", sel = "";

	private JButton IDPWbtn;
	private JButton IpBtn, IdBtn, passiveBtn, LocalBtn, ServerBtn, LocalCDUP, ServerCDUP, ServerMkDir, ServerRmDir;
	private JButton lsBtn, cdBtn, getBtn, putBtn, asciiBtn, binaryBtn, quitBtn;
	private JButton[] btns, btns2;
	public JTextArea textArea;

	private AListener actionL = new AListener();
	private MouseEventHandler mouseR = new MouseEventHandler();

	public int confirm = 0, cnt = 0, cnt_local = 0;
	public boolean access;

	public ClientComponent() {

		setPreferredSize(new Dimension(1200, 550));
		setLayout(null);

		LocalBtn = new JButton("Local");
		LocalBtn.setFont(new Font("verdana", Font.BOLD, 10));
		LocalBtn.setBounds(25, 90, 75, 25);
		LocalBtn.setBackground(Color.black);
		LocalBtn.setForeground(Color.white);
		LocalBtn.addActionListener(actionL);
		LocalBtn.setVisible(true);
		add(LocalBtn);

		ServerBtn = new JButton("Server");
		ServerBtn.setFont(new Font("verdana", Font.BOLD, 10));
		ServerBtn.setBounds(625, 90, 80, 25);
		ServerBtn.setBackground(Color.black);
		ServerBtn.setForeground(Color.white);
		ServerBtn.setVisible(true);
		add(ServerBtn);

		String tempstr = new String(System.getProperty("user.dir"));

		LocalDir = new JTextField(tempstr);
		LocalDir.setBounds(100, 90, 410, 25);
		LocalDir.setFont(new Font("verdana", Font.BOLD, 10));
		LocalDir.setHorizontalAlignment(SwingConstants.LEFT);
		LocalDir.setBackground(new Color(255, 255, 255));
		LocalDir.setEditable(false);
		LocalDir.setVisible(true);
		add(LocalDir);

		LocalCDUP = new JButton("back");
		LocalCDUP.setFont(new Font("verdana", Font.BOLD, 10));
		LocalCDUP.setBounds(510, 90, 65, 25);
		LocalCDUP.setBackground(Color.black);
		LocalCDUP.setForeground(Color.white);
		LocalCDUP.addActionListener(actionL);
		LocalCDUP.setVisible(true);
		// add(LocalCDUP);

		ServerCDUP = new JButton("back");
		ServerCDUP.setFont(new Font("verdana", Font.BOLD, 10));
		ServerCDUP.setBounds(1110, 90, 65, 25);
		ServerCDUP.setBackground(Color.black);
		ServerCDUP.setForeground(Color.white);
		ServerCDUP.addActionListener(actionL);
		ServerCDUP.setVisible(true);
		add(ServerCDUP);

		ServerMkDir = new JButton("Mkdir");
		ServerMkDir.setFont(new Font("verdana", Font.BOLD, 10));
		ServerMkDir.setBounds(1100, 490, 70, 25);
		ServerMkDir.setBackground(Color.black);
		ServerMkDir.setForeground(Color.white);
		ServerMkDir.addActionListener(actionL);
		ServerMkDir.setVisible(true);
		add(ServerMkDir);

		ServerMkD = new JTextField("Enter_the_Dir_name");
		ServerMkD.setBounds(970, 490, 130, 25);
		ServerMkD.setFont(new Font("verdana", Font.BOLD, 10));
		ServerMkD.setHorizontalAlignment(SwingConstants.LEFT);
		ServerMkD.setBackground(new Color(255, 255, 255));
		ServerMkD.setVisible(true);
		add(ServerMkD);

		ServerRmDir = new JButton("Rmdir");
		ServerRmDir.setFont(new Font("verdana", Font.BOLD, 10));
		ServerRmDir.setBounds(1100, 515, 70, 25);
		ServerRmDir.setBackground(Color.black);
		ServerRmDir.setForeground(Color.white);
		ServerRmDir.addActionListener(actionL);
		ServerRmDir.setVisible(true);
		add(ServerRmDir);

		ServerRMD = new JTextField("Enter_the_Dir_name");
		ServerRMD.setBounds(970, 515, 130, 25);
		ServerRMD.setFont(new Font("verdana", Font.BOLD, 10));
		ServerRMD.setHorizontalAlignment(SwingConstants.LEFT);
		ServerRMD.setBackground(new Color(255, 255, 255));
		ServerRMD.setVisible(true);
		add(ServerRMD);

		ServerPDW = new JTextField(" Server's path...");
		ServerPDW.setBounds(705, 90, 410, 25);
		ServerPDW.setFont(new Font("verdana", Font.BOLD, 10));
		ServerPDW.setHorizontalAlignment(SwingConstants.LEFT);
		ServerPDW.setBackground(new Color(255, 255, 255));
		ServerPDW.setEditable(false);
		ServerPDW.setVisible(true);
		add(ServerPDW);

		LocalPanel = new JPanel();
		LocalPanel.setBounds(10, 100, 580, 410);
		LocalPanel.setBackground(new Color(200, 200, 200));
		LocalPanel.setLayout(null);
		add(LocalPanel);

		LocalPPanel = new JPanel();
		LocalPPanel.setBounds(15, 15, 550, 173);
		LocalPPanel.setBackground(new Color(220, 220, 220));
		LocalPPanel.setLayout(null);
		this.LocalPanel.add(LocalPPanel);

		LocalFPanel = new JPanel();
		LocalFPanel.setBounds(15, 200, 550, 190);
		LocalFPanel.setBackground(new Color(220, 220, 220));
		LocalFPanel.setLayout(null);
		this.LocalPanel.add(LocalFPanel);

		ServerPanel = new JPanel();
		ServerPanel.setBounds(610, 100, 580, 410);
		ServerPanel.setBackground(new Color(200, 200, 200));
		ServerPanel.setLayout(null);
		add(ServerPanel);

		ServerDPanel = new JPanel();
		ServerDPanel.setBounds(15, 15, 550, 173);
		ServerDPanel.setBackground(new Color(200, 200, 200));
		ServerDPanel.setLayout(null);
		this.ServerPanel.add(ServerDPanel);

		ServerFPanel = new JPanel();
		ServerFPanel.setBounds(15, 200, 550, 190);
		ServerFPanel.setBackground(new Color(200, 200, 200));
		ServerFPanel.setLayout(null);
		this.ServerPanel.add(ServerFPanel);

		jp_label = new JPanel();
		jp_label.setLayout(new BoxLayout(jp_label, BoxLayout.Y_AXIS));
		jp_label.setBackground(Color.white);

		IpBtn = new JButton("IP Address");
		IpBtn.setFont(new Font("verdana", Font.BOLD, 10));
		IpBtn.setBounds(20, 20, 100, 25);
		IpBtn.setBackground(Color.BLACK);
		IpBtn.setForeground(Color.white);
		IpBtn.setVisible(true);
		add(IpBtn);

		IdBtn = new JButton("ID / PW");
		IdBtn.setFont(new Font("verdana", Font.BOLD, 10));
		IdBtn.setBounds(20, 50, 100, 25);
		IdBtn.setBackground(Color.BLACK);
		IdBtn.setForeground(Color.white);
		IdBtn.setVisible(true);
		add(IdBtn);

		IPBox = new JTextField();
		IPBox.setBounds(130, 20, 250, 25);
		IPBox.setText("210.107.233.178");
		IPBox.setFont(new Font("verdana", Font.BOLD, 10));
		IPBox.setHorizontalAlignment(SwingConstants.CENTER);
		IPBox.setVisible(true);
		add(IPBox);

		IDBox = new JTextField();
		IDBox.setBounds(130, 50, 120, 25);
		IDBox.setText("admin");
		IDBox.setFont(new Font("verdana", Font.BOLD, 10));
		IDBox.setHorizontalAlignment(SwingConstants.CENTER);
		IDBox.setVisible(true);
		add(IDBox);

		PWBox = new JTextField();
		PWBox.setBounds(260, 50, 120, 25);
		PWBox.setText("admin");
		PWBox.setFont(new Font("verdana", Font.BOLD, 10));
		PWBox.setHorizontalAlignment(SwingConstants.CENTER);
		PWBox.setVisible(true);
		add(PWBox);

		IDPWbtn = new JButton("Insert");
		IDPWbtn.setFont(new Font("verdana", Font.BOLD, 10));
		IDPWbtn.setBounds(400, 50, 160, 25);
		IDPWbtn.addActionListener(actionL);
		IDPWbtn.setBackground(Color.white);
		IDPWbtn.setForeground(Color.black);
		IDPWbtn.setVisible(true);
		add(IDPWbtn);

		passiveBtn = new JButton("A / P");
		passiveBtn.setFont(new Font("verdana", Font.BOLD, 10));
		passiveBtn.setBounds(400, 20, 70, 25);
		passiveBtn.setBackground(Color.BLACK);
		passiveBtn.setForeground(Color.white);
		passiveBtn.setVisible(true);
		add(passiveBtn);

		passiveBox = new JTextField();
		passiveBox.setBounds(480, 20, 80, 25);
		passiveBox.setFont(new Font("verdana", Font.BOLD, 10));
		passiveBox.setHorizontalAlignment(SwingConstants.CENTER);
		passiveBox.setVisible(true);
		passiveBox.addActionListener(actionL);
		add(passiveBox);

		IPPanel = new JPanel();
		IPPanel.setBounds(10, 5, 580, 80);
		IPPanel.setBackground(new Color(200, 200, 200));
		IPPanel.setLayout(null);
		add(IPPanel);

		lsBtn = new JButton("ls");
		lsBtn.setFont(new Font("verdana", Font.BOLD, 10));
		lsBtn.setBounds(380, 520, 100, 25);
		lsBtn.addActionListener(actionL);
		lsBtn.setBackground(Color.white);
		lsBtn.setForeground(Color.black);
		lsBtn.setVisible(true);
		add(lsBtn);

		asciiBtn = new JButton("ascii");
		asciiBtn.setFont(new Font("verdana", Font.BOLD, 10));
		asciiBtn.setBounds(500, 520, 100, 25);
		asciiBtn.addActionListener(actionL);
		asciiBtn.setBackground(Color.white);
		asciiBtn.setForeground(Color.black);
		asciiBtn.setVisible(true);
		add(asciiBtn);

		binaryBtn = new JButton("binary");
		binaryBtn.setFont(new Font("verdana", Font.BOLD, 10));
		binaryBtn.setBounds(620, 520, 100, 25);
		binaryBtn.addActionListener(actionL);
		binaryBtn.setBackground(Color.white);
		binaryBtn.setForeground(Color.black);
		binaryBtn.setVisible(true);
		add(binaryBtn);

		quitBtn = new JButton("quit");
		quitBtn.setFont(new Font("verdana", Font.BOLD, 10));
		quitBtn.setBounds(740, 520, 100, 25);
		quitBtn.addActionListener(actionL);
		quitBtn.setBackground(Color.white);
		quitBtn.setForeground(Color.black);
		quitBtn.setVisible(true);
		add(quitBtn);

		scroll = new JScrollPane(jp_label); // 스크롤패널을 선언
		scroll.setBounds(0, 0, 550, 190); // 프레임에 스크롤패널의 위치를 정한다
		LocalPPanel.add(scroll); // 스크롤패널 추가

		JPanel p = new JPanel();

		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));

		jp_label2 = new JPanel();
		jp_label2.setLayout(new BoxLayout(jp_label2, BoxLayout.Y_AXIS));
		jp_label2.setBackground(Color.white);

		scroll2 = new JScrollPane(jp_label2); // 스크롤패널을 선언
		scroll2.setBounds(0, 0, 550, 190); // 프레임에 스크롤패널의 위치를 정한다
		LocalFPanel.add(scroll2); // 스크롤패널 추가

		dir = new File(source);
		fileList = dir.listFiles();
		btns = new JButton[fileList.length];
		JPanel p2 = new JPanel();

		p2.setLayout(new BoxLayout(p2, BoxLayout.Y_AXIS));

		show_local_ls();

		j3 = new JPanel();
		j3.setLayout(new BoxLayout(j3, BoxLayout.Y_AXIS));
		j3.setBackground(Color.white);

		scroll3 = new JScrollPane(j3); // 스크롤패널을 선언
		scroll3.setBounds(0, 0, 550, 190); // 프레임에 스크롤패널의 위치를 정한다
		ServerDPanel.add(scroll3); // 스크롤패널 추가

		JPanel p3 = new JPanel();

		p3.setLayout(new BoxLayout(p3, BoxLayout.Y_AXIS));

		j4 = new JPanel();
		j4.setLayout(new BoxLayout(j4, BoxLayout.Y_AXIS));
		j4.setBackground(Color.white);

		scroll4 = new JScrollPane(j4); // 스크롤패널을 선언
		scroll4.setBounds(0, 0, 550, 190); // 프레임에 스크롤패널의 위치를 정한다
		ServerFPanel.add(scroll4); // 스크롤패널 추가

		JPanel p4 = new JPanel();

		p4.setLayout(new BoxLayout(p4, BoxLayout.Y_AXIS));

		MsgPanel = new JPanel();
		MsgPanel.setBounds(610, 0, 580, 85);
		MsgPanel.setBackground(Color.white);
		MsgPanel.setLayout(new BorderLayout());
		add(MsgPanel);

		SclPanel = new JPanel(); // scroll패널
		MsgPanel.add(SclPanel);

		textArea = new JTextArea(WelMSG);
		// textArea.setFont(new Font("Serif", Font.ITALIC, 16));
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setEditable(false);
		JScrollPane areaScrollPane = new JScrollPane(textArea);
		areaScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		areaScrollPane.setPreferredSize(new Dimension(580, 80));
		SclPanel.add(areaScrollPane);

	}// 생성자

	public void show_server_ls() {
		if (cnt > 0) {
			for (int i = 0; i < content.length; i++) {
				btns2[i].setVisible(false);
			}
		}
		str = ftpC.doLs();
		content = str.split("\n");
		btns2 = new JButton[content.length];

		for (int i = 0; i < content.length; i++) {

			if (content[i].substring(0, 1).equals("d")) { // 디렉토리 인 경우

				String serverFolder = content[i];
				btns2[i] = new JButton((serverFolder), FileIcon);
				btns2[i].setBackground(Color.white);
				btns2[i].setHorizontalAlignment(SwingConstants.LEFT);
				btns2[i].setRolloverIcon(FileIcon);
				btns2[i].setPreferredSize(new Dimension(550, 30));
				btns2[i].setMaximumSize(new Dimension(550, 30));
				btns2[i].addMouseListener(mouseR);
				j3.add(btns2[i]);

			} else if (content[i].substring(0, 1).equals("-")) { // 파일 인
																	// 경우

				String serverFile = content[i];
				btns2[i] = new JButton((serverFile), File2Icon);
				btns2[i].setBackground(Color.white);
				btns2[i].setRolloverIcon(File2Icon);
				btns2[i].setHorizontalAlignment(SwingConstants.LEFT);
				btns2[i].setPreferredSize(new Dimension(545, 30));
				btns2[i].setMaximumSize(new Dimension(545, 30));
				btns2[i].addMouseListener(mouseR);
				j4.add(btns2[i]);

			} else if (content[i].contains("<DIR>")) {// ftp.microsoft.com
														// 에서 디렉토리인 경우

				String serverFolder = content[i];
				btns2[i] = new JButton((serverFolder), FileIcon);
				btns2[i].setBackground(Color.white);
				btns2[i].setHorizontalAlignment(SwingConstants.LEFT);
				btns2[i].setRolloverIcon(FileIcon);
				btns2[i].setPreferredSize(new Dimension(550, 30));
				btns2[i].setMaximumSize(new Dimension(550, 30));

				j3.add(btns2[i]);

			} else { // 이도 저도 아닌 경우 파일로 취급

				String serverFile = content[i];
				btns2[i] = new JButton((serverFile), File2Icon);
				btns2[i].setBackground(Color.white);
				btns2[i].setRolloverIcon(File2Icon);
				btns2[i].setHorizontalAlignment(SwingConstants.LEFT);
				btns2[i].setPreferredSize(new Dimension(545, 30));
				btns2[i].setMaximumSize(new Dimension(545, 30));
				btns2[i].addMouseListener(mouseR);
				j4.add(btns2[i]);

			}

		}
		cnt++;// 버튼 눌린 횟수
		// ServerPDW.setText(" ");
		// System.out.println(ftpC.nowPosition());
		ServerMkD.setText("Enter_the_Dir_name");
		ServerRMD.setText("Enter_the_Dir_name");
		validate();
		repaint();
	}

	public void show_local_ls() {
		if (cnt_local > 0) {
			for (int i = 0; i < fileList.length; i++) {
				btns[i].setVisible(false);
			}
		}

		for (int i = 0; i < fileList.length; i++) {
			File file = fileList[i];
			if (file.isFile()) { // 파일인 경우
				try {
					String str = file.getCanonicalPath();
					String str2 = file.getName();

					btns[i] = new JButton((str2), File2Icon);
					btns[i].setPreferredSize(new Dimension(530, 30));
					btns[i].setMaximumSize(new Dimension(530, 30));
					btns[i].setBackground(Color.white);
					btns[i].setRolloverIcon(File2Icon);
					btns[i].setHorizontalAlignment(SwingConstants.LEFT);
					btns[i].addMouseListener(mouseR);
					jp_label2.add(btns[i]);

				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			else if (file.isDirectory()) { // 디렉토리 인 경우
				try {
					String str = file.getCanonicalPath();
					String str2 = file.getName();

					btns[i] = new JButton((str2), FileIcon);
					btns[i].setPreferredSize(new Dimension(550, 30));
					btns[i].setMaximumSize(new Dimension(550, 30));
					btns[i].setBackground(Color.white);
					btns[i].setHorizontalAlignment(SwingConstants.LEFT);
					btns[i].setRolloverIcon(FileIcon);
					btns[i].addMouseListener(mouseR);
					jp_label.add(btns[i]);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} // for

		cnt_local++;
	}

	public int getConfirm() {
		return confirm;
	}

	public void setMSG(String msg) {

		textArea.append(msg); // 메세지 추가
		textArea.setCaretPosition(textArea.getDocument().getLength());// 마지막 위치로
																		// 포커싱
	}

	public void InitMSG() {
		textArea.setText(ByeMSG);
	}

	// getMsgs 메소드
	// 제어 스트림의 수신 슬롯을 개시한다.
	public void getMsgs() {
		try {
			lt = new ListenThread(ftpC.ctrlInput, this);
			Thread listenerthread = new Thread(lt);
			listenerthread.start();

		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	public static String arrayJoin(String glue, String array[]) {
		String result = "";

		for (int i = 0; i < array.length - 2; i++) {
			result += array[i];
			if (i < array.length - 1)
				result += glue;
		}
		return result;
	}// 문자열 합치기

	public class AListener implements ActionListener {

		public void actionPerformed(ActionEvent event) {
			Object obj = event.getSource();

			if (obj == IDPWbtn) {// insert button

				IPAddress = IPBox.getText();
				ID = IDBox.getText();
				PW = PWBox.getText();
				MODE = passiveBox.getText();

				try {

					ftpC = new FtpClient(IPAddress);
					ftpC.doLogin(ID, PW, MODE);// login
					getMsgs();// 메세지 출력

				} catch (UnknownHostException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} // insert Button

			if (obj == lsBtn) {
				show_server_ls();
			}

			if (obj == ServerCDUP) {
				ftpC.doCDUP();
				show_server_ls();
			}

			if (obj == ServerMkDir) {
				String temp = new String(ServerMkD.getText());
				ftpC.mkdir(temp);
				show_server_ls();
			}

			if (obj == ServerRmDir) {
				String temp = new String(ServerRMD.getText());
				ftpC.removeDir(temp);
				show_server_ls();
			}

			if (obj == asciiBtn) {
				ftpC.doAscii();
			}
			if (obj == binaryBtn) {
				ftpC.doBinary();
			}
			if (obj == quitBtn) {

				ftpC.doQuit();
				InitMSG();
				lt.running = false;

				try {
					ftpC.init();
					lt = null;
				} catch (IOException e) {
					e.printStackTrace();
				}

				if (cnt > 0) { // ls가 1번 이상 클릭 되었으면
					for (int i = 0; i < content.length; i++) {// 서버 초기화 구문
						btns2[i].setVisible(false);
					}
				}
			}
		}
	}

	public class MouseEventHandler implements MouseListener {

		public void mouseClicked(MouseEvent event) {
			Object obj = event.getSource();

			if (event.getClickCount() == 2 && event.getButton()==1) {
				for (int i = 0; i < fileList.length; i++) {
					File file = fileList[i];
					if (file.isFile()) {
						if (obj == btns[i]) {
							ftpC.doPut(file.getName());
							show_server_ls();
						}
					} else if (file.isDirectory()) {
						/*
						 * if (obj == btns[i]) { System.out.println(
						 * "cd를 수행한다. 이동할 폴더 = " + file.getName()); try { dir =
						 * new File(file.getCanonicalPath());
						 * LocalDir.setText(file.getCanonicalPath()); } catch
						 * (IOException e) { e.printStackTrace(); } fileList =
						 * dir.listFiles(); // 이동
						 * 
						 * show_local_ls(); validate(); repaint(); }
						 */
					}
				}

				for (int i = 0; i < content.length; i++) {
					String serverDir = content[i];

					if (content[i].substring(0, 1).equals("d")) {
						if (obj == btns2[i]) {

							String[] array;
							String tmp;

							array = serverDir.split(" ");
							tmp = array[array.length - 1].replace("\r", "");
							ftpC.doCd(tmp);
							System.out.println("서버에서 cd동작" + tmp + "  CWD : ");
							if (cnt > 0) {
								for (int j = 0; j < content.length; j++) {
									btns2[j].setVisible(false);
								}
								//System.out.println("두번째 ls 부터..." + content.length);
							}
							str = ftpC.doLs();
							if (str.equals("")) {
								System.out.println("폴더가 비어있음");
							} else {
								content = str.split("\n");
								btns2 = new JButton[content.length];

								for (int k = 0; k < content.length; k++) {

									if (content[k].substring(0, 1).equals("d")) { // 디렉토리
																					// 인
																					// 경우

										String serverFolder = content[k];
										btns2[k] = new JButton((serverFolder), FileIcon);
										btns2[k].setBackground(Color.white);
										btns2[k].setHorizontalAlignment(SwingConstants.LEFT);
										btns2[k].setRolloverIcon(FileIcon);
										btns2[k].setPreferredSize(new Dimension(550, 30));
										btns2[k].setMaximumSize(new Dimension(550, 30));
										btns2[k].addMouseListener(mouseR);
										j3.add(btns2[k]);

									} else if (content[k].substring(0, 1).equals("-")) { // 파일
																							// 인
																							// 경우

										String serverFile = content[k];
										btns2[k] = new JButton((serverFile), File2Icon);
										btns2[k].setBackground(Color.white);
										btns2[k].setRolloverIcon(File2Icon);
										btns2[k].setHorizontalAlignment(SwingConstants.LEFT);
										btns2[k].setPreferredSize(new Dimension(545, 30));
										btns2[k].setMaximumSize(new Dimension(545, 30));
										btns2[k].addMouseListener(mouseR);
										j4.add(btns2[k]);

									} else if (content[k].contains("<DIR>")) {// ftp.microsoft.com
																				// 에서
																				// 디렉토리인
																				// 경우

										String serverFolder = content[k];
										btns2[k] = new JButton((serverFolder), FileIcon);
										btns2[k].setBackground(Color.white);
										btns2[k].setHorizontalAlignment(SwingConstants.LEFT);
										btns2[k].setRolloverIcon(FileIcon);
										btns2[k].setPreferredSize(new Dimension(550, 30));
										btns2[k].setMaximumSize(new Dimension(550, 30));

										j3.add(btns2[k]);

									} else { // 이도 저도 아닌 경우 파일로 취급

										String serverFile = content[k];
										btns2[k] = new JButton((serverFile), File2Icon);
										btns2[k].setBackground(Color.white);
										btns2[k].setRolloverIcon(File2Icon);
										btns2[k].setHorizontalAlignment(SwingConstants.LEFT);
										btns2[k].setPreferredSize(new Dimension(545, 30));
										btns2[k].setMaximumSize(new Dimension(545, 30));
										btns2[k].addMouseListener(mouseR);
										j4.add(btns2[k]);

									}

								}
								cnt++;// 버튼 눌린 횟수

								validate();
								repaint();
							}
						}
					}
				}//for
				for (int i = 0; i < content.length; i++) {
					String serverFile = content[i];

					if (content[i].substring(0, 1).equals("-")) {
						if (obj == btns2[i]) {

							String[] array;
							String tmp;

							array = serverFile.split(" ");
							tmp = array[array.length - 1].replace("\r", "");
							ftpC.doGet(tmp);
						}
					}
				}//for
			} // 더블클릭했을때

			if (event.getButton() == 3) {
				for (int i = 0; i < content.length; i++) {
					String serverFile = content[i];

					if (content[i].substring(0, 1).equals("-")) {
						if (obj == btns2[i]) {

							String[] array;
							String tmp;

							array = serverFile.split(" ");
							tmp = array[array.length - 1].replace("\r", "");
							int n = JOptionPane.showConfirmDialog(
								    ServerPanel,
								    "정말로 삭제하시겠습니까?",
								    "확인",
								    JOptionPane.YES_NO_OPTION);
							if(n == 0){
								System.out.println("삭제");
								ftpC.deleteFile(tmp);
								show_server_ls();
							}
							else{
								System.out.println("취소");
							}

							//ftpC.doGet(tmp);
						}
					}
				}//for
			} // 왼쪽버튼 눌렸을때

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}
	}
}

class ListenThread extends Thread {

	public boolean running;

	String newline = "\n";
	ClientComponent client;
	BufferedReader ctrlInput = null;

	// constructor 읽고 처리하기 위한 상대방 지정
	public ListenThread(BufferedReader in, ClientComponent clientComponent) {
		ctrlInput = in;
		client = clientComponent;
		running = true;
	}

	public void run() {
		while (running) {
			try {
				client.setMSG(newline + ctrlInput.readLine());

			} catch (Exception e) {
				e.printStackTrace();
				System.exit(1);
			}
		} // while
	}

	public void init() throws IOException { // 초기화
		running = false;
	}
}