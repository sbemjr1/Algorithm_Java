
import java.util.Scanner;

public class N과M1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] arr = new int[N];
		int[] sel = new int[M];
		boolean[] v = new boolean[N];

		for (int i = 0; i < N; i++) {
			arr[i] = i + 1;
		}

		recursive(arr, sel, v, 0);
	}

	private static void recursive(int[] arr, int[] sel, boolean[] v, int k) {
		if (k == sel.length) {
			for (int i = 0; i < sel.length; i++) {
				System.out.print(sel[i] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = 0; i < arr.length; i++) {
			if (v[i] == false) {
				v[i] = true;
				sel[k] = arr[i];
				recursive(arr, sel, v, k + 1);
				v[i] = false;
			}
		}
	}

}
