package swea;

import java.util.Scanner;

public class SWEA_3234_준환이의양팔저울 {
	static int[] weight, sel;
	static int[] RL;
	static int N, R, L, ans;
	static boolean[] v, b;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			
			weight = new int[N];
			sel = new int[N];
			RL = new int[N];
			v = new boolean[N];
			b = new boolean[N];
			R = 0;
			L = 0;
			ans = 0;
			
			for (int i = 0; i < N; i++) {
				weight[i] = sc.nextInt();
			}
			
			recursive(0);
			System.out.println("#"+tc+" "+ans);
		}
	}

	private static void recursive(int k) {
		//basis part
		if(k==sel.length) {
			R = 0;
			L = 0;
			combination(0,0,R,L);
			return;
		}
		
		//inductive part
		for (int i = 0; i < N; i++) {
			if(v[i] == false) {
				v[i] = true;
				sel[k] = weight[i];
				recursive(k+1);
				v[i] = false;
			}
		}
	}

	private static void combination(int idx, int k, int R, int L) {
		if (k == N) {
			if (R <= L) {
				ans++;	
			}
			return;
		}
		if (idx == N) {
			return;
		}
		
		b[k] = true; // R 선택
		combination(idx+1, k+1, R+sel[idx], L);
		if (R<=L) {
			b[k] = false; // L 선택
			combination(idx+1, k+1, R, L+sel[idx]);	
		}
	}

}
