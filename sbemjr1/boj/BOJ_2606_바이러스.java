package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2606_바이러스 {
	static int V, E, ans;
	static ArrayList<Integer>[] graph;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		E = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[V+1];
		visited = new boolean[V+1];
//		ArrayList<Integer> ans = new ArrayList<>();
		for (int i = 0; i <= V; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			
			int from =Integer.parseInt(st.nextToken());
			int to =Integer.parseInt(st.nextToken());
			
			graph[from].add(to);
			graph[to].add(from);
		}
//		for (int i = 0; i < V; i++) {
//			System.out.print(i+" : ");
//			System.out.println(graph[i]);
//		}
//		
//		bfs(1);
		dfs(1);
		System.out.println(ans);
	}
	
	private static void bfs(int start) {
		Queue<Integer> q = new ArrayDeque<>();
		q.add(start);
		visited[start] = true;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for (int i = 0; i < graph[cur].size(); i++) {
				int next = graph[cur].get(i);
				if (!visited[next]) {
					visited[next] = true;
					q.add(next);
					ans++;
				}
			}
		}
	}
	
	private static void dfs(int cur) {
		visited[cur] = true;
		
		for (int i = 0; i < graph[cur].size(); i++) {
			if(!visited[graph[cur].get(i)]) {
				dfs(graph[cur].get(i));
				ans++;
			}
		}
	}
}
