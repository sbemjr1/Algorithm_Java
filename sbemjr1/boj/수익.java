package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수익 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int[] arr = new int[N];
			int sum = 0;
			int max = Integer.MIN_VALUE;
			
			if (N == 0) {
				break;
			}
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				sum += Integer.parseInt(st.nextToken());
				max = Math.max(max, sum);
				if (sum < 0) {
					sum = 0;
				}
				arr[i] = sum;
			}
			
			System.out.println(max);
		}
	}

}
