import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_17144_미세먼지안녕 {
	static int R, C, T, airPurifier01, airPurifier02;
	static int[][] map, tmpMap;
	static ArrayList<Integer> airPurifiers;

	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int[] dr02 = { 1, 0, -1, 0 };
	static int[] dc02 = { 0, 1, 0, -1 };

	static class Point {
		int r, c, w;

		public Point(int r, int c, int w) {
			this.r = r;
			this.c = c;
			this.w = w;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		map = new int[R][C];
		tmpMap = new int[R][C];
		airPurifiers = new ArrayList<>();

		for (int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < C; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if (map[r][c] == -1) {
					airPurifiers.add(r);
				}
			}
		}

		airPurifier01 = airPurifiers.get(0);
		airPurifier02 = airPurifiers.get(1);

		// 초마다 확산 => 공기 청정기
		for (int t = 0; t < T; t++) {
			// 먼지를 리스트 담음
			ArrayList<Point> dustList = new ArrayList<>();
			for (int r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {
					if (map[r][c] > 0) {
						dustList.add(new Point(r, c, map[r][c]));
					}
				}
			}
			// 먼지 리스트를 통해서 한번에 처리
			for (int i = 0; i < dustList.size(); i++) {
				int curR = dustList.get(i).r;
				int curC = dustList.get(i).c;
				int cnt = 0;

				for (int d = 0; d < 4; d++) {
					int nextR = curR + dr[d];
					int nextC = curC + dc[d];

					if (nextR < 0 || nextR >= R || nextC < 0 || nextC >= C) {
						continue;
					}
					if (map[nextR][nextC] == -1) {
						continue;
					}

					tmpMap[nextR][nextC] += (map[curR][curC] / 5);
					cnt++;
				}

				tmpMap[curR][curC] += map[curR][curC] - (map[curR][curC] / 5) * cnt;
			}

			// 처리한 맵을 원본으로 바꾸기
			for (int r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {
					map[r][c] = tmpMap[r][c];
				}
			}
			tmpMap = new int[R][C];

			// 공기 청정기 가동
			// 방향
			int d = 0;
			// 윗 부분 공기 청정기
			int r01 = airPurifier01;
			int c01 = 0;
			// 아랫 부분 공기 청정기
			int r02 = airPurifier02;
			int c02 = 0;
			while (true) {
				// 윗 부분 공기 청정기
				r01 += dr[d];
				c01 += dc[d];

				if (r01 == airPurifier01 && c01 == 0) {
					break;
				}

				if (r01 < 0 || r01 > airPurifier01 || c01 < 0 || c01 >= C) {
					r01 -= dr[d];
					c01 -= dc[d];
					d++;
					if (d == 4) {
						break;
					}
					continue;
				}
				map[r01 - dr[d]][c01 - dc[d]] = map[r01][c01];
				map[r01][c01] = 0;
			}
			d = 0;
			while (true) {
				// 아랫 부분 공기 청정기
				r02 += dr02[d];
				c02 += dc02[d];

				if (r02 == airPurifier02 && c02 == 0) {
					break;
				}

				if (r02 < airPurifier02 || r02 >= R || c02 < 0 || c02 >= C) {
					r02 -= dr02[d];
					c02 -= dc02[d];
					d++;
					if (d == 4) {
						break;
					}
					continue;
				}
				map[r02 - dr02[d]][c02 - dc02[d]] = map[r02][c02];
				map[r02][c02] = 0;
			}

			map[airPurifier01][0] = 0;
			map[airPurifier02][0] = 0;
		}
		int ans = 0;
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (map[r][c] > 0) {
					ans += map[r][c];
				}
			}
		}
		System.out.println(ans);
	}

}
