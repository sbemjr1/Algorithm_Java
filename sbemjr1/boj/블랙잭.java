package boj;

import java.util.Scanner;

public class 블랙잭 {
	static int N, M, ans;
	static int[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N];
		ans = 0;
		
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		combination(0,0,0);
		System.out.println(ans);
	}

	private static void combination(int idx, int k, int sum) {
		if (sum > M) {
			return;
		}
		if (k == 3) {
			ans = Math.max(sum,ans);
			return;
		}
		for (int i = idx; i < arr.length; i++) {
			combination(i+1,k+1,sum+arr[i]);	
		}
	}

}
