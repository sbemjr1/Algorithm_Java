package boj;

import java.util.Arrays;
import java.util.Scanner;

public class 설탕배달 {
	static int N, Ans = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
//		내가 생각 못한 반례가 있었다.. => 완탐 ㄱㄱ
//		greedy(N);
//		완탐 => 답은 찾을 수 있으나 시간 초과
//		recursive(N,0);
//		System.out.println(Ans == Integer.MAX_VALUE ? -1 : Ans);
//		규칙성을 찾아내는 방식
		dp();
	}

	private static void dp() {
		// 각 무게당 필요한 봉지 수를 저장할 배열을 선언합니다.
		int[] dp = new int[N+1];
		Arrays.fill(dp, 9876543);
		dp[3] = 1;
		if (N >= 5) {
			dp[5] = 1;
		}
		for (int i = 6; i <= N; i++) {
			dp[i] = Math.min(dp[i-3]+1, dp[i-5]+1);
		}
		System.out.println(dp[N] >= 9876543 ? -1 : dp[N]);
//		System.out.println(Arrays.toString(dp));
	}

	private static void recursive(int n, int cnt) {
		//basis part
		if (n < 0) {
			return;
		}
		if (n == 0) {
			Ans = Math.min(Ans, cnt);
			return;
		}
		//inductive part
		recursive(n-5,cnt+1);
		recursive(n-3,cnt+1);
	}

	private static void greedy(int n) {
		int cnt = 0;
		
		while(n%5 != 0) {
			n -= 3;
			cnt++;
		}
		if(n<0) {
			System.out.println(-1);
		} else {
			cnt += n/5;
			System.out.println(cnt);
		}
	}
}
