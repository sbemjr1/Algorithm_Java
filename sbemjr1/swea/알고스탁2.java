package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 알고스탁2 {
	static int T;
	static int Ms, Ma; // 초기 예치금, 월별 불입금액
	static int N, L; // 종목 수, 데이터 기간
	static int[][] price_data;
	static int origin_money;
	static int money;
	
	static ArrayList<Integer> benefit_stock;
	static int benefit, result, value, max, sel[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		T = Integer.parseInt(st.nextToken());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			Ms = Integer.parseInt(st.nextToken());
			Ma = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken()) + 1; // 0개월 부터 이므로
			
			price_data = new int[N][L+1];
			benefit_stock = new ArrayList<>(); // 이득 주식 목록
			
			origin_money = Ms + Ma * (L-1);
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < L; j++) {
					price_data[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i < L; i++) {
				benefit_stock = new ArrayList<>();
				// 모든 종목 다음 달과 차익 계산
				for (int j = 0; j < N; j++) {
					result = price_data[j][i+1] - price_data[j][i];
					if (result > 0) {
						benefit_stock.add(j);
					}
				}
				if (benefit_stock.size() > 1) {
					sel = new int[benefit_stock.size()];
					value = 0;
					recursive(0, i);
				}
				// 매달 저축
				Ms += Ma;
			}
//			System.out.println(Ms - Ma - origin_money);
		}
	}

	private static boolean recursive(int k, int idx) {
		if (k == benefit_stock.size()) {
			for (int i = 0; i < sel.length; i++) {
				value += price_data[benefit_stock.get(i)][idx] * sel[i];
//				benefit += (price_data[benefit_stock.get(i)][idx+1] - price_data[benefit_stock.get(i)][idx]) * sel[i];
			}
			money -= value;
//			if(money < 0) {
//				max = Integer.MIN_VALUE;
//				return false;
//			}
			for (int i = 0; i < sel.length; i++) {
				System.out.print(sel[i] + " ");
			}
			System.out.println();
			return true;
		}
		
		// TODO Auto-generated method stub
		for (int i = 0; i < 1000; i++) {
			sel[k] = i;
			value = 0;
			benefit = 0;
			money = Ms;
			if(recursive(k+1, idx)) return true;
		}
		return false;
	}

}
