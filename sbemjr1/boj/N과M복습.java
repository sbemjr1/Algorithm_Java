import java.io.IOException;
import java.util.Scanner;

public class N과M복습 {
	static int N, M, arr[], sel[];
	static boolean v[];
	
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
		
		combination(0,0);
	}

	private static void combination(int idx, int k) {
		if(k == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(sel[i]+" ");
			}
			System.out.println();
			return;
		}
		if(idx==N) {
			return;
		}
		sel[k] = arr[idx];
		combination(idx+1, k+1);
		combination(idx+1, k);
	}

	
}
