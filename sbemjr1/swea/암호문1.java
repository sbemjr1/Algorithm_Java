package swea;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class 암호문1 {
	static int N, K;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 1; i <= 10; i++) {
			List<String> list = new ArrayList<>();
			Stack<String> stack = new Stack<>();
			N = sc.nextInt();
			
			for (int j = 0; j < N; j++) {
				list.add(sc.next());
			}
			K = sc.nextInt();
			
			for (int j = 0; j < K; j++) {
				String command = sc.next();
				int idx = sc.nextInt();
				int cnt = sc.nextInt();
				
				for (int k = 0; k < cnt; k++) {
					stack.push(sc.next());
				}
				for (int k = 0; k < cnt; k++) {
					list.add(idx, stack.pop());
				}
			}
			
			System.out.print("#"+i+" ");
			for (int j = 0; j < 10; j++) {
				System.out.print(list.get(j)+" ");
			}
			System.out.println();
		}
		
	}
}
