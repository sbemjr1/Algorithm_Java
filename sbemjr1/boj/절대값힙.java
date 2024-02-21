package boj;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 절대값힙 {
	static int N;
	
	public static void main(String[] args) {
		// 기본형: 우선순위가 낮은 숫자가 먼저 나옴 (작은 숫자)
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
        	if (Math.abs(a) == Math.abs(b)) {
        		return a - b;
        	}
        	return Math.abs(a) - Math.abs(b);
        });
        
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        
        for (int i = 0; i < N; i++) {
        	int num = sc.nextInt();
        	if (num == 0) {
    			if (pq.isEmpty()) {
    				System.out.println("0");
    			} else {
    				System.out.println(pq.poll());
    			}
        	} else {
        		pq.add(num);
        	}
		}
	}
}

