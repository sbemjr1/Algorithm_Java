package swea;

import java.util.Scanner;

public class Ladder1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int di = 0;
		int dj = 0;
		
		for (int tc = 1; tc <= 10; tc++) {
			int t = sc.nextInt();
			int[][] ladder_map = new int[102][102];
			
			for (int i = 1; i < 101; i++) {
				for (int j = 1; j < 101; j++) {
					ladder_map[i][j] = sc.nextInt();
					if (ladder_map[i][j] == 2) {
						di = i;
						dj = j;
						System.out.println(dj);
					}
				}
			}
			
			for (int i = 100; i > 0; i--) {
				if (ladder_map[i][dj-1] == 1) {
					while(true) {
						dj--;
						if (ladder_map[i][dj] == 0) {
							dj += 1;
							break;
						}
					}
				} else if (ladder_map[i][dj+1] == 1) {
					while(true) {
						dj++;
						if (ladder_map[i][dj] == 0) {
							dj -= 1;
							break;
						}
					}
				}
			}
			System.out.println("#"+tc+" "+(dj-1));
		}
	}

}
