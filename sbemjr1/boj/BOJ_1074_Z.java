package boj;

import java.util.Scanner;

public class BOJ_1074_Z {
	static int N, l, dr, dc;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		dr = sc.nextInt();
		dc = sc.nextInt();
		
		l = (int) Math.pow(2, N);
		
		recursive(dr,dc,l/2,0);
	}

	private static void recursive(int dr, int dc, int leng, int sum) {
		if (leng == 0) {
			System.out.println(sum);
			return;
		}
		
		if (dr < leng && dc < leng) {
			recursive(dr,dc,leng/2,sum);
		} else if (dr < leng && dc >= leng) {
			recursive(dr,dc-leng,leng/2,sum + leng*leng);
		} else if (dr >= leng && dc < leng) {
			recursive(dr-leng,dc,leng/2,sum + leng*leng*2);
		} else if (dr >= leng && dc >= leng) {
			recursive(dr-leng,dc-leng,leng/2,sum + leng*leng*3);
		} 
	}

}
