package sbemjr1;

import java.util.Scanner;

public class SWEA_부먹왕국읭차원관문 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int D = sc.nextInt();
			
			int ans = 0;
			int cnt = 0;
			
			for (int i = 0; i < N; i++) {
				int data = sc.nextInt();
				
				if (data == 1) {
					cnt = 0;
				} else {
					cnt++;
				}
				if(cnt == D) {
					ans++;
					cnt = 0;
				}
			}
			System.out.println("#"+tc+" "+ans);
		}
	}

}
