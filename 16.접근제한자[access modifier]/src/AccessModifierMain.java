import korea.prince.YSChild;

/*
 * Ŭ���� �Ǵ� ����� ������ �����ϴ� ������
 * 	1. Ŭ������ ���� ����
 * 	2. Ŭ������ ���(����, �޼ҵ�)�� ���� ����
 * 	3. ����������(public, protected, (package), private)
 * 		- public : �ܺ� ��� Ŭ����(��ü)���� ���ٰ���\
 * 
 * 		- protected : ���� ��Ű���� �ִ� ��� Ŭ����(��ü)���� ���� ����
 * 					  �ٸ� ��Ű���� �ִ� ��Ӱ��迡 �ִ� �ڽ�Ŭ����(��ü)���� ���� ����
 * 
 * 		- (package) : ���� ��Ű���� �ִ� ���Ŭ����(��ü)���� ���� ����
 * 					  �ٸ� ��Ű���� �ִ� ��� Ŭ�������� ���� �Ұ���
 *  
 * 		- private : �ܺ� ��� Ŭ����(��ü)���� ���� �Ұ���
 */
public class AccessModifierMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		YSChild yC = new YSChild();
		yC.access();
		
		//yC.b(); //������ ���� �ʴ´�. why? -> ��Ű���� �ٸ��� ����
	}

}
