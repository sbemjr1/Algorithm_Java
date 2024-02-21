package swea;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 규영이와인영이의카드게임 {
	static int T, a, b, sel[], winA, winB;
	static boolean v[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			List<Integer> list1 = new ArrayList<>();
			List<Integer> list2 = new ArrayList<>();
			a = 0;
			b = 0;
			winA = 0;
			winB = 0;
 			sel = new int[9];
			v = new boolean[9];
			
			for (int i = 0; i < 9; i++) {
				list1.add(sc.nextInt());
			}
			
			for (int i = 1; i <= 18; i++) {
				if(!list1.contains(i)) {
					list2.add(i);
				}
			}
			
			recursive(list1, list2,0);
			System.out.println("#"+tc+" "+winA+" "+winB);
		}
	}

	private static void recursive(List<Integer> list1, List<Integer> list2, int k) {
		if (k == 9) {
			for (int i = 0; i < 9; i++) {
				if (list1.get(i) > sel[i]) {
					a += (list1.get(i) + sel[i]);
				} else {
					b += (list1.get(i) + sel[i]);
				}
			}
			if (a > b) {
				winA++;
			} else {
				winB++;
			}
			a=0;
			b=0;
			return;
		}
		for (int i = 0; i < 9; i++) {
			if(v[i] == false) {
				v[i] = true;
				sel[k] = list2.get(i);
				recursive(list1,list2,k+1);
				v[i] = false;
			}
		}
	}

}
