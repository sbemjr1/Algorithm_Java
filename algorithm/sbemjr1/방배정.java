package sbemjr1;

import java.util.Arrays;
import java.util.Scanner;

public class 방배정 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[][] arr = new int[2][6]; // 기본 배열 생성
		
		int room = 0;
		
		for (int i = 0; i < N; i++) {
			int S = sc.nextInt();
			int Y = sc.nextInt();
			
			if (S == 0) { // 성별에 따라 0,1로 구별
				arr[0][Y-1] += 1; //인덱스를 이용해 학년별 학생수 기록
			} else {
				arr[1][Y-1] += 1;
			}
		}
		
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 6; j++) {
				if (arr[i][j] > K) {
					if (arr[i][j] % K == 0) {
						room += arr[i][j] / K; // 반올림 구현 ..
					} else {
						room += arr[i][j] / K;
						room += 1;
					}
				} else if (arr[i][j] > 0) {
					room += 1; // 0이상이고 K이하이면 방 한개 추가
				}
			}
		}
		
//		System.out.println(Arrays.toString(arr[0]));
//		System.out.println(Arrays.toString(arr[1]));
		System.out.println(room);
	}
}
