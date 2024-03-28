import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_4485_젤다지_pq {
	static class Point implements Comparable<Point> {
		int r, c, w;

		public Point(int r, int c, int w) {
			super();
			this.r = r;
			this.c = c;
			this.w = w;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + ", w=" + w + "]";
		}

		@Override
		public int compareTo(Point o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.w, o.w);
		}
	}

	static int N;
	static int[][] map, minMap;
	static boolean[][] v;
	static PriorityQueue<Point> pq = new PriorityQueue<>();

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int cnt = 1;
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			if (N == 0) {
				break;
			}
			map = new int[N][N];
			minMap = new int[N][N];
			v = new boolean[N][N];

			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < N; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
					minMap[r][c] = Integer.MAX_VALUE;
				}
			}

			bfs();
			System.out.println("Problem " + cnt++ + ": " + minMap[N - 1][N - 1]);
		}
	}

	private static void bfs() {
		minMap[0][0] = map[0][0];
		pq.offer(new Point(0, 0, map[0][0]));

		while (!pq.isEmpty()) {
			Point p = pq.poll();
			int curR = p.r;
			int curC = p.c;
			int curW = p.w;

			if (v[curR][curC])
				continue;
			v[curR][curC] = true;

			for (int d = 0; d < 4; d++) {
				int nr = curR + dr[d];
				int nc = curC + dc[d];

				if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
					continue;
				}
				if (v[nr][nc]) {
					continue;
				}
				if (minMap[nr][nc] <= minMap[curR][curC] + map[nr][nc]) {
					continue;
				}

				minMap[nr][nc] = minMap[curR][curC] + map[nr][nc];
				pq.offer(new Point(nr, nc, minMap[nr][nc]));
			}
		}
	}

}
