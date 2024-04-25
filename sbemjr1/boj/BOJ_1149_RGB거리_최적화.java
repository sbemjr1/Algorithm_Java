import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1149_RGB거리_최적화 {
	static int N, ans;
	static int[][] map;
	static int[] tmp, res;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());

		map = new int[N][3];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			int red = Integer.parseInt(st.nextToken());
			int green = Integer.parseInt(st.nextToken());
			int blue = Integer.parseInt(st.nextToken());

			map[i][0] = red;
			map[i][1] = green;
			map[i][2] = blue;
		}
		
		for (int i = 1; i < N; i++) {
			map[i][0] += Math.min(map[i - 1][1], map[i - 1][2]);
			map[i][1] += Math.min(map[i - 1][0], map[i - 1][2]);
			map[i][2] += Math.min(map[i - 1][0], map[i - 1][1]);
		}
		
		System.out.println(Math.min(Math.min(map[N - 1][0], map[N - 1][1]), map[N - 1][2]));
	}

}
