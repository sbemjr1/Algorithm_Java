package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17471_게리맨더링 {
	static class Info {
		int n, value;

		public Info(int n, int value) {
			this.n = n;
			this.value = value;
		}

		@Override
		public String toString() {
			return "Info [n=" + n + ", value=" + value + "]";
		}
		
	}
	
	static int N, sumV, sumNV, min, result;
	static int[] arr;
	static boolean[] v, copyV;
	static ArrayList<Info>[] graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		arr = new int[N+1];
		
		graph = new ArrayList[N+1];
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 1; i <= N; i++) {
			
			arr[i] = Integer.parseInt(st.nextToken());
			graph[i] = new ArrayList<Info>();
		}
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			for (int j = 0; j < n; j++) {
				int to = Integer.parseInt(st.nextToken());
				graph[i].add(new Info(to,arr[to]));
			}
		}
		
		for (int i = 0; i <= N; i++) {
			System.out.println(graph[i]);
		}
		
		min =Integer.MAX_VALUE;
		result = 0;
		
		for (int i = 1; i <= N; i++) {
			v = new boolean[N+1];
			
			v[i] = true;
			dfs(i);
		}
		System.out.println(min == Integer.MAX_VALUE ? -1 : min);
	}

	private static void dfs(int cur) {
		// 여기서 구역 체크 및 인구 수 체크
		int regionCnt = 0;
		copyV = new boolean[N+1];
		for (int i = 1; i <= N; i++) {
			copyV[i] = v[i];
		}
		sumNV = 0;
		for (int i = 1; i <= N; i++) {
			if(!copyV[i]) {
				bfs(i);
				regionCnt++;
			}
		}
//		System.out.println(regionCnt);
		sumV = 0;
		for (int i = 1; i <= N; i++) {
			if (v[i]) {
				sumV += arr[i];
			}
		}
		
		result = Math.abs(sumV - sumNV);
		
		if (regionCnt == 1) {
			min = Math.min(result, min);
		}
		
		for (int i = 0; i < graph[cur].size(); i++) {
			if (!v[graph[cur].get(i).n]) {
				v[graph[cur].get(i).n] = true;
				dfs(graph[cur].get(i).n);
				v[graph[cur].get(i).n] = false;
			}
		}
	}

	private static void bfs(int start) {
		Queue<Info> q = new ArrayDeque<>();
		q.add(new Info(start,arr[start]));
		
		copyV[start] = true;
		
		while(!q.isEmpty()) {
			Info p = q.poll();
			int cur = p.n;
			sumNV += p.value;
			
			for (int i = 0; i < graph[cur].size(); i++) {
				if (!copyV[graph[cur].get(i).n]) {
					copyV[graph[cur].get(i).n] = true;
					q.add(graph[cur].get(i));
				}
			}
		}
	}

}
