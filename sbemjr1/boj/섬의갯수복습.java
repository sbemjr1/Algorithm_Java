package boj;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class 섬의갯수복습 {
	static int w,h,map[][],ans;
	static boolean v[][];
	static int[] dr = {-1,-1,-1,0,1,1,1,0};
	static int[] dc = {-1,0,1,1,1,0,-1,-1};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			w = sc.nextInt();
			h = sc.nextInt();
			map = new int[h][w];
			v = new boolean[h][w];
			ans = 0;
			
			if (w == 0 && h == 0) {
				break;
			}
			
			for (int r = 0; r < h; r++) {
				for (int c = 0; c < w; c++) {
					map[r][c] = sc.nextInt();
				}
			}
			
			for (int r = 0; r < h; r++) {
				for (int c = 0; c < w; c++) {
					if (map[r][c] == 1 && !v[r][c]) {
//						dfs(r,c);
						v[r][c] = true;
						bfs(r,c);
						ans++;
					}
				}
			}
			System.out.println(ans);
		}
	}

	private static void bfs(int r, int c) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {r,c});
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int nowR = now[0];
			int nowC = now[1];
			
			for (int i = 0; i < 8; i++) {
				int nextR = nowR + dr[i];
				int nextC = nowC + dc[i];
				
				if (nextR < 0 || nextC < 0 || nextR >= h || nextC >= w) {
					continue;
				}
				if (v[nextR][nextC] || map[nextR][nextC] == 0) {
					continue;
				}
				
				q.add(new int[] {nextR, nextC});
        		v[nextR][nextC] = true;
			}
		}
	}

	private static void dfs(int r, int c) {
		for (int d = 0; d < 8; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if (nr>=0&&nr<h&&nc>=0&&nc<w&&map[nr][nc]==1&&!v[nr][nc]) {
				v[nr][nc] = true;
				dfs(nr,nc);
			}
		}
	}

}
