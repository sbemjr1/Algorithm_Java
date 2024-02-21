package swea;

import java.util.Arrays;
import java.util.Scanner;

public class D3_진기의최고급붕어빵 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int K = sc.nextInt();
			
			int[] visitTime = new int[N];
			
			for (int i = 0; i < N; i++) {
				visitTime[i] = sc.nextInt();
			}
			
			Arrays.sort(visitTime);
			int cnt = 0;
			int remain = 0;
			int adder = M;
			int flag = 0;
			
			if (visitTime[0] < M) {
				System.out.println("#"+tc+" "+"Impossible");
				continue;
			}
			
			for (int i = 0; i < visitTime.length; i++) {
				cnt++;
			}
			
			if(flag == 0) {
				System.out.println("#"+tc+" "+"Possible");
			}
		}
	}
}
