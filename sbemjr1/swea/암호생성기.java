package swea;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class 암호생성기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 1; i <= 10; i++) {
			Queue<Integer> q = new ArrayDeque<Integer>();
			int N = sc.nextInt();
			
			for (int j = 0; j < 8; j++) {
				q.offer(sc.nextInt());
			}
			
			int cnt = 1;
			
			while (true) {
				int tmp = q.peek() - cnt++;
				if (cnt == 6) {
					cnt = 1;
				}
				if (tmp < 0) {
					tmp = 0;
				}
				q.poll();
				q.offer(tmp);
				if (tmp == 0) {
					break;
				}
			}
			System.out.print("#"+i+" ");
			for (int j = 0; j < 8; j++) {
				System.out.print(q.poll()+" ");
			}
			System.out.println();
		}
	}

}
