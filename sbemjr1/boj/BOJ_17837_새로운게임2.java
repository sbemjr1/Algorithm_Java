import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_17837_새로운게임2 {
	static int N, K;
	static int[][] map;
	static ArrayList<Integer>[][] horse_map;
	static int[] cur_dir;
//	0부터 순서대로 →, ←, ↑, ↓의 의미를 갖는다.
	static int dr[] = { 0, 0, -1, 1 };
	static int dc[] = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		horse_map = new ArrayList[N][N];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				horse_map[r][c] = new ArrayList();
			}
		}

		cur_dir = new int[K + 1];

		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 1; i <= K; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int d = Integer.parseInt(st.nextToken()) - 1;

			horse_map[r][c].add(i);
			cur_dir[i] = d;
		}
		for (int k = 0; k < 2; k++) {
			for (int i = 1; i <= K; i++) {
				L: for (int r = 0; r < N; r++) {
					for (int c = 0; c < N; c++) {
						for (int j = 0; j < horse_map[r][c].size(); j++) {
							if (horse_map[r][c].get(j) == i) {
								int nr = r + dr[cur_dir[i]];
								int nc = c + dc[cur_dir[i]];

								if (nr < 0 || nr >= N || nc < 0 || nc >= N || map[nr][nc] == 2) {
									if (cur_dir[i] % 2 == 0) {
										cur_dir[i] += 1;
									} else {
										cur_dir[i] -= 1;
									}
//									System.out.println(Arrays.toString(cur_dir));
									break L;
								}
								horse_map[nr][nc].addAll(horse_map[r][c].subList(j, horse_map[r][c].size()));
								if (j == 0) {
									horse_map[r][c].clear();
								} else {
									horse_map[r][c].subList(j, horse_map[r][c].size()).clear();
								}
								if (map[nr][nc] == 1) {
									Collections.reverse(horse_map[nr][nc]);
								}
								print();
								break L;
							}
						}

					}
				}
			}
		}
	}

	private static void print() {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				System.out.print(horse_map[r][c] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

}
