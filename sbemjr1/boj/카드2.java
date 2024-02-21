package boj;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class 카드2 {
	static int N;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		Queue<Integer> q = new ArrayDeque<Integer>();
		
		for (int i = 1; i <= N; i++) {
			q.offer(i);
		}
		
		while(true) {
			if (q.size() == 1) {
				System.out.println(q.peek());
				break;
			}
			q.poll();
			int tmp = q.peek();
			q.poll();
			q.offer(tmp);
		}
	}

}
