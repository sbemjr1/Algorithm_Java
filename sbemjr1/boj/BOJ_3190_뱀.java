//먼저 뱀은 몸길이를 늘려 머리를 다음칸에 위치시킨다.
//만약 벽이나 자기자신의 몸과 부딪히면 게임이 끝난다.
//만약 이동한 칸에 사과가 있다면, 그 칸에 있던 사과가 없어지고 꼬리는 움직이지 않는다.
//만약 이동한 칸에 사과가 없다면, 몸길이를 줄여서 꼬리가 위치한 칸을 비워준다. 즉, 몸길이는 변하지 않는다.

/*
 * 풀이 방법
 * 앞으로 이동하는 것과 방향 전환은 단순 구현(방향 전환 방법이 맘에 들지는 않음)
 * 꼬리를 자르는 방법 생각하는 것이 생각보다 오래걸림
 * 처음엔 bfs로 머리부터 타고 들어가서 꼬리를 자르려고 했지만 뱀이 다 붙어있는 경우에 문제 발생
 * queue에 뱀의 좌표를 넣어서 가장 먼저 들어옴 뱀의 부위를 poll 하면서 이동하는 것으로 해결 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_3190_뱀 {
	static class Command {
		int t;
		String dir;

		public Command(int t, String dir) {
			super();
			this.t = t;
			this.dir = dir;
		}
	}

	static class Point {
		int r, c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}

	}

	static int N, K, L;
	static int[][] map;

	static int[] dr = { -1, 1, 0, 0 }; // 0은 더미 1:상 2:하 3:좌 4:우
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());

		map = new int[N + 2][N + 2];
		map[1][1] = 1;

		// 벽 생성
		for (int i = 0; i <= N + 1; i++) {
			map[i][0] = 9;
			map[0][i] = 9;
			map[i][N + 1] = 9;
			map[N + 1][i] = 9;
		}

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());

			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			map[r][c] = 2; // 사과
		}

		st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		Queue<Command> q = new ArrayDeque<>();

		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());

			int t = Integer.parseInt(st.nextToken());
			String dir = st.nextToken();

			q.offer(new Command(t, dir));
		}

		int sec = 0;
		int nowR = 1;
		int nowC = 1;
		int nowD = 3;

		Queue<Point> snake = new ArrayDeque<>();
		snake.offer(new Point(nowR, nowC));

		while (true) {
			if (!q.isEmpty()) {
				Command com = q.peek();
				if (com.t == sec) {
					Command comp = q.poll();

					if (nowD == 0) {
						if (comp.dir.equals("L")) {
							nowD = 2;
						} else if (comp.dir.equals("D")) {
							nowD = 3;
						}
					} else if (nowD == 1) {
						if (comp.dir.equals("L")) {
							nowD = 3;
						} else if (comp.dir.equals("D")) {
							nowD = 2;
						}
					} else if (nowD == 2) {
						if (comp.dir.equals("L")) {
							nowD = 1;
						} else if (comp.dir.equals("D")) {
							nowD = 0;
						}
					} else if (nowD == 3) {
						if (comp.dir.equals("L")) {
							nowD = 0;
						} else if (comp.dir.equals("D")) {
							nowD = 1;
						}
					}
				}
			}

			int nr = nowR + dr[nowD];
			int nc = nowC + dc[nowD];

			if (map[nr][nc] == 2) {
				map[nr][nc] = 1;
				snake.offer(new Point(nr, nc));
			} else if (map[nr][nc] == 0) {
				map[nr][nc] = 1;
				snake.offer(new Point(nr, nc));
				Point p = snake.poll();
				map[p.r][p.c] = 0;
			} else if (map[nr][nc] == 9) {
				System.out.println(sec + 1);
				break;
			} else if (map[nr][nc] == 1) {
				System.out.println(sec + 1);
				break;
			}

			nowR = nr;
			nowC = nc;
			sec++;
		}
	}

}
