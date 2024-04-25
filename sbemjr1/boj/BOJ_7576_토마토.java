import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7576_토마토 {
	static int R, C, cnt;
	static int[][] map;
	static Queue<Point> q;

	static class Point {
		int r, c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		map = new int[R][C];
		q = new ArrayDeque<>();

		for (int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < C; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if (map[r][c] == 0) {
					cnt++;
				}
				if (map[r][c] == 1) {
					q.offer(new Point(r, c));
				}
			}
		}
		int ans = 0;
		while (true) {
			int size = q.size();
			
			if (cnt == 0) {
				break;
			}
			if (q.isEmpty()) {
				ans = -1;
				break;
			}

			for (int i = 0; i < size; i++) {
				Point p = q.poll();
				int r = p.r;
				int c = p.c;

				for (int d = 0; d < 4; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					
					if (nr<0||nr>=R||nc<0||nc>=C) {
						continue;
					}
					if (map[nr][nc] != 0) {
						continue;
					}
					
					map[nr][nc] = 1;
					cnt--;
					q.offer(new Point(nr, nc));
				}
			}
			ans++;
		}
		System.out.println(ans);
	}

}
