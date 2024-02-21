package boj;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class 요세푸스문제 {
	static int N, K, cnt;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<Integer> q = new ArrayDeque<>();
		
		N = sc.nextInt();
		K = sc.nextInt();
		List<Integer> ans = new ArrayList<>();
		
		cnt = 0;
		
		for (int i = 1; i <= N; i++) {
			q.offer(i);
		}
		
		while(!q.isEmpty()) {
			int tmp = q.poll();
			cnt++;
			if(cnt < K) {
				q.offer(tmp);
			} else {
				cnt-=K;
				ans.add(tmp);
			}
		}
		
		for (int i = 0; i < N; i++) {
			if (N == 1) {
				System.out.print("<"+ans.get(i)+">");
			} else if (i == 0) {
				System.out.print("<"+ans.get(i)+", ");
			} else if(i==N-1) {
				System.out.print(ans.get(i)+">");	
			} else {
				System.out.print(ans.get(i)+", ");
			}
		}
	}
}
