package boj;

import java.util.Scanner;

public class N과M4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] arr = new int[N];
		int[] sel = new int[M];
		
		for (int i = 0; i < N; i++) {
			arr[i] = i+1;
		}
		
		recursive(arr,sel,0,0);
	}

	private static void recursive(int[] arr, int[] sel, int idx, int k) {
		if (k==sel.length) {
			for (int i = 0; i < sel.length; i++) {
				System.out.print(sel[i]+" ");
			}
			System.out.println();
			return;
		}
		if (idx == arr.length) {
			return;
		}
		for (int i = idx; i < arr.length; i++) {
			sel[k] = arr[i];
			recursive(arr, sel, i, k+1);
		}
	}

}
