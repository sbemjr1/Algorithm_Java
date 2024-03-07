import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_19237_어른상어 {
	static class Shark {
		int num, role;

		public Shark(int num, int role) {
			super();
			this.num = num;
			this.role = role;
		}

	}

	static int N, M, K;
	static Shark[][][] map;

	static ArrayList<Integer> shark_list;
	static int[] move_option;
	static int[][][] move_guide;

	static int[] dr = { 0, -1, 1, 0, 0 }; // 0은 더미 1:상 2:하 3:좌 4:우
	static int[] dc = { 0, 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new Shark[N][N][2];
		shark_list = new ArrayList<>();
		move_option = new int[M + 1];
		move_guide = new int[M + 1][4][4];

		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				int input_shark = Integer.parseInt(st.nextToken());
				if (input_shark != 0) {
					map[r][c][0] = new Shark(input_shark, 0); // 상어 번호, 보고 있는 방향
					map[r][c][1] = new Shark(input_shark, K); // 상어 번호, 냄새
					shark_list.add(input_shark);
				} else {
					map[r][c][0] = new Shark(0, 0);
					map[r][c][1] = new Shark(0, 0);
				}
			}
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= M; i++) {
			int input_shark_dir = Integer.parseInt(st.nextToken());
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (map[r][c][0].num == i) {
						map[r][c][0].role = input_shark_dir;
					}
				}
			}
		}

		for (int i = 1; i <= M; i++) {
			for (int j = 0; j < 4; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < 4; k++) {
					move_guide[i][j][k] = Integer.parseInt(st.nextToken());
				}
			}
		}

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.print(move_guide[4][i][j] + " ");
			}
			System.out.println();
		}

//		for (int r = 0; r < N; r++) {
//			for (int c = 0; c < N; c++) {
//				System.out.print(map[r][c][0].role);
//			}
//			System.out.println();
//		}

		// 이동 가능한 칸 찾기 (냄새 X -> 자신의 냄새
		// 이동 가능한 칸이 여러개라면 특수한 우선순위로 이동
		while (true) {
			// 상어가 한 마리이면 종료
			if (shark_list.size() == 1) {
				break;
			}

			// 상어 모두 찾고 이동 가능한 방향으로 이동(냄새(1)는 남기고 상어(0)는 이동)
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					ArrayList<int[]> list = new ArrayList<>();
					if (map[r][c][0].num != 0) {
						for (int d = 0; d < 4; d++) {
							int nr = r + dr[d];
							int nc = c + dc[d];

							if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
								continue;
							}
							if (map[nr][nc][1].role == 0) { // 빈칸이거나 (냄새 X)
								list.add(new int[] { nr, nc });
							} else if (map[nr][nc][1].num == map[r][c][1].num) { // 자신의 냄새이거나
								list.add(new int[] { nr, nc });
							}
						}
						// 갈 수 있는 방향이 하나인 경우
						if (list.size() == 1) {
							map[nr][nc][0].num 
						} else if (list.size() > 1) {// 여러 개인 경우

						}
					}
				}
			}
		}
	}

}
