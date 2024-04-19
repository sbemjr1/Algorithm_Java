import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1012_유기농배추 {
	static int T, R, C, K;
	static int[][] map;

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		T = Integer.parseInt(st.nextToken());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());

			C = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			map = new int[R][C];

			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());

				int c = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());

				map[r][c] = 1;
			}
			
			int ans = 0;
			for (int r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {
					if (map[r][c] == 1) {
						bfs(r, c);
						ans++;
					}
				}
			}
			
			System.out.println(ans);
		}
	}

	static class Point {
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + "]";
		}
	}

	private static void bfs(int sr, int sc) {
		Queue<Point> q = new ArrayDeque<>();
		q.offer(new Point(sr, sc));
		map[sr][sc] = 2;

		while (!q.isEmpty()) {
			Point cur = q.poll();
			int r = cur.r;
			int c = cur.c;

			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];

				if (nr < 0 || nr >= R || nc < 0 || nc >= C) {
					continue;
				}
				if (map[nr][nc] != 1) {
					continue;
				}
				q.offer(new Point(nr, nc));
				map[nr][nc] = 2;
			}
		}
	}

}
