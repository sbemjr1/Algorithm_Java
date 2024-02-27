package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1753_최단경로 {
	static class Node{
		int vertex, weight;
		Node next;
		
		public Node(int vertex, int weight, Node next) {
			this.vertex = vertex;
			this.weight = weight;
			this.next = next;
		}
	}
	
	static int V,E,start;
	static Node[] adjList;
	static boolean[] v;
	static int[] minDistance;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		adjList = new Node[V+1];
		
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			adjList[from]=(new Node(to,weight,adjList[from]));
		}
		
		v = new boolean[V+1];
		minDistance = new int[V+1];
		
		Arrays.fill(minDistance, Integer.MAX_VALUE);
		minDistance[start] = 0;
		
		for (int i = 1; i <= V; i++) {
			int min = Integer.MAX_VALUE;
			int minVertex = -1;
			
			for (int j = 1; j <= V; j++) {
				if(!v[j] && minDistance[j] < min) {
					min = minDistance[j];
					minVertex = j;
				}
			}
			
			if(minVertex == -1) {
				break;
			}
			v[minVertex] = true;
			
			for (Node tmp = adjList[minVertex]; tmp != null; tmp = tmp.next) {
				if(minDistance[tmp.vertex] > min + tmp.weight) {
					minDistance[tmp.vertex] = min + tmp.weight;
				}
			}
		}
		
		for (int i = 1; i <= V; i++) {
			System.out.println(minDistance[i] == Integer.MAX_VALUE ? "INF" : minDistance[i]);
		}
	}

}
