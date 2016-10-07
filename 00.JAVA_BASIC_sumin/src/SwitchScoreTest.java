public class SwitchScoreTest 
{
	public static void main(String[] args) 
	{
		/*
		국어,영어,수학 점수를 가지고 
		총점,평균,평점(A,B,C....)을 출력하시요....
           - 100점이 넘는 수나 음수가 입력되면 메세지를 출력하세요
           - 평균은 소수점이하 2자리수까지만(반올림) 출력하세요
           - 출력포맷
			 
			 ************************
			 국어: 78
			 영어: 56
			 수학: 77
			 총점:256
			 평균:78.37
			 평점: C
			 ************************
		*/
		
		int kor,eng,math,total;
		double avg;
		char grade = 'A';
		kor=88;
		eng=76;
		math=30;
		
		if (kor<0 || kor >100){
			System.out.println("0~100 범위를 벗어났습니다.");
			return;
		}
		if (eng<0 || eng >100){
			System.out.println("0~100 범위를 벗어났습니다.");
			return;
		}
		if (math < 0 || math >100){
			System.out.println("0~100 범위를 벗어났습니다.");
			return;
		}
		
		
		total = kor + eng+ math;
		
		
		avg = total/3.0;
		avg = avg+0.005;
		avg = avg*100;
		avg = (int)avg;	//소숫점 자르기
		avg = avg/100;	//소수 2째 자리로 표현
	

		
		switch ((int)avg/10) {
		case 10:
		case 9:
			grade = 'A';
			break;
		case 8:
			grade = 'B';
			break;
		case 7:
			grade = 'C';
			break;
		case 6:
			grade = 'D';
			break;
		default:
			grade = 'F';
			break;
		}
		
		System.out.println("************************");
		System.out.println("국어: "+kor);
		System.out.println("영어: "+eng);
		System.out.println("수학: "+math);
		System.out.println("총점: "+total);
		System.out.println("평균: "+avg);
		System.out.println("평점: "+grade);
		System.out.println("************************");

		
	}
}

