import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9095_123더하기 {
	static int N, num, ans;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());

		for (int tc = 0; tc < N; tc++) {
			st = new StringTokenizer(br.readLine());

			num = Integer.parseInt(st.nextToken());

			if (num < 4) {
				arr = new int[4];
			} else {
				arr = new int[num + 1];
			}
			arr[0] = 0;
			arr[1] = 1;
			arr[2] = 2;
			arr[3] = 4;

			for (int i = 4; i <= num; i++) {
				arr[i] = arr[i - 1] + arr[i - 2] + arr[i - 3];
			}

			System.out.println(arr[num]);
		}
	}

}
