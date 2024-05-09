import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1043_거짓말 {
	static int N, M, k;
	static boolean[] facts;
	static ArrayList<Integer>[] party;
	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		k = Integer.parseInt(st.nextToken());
		facts = new boolean[N + 1];

		party = new ArrayList[M + 1];

		parent = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}

		for (int i = 0; i < k; i++) {
			int idx = Integer.parseInt(st.nextToken());
			facts[idx] = true;
		}

		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());

			int l = Integer.parseInt(st.nextToken());
			party[i] = new ArrayList<>();
			if (l > 0) {
				int x = Integer.parseInt(st.nextToken());
				party[i].add(x);

				for (int j = 1; j < l; j++) {
					int y = Integer.parseInt(st.nextToken());
					union(x, y);
					party[i].add(y);
				}
			}
		}

		for (int i = 1; i < facts.length; i++) {
			if (facts[i]) {
				facts[find(i)] = true;
			}
		}

		int total = 0;
		int root;
		for (int i = 1; i <= M; i++) {
			if (party[i].size() > 0) {
				root = find(party[i].get(0));
				if (!facts[root])
					total++;
			}
		}
		// 거짓말 할 수 있는 파티 최대 수 출력
		System.out.println(total);
	}

	private static void union(int x, int y) {
		int rootX = find(x);
		int rootY = find(y);

		if (rootX != rootY) {
			if (rootX > rootY) {
				parent[rootX] = rootY;
			} else {
				parent[rootY] = rootX;
			}
		}
	}

	private static int find(int num) {
		if (parent[num] == num) {
			return num;
		}
		return find(parent[num]);
	}

}
