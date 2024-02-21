package swea;

import java.util.Scanner;

public class 정사각형방 {
	static int[][] map;
	static boolean[][] v;
	static int T, N, cnt;
	static long val;
	static long Ans;
	static int [] dr = {0,1,0,-1};
	static int [] dc = {1,0,-1,0};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			val=Integer.MAX_VALUE;
			Ans=Integer.MIN_VALUE;
			
			map = new int[N][N];
			v = new boolean[N][N];
			
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					map[r][c] = sc.nextInt();
				}
			}
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					v[r][c] = true;
					dfs(r,c,1);
					v[r][c] = false;
				}
			}
			System.out.println("#"+tc+" "+val+" "+Ans);
		}
	}

	private static void dfs(int r, int c, int cnt) {
		// basis part
		
		// inductive
		for(int d =0;d<4;d++){
			int nr = r + dr[d];
			int nc = c + dc[d];
			// 지도경계
			if(nr>=0&nr<N&&nc>=0&&nc<N&&!v[nr][nc]&&map[nr][nc]-map[r][c]==1) {
				v[nr][nc] = true;
				dfs(nr,nc,cnt+1);
				v[nr][nc] = false;
			}
		}
		if (Ans < cnt) {
			Ans = cnt;
			val = map[r][c]-cnt+1;
		} else if (Ans == cnt) {
			val = val < map[r][c]-cnt+1 ? val : map[r][c]-cnt+1;
		}
	}

}
