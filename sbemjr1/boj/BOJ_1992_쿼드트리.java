package boj;

import java.util.Scanner;

public class BOJ_1992_쿼드트리 {
	static int N, l, map[][];
	static String ans = "";
	static boolean flag;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		
		for (int r = 0; r < N; r++) {
			String str = sc.next();
			for (int c = 0; c < N; c++) {
				map[r][c] = str.charAt(c) - '0';
			}
		}

		recursive(0,0,N);
		
		System.out.println(ans);
	}

	private static void recursive(int r, int c, int leng) {
		flag = false;
		
		for (int i = r; i < r + leng; i++) {
			for (int j = c; j <c + leng; j++) {
				if (map[r][c] != map[i][j]) {
					flag = true;
				}
			}
		}
		if (flag) {
			ans += "(";
			recursive(r,c,leng/2);
			recursive(r,c+leng/2,leng/2);
			recursive(r+leng/2,c,leng/2);
			recursive(r+leng/2,c+leng/2,leng/2);
			ans += ")";
		} else {
			ans += map[r][c];
		}
		
	}

}
