package basic;

public class MyDriverClassLoadingMain {

	public static void main(String[] args) throws Exception {
		/*
		 * MyDriver myDriver = new MyDriver(); //My DB�� ������ �߻�, Oracle, MYSQL, MSSQL.. �� ��ο� ��밡���� ���������� ��ü ���� ���?
		 */
		
		Class driverClass = Class.forName("basic.MyDriver");	//Ŭ���� �̸� ���ڿ��� ���ڷ�.. �ش� Ŭ�����̸��� ã�´�.
																//Oracle Driver ��ü�� �����ϰ� �����ϴ� ���� �������� �߻��ϱ� ������
																//���� ���� ������� (���ڿ���) Ŭ������ �����ϰ� �Ʒ����� ��ü�� �����Ѵ�.
		Object diriverClassObj = driverClass.newInstance();
		System.out.println("����̹���ü : "+diriverClassObj);
		
	}

}
