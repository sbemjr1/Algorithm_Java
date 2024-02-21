package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10162_전자레인지 {
	static int T, btn[], ans[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		T = Integer.parseInt(st.nextToken());
		btn = new int[] {300,60,10};
		ans = new int[3];
		
		for (int i = 0; i < btn.length; i++) {
			ans[i] = T / btn[i];
			T = T % btn[i];
		}
		
		if (T == 0) {
			for (int i = 0; i < ans.length; i++) {
				System.out.print(ans[i] + " ");
			}
		} else {
			System.out.println(-1);
		}
	}

}
