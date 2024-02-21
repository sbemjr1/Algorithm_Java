package boj;

import java.util.Scanner;

public class DNA비밀번호 {
	static int S, P, la, lc, lg, lt, cntA, cntC, cntG, cntT, ans;
	static String input_data;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		S = sc.nextInt();
		P = sc.nextInt();
		
		input_data = sc.next();
		
		la = sc.nextInt();		
		lc = sc.nextInt();		
		lg = sc.nextInt();		
		lt = sc.nextInt();
		
		for (int i = 0; i < P; i++) {
			if (input_data.charAt(i) == 'A') {
				cntA += 1;
			} else if (input_data.charAt(i) == 'C') {
				cntC += 1;
			} else if (input_data.charAt(i) == 'G') {
				cntG += 1;
			} else if (input_data.charAt(i) == 'T') {
				cntT += 1;
			}
		}
		
		for (int i = 0; i <= S-P; i++) {
			if (cntA >= la && cntC >= lc && cntG >= lg && cntT >= lt) {
				ans += 1;
			}
			if (input_data.charAt(i) == 'A') {
				cntA -= 1;
			} else if (input_data.charAt(i) == 'C') {
				cntC -= 1;
			} else if (input_data.charAt(i) == 'G') {
				cntG -= 1;
			} else if (input_data.charAt(i) == 'T') {
				cntT -= 1;
			}
			
			if (i+P < S) {
				if (input_data.charAt(i+P) == 'A') {
					cntA += 1;
				} else if (input_data.charAt(i+P) == 'C') {
					cntC += 1;
				} else if (input_data.charAt(i+P) == 'G') {
					cntG += 1;
				} else if (input_data.charAt(i+P) == 'T') {
					cntT += 1;
				}
			}
		}
		
		System.out.println(ans);
	}

}
