import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1149_RGB거리 {
	static int N, ans;
	static int[][] map;
	static boolean[] v;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());

		map = new int[N][3];
		v = new boolean[3];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			int red = Integer.parseInt(st.nextToken());
			int green = Integer.parseInt(st.nextToken());
			int blue = Integer.parseInt(st.nextToken());

			map[i][0] = red;
			map[i][1] = green;
			map[i][2] = blue;
		}
		
		ans = Integer.MAX_VALUE;
		recursive(0, -1, 0);
		System.out.println(ans);
	}

	private static void recursive(int k, int cur, int sum) {
		if (sum >= ans) {
			return;
		}
		if (k == N) {
			ans = Math.min(ans, sum);
			return;
		}

		for (int i = 0; i < 3; i++) {
			if (i != cur) {
				recursive(k + 1, i, sum + map[k][i]);
			}
		}
	}

}
