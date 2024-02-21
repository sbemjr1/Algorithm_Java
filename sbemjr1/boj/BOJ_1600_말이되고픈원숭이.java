package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1600_말이되고픈원숭이 {
	static int k,w,h, map[][],ans=Integer.MIN_VALUE;
	static int[] dr = {-1,1,0,0,-1,1,2,2,-1,1,-2,-2}; // 원숭이의 움직임
	static int[] dc = {0,0,-1,1,2,2,-1,1,-2,-2,-1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		k = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		
		map = new int[h][w];
		
		for (int r = 0; r < h; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < w; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		bfs();
		if (w == 1 && h == 1) {
			System.out.println(0);
		} else {
			System.out.println(ans == 0 ? -1 : ans);
		}
	}
	
	static class Point {
		int r;
		int c;
		int cnt;
		int t;
		
		public Point(int r, int c, int cnt, int t) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.t = t;
		}
	}

	private static void bfs() {
		Queue<Point> q = new ArrayDeque<>();
		q.add(new Point(0,0,0,0));
		boolean v[][][] = new boolean[h][w][k+1];
		v[0][0][0] = true;
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			if (p.r == h-1 && p.c == w-1) {
				ans = p.cnt;
				break;
			}
			for (int d = 0; d < 12; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];
				
				if(nr>=0&&nr<h&&nc>=0&&nc<w) {
					// 원숭이인 경우 상하좌우로 그냥 이동
					if (d <= 3) {
						if (map[nr][nc] == 0 && !v[nr][nc][p.t]) {
							v[nr][nc][p.t] = true;
							q.offer(new Point(nr,nc,p.cnt+1,p.t));
						}
					}
					if (d > 3) {
						if (map[nr][nc] == 0 && p.t < k && !v[nr][nc][p.t+1]) {
							v[nr][nc][p.t+1] = true;
							q.offer(new Point(nr,nc,p.cnt+1,p.t+1));
						}
					}
				}
			}
		}
	}
}
