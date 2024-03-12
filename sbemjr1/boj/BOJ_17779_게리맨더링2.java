import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_17779_게리맨더링2 {
	static int N;
	static int[][] map, area;
	static int[] people;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());

		map = new int[N + 2][N + 2];
		area = new int[N + 2][N + 2];
		people = new int[6]; // 0은 더미 1-5

		for (int r = 1; r <= N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 1; c <= N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}

//		(x, y), (x+1, y-1), ..., (x+d1, y-d1)
//		(x, y), (x+1, y+1), ..., (x+d2, y+d2)
//		(x+d1, y-d1), (x+d1+1, y-d1+1), ... (x+d1+d2, y-d1+d2)
//		(x+d2, y+d2), (x+d2+1, y+d2-1), ..., (x+d2+d1, y+d2-d1)

		int ans = Integer.MAX_VALUE;

		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= N; c++) {
				// 해당 위치에서 모든 d1,d2 고려
				for (int d1 = 1; d1 <= N; d1++) {
					for (int d2 = 1; d2 <= N; d2++) {
						if (r + d1 >= N + 1 || c - d1 < 1) {
							break;
						}
						if (r + d2 >= N + 1 || c + d2 >= N + 1) {
							break;
						}
						if (r + d1 + d2 >= N + 1 || c - d1 + d2 >= N + 1) {
							break;
						}
						if (r + d2 + d1 >= N + 1 || c + d2 - d1 < 1) {
							break;
						}

						int nr = r;
						int nc = c;

						for (int i = 0; i <= N + 1; i++) {
							for (int j = 0; j <= N + 1; j++) {
								area[i][j] = 0;
							}
						}

						people = new int[6];

						people[5] += map[nr][nc];

						// 1번 방향
						while (true) {
							area[nr][nc] = 5;
							if (nc == c - d1) {
								break;
							}
							nr += 1;
							nc -= 1;
						}
						// 3번 방향
						while (true) {
							area[nr][nc] = 5;
							if (nr == r + d1 + d2) {
								break;
							}
							nr += 1;
							nc += 1;
						}
						nr = r;
						nc = c;

						// 2번 방향
						while (true) {
							area[nr][nc] = 5;
							if (nc == c + d2) {
								break;
							}
							nr += 1;
							nc += 1;
						}
						// 4번 방향
						while (true) {
							area[nr][nc] = 5;
							if (nr == r + d2 + d1) {
								people[5] += map[nr][nc];
								break;
							}
							nr += 1;
							nc -= 1;
						}

						// 5번 선거구
						for (int i = r + 1; i < r + d2 + d1; i++) {
							L: for (int j = 1; j <= N; j++) {
								if (area[i][j] == 5) {
									people[5] += map[i][j];
									for (int k = j + 1; k <= N; k++) {
										if (area[i][k] == 5) {
											people[5] += map[i][k];
											break L;
										}
										area[i][k] = 5;
										people[5] += map[i][k];
									}
								}
							}
						}

//						1번 선거구: 1 ≤ r < x+d1, 1 ≤ c ≤ y
//						2번 선거구: 1 ≤ r ≤ x+d2, y < c ≤ N
//						3번 선거구: x+d1 ≤ r ≤ N, 1 ≤ c < y-d1+d2
//						4번 선거구: x+d2 < r ≤ N, y-d1+d2 ≤ c ≤ N
						// 영역 표시 및 인구 수 체크
						// 1번 선거구
						for (int i = 1; i < r + d1; i++) {
							for (int j = 1; j <= c; j++) {
								if (area[i][j] == 5) {
									break;
								}
								area[i][j] = 1;
								people[1] += map[i][j];
							}
						}
						for (int i = 1; i <= r + d2; i++) {
							for (int j = c; j <= N; j++) {
								if (area[i][j] != 0) {
									continue;
								}
								area[i][j] = 2;
								people[2] += map[i][j];
							}
						}
						for (int i = r + d1; i <= N; i++) {
							for (int j = 1; j < c - d1 + d2; j++) {
								if (area[i][j] == 5) {
									break;
								}
								area[i][j] = 3;
								people[3] += map[i][j];
							}
						}
						for (int i = r + d2 + 1; i <= N; i++) {
							for (int j = c - d1 + d2; j <= N; j++) {
								if (area[i][j] != 0) {
									continue;
								}
								area[i][j] = 4;
								people[4] += map[i][j];
							}
						}

						Arrays.sort(people);
						int result = people[5] - people[1];
						ans = Math.min(result, ans);
					}
				}
			}

		}
		System.out.println(ans);
	}

}
