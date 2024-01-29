package sbemjr1;

import java.util.Scanner;

////다음 기회에 .....  GGGGGGGG
public class 오목 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int[][] map = new int[19][19];
		
		int[][] delta = {{-1,1},{0,1},{1,1},{1,0}}; //우상 우 우하 하
		int flag = 0;
		
		//오목판 입력
		for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 19; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 19; j++) {
				//검은돌을 마주침
				if (map[i][j] == 1) {
					//사방 탐색 시작 같은 색 돌을 찾으면 쭉 탐색+뒤에 확인(첫 돌인지)
					for (int k = 0; k < 4; k++) {
						int ni = i+delta[k][0];
						int nj = j+delta[k][1];
						int di = 0;
						int dj = 0;
						
						int cnt = 1;
						
						if (ni >= 0 && nj >= 0 && ni < 19 && nj < 19 && map[ni][nj] == 1) {
							while(true) {
								di += delta[k][0];
								dj += delta[k][1];
								
								if (i+di >= 0 && i+dj >= 0 && i+di < 19 && i+dj < 19 && map[i+di][i+dj] == 1) {
									cnt++;
								} else {
									break;
								}
							}
						}
						if (cnt == 5) {
							if (i==0 && j==0) {
								System.out.println("1");
								System.out.println((i+1) + " " + (j+1));
								flag = 1;
							} else if (i==0 && j > 0 && map[i][j-1] != 1) {
								System.out.println("1");
								System.out.println((i+1) + " " + (j+1));
								flag = 1;
							} else if (i>0 && j == 0 && map[i-1][j] != 1) {
								System.out.println("1");
								System.out.println((i+1) + " " + (j+1));
								flag = 1;
							} else if (i>0 && j > 0 && map[i-1][j-1] != 1) {
								System.out.println("1");
								System.out.println((i+1) + " " + (j+1));
								flag = 1;
							}
						}
					
					}
				}
				
				
				if (map[i][j] == 2) {
					//사방 탐색 시작 같은 색 돌을 찾으면 쭉 탐색+뒤에 확인(첫 돌인지)
					for (int k = 0; k < 4; k++) {
						int ni = i+delta[k][0];
						int nj = j+delta[k][1];
						int di = 0;
						int dj = 0;
						
						int cnt = 1;
						
						if (ni >= 0 && nj >= 0 && ni < 19 && nj < 19 && map[ni][nj] == 2) {
							while(true) {
								di += delta[k][0];
								dj += delta[k][1];
								
								if (i+di >= 0 && i+dj >= 0 && i+di < 19 && i+dj < 19 && map[i+di][i+dj] == 2) {
									cnt++;
								} else {
									break;
								}
							}
						}
						if (cnt == 5) {
							if (i==0 && j==0) {
								System.out.println("2");
								System.out.println((i+1) + " " + (j+1));
								flag = 1;
							} else if (i==0 && j > 0 && map[i][j-1] != 1) {
								System.out.println("2");
								System.out.println((i+1) + " " + (j+1));
								flag = 1;
							} else if (i>0 && j == 0 && map[i-1][j] != 1) {
								System.out.println("2");
								System.out.println((i+1) + " " + (j+1));
								flag = 1;
							} else if (i>0 && j > 0 && map[i-1][j-1] != 2) {
								System.out.println("2");
								System.out.println((i+1) + " " + (j+1));
								flag = 1;
							}
						}
					
					}
				}
				if (flag == 1) {
					break;
				}
			}
			if (flag == 1) {
				break;
			}
		}
		if (flag == 0) {
			System.out.println("0");
		}
	}
}


