package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_7465_창용마을무리의개수_서로소집합 {
	static int T,N,M,group[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		T = Integer.parseInt(st.nextToken());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			group = new int[N+1];
			
			for (int i = 1; i <= N; i++) {
				group[i] = i;
			}
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				
				int org = Integer.parseInt(st.nextToken());
				int change = Integer.parseInt(st.nextToken());
				
				union(org,change);
			}
			
			for (int i = 1; i <= N; i++) {
				System.out.println(group[i]);
			}
			
			ArrayList<Integer> ans = new ArrayList<>();
			
			for (int i = 1; i <= N; i++) {
				if (!ans.contains(find(group[i]))) {
					ans.add(find(group[i]));
				}
			}
			
			System.out.println("#"+tc+" "+ans.size());
		}
	}

	private static void union(int org, int change) {
		int a = find(org);
		int b = find(change);
		
		if (a <= b) {
			group[b] = group[a];
		} else {
			group[a] = group[b];
		}
	}

	private static int find(int num) {
		if (group[num] != num) {
			return group[num] = find(group[num]);
		}
		return num;
	}

}
