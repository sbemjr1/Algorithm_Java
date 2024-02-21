package boj;

import java.util.Scanner;

public class 도영이가만든맛있는음식 {
	static int N, arr[][], ans;
	static boolean isSelected[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N][2];
		isSelected = new boolean[N];
		ans = Integer.MAX_VALUE;
		
		for (int i = 0; i < N; i++) {
			arr[i][0] = sc.nextInt(); //신맛 S
			arr[i][1] = sc.nextInt(); //쓴맛 B
		}
		
		recursive(0,1,0);
		System.out.println(ans);
	}

	private static void recursive(int cnt, int s, int b) {
		if (cnt == N) {
			if (s == 1 && b == 0) {
				return;
			} else {
//				System.out.println(s+" "+b);
				ans = Math.min(ans,Math.abs(s-b));
				return;
			}
		}
		
		isSelected[cnt] = true;
		recursive(cnt+1, s*arr[cnt][0], b+arr[cnt][1]);
		isSelected[cnt] = false;
		recursive(cnt+1, s, b);
	}

}
