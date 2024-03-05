import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_21610_마법사상어와비바라기 {
	static int N,M,dir,s,ans;
	static int[][] map;
	
	static boolean[][][] v;
 	
	static int[] dr = {0,0,-1,-1,-1,0,1,1,1}; // 0은 의미 없음
	static int[] dc = {0,-1,-1,0,1,1,1,0,-1};	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); //map의 크기
		M = Integer.parseInt(st.nextToken()); //이동 횟수
		
		map = new int[N][N];
		v = new boolean[N][N][2];
		
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if(r == N-1) {
					if(c == 0 || c == 1) {
						v[r][c][0] = true;
					}
				} else if(r == N-2) {
					if(c == 0 || c == 1) {
						v[r][c][0] = true;
					}
				}
			}
		}
		
		int k = 0;
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			dir = Integer.parseInt(st.nextToken()); //이동 방향
			s = Integer.parseInt(st.nextToken()); //이동 거리
			
			//명령만큼 이동
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if(v[r][c][k%2] == true) {
						int nr = (r + dr[dir] * s) % N < 0 ? (r + dr[dir] * s) % N + N : (r + dr[dir] * s) % N;
						int nc = (c + dc[dir] * s) % N < 0 ? (c + dc[dir] * s) % N + N : (c + dc[dir] * s) % N;
						
						v[r][c][k%2] = false;
						v[nr][nc][(k+1)%2] = true;
						map[nr][nc] += 1;
					}
				}
			}
			//대각선 탐색 후 물이 있는 구역 만큼 더해줌
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if(v[r][c][(k+1)%2] == true) {
						int cnt = 0;
						for (int d = 2; d <= 8; d+=2) {
							int nr = r + dr[d];
							int nc = c + dc[d];
							
							if(nr>=0 && nr<N && nc>=0 &&nc<N && map[nr][nc] > 0) {
								cnt++;
							}
						}
						map[r][c] += cnt;
					}
				}
			}
			//해당 구름 이외에 모두 구름 생성(물이 2이상인 경우)
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if(v[r][c][(k+1)%2] == false && map[r][c]>=2) {
						map[r][c] -= 2;
						v[r][c][(k+1)%2] = true;
					} else if(v[r][c][(k+1)%2] == true) {
						v[r][c][(k+1)%2] = false;
					}
				}
			}
			//다른 배열로 전환하기 위함
			k++;
		}
		
		adder();
		System.out.println(ans);
	}

	private static void adder() {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				ans += map[r][c];
			}
		}
	}

}
