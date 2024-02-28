package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1767_프로세스연결하기 {
	static int T,N;
	static int[][] map;
	
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	
	static int process_cnt;
	static int[] sel;
	static int[][] multiverse;
	static boolean flag;
	
	static int conect_cnt, length;
	
	static int max_cnt, min_leng;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		T = Integer.parseInt(st.nextToken());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			map = new int[N+2][N+2];
			multiverse = new int[N+2][N+2];
			process_cnt = 0;
			
			for (int i = 0; i <= N+1; i++) { // 파워 영역 생성
				map[0][i] = 7;
				map[i][0] = 7;
				map[N+1][i] = 7;
				map[i][N+1] = 7;
			}
			
			for (int r = 1; r <= N; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 1; c <= N; c++) {
					map[r][c] = Integer.parseInt(st.nextToken()); // 입력
					for (int d = 0; d < 4; d++) {
						int nr = r + dr[d];
						int nc = c + dc[d];
						
						if (map[nr][nc] == 7 && map[r][c] == 1) {
							map[r][c] = 2; // 벽에 이미 붙어있는 경우
						}
					}
					if(map[r][c] == 1) {
						process_cnt++; // 고려해야 할 프로세스 갯수
					}
				}
			}
			
			sel = new int[process_cnt];
			max_cnt = Integer.MIN_VALUE;
			min_leng = Integer.MAX_VALUE;
			recursive(0);
			
			System.out.println("#"+tc+" "+min_leng);
		}
		
	}

	private static void recursive(int k) {
		if(k == process_cnt) {
			cal();
			
			if (conect_cnt > max_cnt) {
				max_cnt = conect_cnt;
				min_leng = length;
			} else if(conect_cnt == max_cnt) {
				if (length < min_leng) {
					min_leng = length;
				}
			}
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			sel[k] = i;
			recursive(k+1);
		}
	}

	private static void cal() {
		// 멀티버스 맵 복사
		for (int r = 0; r <= N+1; r++) {
			for (int c = 0; c <= N+1; c++) {
				multiverse[r][c] = map[r][c];
			}
		}
		
		int k = 0; // 몇 번째 프로세스 인지?
		conect_cnt = 0;
		length = 0;
		L:for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= N; c++) {
				if(multiverse[r][c] == 1) {
					flag = false;
					
					switch(sel[k++]) {
					case 0:
						for (int i = r-1; i >= 1; i--) {
							if(multiverse[i][c] != 0) {
								flag = true;
								break;
							}
						}
						if(!flag) {
							for (int i = r-1; i >= 1; i--) {
								multiverse[i][c] = 3;
								length++;
							}
							conect_cnt++;
						}
						break;
					case 1:
						for (int i = c+1; i <= N; i++) {
							if(multiverse[r][i] != 0) {
								flag = true;
								break;
							}
						}
						if(!flag) {
							for (int i = c+1; i <= N; i++) {
								multiverse[r][i] = 3;
								length++;
							}
							conect_cnt++;
						}
						
						break;
					case 2:
						for (int i = r+1; i <= N; i++) {
							if(multiverse[i][c] != 0) {
								flag = true;
								break;
							}
						}
						if(!flag) {
							for (int i = r+1; i <= N; i++) {
								multiverse[i][c] = 3;
								length++;
							}
							conect_cnt++;
						}
						
						break;
					case 3:
						for (int i = c-1; i >= 1; i--) {
							if(multiverse[r][i] != 0) {
								flag = true;
								break;
							}
						}
						if(!flag) {
							for (int i = c-1; i >= 1; i--) {
								multiverse[r][i] = 3;
								length++;
							}
							conect_cnt++;
						}
						break;
					}
					
					if(process_cnt - k + 1 + conect_cnt < max_cnt) {
						break L;
					}
				}
			}
		}

	}
	

}
