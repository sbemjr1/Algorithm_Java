import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_17471_게리맨더링_조합_DFS {
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
	
	static int N, sum_A, sum_B, min, result;
	static int[] people;
	static boolean[] v_A,v_B,sel;
	
	static ArrayList<Info>[] graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		people = new int[N+1];
		
		graph = new ArrayList[N+1];
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 1; i <= N; i++) {
			people[i] = Integer.parseInt(st.nextToken());
			graph[i] = new ArrayList<Info>();
		}
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			for (int j = 0; j < n; j++) {
				int to = Integer.parseInt(st.nextToken());
				graph[i].add(new Info(to,people[to]));
				graph[to].add(new Info(i,people[i]));
			}
		}
//		for (int i = 0; i <= N; i++) {
//			System.out.println(graph[i]);
//		}
		
		// 조합
		sel = new boolean[N];
		v_A = new boolean[N+1];
		v_B = new boolean[N+1];
		result = 0;
		min = Integer.MAX_VALUE;
		combination(0);
		
		System.out.println(min == Integer.MAX_VALUE ? -1 : min);
	}

	private static void combination(int k) {
		if (k == N) {
			// 모두 false 거나 true 인 경우 제외
			if (falseCheck(0,N-1,sel)) {
				return;
			}
			if (trueCheck(0,N-1,sel)) {
				return;
			}
			// dfs
			sum_A = 0;
			sum_B = 0;
			divideTest();
			return;
		}
		
		sel[k] = true;
		combination(k+1);
		sel[k] = false;
		combination(k+1);
	}

	private static void divideTest() {
		// 방문 배열 복사복 생성
		for (int i = 0; i < N; i++) {
			v_A[i+1] = sel[i];
			v_B[i+1] = !sel[i];
		}
		
		// 방문 배열 탐색 후 false 발견 하면 dfs 한번 실행
		for (int i = 1; i <= N; i++) {
			if(!v_A[i]) {
				v_A[i] = true;
				sum_A += people[i];
				dfs_A(i);
				break;
			}
		}
		for (int i = 1; i <= N; i++) {
			if(!v_B[i]) {
				v_B[i] = true;
				sum_B += people[i];
				dfs_B(i);
				break;
			}
		}
		// dfs 실행 후에 모두 true이면 인구 차이 실행 및 최솟값 갱신
		if(trueCheck(1, N, v_A) && trueCheck(1, N, v_B)) {
			result = Math.abs(sum_A - sum_B);
			min = Math.min(result, min);
		}
	}

	private static void dfs_A(int cur) {
		for (int i = 0; i < graph[cur].size(); i++) {
			if(!v_A[graph[cur].get(i).n]) {
				v_A[graph[cur].get(i).n] = true;
				sum_A += graph[cur].get(i).value;
				dfs_A(graph[cur].get(i).n);
			}
		}
	}
	
	private static void dfs_B(int cur) {
		for (int i = 0; i < graph[cur].size(); i++) {
			if(!v_B[graph[cur].get(i).n]) {
				v_B[graph[cur].get(i).n] = true;
				sum_B += graph[cur].get(i).value;
				dfs_B(graph[cur].get(i).n);
			}
		}
	}

	private static boolean falseCheck(int start, int end, boolean visited[]) {
		for (int i = start; i <= end; i++) { //모두 false
			if (visited[i]) {
				return false;
			}
		}
		return true;
	}
	private static boolean trueCheck(int start, int end, boolean visited[]) {
		for (int i = start; i <= end; i++) { // 모두 true
			if (!visited[i]) {
				return false;
			}
		}
		return true;
	}

}
