import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_16637_괄호추가하기 {
	static int N, ans;
	static int[] numbers;
	static char[] symbols;
	static String input_data;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		input_data = st.nextToken();

		numbers = new int[N / 2 + 1];
		symbols = new char[N / 2];

		for (int i = 0; i < input_data.length(); i++) {
			if (i % 2 == 0) {
				numbers[i / 2] = input_data.charAt(i) - '0';
			} else {
				symbols[i / 2] = input_data.charAt(i);
			}
		}

		ans = Integer.MIN_VALUE;
		recursive(numbers[0], 0);

		System.out.println(ans);
	}

	private static void recursive(int result, int idx) {
		if (idx >= symbols.length) {
			ans = Math.max(result, ans);
			return;
		}

		int res1 = calc(symbols[idx], result, numbers[idx + 1]);
		recursive(res1, idx + 1);

		if (idx + 1 < symbols.length) {
			int res2 = calc(symbols[idx + 1], numbers[idx + 1], numbers[idx + 2]);
			recursive(calc(symbols[idx], result, res2), idx + 2);
		}
	}

	private static int calc(char sym, int n1, int n2) {
		if (sym == '+') {
			return n1 + n2;
		} else if (sym == '-') {
			return n1 - n2;
		} else if (sym == '*') {
			return n1 * n2;
		} 
		return -1;
	}

}
