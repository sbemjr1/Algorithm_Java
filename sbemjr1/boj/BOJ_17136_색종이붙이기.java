import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_17136_색종이붙이기 {
	static int ans;
	static int[][] map;
	static int[] papers;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		map = new int[10][10];
		papers = new int[6];

		for (int i = 1; i <= 5; i++) {
			papers[i] = 5;
		}

		for (int r = 0; r < 10; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < 10; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		ans = Integer.MAX_VALUE;
		recursive(0);
		
		System.out.println(ans);
	}

	private static void recursive(int cnt) {
		if(lastCheck()) {
//			for (int[] e : map) {
//				System.out.println(Arrays.toString(e));
//			}
			ans = Math.min(cnt, ans);
			return;
		}

		for (int r = 0; r < 10; r++) {
			for (int c = 0; c < 10; c++) {
				if (map[r][c] == 1) {
					for (int i = 1; i <= 5; i++) {
						if (papers[i] > 0) {
							if (check(r, c, i)) {
								for (int nr = r; nr < r + i; nr++) {
									for (int nc = c; nc < c + i; nc++) {
										map[nr][nc] = 2;
									}
								}
								papers[i]--;
								recursive(cnt + 1);
								papers[i]++;
								for (int nr = r; nr < r + i; nr++) {
									for (int nc = c; nc < c + i; nc++) {
										map[nr][nc] = 1;
									}
								}
							}
						}
					}
				}
			}
		}
	}

	private static boolean lastCheck() {
		for (int r = 0; r < 10; r++) {
			for (int c = 0; c < 10; c++) {
				if (map[r][c] == 1) {
					return false;
				}
			}
		}
		return true;
	}

	private static boolean check(int r, int c, int i) {
		for (int nr = r; nr < r + i; nr++) {
			for (int nc = c; nc < c + i; nc++) {
				if (nr >= 10 || nc >= 10) {
					return false;
				}
				if (map[nr][nc] == 0) {
					return false;
				}
			}
		}
		return true;
	}

}
