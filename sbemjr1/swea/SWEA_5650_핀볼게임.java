package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_5650_핀볼게임 {
	static int T, N, totalScore;
	static int[][] map;
	static ArrayList<WormHole> wormHole;

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static class Ball {
		int r, c, dir;

		public Ball(int r, int c, int dir) {
			this.r = r;
			this.c = c;
			this.dir = dir;
		}
	}
	
	static class WormHole {
		int r, c, num;

		public WormHole(int r, int c, int num) {
			this.r = r;
			this.c = c;
			this.num = num;
		}
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		T = Integer.parseInt(st.nextToken());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			wormHole = new ArrayList<>();
			totalScore = Integer.MIN_VALUE;

			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < N; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
					
					if (map[r][c] >= 6 && map[r][c] <= 10) {
						wormHole.add(new WormHole(r, c, map[r][c]));
					}
				}
			}

			// 모든 점에서 사방으로 핀볼 발사
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					// 빈 공간인 경우 시뮬레이션
					if (map[r][c] != 0) {
						simulation(r, c);
					}
				}
			}
			
			System.out.println(totalScore);
		}
	}

	private static void simulation(int r, int c) {
		for (int d = 0; d < 4; d++) {
			// 초기 공의 상태
			Ball ball = new Ball(r, c, d);
			int curScore = 0;
			// 공이 시작위치로 돌아오거나 블랙홀에 들어가면 종료
			while (true) {
				int nr = ball.r + dr[ball.dir];
				int nc = ball.c + dc[ball.dir];

				// 외벽이면 진행방향 반대로 바꾸고 점수 증가
				if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
					curScore++;

					if (ball.dir % 2 == 0) {
						ball.dir++;
					} else {
						ball.dir--;
					}
					
					if (ball.r == r && ball.c == c) {
						totalScore = Math.max(totalScore, curScore);
						break;
					}
					continue;
				}
				
				// 외벽이 아니면 일단 이동
				ball.r = nr;
				ball.c = nc;
				
				// 1-4 구조물이라면 진행방향 바꾸고 점수 증가
				if (map[ball.r][ball.c] >= 1 && map[ball.r][ball.c] <= 4) {
					curScore++;
					if (ball.dir == 0) {
						if (map[ball.r][ball.c] == 1) {
							if (ball.dir % 2 == 0) {
								ball.dir++;
							} else {
								ball.dir--;
							}
						} else if (map[ball.r][ball.c] == 2) {
							ball.dir = 3;
						} else if (map[ball.r][ball.c] == 3) {
							ball.dir = 2;
						} else if (map[ball.r][ball.c] == 4) {
							if (ball.dir % 2 == 0) {
								ball.dir++;
							} else {
								ball.dir--;
							}
						}
					} else if (ball.dir == 1) {
						if (map[nr][nc] == 1) {
							ball.dir = 3;
						} else if (map[nr][nc] == 2) {
							if (ball.dir % 2 == 0) {
								ball.dir++;
							} else {
								ball.dir--;
							}
						} else if (map[nr][nc] == 3) {
							if (ball.dir % 2 == 0) {
								ball.dir++;
							} else {
								ball.dir--;
							}
						} else if (map[nr][nc] == 4) {
							ball.dir = 2;
						}
					} else if (ball.dir == 2) {
						if (map[nr][nc] == 1) {
							ball.dir = 0;
						} else if (map[nr][nc] == 2) {
							ball.dir = 1;
						} else if (map[nr][nc] == 3) {
							if (ball.dir % 2 == 0) {
								ball.dir++;
							} else {
								ball.dir--;
							}
						} else if (map[nr][nc] == 4) {
							if (ball.dir % 2 == 0) {
								ball.dir++;
							} else {
								ball.dir--;
							}
						}
					} else if (ball.dir == 3) {
						if (map[nr][nc] == 1) {
							if (ball.dir % 2 == 0) {
								ball.dir++;
							} else {
								ball.dir--;
							}
						} else if (map[nr][nc] == 2) {
							if (ball.dir % 2 == 0) {
								ball.dir++;
							} else {
								ball.dir--;
							}
						} else if (map[nr][nc] == 3) {
							ball.dir = 1;
						} else if (map[nr][nc] == 4) {
							ball.dir = 0;
						}
					}
					continue;
				}
				// 6-10 이면 웜홀 이동 처리
				if (map[nr][nc] >= 6 && map[nr][nc] <= 10) {
					for (int i = 0; i < wormHole.size(); i++) {
						WormHole wh = wormHole.get(i);
						if (wh.num == map[nr][nc] && (wh.r != nr || wh.c != nc)) {
							ball.r = wh.r;
							ball.c = wh.c;
							break;
						}
					}
				}
				// 블랙홀 이거나 시작위치라면 종료
				if (map[nr][nc] == -1) {
					totalScore = Math.max(totalScore, curScore);
					break;
				}
			}
		}
	}

}
