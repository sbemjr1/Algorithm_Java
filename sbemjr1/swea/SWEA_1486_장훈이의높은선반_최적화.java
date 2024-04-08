package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_1486_장훈이의높은선반_최적화 {
	static int T, B, N, ans;
	static int[] arr, sel;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		T = Integer.parseInt(st.nextToken());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());

			arr = new int[N];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			ans = Integer.MAX_VALUE;
			for (int i = 1; i <= N; i++) {
				sel = new int[i];
				combination(0, 0, i, 0);
			}
			System.out.println("#"+tc+" "+(ans - B));
		}
	}

	private static void combination(int idx, int k, int size, int sum) {
		if (sum >= ans) {
			return;
		}
		if (k == size) {
			if (sum >= B) {
				ans = Math.min(ans, sum);
			}
			return;
		}
		if (idx == N) {
			return;
		}

		sel[k] = arr[idx];
		combination(idx + 1, k + 1, size, sum + arr[idx]);
		combination(idx + 1, k, size, sum);
	}
}
