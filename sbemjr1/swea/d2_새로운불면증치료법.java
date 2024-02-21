package swea;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class d2_새로운불면증치료법 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			List<Character> list = new ArrayList<>();
			int i = 0;
			
			while(true) {
				String str = Integer.toString(N * ++i);
				
				for (int j = 0; j < str.length(); j++) {
					if(!list.contains(str.charAt(j))) {
						list.add(str.charAt(j));
					}
				}
				
				if(list.size() == 10) {
					System.out.println("#"+tc+" " +N * i);
					break;
				}
			}
			
			
		}
	}
}
