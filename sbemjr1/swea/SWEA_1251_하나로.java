package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class SWEA_1251_하나로 {
	static int T,V;
	static double E;
	static Island[] map;
	static int[] set;
	static ArrayList<Edge> edgeList;
	
	static class Edge implements Comparable<Edge> {
		int from,to;
		double weight;

		public Edge(int from, int to, double weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "Edge [from=" + from + ", to=" + to + ", weight=" + weight + "]";
		}

		@Override
		public int compareTo(Edge o) {
			return Double.compare(this.weight, o.weight);
		}
	}
	
	static class Island {
		int r,c;

		public Island(int r, int c) {
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Island [r=" + r + ", c=" + c + "]";
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		T = Integer.parseInt(st.nextToken());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			
			V = Integer.parseInt(st.nextToken());
			
			map = new Island[V];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < V; i++) {
				int r = Integer.parseInt(st.nextToken());
				map[i] = new Island(r, 0);
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < V; i++) {
				int c = Integer.parseInt(st.nextToken());
				map[i].c = c;
			}
			st = new StringTokenizer(br.readLine());
			E = Double.parseDouble(st.nextToken());
			
			edgeList = new ArrayList<Edge>();
			for (int i = 0; i < V-1; i++) { // 간선 비용 구하기
				for (int j = i+1; j < V; j++) {
					int from = i;
					int to = j;
					double weight = Math.pow(Math.sqrt(Math.pow(Math.abs(map[i].r - map[j].r),2) + Math.pow(Math.abs(map[i].c - map[j].c), 2)),2) * E;
					
					edgeList.add(new Edge(from,to,weight));
				}
			}
			
			Collections.sort(edgeList);
			
//			for (int i = 0; i < edgeList.size(); i++) {
//				System.out.println(edgeList.get(i));
//			}
//			
			set = new int[V];
			
			for (int i = 0; i < V; i++) {
				set[i] = i;
			}
			
			int cnt = 0;
			double total = 0.0;
			for (Edge edge : edgeList) {
				if(!union(edge.from,edge.to)) {
					continue;
				}
				total += edge.weight;
				if(++cnt == V-1) {
					break;
				}
			}
			
			System.out.println("#"+tc+" "+(long) Math.round(total));
		}
	}

	private static boolean union(int a,int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot==bRoot) {
			return false;
		}
		set[bRoot]=aRoot;
		return true;
	}

	private static int find(int a) {
		if(set[a] == a) {
			return a;
		}
		return set[a] = find(set[a]);
	}	
	
}
