package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

class Top {
	int num;
	int h;
	
	Top(int num, int height) {
        this.num = num;
        this.h = height;
    }
}

public class 탑 {
	static int N;
	
	public static void main(String[] args) throws IOException {
		Stack<Top> stack = new Stack<>();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder ans = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N =  Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			int h = Integer.parseInt(st.nextToken());
			
			if (stack.isEmpty()) {
				ans.append("0 ");
				stack.push(new Top(i, h));
			} else {
				while(true) {
					if(stack.isEmpty()) {
						ans.append("0 ");
						stack.push(new Top(i, h));
						break;
					}
					if(stack.peek().h > h) {
						ans.append(stack.peek().num + " ");
						stack.push(new Top(i,h));
						break;
					} else {
						stack.pop();
					}
				}
			}
		}
		
		System.out.println(ans.toString());
		
	}

}
