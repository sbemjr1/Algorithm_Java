
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_4485_녹색옷입은애가젤다지 {
	static class Vertex implements Comparable<Vertex> {
		int node, weight;

		public Vertex(int node, int weight) {
			super();
			this.node = node;
			this.weight = weight;
		}

		@Override
		public int compareTo(Vertex o) {
			return Integer.compare(this.weight, o.weight);
		}

	}

	static class Node {
		int vertex, weight;
		Node next;

		public Node(int vertex, int weight, Node next) {
			this.vertex = vertex;
			this.weight = weight;
			this.next = next;
		}

		@Override
		public String toString() {
			return "Node [vertex=" + vertex + ", weight=" + weight + ", next=" + next + "]";
		}

	}

	static int T, N;
	static int[][] map;
	static Node[] adjList;

	static boolean[] v;
	static int[] minDistance;

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			if (N == 0) {
				break;
			}

			map = new int[N][N];

			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < N; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}

			adjList = new Node[N * N];

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					for (int d = 0; d < 4; d++) {
						int nr = r + dr[d];
						int nc = c + dc[d];

						if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
							adjList[r * N + c] = new Node(nr * N + nc, map[nr][nc], adjList[r * N + c]);
						}
					}
				}
			}

			v = new boolean[N * N];
			minDistance = new int[N * N];

			Arrays.fill(minDistance, Integer.MAX_VALUE);
			minDistance[0] = map[0][0];

			PriorityQueue<Vertex> pq = new PriorityQueue<>();
			pq.offer(new Vertex(0, minDistance[0]));
			int cnt = 0;

			while (!pq.isEmpty()) {
				Vertex minVertex = pq.poll();
				if (v[minVertex.node]) {
					continue;
				}
				v[minVertex.node] = true;
				if (++cnt == N * N) {
					break;
				}

				for (Node tmp = adjList[minVertex.node]; tmp != null; tmp = tmp.next) {
					if (!v[tmp.vertex] && minDistance[tmp.vertex] > minVertex.weight + tmp.weight) {
						minDistance[tmp.vertex] = minVertex.weight + tmp.weight;
						pq.offer(new Vertex(tmp.vertex, minVertex.weight + tmp.weight));
					}
				}
			}

//			for (int i = 0; i < N*N; i++) {
//				int min = Integer.MAX_VALUE;
//				int minVertex = -1;
//				
//				for (int j = 0; j < N*N; j++) {
//					if(!v[j] && minDistance[j] < min) {
//						min = minDistance[j];
//						minVertex = j;
//					}
//				}
//				
//				if(minVertex == -1) {
//					break;
//				}
//				v[minVertex] = true;
//				
//				for (Node tmp = adjList[minVertex]; tmp != null; tmp = tmp.next) {
//					if(!v[tmp.vertex] && minDistance[tmp.vertex] > min + tmp.weight) {
//						minDistance[tmp.vertex] = min + tmp.weight;
//					}
//				}
//			}
			T++;
			System.out.println("Problem " + T + ": " + minDistance[N * N - 1]);

		}
	}

}
