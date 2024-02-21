package boj;

import java.util.Scanner;

public class 색종이 {
	static int N, ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		int[][] arr = new int[100][100];
		
		ans = 0;
		
		for (int i = 0; i < N; i++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			for (int j = r; j < r+10; j++) {
				for (int k = c; k < c+10; k++) {
					if (arr[j][k] == 0) {
						arr[j][k] = 1;
						ans += 1;
					}
				}
			}
		}
		
		System.out.println(ans);
	}
}
	