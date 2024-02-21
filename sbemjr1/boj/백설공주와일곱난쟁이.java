package boj;

import java.util.Scanner;

public class 백설공주와일곱난쟁이 {
	static int arr[], sel[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		arr = new int[9];
		sel = new int[7];
		
		for (int i = 0; i < 9; i++) {
			arr[i] = sc.nextInt();
		}
		
		combination(0,0,0);
	}

	private static void combination(int idx, int cnt, int ans) {
		//basis part
		if (cnt == 7) {
			if (ans == 100) {
				for (int i = 0; i < 7; i++) {
					System.out.println(sel[i]);
				}
			}
			return;
		}
		if (idx == 9) {
			return;
		}
		//inductive part
		sel[cnt] = arr[idx];
		combination(idx+1,cnt+1,ans+arr[idx]);
		combination(idx+1,cnt,ans);
	}

}
