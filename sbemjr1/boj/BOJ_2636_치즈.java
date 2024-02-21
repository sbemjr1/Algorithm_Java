package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2636_치즈 {
	static int N,M,map[][],air,before,cnt,config;
	static boolean v[][];
	
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		v = new boolean[N][M];
		air = 3;
		
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 치즈가 모두 녹을 때까지 프로그램 실행
		while(true) {
			cnt = 0; // 0의 개수를 저장
			before = 0; // 녹기 한 시간 전 치즈 개수 치즈 개수
			config = 0; // 공기(녹은 후에 공간+초기 공기)
			
			// 녹기 한 시간 전 치즈 개수
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					if(map[r][c] == 1) {
						before++;
					}
				}
			}
			
			// 빈 공간을 공기로 채움
			airDFS(0,0);
			
			// 만약 공기와 접촉한 치즈라면 녹이기
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					if(map[r][c] == 1) {
						if(meltCheese(r, c)) {
							// 녹여버려
							map[r][c] = 0;
						}
					}
				}
			}
			
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					// 한 시간이 지난 뒤에 빈 공간(0) 카운트
					if(map[r][c] == 0) {
						cnt++;
					}
					// 한 시간이 지난 뒤에 빈 공간(0)과 치즈 개수(1) 카운트
					if(map[r][c] < air) {
						config++;
					}
				}
			}
			
			// 만약 빈공간과 빈공간+치즈 개수가 같다면 프로그램 스탑
			if (config == cnt) {
				break;
			}
			
			air++; // 시간 측정을 위해 증가 시킴
		}
		
		System.out.println(air - 2); // 초기값이 3이므로 2빼줌
		System.out.print(before);
	}

	private static void airDFS(int r, int c) {
		// 사방 탐색
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			// 지도 경계 안 쪽이거나 빈 공간이거나 이미 공기가 채워진 공간으로 이동 가능
			if (nr >= 0 && nr < N && nc >= 0 && nc < M && (map[nr][nc] == 0 || map[nr][nc] == air - 1)) {
				// 빈 공간을 공기로 채워줌
				map[nr][nc] = air;
				airDFS(nr,nc);
			}
		}
	}

	private static boolean meltCheese(int r, int c) {
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			// 지도 경계 안 이거나 공기와 접촉했으면 true 리턴
			if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] == air) {
				return true;
			}
		}
		return false;
	}
}
