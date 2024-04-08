package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2112_보호필름_재풀이 {
	static int T, D, W, K, ans;
	static int[][] cell, copyCell;
	static int[] sel;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		T = Integer.parseInt(st.nextToken());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());

			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			cell = new int[D][W];
			copyCell = new int[D][W];

			for (int r = 0; r < D; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < W; c++) {
					cell[r][c] = Integer.parseInt(st.nextToken());
				}
			}

			ans = Integer.MAX_VALUE;
			sel = new int[D];
			recursive(0, 0);

			System.out.println(ans);
		}
	}

	private static void recursive(int idx, int cnt) {
		if (cnt >= ans) {
			return;
		}
		if (idx == D) {
			copy();
			for (int i = 0; i < D; i++) {
				for (int c = 0; c < W; c++) {
					if (sel[i] != -1) {
						copyCell[i][c] = sel[i];
					}
				}
			}
			
			if (checkCell(copyCell)) {
				ans = Math.min(ans, cnt);
			}

			return;
		}

		// 아무것도 안넣은 경우
		sel[idx] = -1;
		recursive(idx + 1, cnt);

		// A시약
		sel[idx] = 0;
		recursive(idx + 1, cnt + 1);

		// B시약
		sel[idx] = 1;
		recursive(idx + 1, cnt + 1);
	}

	private static boolean checkCell(int[][] arr) {
		int tmp = 0;
		int cnt = 0;
		int res = 0;
		
		for (int c = 0; c < W; c++) {
			tmp = arr[0][c];
			cnt = 0;
			for (int r = 0; r < D; r++) {
				if (arr[r][c] == tmp) {
					cnt++;
					if (cnt == K) {
						res++;
						break;
					}
				} else {
					cnt = 1;
					tmp = arr[r][c];
				}
			}
			if (res != c + 1) {
				return false;
			}
		}
		
		return true;
	}

	private static void copy() {
		for (int r = 0; r < D; r++) {
			for (int c = 0; c < W; c++) {
				copyCell[r][c] = cell[r][c];
			}
		}
	}

}
