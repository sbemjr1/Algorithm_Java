
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1927_최소힙 {
	static int N;

	static class Num implements Comparable<Num> {
		int num;

		public Num(int num) {
			super();
			this.num = num;
		}

		@Override
		public int compareTo(Num o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.num, o.num);
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		PriorityQueue<Num> pq = new PriorityQueue<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(st.nextToken());
			
			if (x == 0) {
				if (pq.isEmpty()) {
					System.out.println(0);
				} else {
					System.out.println(pq.poll().num);
				}
			} else {
				pq.offer(new Num(x));
			}
		}
	}

}
