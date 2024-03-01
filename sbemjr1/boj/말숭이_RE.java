import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class 말숭이_RE {
	static class Monkey {
		int r,c,cnt,horse;

		public Monkey(int r, int c, int cnt, int horse) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.horse = horse;
		}
	}
	
	static int K,W,H,ans;
	static int[][] map;
	
	static int[] dr = {-1,0,1,0,-2,-1,1,2,2,1,-1,-2}; //0-3 원숭이 3-11 말
	static int[] dc = {0,1,0,-1,1,2,2,1,-1,-2,-2,-1};
	
	static boolean[][][] v;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		K = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		map = new int[H][W];
		v = new boolean[H][W][K+1]; // K는 말처럼 움직일 수 있는 횟수
		
		for (int r = 0; r < H; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < W; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		ans = Integer.MIN_VALUE;
		bfs(0,0);
		System.out.println(ans == Integer.MIN_VALUE ? -1 : ans);
	}

	private static void bfs(int r, int c) {
		Queue<Monkey> q = new ArrayDeque<>();
		q.add(new Monkey(r, c, 0, 0));
		v[r][c][0] = true;
		
		while(!q.isEmpty()) {
			Monkey m = q.poll();
			int nowR = m.r;
			int nowC = m.c;
			
			if(nowR == H-1 && nowC == W-1) {
				ans = m.cnt;
				break;
			}
			
			for (int d = 0; d < 12; d++) {
				int nextR = nowR + dr[d];
				int nextC = nowC + dc[d];
				
				if(nextR>=0 && nextR<H && nextC>=0 && nextC<W) {
					if(d<=3) {
						if(map[nextR][nextC] == 0 && !v[nextR][nextC][m.horse]) {
							v[nextR][nextC][m.horse] = true;
							q.add(new Monkey(nextR, nextC, m.cnt+1, m.horse));
						}
					}
					if(m.horse == K) continue;
					if(d>3) {
						if(map[nextR][nextC] == 0 && !v[nextR][nextC][m.horse+1]) {
							v[nextR][nextC][m.horse+1] = true;
							q.add(new Monkey(nextR, nextC, m.cnt+1, m.horse+1));
						}
					}
				}

			}
			
		}
	}

}
