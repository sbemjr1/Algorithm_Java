
import java.util.Scanner;

public class N과M2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] arr = new int[N];
		int[] sel = new int[M];

		for (int i = 0; i < N; i++) {
			arr[i] = i + 1;
		}

		recursive(arr, sel, 0, 0);
	}

	private static void recursive(int[] arr, int[] sel, int idx, int k) {
		if (k == sel.length) {
			for (int i = 0; i < sel.length; i++) {
				System.out.print(sel[i] + " ");
			}
			System.out.println();
			return;
		}
		if (idx == arr.length) {
			return;
		}
		sel[k] = arr[idx];
		recursive(arr, sel, idx + 1, k + 1);
		recursive(arr, sel, idx + 1, k);
	}

}
