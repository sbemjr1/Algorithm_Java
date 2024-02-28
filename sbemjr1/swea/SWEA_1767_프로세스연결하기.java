package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1767_프로세스연결하기 {
	static int T,N;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		T = Integer.parseInt(st.nextToken());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			map = new int[N+2][N+2];
			
			for (int r = 1; r <= N; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 1; c <= N; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i <= N+1; i++) { // 파워 영역 생성
				map[0][i] = 7;
				map[i][0] = 7;
				map[N+1][i] = 7;
				map[i][N+1] = 7;
			}
			
			for (int r = 0; r <= N+1; r++) {
				for (int c = 0; c <= N+1; c++) {
					System.out.print(map[r][c]+" ");
				}
				System.out.println();
			}
		}
		
	}

}
