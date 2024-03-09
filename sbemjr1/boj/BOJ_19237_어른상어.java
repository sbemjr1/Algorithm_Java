import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_19237_어른상어 {
	static class Shark {
		int num, look;

		public Shark(int num, int look) {
			this.num = num;
			this.look = look;
		}
	}

	static class Smell {
		int num, day;

		public Smell(int num, int day) {
			this.num = num;
			this.day = day;
		}
	}

	static class Move_shark {
		int r, c, num, orgLook, look;

		public Move_shark(int r, int c, int num, int orgLook, int look) {
			this.r = r;
			this.c = c;
			this.num = num;
			this.orgLook = orgLook;
			this.look = look;
		}
	}

	static class MovingShark {
		int r, c, num, look;

		public MovingShark(int r, int c, int num, int look) {
			this.r = r;
			this.c = c;
			this.num = num;
			this.look = look;
		}

	}

	static int N, M, K;
	static Shark[][] shark_map;
	static Smell[][] smell_map;

	static int[][][] move_guide;

	static int[] dr = { 0, -1, 1, 0, 0 }; // 0은 더미 1:상 2:하 3:좌 4:우
	static int[] dc = { 0, 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		shark_map = new Shark[N][N];
		smell_map = new Smell[N][N];
		move_guide = new int[M + 1][5][5];

		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				int input_shark = Integer.parseInt(st.nextToken());
				if (input_shark != 0) {
					shark_map[r][c] = new Shark(input_shark, 0); // 상어 번호, 보고 있는 방향
					smell_map[r][c] = new Smell(input_shark, K); // 냄새 주인, 냄새 기한
				} else {
					shark_map[r][c] = new Shark(0, 0); // 초기 빈칸
					smell_map[r][c] = new Smell(0, 0);
				}
			}
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= M; i++) {
			int input_shark_dir = Integer.parseInt(st.nextToken());
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (shark_map[r][c].num == i) {
						shark_map[r][c].look = input_shark_dir;
					}
				}
			}
		}

		for (int i = 1; i <= M; i++) {
			for (int j = 1; j <= 4; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 1; k <= 4; k++) {
					move_guide[i][j][k] = Integer.parseInt(st.nextToken());
				}
			}
		}

		// 이동 가능한 칸 찾기 (냄새 X -> 자신의 냄새
		// 이동 가능한 칸이 여러개라면 특수한 우선순위로 이동
		// 상어 모두 찾고 이동 가능한 방향으로 이동(냄새는 남기고 상어는 이동)
		int result = 0;
		ArrayList<MovingShark> moved_shark_list = new ArrayList<>();
		ArrayList<Move_shark> blank = new ArrayList<>();
		ArrayList<Move_shark> smell_mine = new ArrayList<>();
		while (true) {
			moved_shark_list.clear();
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					blank.clear();
					smell_mine.clear();
					// 상어가 있으면 이동 가능한 공간 찾기
					if (shark_map[r][c].num != 0) {

						for (int d = 1; d <= 4; d++) {
							int nr = r + dr[d];
							int nc = c + dc[d];

							if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
								continue;
							}
							if (smell_map[nr][nc].num == 0) { // 냄새가 없는 경우(빈칸) - 우선 순위 1
								blank.add(new Move_shark(nr, nc, shark_map[r][c].num, shark_map[r][c].look, d));
							} else if (smell_map[nr][nc].num == shark_map[r][c].num) { // 자신의 냄새인 경우 - 우선순위 2
								smell_mine.add(new Move_shark(nr, nc, shark_map[r][c].num, shark_map[r][c].look, d));
							}
						}
					}
					// 이동가능 경로 저장 후 현재 상어 위치 없애기
					shark_map[r][c].num = 0;
					shark_map[r][c].look = 0;
					// 상어가 이동가능한 큐를 이용하여 이동 시키기
					if (!blank.isEmpty()) { // 빈칸으로 이동 가능한 경우가 있다면
						L: for (int i = 1; i <= 4; i++) {
							for (int j = 0; j < blank.size(); j++) {
								Move_shark cur = blank.get(j);

								if (move_guide[cur.num][cur.orgLook][i] == cur.look) {
									moved_shark_list.add(new MovingShark(cur.r, cur.c, cur.num, cur.look));
									break L;
								}
							}
						}
					} else if (blank.isEmpty() && !smell_mine.isEmpty()) { // 빈칸으로 이동 가능한 경우가 없다면
						L: for (int i = 1; i <= 4; i++) {
							for (int j = 0; j < smell_mine.size(); j++) {
								Move_shark cur = smell_mine.get(j);

								if (move_guide[cur.num][cur.orgLook][i] == cur.look) {
									moved_shark_list.add(new MovingShark(cur.r, cur.c, cur.num, cur.look));
									break L;
								}
							}
						}
					}
				}
			}
			for (int i = 0; i < moved_shark_list.size(); i++) {
				MovingShark list = moved_shark_list.get(i);
				if (shark_map[list.r][list.c].num != 0) {
					if (shark_map[list.r][list.c].num > list.num) {
						shark_map[list.r][list.c].num = list.num;
						shark_map[list.r][list.c].look = list.look;
					}
				} else {
					shark_map[list.r][list.c].num = list.num;
					shark_map[list.r][list.c].look = list.look;
				}
			}
			// 이동 완료 후 냄새 지정 및 감소
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (shark_map[i][j].num != 0) { // 상어가 있으면 냄새 추가
						smell_map[i][j].num = shark_map[i][j].num;
						smell_map[i][j].day = K;
					} else if (smell_map[i][j].day > 0) { // 이미 냄새가 있었다면 냄새 감소
						smell_map[i][j].day--;
						if (smell_map[i][j].day == 0) {
							smell_map[i][j].num = 0;
						}
					}
				}
			}
			if (moved_shark_list.size() == 1) {
				System.out.println(result);
				break;
			}
			result++;
			if (result > 1000) {
				System.out.println(-1);
				break;
			}
		}
	}
}
