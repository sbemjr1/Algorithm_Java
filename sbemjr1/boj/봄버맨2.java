package boj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 봄버맨2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<int[][]> list = new ArrayList<>();
		int R = sc.nextInt();
		int C = sc.nextInt();
		int N = sc.nextInt();
		
		int[][] delta = {{-1,0},{1,0},{0,-1},{0,1}}; //상 하 좌 우
		
		Character[][] bombMap = new Character[R][C];
		
		for (int i = 0; i < R; i++) {
			String str = sc.next();
			for (int j = 0; j < C; j++) {
				bombMap[i][j] = str.charAt(j);
			}
		}
		if (N == 1) {
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					System.out.print(bombMap[i][j]);
				}
				System.out.println();
			}
		} else if (N%2 == 0) {
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					System.out.print('O');
				}
				System.out.println();
			}
		} else {
			if (N%4 == 3) {
					for (int i = 0; i < R; i++) {
						for (int j = 0; j < C; j++) {
							if (bombMap[i][j] == '.') {
								bombMap[i][j] = 'O';
							} else {
								bombMap[i][j] = 'X';
							}
						}
					}
					for (int i = 0; i < R; i++) {
						for (int j = 0; j < C; j++) {
							if (bombMap[i][j] == 'X') {
								bombMap[i][j] = '.';
								for (int k = 0; k < 4; k++) {
									int ni = i+delta[k][0];
									int nj = j+delta[k][1];
									
									if(ni >= 0 && nj >= 0 && ni < R && nj < C && bombMap[ni][nj] != 'X') {
										bombMap[ni][nj] = '.';
									}
								}
							}
						}
					}
			} else if (N%4 == 1) {
				for (int q = 0; q < 2; q++) {
					for (int i = 0; i < R; i++) {
						for (int j = 0; j < C; j++) {
							if (bombMap[i][j] == '.') {
								bombMap[i][j] = 'O';
							} else {
								bombMap[i][j] = 'X';
							}
						}
					}
					for (int i = 0; i < R; i++) {
						for (int j = 0; j < C; j++) {
							if (bombMap[i][j] == 'X') {
								bombMap[i][j] = '.';
								for (int k = 0; k < 4; k++) {
									int ni = i+delta[k][0];
									int nj = j+delta[k][1];
									
									if(ni >= 0 && nj >= 0 && ni < R && nj < C && bombMap[ni][nj] != 'X') {
										bombMap[ni][nj] = '.';
									}
								}
							}
						}
					}
				}
			}
					
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					System.out.print(bombMap[i][j]);
				}
				System.out.println();
			}
		}
	}

}
