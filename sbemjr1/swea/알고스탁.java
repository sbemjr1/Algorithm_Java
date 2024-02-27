package swea;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class 알고스탁 {
	static int N, L, Ans; // 종목 수, 데이터 기간
	static int Ms, Ma, T, monthMaxBenefit; // 초기 예치금, 월별 불입금액
	static int[][] data;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			Ms = sc.nextInt();
			Ma = sc.nextInt();
			N = sc.nextInt();
			L = sc.nextInt();
			
			data = new int[N][L+1];
			
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < L+1; c++) {
					data[r][c] = sc.nextInt();
				}
			}
//			print();
			int money = Ms;
			for (int month = 0; month < L; month++) {
				// 매달 구매 리스트
				ArrayList<Stock> stockList = new ArrayList<>();
				for (int i = 0; i < N; i++) {
					// 다음 달에 오를 주식을 리스트에 저장
					if(data[i][month] < data[i][month+1]) {
						stockList.add(new Stock(data[i][month],data[i][month+1]
										,data[i][month+1] - data[i][month]));
					}
				}
				monthMaxBenefit = 0;
				// 어떤 주식을 얼마만큼 살까요?
				recursive(0,money,stockList,0);
				// 매달 이익금
				money += monthMaxBenefit;
				// 매달 저축금
				money += Ma;
			}
			Ans = money - Ms - (Ma * L);
			System.out.println("#"+tc+" "+Ans);
		}
	}

	private static void recursive(int idx, int money, ArrayList<Stock> stockList, int benefit) {
		// basis part
		if(idx == stockList.size()) {
			monthMaxBenefit = Math.max(monthMaxBenefit, benefit);
			return;
		}
		// inductive part
		// 살 종목
		Stock stock = stockList.get(idx);
		
		if(money >= stock.curPrice) {
			// 구매할 수 있으면 구매하기
			recursive(idx, money-stock.curPrice, stockList, benefit + stock.diff);
		}
		// 살만큼 샀다면 다음 종목으로 넘긴다.
		recursive(idx+1, money, stockList, benefit);
	}

	static class Stock {
		int curPrice, nextPrice, diff;

		public Stock(int curPrice, int nextPrice, int diff) {
			this.curPrice = curPrice;
			this.nextPrice = nextPrice;
			this.diff = diff;
		}
	}

	private static void print() {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < L+1; c++) {
				System.out.print(data[r][c] + " ");
			}
			System.out.println();
		}
	}

}
