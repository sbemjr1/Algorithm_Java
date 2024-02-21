package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2252_줄세우기 {
	static int N,M;
	static int[] inDegree;
	static ArrayList<Integer>[] graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[N+1];
		inDegree = new int[N+1];
		
		for (int i = 0; i < N+1; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			graph[from].add(to);
			inDegree[to]++;
		}
		
		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			if(inDegree[i] == 0) {
				q.add(i);
//				System.out.print(i + " ");
			}
		}
		
		ArrayList<Integer> result = new ArrayList<>();
		while(!q.isEmpty()) {
			int cur = q.poll();
			System.out.print(cur + " ");
			result.add(cur);
			for (int i = 0; i < graph[cur].size(); i++) {
				int tmp = graph[cur].get(i);
				
				inDegree[tmp]--;
				
				if (inDegree[tmp] == 0) {
					q.add(tmp);
				}
			}
		}
	}

}
