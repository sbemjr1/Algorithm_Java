package boj;

import java.util.Scanner;

public class 참외밭 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();
		
		int[][] points = new int[6][2];
		int[] zeroPoints = {0,0};
		
		for (int i = 0; i < 6; i++) {
			int[] dirArr = new int[2];
			int dir = sc.nextInt();
			int length = sc.nextInt();
			
			switch(dir) {
			case 1: //east
				dirArr[0] = 0;
				dirArr[1] = 1;
				break;
			case 2: //west
				dirArr[0] = 0;
				dirArr[1] = -1;
				break;
			case 3: //south
				dirArr[0] = 1;
				dirArr[1] = 0;
				break;
			case 4: //north
				dirArr[0] = -1;
				dirArr[1] = 0;
				break;
			}
			zeroPoints[0] += dirArr[0] * length;
			zeroPoints[1] += dirArr[1] * length;
			int[] result = {zeroPoints[0], zeroPoints[1]};
			points[i] = result;
		}
		
		int sum = 0;
		int line = 0;
		
		for (int i = 0; i < points.length; i++) {
			if (i == points.length - 1) {
				line = points[i][0]*points[0][1] - points[0][0]*points[i][1];
			} else {
				line = points[i][0]*points[i+1][1] - points[i+1][0]*points[i][1];
			}
			sum += line;
		}
		if (sum < 0) {
			sum = -sum;
		}
		
		System.out.println(sum / 2 * K);
	}
}
