package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2206_벽부수고이동하기 {
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
	}
	
	static class Point {
		int r,c,cnt,puk;

		public Point(int r, int c, int cnt, int puk) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.puk = puk;
		}
	}

	private static void bfs() {
		Queue<Point> q = new ArrayDeque<>();
		q.offer(new Point(1,1,1,0));
		boolean[][][] v = new boolean[n+1][m+1][2]; // [][] 현재 위치 [] 부수고 왔는지 유무
		v[1][1][0] = true; // 안 부심
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			if(p.r == n && p.c == m) {
				//몇칸 만에 왔는지 ans에 저장
				ans = p.cnt;
				break; // 가장 먼저 도착하면 최단 거리 이므로 break 해도 됨
			}
			for (int d = 0; d < 4; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];
				
				if (nr >= 1 && nr <=n && nc >= 1 && nc <=m) {
					// 길인 경우
					// 그냥 간다
					if (map[nr][nc] == 0 && !v[nr][nc][p.puk]) {
						v[nr][nc][p.puk] = true;
						q.add(new Point(nr,nc,p.cnt+1,p.puk));
					}
					// 벽인 경우
					// 부신 적이 없다면 부셔
					if (map[nr][nc] == 1 && p.puk == 0) {
						v[nr][nc][1] = true;
						q.add(new Point(nr,nc,p.cnt+1,1));
					}
				}
			}
		}
		System.out.println(ans == 0 ? -1 : ans);
	}

}
