import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_4485_젤다지 {
	static int N;
	static int[][] map, minMap;
	static boolean[][] v;

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

			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < N; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
					minMap[r][c] = Integer.MAX_VALUE;
				}
			}

			v = new boolean[N][N];

			minMap[0][0] = map[0][0];

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					int min = Integer.MAX_VALUE;
					int[] minVertex = { -1, -1 };

					for (int i = 0; i < N; i++) {
						for (int j = 0; j < N; j++) {
							if (!v[i][j] && minMap[i][j] < min) {
								min = minMap[i][j];
								minVertex[0] = i;
								minVertex[1] = j;
							}
						}
					}

					if (minVertex[0] == -1 && minVertex[1] == -1) {
						break;
					}
					v[minVertex[0]][minVertex[1]] = true;

					for (int d = 0; d < 4; d++) {
						int nr = minVertex[0] + dr[d];
						int nc = minVertex[1] + dc[d];

						if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
							continue;
						}
						if (v[nr][nc]) {
							continue;
						}
						if (minMap[nr][nc] <= min + map[nr][nc]) {
							continue;
						}
						minMap[nr][nc] = min + map[nr][nc];
					}
				}
			}
			System.out.println("Problem " + cnt++ + ": " + minMap[N - 1][N - 1]);
		}
	}

}
