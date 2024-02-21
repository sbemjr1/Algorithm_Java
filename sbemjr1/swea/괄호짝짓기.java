package swea;

import java.util.Scanner;
import java.util.Stack;

public class 괄호짝짓기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int tc = 1; tc <= 10; tc++) {
			Stack<Character> stack = new Stack<Character>();
			int N = sc.nextInt();
			String input_data = sc.next();
			stack.push(input_data.charAt(0));
			
			for (int i = 1; i < N; i++) {
//				System.out.println(stack);
				if (stack.size() > 0 && (input_data.charAt(i) - stack.peek() == 2 || input_data.charAt(i) - stack.peek() == 1)) {
					stack.pop();
				} else {
					stack.push(input_data.charAt(i));					
				}
			}
			
			if (stack.size() == 0) {
				System.out.println("#"+tc+" "+1);
			} else {
				System.out.println("#"+tc+" "+0);
			}
		}
		
		
	}

}
