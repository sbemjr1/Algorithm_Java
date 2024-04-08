package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_1486_장훈이의높은선반 {
	static int T, B, N, res, ans;
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
				res = 0;
				combination(0, 0, i);
			}
			System.out.println("#"+tc+" "+(ans - B));
		}
	}

	private static void combination(int idx, int k, int size) {
		if (k == size) {
			for (int i = 0; i < size; i++) {
				res += sel[i];
			}
			if (res >= B) {
				ans = Math.min(ans, res);
			}
			res = 0;
			return;
		}
		if (idx == N) {
			return;
		}

		sel[k] = arr[idx];
		combination(idx + 1, k + 1, size);
		combination(idx + 1, k, size);
	}
}
