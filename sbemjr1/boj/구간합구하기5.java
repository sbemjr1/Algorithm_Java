package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 구간합구하기5 {
	static int N, M, sum, ans;
	static int[][] arr, res;
	
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine()); //StringTokenizer인자값에 입력 문자열 넣음
		N = Integer.parseInt(st.nextToken()); //첫번째 호출
		M = Integer.parseInt(st.nextToken()); //두번째 호출
		arr = new int[N+1][N+1];
		res = new int[N+1][N+1];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 1. 구간합 테이블 (1,1) ~ (x, y) 만들기
		for (int j = 1; j <= N; j++) {
			for (int k = 1; k <= N; k++) {
				res[j][k] = arr[j][k] + res[j][k-1] + res[j-1][k] - res[j-1][k-1];
			}
		}
		
		// 2. 구간합 테이블을 이용해서 (x1, y1) ~ (x2, y2) 까지의 구간합 구하기
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			ans = res[x2][y2] - res[x2][y1-1] - res[x1-1][y2] + res[x1-1][y1-1];
			sb.append(ans+"\n");
		}
		System.out.println(sb.toString());
	}

}
