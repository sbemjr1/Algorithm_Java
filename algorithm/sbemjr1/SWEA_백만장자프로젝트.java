package sbemjr1;

import java.util.Scanner;

public class SWEA_백만장자프로젝트 {
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int tc = 1; tc <= T; tc++)
		{
			int N = sc.nextInt();
			int[] arr = new int[N];
			
			long total = 0;
			
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			int max = 0;
			
			for (int i = N-1; i>=0; i--) {
				if (max <= arr[i]) {
					max = arr[i];
				} else {
					total += max - arr[i];
				}
			}
			System.out.println("#"+tc+" "+total);
		}
	}
}
