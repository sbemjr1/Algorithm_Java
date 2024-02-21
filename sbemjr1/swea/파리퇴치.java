package swea;

import java.util.Scanner;
import java.io.FileInputStream;

public class 파리퇴치 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[][] arr = new int[N][N];
			
			int sum = 0;
			int max = 0;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			for (int i = 0; i <= N - M; i++) {
				for (int j = 0; j <= N - M; j++) {
					for (int r = 0; r < M; r++) {
						for (int c = 0; c < M; c++) {
							sum += arr[i+r][j+c];
						}
					}
					max = Math.max(max, sum);
					sum = 0;
				}
			}
			
			System.out.println("#" + tc + " " + max);
		}
	}
}