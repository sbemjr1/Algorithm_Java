package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_7465_창용마을무리의개수 {
	static int T,N,M,ans;
	static ArrayList<Integer>[] graph;
	static boolean v[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		T = Integer.parseInt(st.nextToken());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			graph = new ArrayList[N+1];
			v = new boolean[N+1];
			ans = 0;
			
			for (int i = 1; i <= N; i++) {
				graph[i] = new ArrayList<Integer>();
			}
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				
				graph[from].add(to);
				graph[to].add(from);
			}
			
			for (int i = 1; i <= N; i++) {
				if(!v[i]) {
					dfs(i);
//					bfs(i);
					ans++;
				}
			}
			
			System.out.println("#"+tc+" "+ans);
		}
	}

	private static void bfs(int start) {
		Queue<Integer> q = new ArrayDeque<>();
		q.add(start);
		v[start] = true;
		
		while(!q.isEmpty()) {
			int current = q.poll();
			
			for (int i = 0; i < graph[current].size(); i++) {
				if(!v[graph[current].get(i)]) {
					v[graph[current].get(i)] = true;
					q.add(graph[current].get(i));
				}
			}
		}
	}

	private static void dfs(int current) {
		v[current] = true;
		
		for (int i = 0; i < graph[current].size(); i++) {
			if(!v[graph[current].get(i)]) {
				v[graph[current].get(i)] = true;
				dfs(graph[current].get(i));
			}
		}
	}
	
	

}
