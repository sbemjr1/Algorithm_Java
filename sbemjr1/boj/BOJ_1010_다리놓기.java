package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1010_다리놓기 {
	static int T,N,M;
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		T = Integer.parseInt(st.nextToken());
		
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			int[][] B = new int[M+1][N+1];
			
			for (int i = 0; i <= M; i++) {
				for (int j = 0, end = Math.min(i, N); j <= end; ++j) { // 1C4 같은 경우 방지를 위해 min 사용
					if(j == 0 || j == i) {
						B[i][j] = 1; // 외곽 - 1인 경우
					} else {
						B[i][j] = B[i-1][j-1] + B[i-1][j]; // nCk = n-1Ck-1 + n-1Ck
					}
				}
			}
			
			System.out.println(B[M][N]);
		}
		
	}

}
