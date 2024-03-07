import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14501_퇴사 {
	static class Meeting {
		int t, p;

		public Meeting(int t, int p) {
			this.t = t;
			this.p = p;
		}

		@Override
		public String toString() {
			return "Meeting [t=" + t + ", p=" + p + "]";
		}
	}

	static int N, ans;
	static Meeting[] arr;
	static int[] sel;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		arr = new Meeting[N + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());

			int t = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			arr[i] = new Meeting(t, p);
		}

		ans = Integer.MIN_VALUE;

		sel = new int[N + 1];
		combination(1);

		System.out.println(ans);
	}

	private static void combination(int k) {
		if (k > N + 1) {
			return;
		}
		if (k == N + 1) {
			find_max_val();
			return;
		}

		find_max_val();
		sel[k] = 1;
		combination(k + arr[k].t);
		sel[k] = 0;
		combination(k + 1);
	}

	private static void find_max_val() {
		int result = 0;
		for (int i = 1; i <= N; i++) {
			if (sel[i] == 1) {
				result += arr[i].p;
			}
		}
		ans = Math.max(result, ans);
	}

}
