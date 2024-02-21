package boj;

import java.util.Scanner;

public class 신기한소수 {
	static int N;
	static int frontArr[], backArr[];  

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		frontArr = new int[] {2,3,5,7};
		backArr = new int[] {1,3,5,7,9};
		
		recursive();
	}

	private static int isPrimeNum(int num) {
		if (num < 2) {
			return 0;
		}
		for (int i = 2; i<=(int)Math.sqrt(num); i++) {
		      if (num % i == 0) {
		          return 0;
		      }
		}
		return 1;
	}
}
