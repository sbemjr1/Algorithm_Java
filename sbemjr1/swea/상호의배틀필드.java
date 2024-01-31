package swea;

import java.util.Arrays;
import java.util.Scanner;

public class 상호의배틀필드 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			int H = sc.nextInt();
			int W = sc.nextInt();
			char[][] map = new char[H][W];
			
			// 현재 위치와 진행 방향
			int x = 0;
			int y = 0;
			char direction= 0;
			
			for (int i=0; i<H; i++) { // 입력
				String str = sc.next();
				char[] line = new char[W];
				for (int j=0; j<W; j++) {
					line[j] = str.charAt(j);
					// 만약 전차의 위치가 나타나면 현재 위치에 저장
					if (str.charAt(j) =='^' || str.charAt(j) =='v' || str.charAt(j) =='<' || str.charAt(j) =='>') {
						x = i;
						y = j;
						direction = str.charAt(j);
					}
				}
				map[i] = line;
			}
			
			int N = sc.nextInt();
			String command = sc.next();
			
			for (int i = 0; i < N; i++) {
				if (command.charAt(i) == 'S') {
					// shoot 구현 현재 진행 방향을 고려하여 구현
					if (direction == '<') {
						for (int j = y; j >= 0; j--) {
							// 벽돌 벽이 나오면 현재 위치를 평지로 바꾸고 반복문 break
							if(map[x][j] == '*') {
								map[x][j] = '.';
								break;
							}
							// 강철 벽이 나오면 반복문 break
							if (map[x][j] == '#') {
								break;
							}
						}
					}
					if (direction == '>') {
						for (int j = y; j < W; j++) {
							if(map[x][j] == '*') {
								map[x][j] = '.';
								break;
							}
							if (map[x][j] == '#') {
								break;
							}
						}
					}
					if (direction == 'v') {
						for (int j = x; j < H; j++) {
							if(map[j][y] == '*') {
								map[j][y] = '.';
								break;
							}
							if (map[j][y] == '#') {
								break;
							}
						}
					}
					if (direction == '^') {
						for (int j = x; j >= 0; j--) {
							if(map[j][y] == '*') {
								map[j][y] = '.';
								break;
							}
							if (map[j][y] == '#') {
								break;
							}
						}
					}
				}
				
				// 이동 방향 구현
				if (command.charAt(i) == 'U') {
					direction = '^';
					// 게임 맵 범위와 평지인지를 고려하여 현재 위치 갱신
					if(x - 1 >= 0 && map[x-1][y] == '.') {
						map[x-1][y] = '^';
						map[x][y] = '.';
						x -= 1;
					} else {
						map[x][y] = '^';
					}
				}
				if (command.charAt(i) == 'D') {
					direction = 'v';
					if(x + 1 < H && map[x+1][y] == '.') {
						map[x+1][y] = 'v';
						map[x][y] = '.';
						x += 1;
					} else {
						map[x][y] = 'v';
					}
				}
				if (command.charAt(i) == 'R') {
					direction = '>';
					if(y + 1 < W && map[x][y+1] == '.') {
						map[x][y+1] = '>';
						map[x][y] = '.';
						y += 1;
					} else {
						map[x][y] = '>';
					}
				}
				if (command.charAt(i) == 'L') {
					direction = '<';
					if(y - 1 >= 0 && map[x][y-1] == '.') {
						map[x][y-1] = '<';
						map[x][y] = '.';
						y -= 1;
					} else {
						map[x][y] = '<';
					}
				}
			}
			System.out.print("#"+tc+ " ");
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}

	}

}
