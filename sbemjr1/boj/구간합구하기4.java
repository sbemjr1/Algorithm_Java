package boj;

import java.util.Scanner;

public class 구간합구하기4 {
	static int N, M, sum, ans;
	static int[] arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N];
		
		for (int i = 0; i < N; i++) {
			sum += sc.nextInt();
			arr[i] = sum;
		}
		
		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			if (a == 1) {
				System.out.println(arr[b-1]);
			} else {
				System.out.println(arr[b-1]-arr[a-2]);
			}
		}
	}

}
