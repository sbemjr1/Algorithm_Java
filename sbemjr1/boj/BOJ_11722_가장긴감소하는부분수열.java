import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11722_가장긴감소하는부분수열 {
	static int N;
	static int[] arr, res;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		arr = new int[N];
		res = new int[N];
		int ans = 0;

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i] >= res[j]) {
					if (res[j] == 0) {
						ans++;
					}
					res[j] = arr[i];
					break;
				}
			}
		}

		System.out.println(ans);
	}

}
