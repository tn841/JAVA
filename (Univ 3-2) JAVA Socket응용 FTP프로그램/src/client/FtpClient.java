package client;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class FtpClient {

	// ClientComponent client;

	public Socket ctrlSocket;// 제어용 소켓

	public PrintWriter ctrlOutput;// 제어 출력용 스트림
	public BufferedReader ctrlInput;// 제어 입력용 스트림

	Scanner sc = new Scanner(System.in);

	final int CTRLPORT = 21;// ftp 제어용 포트

	// 주소와 포트 번호로부터 소켓을 만들고 제어용 스트림을 작성한다.
	public FtpClient(String host) throws IOException, UnknownHostException {
		ctrlSocket = new Socket(host, CTRLPORT);
		ctrlOutput = new PrintWriter(ctrlSocket.getOutputStream());
		ctrlInput = new BufferedReader(new InputStreamReader(ctrlSocket.getInputStream()));
	}

	public void doLogin(String Id, String pw, String mode) {

		try {
			// USER 명령에 의한 로그인
			ctrlOutput.println("USER " + Id);
			ctrlOutput.flush();
			// PASS 명령에 의한 패스워드의 입력
			ctrlOutput.println("PASS " + pw);
			ctrlOutput.flush();

			if (mode.equals("P")) {
				ctrlOutput.println("PASV"); // passive mode
				ctrlOutput.flush();

			} else {
				System.out.println("active mode!");
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	// doQuit 메소드
	// ftp 서버로부터 로그 아웃한다
	public void doQuit() {

		ctrlOutput.println("QUIT");// QUIT 명령의 송신
		ctrlOutput.flush();
	}
	
	public void doCDUP() {
		ctrlOutput.println("CDUP");// CDUP
		ctrlOutput.flush();
	}

	public void init() throws IOException {
		ctrlInput.close();
		ctrlOutput.close();
		ctrlSocket.close();
	}

	public void changeFileName(String before, String after) { // 파일 이름 변경
		ctrlOutput.println("RNFR " + before);// 변경 전 파일 이름
		ctrlOutput.flush();
		ctrlOutput.println("RNTO " + after); // 변경 후 파일 이름
		ctrlOutput.flush();
	}

	public void deleteFile(String filename) { // 파일 삭제
		ctrlOutput.println("DELE " + filename);
		ctrlOutput.flush();

	}

	public void mkdir(String directory) { // 디렉토리 생성
		ctrlOutput.println("MKD " + directory); // 생성할 디렉토리 이름
		ctrlOutput.flush();
	}

	public String nowPosition() { // PWD명령, 즉 서버에서 현재 위치 반환
		String str = null;
		try {
			int n;

			byte[] buff = new byte[1024];
			// 데이터용 연결(connection)을 만든다.
			Socket dataSocket = dataConnection("pwd");
			// 데이터를 읽어 처리하는 스트림을 사용한다.
			BufferedInputStream dataInput = new BufferedInputStream(dataSocket.getInputStream());
			// 디렉토리 정보를 읽고 처리한다.
			while ((n = dataInput.read(buff)) > 0) {
				str = new String(buff, 0, n);
			}
			dataSocket.close();

		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
		return str;
	}

	public void removeDir(String dir) { // 디렉토리 삭제
		ctrlOutput.println("RMD " + dir);
		ctrlOutput.flush();

	}

	// doCd 메소드
	// 디렉토리를 변경한다.
	public void doCd(String path) {
		try {
			ctrlOutput.println("CWD " + path);
			ctrlOutput.flush();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	// doLs 메소드
	// 디렉토리 정보를 얻는다.
	public String doLs() {
		String str = null;
		try {
			int n;

			byte[] buff = new byte[1024];
			// 데이터용 연결(connection)을 만든다.
			Socket dataSocket = dataConnection("LIST");
			// 데이터를 읽어 처리하는 스트림을 사용한다.
			BufferedInputStream dataInput = new BufferedInputStream(dataSocket.getInputStream());
			// 디렉토리 정보를 읽고 처리한다.
			while ((n = dataInput.read(buff)) > 0) {
				str = new String(buff, 0, n);
			}
			dataSocket.close();

		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
		return str;
	}

	// dataConnection 메소드
	// 서버와의 데이터 교환용 소켓을 만든다.
	// 또한, 서버에게 port 명령으로 포트를 알린다.
	public Socket dataConnection(String ctrlcmd) {
		String cmd = "PORT "; // PORT 명령으로 송신할 데이터 저장 변수
		int i;
		Socket dataSocket = null;// 데이터 전송용 소켓
		try {
			byte[] address = InetAddress.getLocalHost().getAddress(); // 자신의 주소를
																		// 얻는다.

			ServerSocket serverDataSocket = new ServerSocket(0, 1);// 자동으로 포트
																	// 번호를 생성하고
																	// 서버 소켓을
																	// 만든다.

			for (i = 0; i < 4; ++i) { // PORT 명령용의 송신 데이터를 이용한다.
				cmd = cmd + (address[i] & 0xff) + ",";
			}
			cmd = cmd + (((serverDataSocket.getLocalPort()) / 256) & 0xff) + ","
					+ (serverDataSocket.getLocalPort() & 0xff);
			// PORT 명령을 제어용 스트림을 통해 전송한다.
			ctrlOutput.println(cmd);
			ctrlOutput.flush();
			// 처리 대상 명령 (LIST, RETR, STOR)을 서버로 보낸다.
			ctrlOutput.println(ctrlcmd);
			ctrlOutput.flush();
			// 서버로부터 접속을 받는다.
			dataSocket = serverDataSocket.accept();
			serverDataSocket.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
		return dataSocket;
	}

	// doAscii 메소드
	// 텍스트 전송 모드로 셋팅한다.
	public void doAscii() {
		try {
			ctrlOutput.println("TYPE A");// A 모드
			ctrlOutput.flush();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	// doBinary 메소드
	// 이진 전송 모드로 셋팅한다.
	public void doBinary() {
		try {
			ctrlOutput.println("TYPE I");// I 모드
			ctrlOutput.flush();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	// doGet 메소드
	// 서버상의 파일을 가져온다.
	public void doGet(String fileName) {

		try {
			int n;
			byte[] buff = new byte[1024];

			FileOutputStream outfile = new FileOutputStream(fileName);
			// 파일 전송용 데이터 스트림을 작성한다.
			Socket dataSocket = dataConnection("RETR " + fileName);
			BufferedInputStream dataInput = new BufferedInputStream(dataSocket.getInputStream());
			// 서버로부터 데이터를 받아 파일로 저장한다.
			while ((n = dataInput.read(buff)) > 0) {
				outfile.write(buff, 0, n);
			}
			dataSocket.close();
			outfile.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	// doPut 메소드
	// 서버에 파일을 전송한다.

	public void doPut(String fileName) {

		try {
			int n;
			byte[] buff = new byte[1024];
			FileInputStream sendfile = null;
			try {
				sendfile = new FileInputStream(fileName);
			} catch (Exception e) {
				System.out.println("파일 전송 실패");
				return;
			}

			if (fileName.contains("\\")) {
				fileName = fileName.substring(fileName.lastIndexOf("\\"), fileName.length());
			} else {// 상대 경로 일 때, 바로 출력 가능
			}
			System.out.println(fileName);

			Socket dataSocket = dataConnection("STOR " + fileName);
			OutputStream outstr = dataSocket.getOutputStream();
			// 파일을 읽어 네트워크를 경유하여 서버로 보낸다.
			while ((n = sendfile.read(buff)) > 0) {
				outstr.write(buff, 0, n);
			}
			dataSocket.close();
			sendfile.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
}
