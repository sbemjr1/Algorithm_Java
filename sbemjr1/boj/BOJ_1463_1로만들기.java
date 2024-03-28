import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1463_1로만들기 {
	static int N, ans;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		if (N < 4) {
			arr = new int[4];
		} else {
			arr = new int[N + 1];
		}
		Arrays.fill(arr, Integer.MAX_VALUE);
		arr[0] = 0;
		arr[1] = 0;
		arr[2] = 1;
		arr[3] = 1;

		for (int i = 4; i <= N; i++) {
			if (i % 3 == 0) {
				arr[i] = Math.min(arr[i], arr[i / 3] + 1);
			}
			if (i % 2 == 0) {
				arr[i] = Math.min(arr[i], arr[i / 2] + 1);
			}
			arr[i] = Math.min(arr[i], arr[i - 1] + 1);
		}
		System.out.println(arr[N]);
	}
}
