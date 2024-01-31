package swea;

import java.util.Scanner;

public class 농작물수확 {

	public static void main(String[] args) {
		Scanner	sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[][] map = new int[N][N];
			
			for (int i=0; i<N; i++) { // 입력
				String str = sc.next();
				int[] line = new int[N];
				for (int j=0; j<N; j++) {
					line[j] = str.charAt(j)-'0'; //정수 배열로 변환
				}
				map[i] = line;
			}
			
			int start = N / 2; //중간값
			int range = 0; //좌, 우 범위 설정
			int sum = 0; 
			boolean flag = true; //좌우 범위 설정을 위한 flag
			
			for (int i = 0; i < N; i++) {
				if (flag) { //range가 중간값 start보다 작으면 실행됨 (범위가 늘어나는 방향으로)
					for (int j = start - range; j <= start+range; j++) {
						sum += map[i][j];
					}
					range += 1;
					if (range >= start) { //range 크기가 start 이상이면 flag false로 설정하여 다른 반복문이 실행되도록 했음
						flag = false;
					}
				} else {//range가 중간값 start 이상이면 실행됨 (범위가 줄어드는 방향으로)
					for (int j = start - range; j <= start+range; j++) {
						sum += map[i][j];
					}
					range -= 1;
				}
			}
			
			System.out.println("#"+tc+" "+sum);
		}
	}

}

