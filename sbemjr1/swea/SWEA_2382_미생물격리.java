package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA_2382_미생물격리 {
	static int T, N, M, K;
	static Point[][][] map;

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static class Point {
		int w, dir;

		public Point(int w, int dir) {
			this.w = w;
			this.dir = dir;
		}
	}

	static class MoveInfo {
		int r, c;

		public MoveInfo(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		T = Integer.parseInt(st.nextToken());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			map = new Point[N][N][2];

			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken()) - 1;

				map[r][c][0] = new Point(w, dir);
			}

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (map[r][c][0] == null) {
						map[r][c][0] = new Point(0, -1);
					}
					map[r][c][1] = new Point(0, -1);
				}
			}

			for (int i = 0; i < M; i++) {
				ArrayList<MoveInfo> list = new ArrayList<>();
				for (int r = 0; r < N; r++) {
					for (int c = 0; c < N; c++) {
						Point curPoint = map[r][c][i % 2];
						if (curPoint.w > 0) {
							int nr = r + dr[curPoint.dir];
							int nc = c + dc[curPoint.dir];

							if (nr == 0 || nc == 0 || nr == N - 1 || nc == N - 1) {
								map[nr][nc][(i % 2 + 1) % 2].w += curPoint.w / 2;
								if (curPoint.dir % 2 == 0) {
									map[nr][nc][(i % 2 + 1) % 2].dir = curPoint.dir + 1;
								} else {
									map[nr][nc][(i % 2 + 1) % 2].dir = curPoint.dir - 1;
								}
							} else {
								map[nr][nc][(i % 2 + 1) % 2].w += curPoint.w;
								list.add(new MoveInfo(nr, nc));
							}
						}
					}
				}
				for (int j = 0; j < list.size(); j++) {
					MoveInfo cur = list.get(j);
					int res = Integer.MIN_VALUE;
					int dir = -1;
					for (int d = 0; d < 4; d++) {
						int nr = cur.r + dr[d];
						int nc = cur.c + dc[d];

						if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
							continue;
						}
						if (map[nr][nc][i%2].dir == -1) {
							continue;
						}
						int tmpR = nr + dr[map[nr][nc][i%2].dir];
						int tmpC = nc + dc[map[nr][nc][i%2].dir];
						
						if (tmpR != cur.r || tmpC != cur.c) {
							continue;
						}

						if (map[nr][nc][i % 2].w > res) {
							dir = map[nr][nc][i % 2].dir;
							res = map[nr][nc][i % 2].w;
						}
					}
					map[cur.r][cur.c][(i % 2 + 1) % 2].dir = dir;
				}

				for (int r = 0; r < N; r++) {
					for (int c = 0; c < N; c++) {
						map[r][c][i % 2] = new Point(0, -1);
					}
				}
			}
			int ans = 0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					ans += map[r][c][0].w;
					ans += map[r][c][1].w;
				}
			}
			
			System.out.println("#"+ tc+" "+ans);
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					System.out.print(map[r][c][0].w + " ");

				}
				System.out.println();
			}
			System.out.println();

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {

					System.out.print(map[r][c][1].w + " ");
				}
				System.out.println();
			}
			System.out.println();
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {

					System.out.print(map[r][c][1].dir + " ");
				}
				System.out.println();
			}
		}
	}

}
