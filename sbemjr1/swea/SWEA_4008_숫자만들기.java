package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_4008_숫자만들기 {
	static int T, N, res, max, min, ans;
	static int[] numbers, symbols, copySymbols, sel;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		T = Integer.parseInt(st.nextToken());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			numbers = new int[N];
			symbols = new int[4];
			copySymbols = new int[4];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				symbols[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				numbers[i] = Integer.parseInt(st.nextToken());
			}

			sel = new int[N - 1];
			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
			permutation(0);
			
			ans = max - min;
			System.out.println("#"+tc+" "+ans);
		}
	}

	private static void permutation(int k) {
		if (k == N - 1) {
//			System.out.println(Arrays.toString(sel));
			copy();
			res = numbers[0];
			if(simulation()) {
				max = Math.max(res, max);
				min = Math.min(res, min);
			}
			return;
		}

		for (int i = 0; i < 4; i++) {
			sel[k] = i;
			permutation(k + 1);
		}
	}

	private static void copy() {
		for (int i = 0; i < 4; i++) {
			copySymbols[i] = symbols[i];
		}
	}

	private static boolean simulation() {
		for (int i = 0; i < N - 1; i++) {
			if (copySymbols[sel[i]] == 0) {
				return false;
			}
			if (sel[i] == 0) {
				res += numbers[i + 1];
				copySymbols[0]--;
			}
			if (sel[i] == 1) {
				res -= numbers[i + 1];
				copySymbols[1]--;
			}
			if (sel[i] == 2) {
				res *= numbers[i + 1];
				copySymbols[2]--;
			}
			if (sel[i] == 3) {
				res /= numbers[i + 1];
				copySymbols[3]--;
			}
		}
		return true;
	}

}
