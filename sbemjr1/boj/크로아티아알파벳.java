package boj;

import java.util.Scanner;

public class 크로아티아알파벳 {
	static String alpha[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = "*" + sc.next() + "*";
		
		alpha = new String[] {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
		
		for (int i = 0; i < 8; i++) {
			str = String.join("*", str.split(alpha[i]));
		}
		
		System.out.println(str.length() - 2);
	}

}
