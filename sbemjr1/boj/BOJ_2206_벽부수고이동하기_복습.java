package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2206_벽부수고이동하기_복습 {
	static int n, m, ans;
	static int map[][];
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n+1][m+1];
		
		for (int r = 1; r <= n; r++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			for (int c = 1; c <= m; c++) {
				map[r][c] = str.charAt(c-1) - '0';
			}
		}
		
		bfs();
		System.out.println(ans == 0 ? -1 : ans);
	}
	
	static class Point {
		int r;
		int c;
		int cnt;
		int destroy;
		
		public Point(int r, int c, int cnt, int destroy) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.destroy = destroy;
		}
		
	}

	private static void bfs() {
		Queue<Point> q = new ArrayDeque<>();
		q.add(new Point(1,1,1,0));
		boolean v[][][] = new boolean[n+1][m+1][2];
		v[1][1][0] = true;
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			if (p.r == n && p.c == m) {
				ans = p.cnt;
				break;
			}
			for (int d = 0; d < 4; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];
				
				if (nr >= 1 && nr <= n && nc <= m && nc >= 1) {
					if(map[nr][nc] == 0 && !v[nr][nc][p.destroy]) {
						v[nr][nc][p.destroy] = true;
						q.add(new Point(nr, nc, p.cnt+1, p.destroy));
					}
					if(map[nr][nc] == 1 && p.destroy == 0) {
						v[nr][nc][1] = true;
						q.add(new Point(nr, nc, p.cnt+1, 1));
					}
				}
			}
		}
	}

}
