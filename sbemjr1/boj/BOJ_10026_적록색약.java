package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_10026_적록색약 {
	static int N, ans;
	static Character[][] map;
	static boolean[][] v;
	
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
  
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		map = new Character[N][N];
		v = new boolean[N][N];
		
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			for (int c = 0; c < N; c++) {
				map[r][c] = str.charAt(c);
			}
		}
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (!v[r][c]) {
					normalBFS(r,c);
					ans++;
				}
			}
		}
		System.out.print(ans+" ");

		v = new boolean[N][N];
		ans = 0;
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (!v[r][c]) {
					specialBFS(r,c);
					ans++;
				}
			}
		}
		
		System.out.print(ans);
	}
	
	private static void specialBFS(int r, int c) {
		Queue<Point> q = new ArrayDeque<>();
		q.add(new Point(map[r][c],r,c));
		v[r][c] = true;
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			Character color = p.color;
			int nowR = p.r;
			int nowC = p.c;
			
			// 붉은 색 또는 초록 색 일때
			if (color == 'R' || color == 'G') {
				for (int d = 0; d < 4; d++) {
					int nextR = nowR + dr[d];
					int nextC = nowC + dc[d];
					
					if (nextR >= 0 && nextR < N && nextC >= 0 && nextC < N && (map[nextR][nextC] == 'R' || map[nextR][nextC] == 'G') && !v[nextR][nextC]) {
						v[nextR][nextC] = true;
						q.add(new Point(color, nextR, nextC));
					}
				}
			} else {
				for (int d = 0; d < 4; d++) {
					int nextR = nowR + dr[d];
					int nextC = nowC + dc[d];
					
					if (nextR >= 0 && nextR < N && nextC >= 0 && nextC < N && map[nextR][nextC] == color && !v[nextR][nextC]) {
						v[nextR][nextC] = true;
						q.add(new Point(color, nextR, nextC));
					}
				}
			}
		}
	}

	private static void normalBFS(int r, int c) {
		Queue<Point> q = new ArrayDeque<>();
		q.add(new Point(map[r][c],r,c));
		v[r][c] = true;
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			Character color = p.color;
			int nowR = p.r;
			int nowC = p.c;
			
			for (int d = 0; d < 4; d++) {
				int nextR = nowR + dr[d];
				int nextC = nowC + dc[d];
				
				if (nextR >= 0 && nextR < N && nextC >= 0 && nextC < N && map[nextR][nextC] == color && !v[nextR][nextC]) {
					v[nextR][nextC] = true;
					q.add(new Point(color, nextR, nextC));
				}
			}
		}
	}
	


	static class Point {
		Character color;
		int r;
		int c;
		
		public Point(Character color, int r, int c) {
			this.color = color;
			this.r = r;
			this.c = c;
		}
	}
}
