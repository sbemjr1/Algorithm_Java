import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2579_계단오르기 {
	static int N, ans;
	static int[] map;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());

		map = new int[N + 1];
		arr = new int[2][N + 1]; // 0 : 한칸만 뛴 경우 1 : 두칸 뛴 경우

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());
			map[i] = n;
		}

		int result;
		if (N == 1) {
			result = map[1];
		} else if (N == 2) {
			result = map[1] + map[2];
		} else {
			arr[0][1] = map[1];
			arr[1][1] = 0;
			arr[0][2] = map[1] + map[2];
			arr[1][2] = map[2];

			for (int i = 3; i <= N; i++) {
				arr[0][i] = arr[1][i - 1] + map[i];

				arr[1][i] = Math.max(arr[0][i - 2], arr[1][i - 2]) + map[i];
			}

			result = (Math.max(arr[0][N], arr[1][N]));
		}

		System.out.println(result);
	}

}
