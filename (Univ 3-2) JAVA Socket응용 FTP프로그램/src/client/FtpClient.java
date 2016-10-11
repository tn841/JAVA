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

	public Socket ctrlSocket;// ����� ����

	public PrintWriter ctrlOutput;// ���� ��¿� ��Ʈ��
	public BufferedReader ctrlInput;// ���� �Է¿� ��Ʈ��

	Scanner sc = new Scanner(System.in);

	final int CTRLPORT = 21;// ftp ����� ��Ʈ

	// �ּҿ� ��Ʈ ��ȣ�κ��� ������ ����� ����� ��Ʈ���� �ۼ��Ѵ�.
	public FtpClient(String host) throws IOException, UnknownHostException {
		ctrlSocket = new Socket(host, CTRLPORT);
		ctrlOutput = new PrintWriter(ctrlSocket.getOutputStream());
		ctrlInput = new BufferedReader(new InputStreamReader(ctrlSocket.getInputStream()));
	}

	public void doLogin(String Id, String pw, String mode) {

		try {
			// USER ��ɿ� ���� �α���
			ctrlOutput.println("USER " + Id);
			ctrlOutput.flush();
			// PASS ��ɿ� ���� �н������� �Է�
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

	// doQuit �޼ҵ�
	// ftp �����κ��� �α� �ƿ��Ѵ�
	public void doQuit() {

		ctrlOutput.println("QUIT");// QUIT ����� �۽�
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

	public void changeFileName(String before, String after) { // ���� �̸� ����
		ctrlOutput.println("RNFR " + before);// ���� �� ���� �̸�
		ctrlOutput.flush();
		ctrlOutput.println("RNTO " + after); // ���� �� ���� �̸�
		ctrlOutput.flush();
	}

	public void deleteFile(String filename) { // ���� ����
		ctrlOutput.println("DELE " + filename);
		ctrlOutput.flush();

	}

	public void mkdir(String directory) { // ���丮 ����
		ctrlOutput.println("MKD " + directory); // ������ ���丮 �̸�
		ctrlOutput.flush();
	}

	public String nowPosition() { // PWD���, �� �������� ���� ��ġ ��ȯ
		String str = null;
		try {
			int n;

			byte[] buff = new byte[1024];
			// �����Ϳ� ����(connection)�� �����.
			Socket dataSocket = dataConnection("pwd");
			// �����͸� �о� ó���ϴ� ��Ʈ���� ����Ѵ�.
			BufferedInputStream dataInput = new BufferedInputStream(dataSocket.getInputStream());
			// ���丮 ������ �а� ó���Ѵ�.
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

	public void removeDir(String dir) { // ���丮 ����
		ctrlOutput.println("RMD " + dir);
		ctrlOutput.flush();

	}

	// doCd �޼ҵ�
	// ���丮�� �����Ѵ�.
	public void doCd(String path) {
		try {
			ctrlOutput.println("CWD " + path);
			ctrlOutput.flush();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	// doLs �޼ҵ�
	// ���丮 ������ ��´�.
	public String doLs() {
		String str = null;
		try {
			int n;

			byte[] buff = new byte[1024];
			// �����Ϳ� ����(connection)�� �����.
			Socket dataSocket = dataConnection("LIST");
			// �����͸� �о� ó���ϴ� ��Ʈ���� ����Ѵ�.
			BufferedInputStream dataInput = new BufferedInputStream(dataSocket.getInputStream());
			// ���丮 ������ �а� ó���Ѵ�.
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

	// dataConnection �޼ҵ�
	// �������� ������ ��ȯ�� ������ �����.
	// ����, �������� port ������� ��Ʈ�� �˸���.
	public Socket dataConnection(String ctrlcmd) {
		String cmd = "PORT "; // PORT ������� �۽��� ������ ���� ����
		int i;
		Socket dataSocket = null;// ������ ���ۿ� ����
		try {
			byte[] address = InetAddress.getLocalHost().getAddress(); // �ڽ��� �ּҸ�
																		// ��´�.

			ServerSocket serverDataSocket = new ServerSocket(0, 1);// �ڵ����� ��Ʈ
																	// ��ȣ�� �����ϰ�
																	// ���� ������
																	// �����.

			for (i = 0; i < 4; ++i) { // PORT ��ɿ��� �۽� �����͸� �̿��Ѵ�.
				cmd = cmd + (address[i] & 0xff) + ",";
			}
			cmd = cmd + (((serverDataSocket.getLocalPort()) / 256) & 0xff) + ","
					+ (serverDataSocket.getLocalPort() & 0xff);
			// PORT ����� ����� ��Ʈ���� ���� �����Ѵ�.
			ctrlOutput.println(cmd);
			ctrlOutput.flush();
			// ó�� ��� ��� (LIST, RETR, STOR)�� ������ ������.
			ctrlOutput.println(ctrlcmd);
			ctrlOutput.flush();
			// �����κ��� ������ �޴´�.
			dataSocket = serverDataSocket.accept();
			serverDataSocket.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
		return dataSocket;
	}

	// doAscii �޼ҵ�
	// �ؽ�Ʈ ���� ���� �����Ѵ�.
	public void doAscii() {
		try {
			ctrlOutput.println("TYPE A");// A ���
			ctrlOutput.flush();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	// doBinary �޼ҵ�
	// ���� ���� ���� �����Ѵ�.
	public void doBinary() {
		try {
			ctrlOutput.println("TYPE I");// I ���
			ctrlOutput.flush();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	// doGet �޼ҵ�
	// �������� ������ �����´�.
	public void doGet(String fileName) {

		try {
			int n;
			byte[] buff = new byte[1024];

			FileOutputStream outfile = new FileOutputStream(fileName);
			// ���� ���ۿ� ������ ��Ʈ���� �ۼ��Ѵ�.
			Socket dataSocket = dataConnection("RETR " + fileName);
			BufferedInputStream dataInput = new BufferedInputStream(dataSocket.getInputStream());
			// �����κ��� �����͸� �޾� ���Ϸ� �����Ѵ�.
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

	// doPut �޼ҵ�
	// ������ ������ �����Ѵ�.

	public void doPut(String fileName) {

		try {
			int n;
			byte[] buff = new byte[1024];
			FileInputStream sendfile = null;
			try {
				sendfile = new FileInputStream(fileName);
			} catch (Exception e) {
				System.out.println("���� ���� ����");
				return;
			}

			if (fileName.contains("\\")) {
				fileName = fileName.substring(fileName.lastIndexOf("\\"), fileName.length());
			} else {// ��� ��� �� ��, �ٷ� ��� ����
			}
			System.out.println(fileName);

			Socket dataSocket = dataConnection("STOR " + fileName);
			OutputStream outstr = dataSocket.getOutputStream();
			// ������ �о� ��Ʈ��ũ�� �����Ͽ� ������ ������.
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
