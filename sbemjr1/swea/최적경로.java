package swea;

import java.util.Scanner;

//거리 문제는 이차원 배열로 하는게 맞는지 고민해보자.
//N이 10이하는 완탐인데 11 이상이면 좀 위험함
public class 최적경로 {
	static int T, N, Ans;
	
	static class Point {
		int x, y;
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			Ans = Integer.MAX_VALUE;
			N = sc.nextInt();
			
			Point[] cus = new Point[N];
			Point company = new Point(sc.nextInt(), sc.nextInt());
			Point home = new Point(sc.nextInt(), sc.nextInt());
			for (int i = 0; i < cus.length; i++) {
				cus[i] = new Point(sc.nextInt(), sc.nextInt());
			}
			
			permutation(cus, new Point[N], new boolean[N], 0, home, company);
			System.out.println(Ans);
		}
	}

	private static void permutation(Point[] cus, Point[] sel, boolean[] v, int idx, Point home, Point company) {
		//basis part
		if(idx == sel.length) {
			// 다 골랐음
			// 그럼 거리 계산해
//			System.out.println(Arrays.toString(sel));
			// 회사에서 첫 집
			int c = Math.abs(company.x - sel[0].x)+Math.abs(company.y - sel[0].y);
			// 마지막 집에서 집까지
			int h = Math.abs(sel[sel.length-1].x - home.x)+Math.abs(sel[sel.length-1].y - home.y);
			int co = 0;
			for (int i = 0; i < N-1; i++) {
				co += Math.abs(sel[i].x - sel[i+1].x) + Math.abs(sel[i].y - sel[i+1].y);
			}
			Ans = Math.min(Ans, co+h+c);
			return;
		}
		//inductive part
		for (int i = 0; i < cus.length; i++) {
			if(!v[i]) {
				v[i] = true;
				sel[idx] = cus[i];
				permutation(cus, sel, v, idx+1, home, company);
				v[i] = false;
			}
		}
	}

}
