package swea;

import java.util.Scanner;

public class 햄버거다이어트 {
	static int T, N, L, max; //테케, 재료 수, 제한 칼로리, 최대 점수
	static int arr[][];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			L = sc.nextInt();
			arr = new int[N][2];
			max = 0;
			
			for (int i = 0; i < N; i++) {
				arr[i][0] = sc.nextInt();
				arr[i][1] = sc.nextInt();
			}
			
			for (int i = N; i > 0; i--) {
				recursive(0,0,i,0,0);
			}
			
			System.out.println("#"+tc+" "+max);
		}
	}

	private static void recursive(int idx, int k, int stop, int score, int cal) {
		if (cal <= L && k == stop) {
			max = Math.max(max, score);
			return;
		}
		for (int i = idx; i < arr.length; i++) {
			recursive(i+1,k+1,stop,score+arr[i][0],cal+arr[i][1]);
		}
	}

}
