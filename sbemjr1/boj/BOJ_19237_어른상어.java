import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_19237_어른상어 {
	static class Shark {
		int num, look, smell;

		public Shark(int num, int look, int smell) {
			super();
			this.num = num;
			this.look = look;
			this.smell = smell;
		}

	}

	static class Move_shark {
		int r, c, num, look;

		public Move_shark(int r, int c, int num, int look) {
			super();
			this.r = r;
			this.c = c;
			this.num = num;
			this.look = look;
		}
	}

	static int N, M, K;
	static Shark[][] map;

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

		map = new Shark[N][N];
		shark_list = new ArrayList<>();
		move_guide = new int[M + 1][4][4];

		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				int input_shark = Integer.parseInt(st.nextToken());
				if (input_shark != 0) {
					map[r][c] = new Shark(input_shark, 0, K); // 상어 번호, 보고 있는 방향, 냄새
					shark_list.add(input_shark); // 상어 갯수 파악
				} else {
					map[r][c] = new Shark(0, 0, 0); // 초기 빈칸
				}
			}
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= M; i++) {
			int input_shark_dir = Integer.parseInt(st.nextToken());
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (map[r][c].num == i) {
						map[r][c].look = input_shark_dir;
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

//		for (int i = 0; i < 4; i++) {
//			for (int j = 0; j < 4; j++) {
//				System.out.print(move_guide[4][i][j] + " ");
//			}
//			System.out.println();
//		}

//		for (int r = 0; r < N; r++) {
//			for (int c = 0; c < N; c++) {
//				System.out.print(map[r][c].smell);
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
			ArrayList<Move_shark> list_blank = new ArrayList<>(); // 빈칸
			ArrayList<Move_shark> list_mine = new ArrayList<>(); // 자신의 냄새
			// 상어 모두 찾고 이동 가능한 방향으로 이동(냄새(1)는 남기고 상어(0)는 이동)
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (map[r][c].look != 0) { // 해당 위치에 상어가 실제로 있는지
						// 이동 가능한 곳 찾기 (빈칸 or 자신의 냄새)
						for (int d = 0; d < 4; d++) {
							int nr = r + dr[d];
							int nc = c + dc[d];

							if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
								continue;
							}
							if (map[nr][nc].smell == 0) { // 빈칸인 경우
								list_blank.add(new Move_shark(nr, nc, map[r][c].num, d));
							}
							if (map[nr][nc].num == map[r][c].num) { // 자신의 냄새인 경우
								list_mine.add(new Move_shark(nr, nc, map[r][c].num, d));
							}
						}
					}
					// 상어 위치 이동하기 위해 현재 상어 초기화
					map[r][c].look = 0;

					// 이동 시작
					if (list_blank.size() > 0) { // 빈칸으로 이동할 수 있는 경우

					} else if (list_blank.size() == 0) { // 빈칸으로 이동 불가한 경우

					}
				}
			}
		}
	}

}
