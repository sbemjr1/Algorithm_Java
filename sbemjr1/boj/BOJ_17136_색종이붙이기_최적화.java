import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;

public class BOJ_17136_색종이붙이기_최적화 {
	static int ans, N;
	static int[][] map;
	static int[] papers;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		map = new int[10][10];
		papers = new int[] { 0, 5, 5, 5, 5, 5 };
		N = 10;

		for (int r = 0; r < 10; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < 10; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		ans = Integer.MAX_VALUE;
		recursive(0);

		System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
	}

	private static void recursive(int cnt) {
		int sr = -1, sc = -1;
		L: for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (map[r][c] == 1) {
					sr = r;
					sc = c;
					break L;
				}
			}
		}

		if (sr == -1 && sc == -1) {
			ans = Math.min(ans, cnt);
			return;
		}


		int size = getLargeSize(sr, sc);
		
		if (size == -1) return;
		
		for (int i = 1; i <= size; i++) {
			if (papers[i] > 0) {
				for (int r = sr; r < sr + i; r++) {
					for (int c = sc; c < sc + i; c++) {
						map[r][c] = 0;
					}
				}
				papers[i]--;
				recursive(cnt + 1);
				for (int r = sr; r < sr + i; r++) {
					for (int c = sc; c < sc + i; c++) {
						map[r][c] = 1;
					}
				}
				papers[i]++;
			}
		}
	}

	private static int getLargeSize(int sr, int sc) {
		int SIZE = 5;
		for (int i = SIZE; i > 0; i--) {
			boolean flag = true;
			L:for (int r = sr; r < sr + i; r++) {
				for (int c = sc; c < sc + i; c++) {
					if (r < 0 || r >= N || c < 0 || c >= N || map[r][c] == 0) {
						flag = false;
						break L;
					}
				}
			}
			if (flag) {
				return i;
			}
		}
		return -1;
	}

}
