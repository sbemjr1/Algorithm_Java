package boj;

import java.io.IOException;
import java.util.Scanner;

public class N과M복습 {
	static int N, M, arr[], sel[];
//	static boolean v[];
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		arr = new int[N];
		sel = new int[M];
//		v = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = i+1;
		}
		
		recursive(0,0);
	}

	private static void recursive(int idx, int cnt) {
		if (cnt == sel.length) {
			for (int i = 0; i < sel.length; i++) {
				System.out.print(sel[i] + " ");
			}
			System.out.println();
			return;
		}
		if (idx == N) {
			return;
		}
		
		sel[cnt] = arr[idx];
		recursive(idx+1,cnt+1);
		recursive(idx+1,cnt);
	}
}
