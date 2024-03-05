import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1260_DFS와BFS {
	static class Node implements Comparable<Node> {
		int vertex;
		
		public Node(int vertex) {
			this.vertex = vertex;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.vertex, o.vertex);
		}
	}
	
	static int V,E,N;
	static ArrayList<Node>[] adjList;
	
	static boolean[] v;

	public static void main(String[] args) throws IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken()); //정점의 수
		E = Integer.parseInt(st.nextToken()); //간선의 수
		N = Integer.parseInt(st.nextToken()); //시작 정점
		
		adjList = new ArrayList[V+1]; //0은 더미
		v = new boolean[V+1];
		
		for (int i = 1; i <= V; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			adjList[from].add(new Node(to));
			adjList[to].add(new Node(from));
		}
		
		for (int i = 1; i <= V; i++) {
			Collections.sort(adjList[i]);
		}
		
		v[N] = true;
		System.out.print(N+" ");
		dfs(N);
		
		System.out.println();
		v = new boolean[V+1];
		bfs(N);
	}

	private static void bfs(int start) {
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(start);
		v[start] = true;
		System.out.print(start+" ");
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for (int i = 0; i < adjList[cur].size(); i++) {
				if(!v[adjList[cur].get(i).vertex]) {
					v[adjList[cur].get(i).vertex] = true;
					System.out.print(adjList[cur].get(i).vertex+" ");
					q.offer(adjList[cur].get(i).vertex);
				}
			}
		}
	}

	private static void dfs(int cur) {
		
		for (int i = 0; i < adjList[cur].size(); i++) {
			if(!v[adjList[cur].get(i).vertex]) {
				v[adjList[cur].get(i).vertex] = true;
				System.out.print(adjList[cur].get(i).vertex+" ");
				dfs(adjList[cur].get(i).vertex);
			}
		}
	}

}
