package swea;

import java.util.Scanner;

public class 햄버거다이어트_부분집합 {
	static int T, N, L, max; //테케, 재료 수, 제한 칼로리, 최대 점수
	static int arr[][];
	static boolean isSelected[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			L = sc.nextInt();
			arr = new int[N][2];
			isSelected = new boolean[N];
			max = 0;
			
			for (int i = 0; i < N; i++) {
				arr[i][0] = sc.nextInt();
				arr[i][1] = sc.nextInt();
			}
			
			recursive(0,0,0);
			
			System.out.println("#"+tc+" "+max);
		}
	}

	private static void recursive(int idx, int score, int cal) {
		if (idx == N) {
			if (cal <= L) {
				max = Math.max(max, score);
			}
			return;
		}

		isSelected[idx] = true;
		recursive(idx+1, score+arr[idx][0], cal+arr[idx][1]);
		isSelected[idx] = false;
		recursive(idx+1, score, cal);
	}

}
