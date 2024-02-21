package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_3289_서로소집합 {
	static int T,N,M,arr[];
	// 높이를 저장하는 배열
//	static int[] height;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		T = Integer.parseInt(st.nextToken());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			sb = new StringBuilder();
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			arr = new int[N+1];
//			height = new int[N+1];
			
			// make-set
			for (int i = 1; i <= N; i++) {
				arr[i] = i;
			}
			
			// 연산 횟수
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				
				int method = Integer.parseInt(st.nextToken());	
				int a = Integer.parseInt(st.nextToken());	
				int b = Integer.parseInt(st.nextToken());
				
				if (method == 0) {
					union(a,b);
				} else {
					if(find(a) != find(b)) {
						sb.append(0);
					} else {
						sb.append(1);
					}
				}
			}
			System.out.println("#"+tc+" "+sb.toString());
			
		}
	}

	private static int find(int num) {
		if(arr[num] == num) {
			return arr[num];
		}else {
			return arr[num] = find(arr[num]);
		}
	}

	private static void union(int a, int b) {
		int parentA = find(a);
		int parentB = find(b);
		
		if(parentA <= parentB) {
			arr[parentB] = arr[parentA];
		} else {
			arr[parentA] = arr[parentB];
			
		}
		
	}

}
