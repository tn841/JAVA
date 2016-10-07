package com.itwill04.student.array;

public class PrimitiveArrayMain {

	public static void main(String[] args) {
		int[] noArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		String[] nameArray = { "KIM", "KANG", "LEE", "SIM", "PARK", "KOO", "JIM", "DIM", "PIM", "AIM" };
		int[] korArray = { 34, 56, 23, 89, 12, 45, 65, 34, 56, 23 };
		int[] engArray = { 78, 45, 88, 78, 90, 23, 56, 55, 30, 89 };
		int[] mathArray = { 74, 46, 86, 38, 80, 43, 26, 95, 20, 19 };
		int[] totArray = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		double[] avgArray = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		char[] gradeArray = { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' };
		int[] rankArray = { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
		/*
		 * 1. 총점.평균.평점.석차
		 */
		
		// 총점
		for (int i = 0; i < noArray.length; i++) {
			totArray[i] = korArray[i] + engArray[i] + mathArray[i];
		}
		// 평균
		for (int i = 0; i < noArray.length; i++) {
			avgArray[i] = (double) totArray[i] / 3.0;
			avgArray[i] = (int) ((avgArray[i] * 100) + 0.5) / 100.0;

		}
		// 학점
		for (int i = 0; i < noArray.length; i++) {
			if (avgArray[i] >= 65) {
				gradeArray[i] = 'A';
			} else if (avgArray[i] >= 55) {
				gradeArray[i] = 'B';
			} else if (avgArray[i] >= 50) {
				gradeArray[i] = 'C';
			} else if (avgArray[i] >= 45) {
				gradeArray[i] = 'D';
			} else {
				gradeArray[i] = 'F';
			}
		}

		// 석차
		for (int i = 0; i < noArray.length; i++) {
			for (int j = 0; j < noArray.length; j++) {
				if (totArray[j] > totArray[i]) {
					rankArray[i]++;
				}
			}
		}
		//석차 출력
		for (int i = 0; i < mathArray.length; i++) {
			for (int j = 0; j < mathArray.length - 1; j++) {
				if (rankArray[j] > rankArray[j + 1]) {
					int rankTemp = rankArray[j];
					rankArray[j] = rankArray[j + 1];
					rankArray[j + 1] = rankTemp;
					
					int noTemp = noArray[j];
					noArray[j] = noArray[j + 1];
					noArray[j + 1] = noTemp;
					
					String nameTemp = nameArray[j];
					nameArray[j] = nameArray[j + 1];
					nameArray[j + 1] = nameTemp;
					
					int korTemp = korArray[j];
					korArray[j] = korArray[j + 1];
					korArray[j + 1] = korTemp;
					
					int engTemp = engArray[j];
					engArray[j] = engArray[j + 1];
					engArray[j + 1] = engTemp;
					
					int mathTemp = mathArray[j];
					mathArray[j] = mathArray[j + 1];
					mathArray[j + 1] = mathTemp;

					int totTemp = totArray[j];
					totArray[j] = totArray[j + 1];
					totArray[j + 1] = totTemp;

					double avgTemp = avgArray[j];
					avgArray[j] = avgArray[j + 1];
					avgArray[j + 1] = avgTemp;
					
					char gradeTemp = gradeArray[j];
					gradeArray[j] = gradeArray[j + 1];
					gradeArray[j + 1] = gradeTemp;
					
				}
			}
		}
		
		System.out.println("번호\t이름\t국어\t영어\t수학\t총점\t평균\t학점\t석차");
		for (int i = 0; i < noArray.length; i++) {
			System.out.print(noArray[i] + "\t");
			System.out.print(nameArray[i] + "\t");
			System.out.print(korArray[i] + "\t");
			System.out.print(engArray[i] + "\t");
			System.out.print(mathArray[i] + "\t");
			System.out.print(totArray[i] + "\t");
			System.out.print(avgArray[i] + "\t");
			System.out.print(gradeArray[i] + "\t");
			System.out.print(rankArray[i] + "등");
			System.out.println();
		}
	}
}
