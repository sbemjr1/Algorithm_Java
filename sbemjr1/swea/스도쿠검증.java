package swea;

import java.util.Scanner;

public class 스도쿠검증 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			int[][] arr = new int[9][9];
			int ans = 1;
			
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					for (int r = 0; r < 9; r++) {
						if (j != r && arr[i][r] == arr[i][j]) {
							ans = 0;
						}
					}
					for (int r = 0; r < 9; r++) {
						if (i != r && arr[r][j] == arr[i][j]) {
							ans = 0;
						}
					}
				}
			}
			for (int i = 0; i < 9; i+=3) {
				for (int j = 0; j < 9; j+=3) {
					for (int r = 0; r < 3; r++) {
						for (int c = 0; c < 3; c++) {
							if (i+r != i && j+c != j && arr[i+r][j+c] == arr[i][j]) {
								ans = 0;
							}
						}
					}
				}
			}
			
			System.out.println("#" + tc + " " + ans);
		}
	}
}