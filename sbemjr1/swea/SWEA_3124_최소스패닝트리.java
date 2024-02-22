package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 크루스칼 알고리즘 사용
public class SWEA_3124_최소스패닝트리 {
	static class Edge implements Comparable<Edge> {
		int from,to,weight;

		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}

		@Override
		public String toString() {
			return "Edge [from=" + from + ", to=" + to + ", weight=" + weight + "]";
		}
		
	}
	
	static int T,V,E, root[];
	static Edge[] edgeList;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		T = Integer.parseInt(st.nextToken());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());

			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			edgeList = new Edge[E];
			
			// 간선 리스트 생성
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				
				edgeList[i] = new Edge(from,to,weight);
			}
			
			// 전처리 : 간선 리스트 가중치 기준으로 오름차순 정렬
			Arrays.sort(edgeList);
			
			// 1. make-set
			make();
			
			int cnt = 0;
			long weight = 0;
			for (Edge edge : edgeList) {
				if(!union(edge.from, edge.to)) {
					continue;
				}
				weight+=edge.weight;
				if(++cnt == V-1) {
					break;
				}
			}
			
			System.out.println("#"+tc+" "+weight);
		}
	}

	private static void make() {
		root = new int[V+1];
		for (int i = 1; i <= V; i++) {
			root[i] = i;
		}
	}
	
	private static int find(int a) {
		if(root[a] == a) {
			return a;
		}
		return root[a] = find(root[a]);
	}
	
	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot) {
			return false;
		}
		
		root[bRoot] = aRoot;
		return true;
	}
}
