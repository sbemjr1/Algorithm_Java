package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 배열돌리기3 {
	static int N, M, R;
	static int[][] arr, tmp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				arr[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < R; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			switch(num) {
			case 1:
				if (arr[0].length == M) {
					tmp = new int[N][M];
					for (int j = 0; j < N; j++) {
						tmp[j] = arr[N-1-j];
					}
					arr = tmp;
				} else {
					tmp = new int[M][N];
					for (int j = 0; j < M; j++) {
						tmp[j] = arr[M-1-j];
					}
					arr = tmp;
				}
				break;
			case 2:
				if (arr[0].length == M) {
					tmp = new int[N][M];
					for (int j = 0; j < N; j++) {
						for (int k = 0; k < M; k++) {
							tmp[j][k] = arr[j][M-1-k];
						}
					}
					arr = tmp;
				} else {
					tmp = new int[M][N];
					for (int j = 0; j < M; j++) {
						for (int k = 0; k < N; k++) {
							tmp[j][k] = arr[j][N-1-k];
						}
					}
					arr = tmp;
				}
				break;
			case 3:
				if (arr[0].length == M) {
					tmp = new int[M][N];
					for (int j = 0; j < M; j++) {
						for (int k = 0; k < N; k++) {
							tmp[j][k] = arr[N-1-k][j];
						}
					}
					arr = new int[M][N];
					arr = tmp;
				} else {
					tmp = new int[N][M];
					for (int j = 0; j < N; j++) {
						for (int k = 0; k < M; k++) {
							tmp[j][k] = arr[M-1-k][j];
						}
					}
					arr = new int[N][M];
					arr = tmp;
				}
				break;
			case 4:
				if (arr[0].length == M) {
					tmp = new int[M][N];
					for (int j = 0; j < M; j++) {
						for (int k = 0; k < N; k++) {
							tmp[j][k] = arr[k][M-1-j];
						}
					}
					arr = new int[M][N];
					arr = tmp;
				} else {
					tmp = new int[N][M];
					for (int j = 0; j < N; j++) {
						for (int k = 0; k < M; k++) {
							tmp[j][k] = arr[k][N-1-j];
						}
					}
					arr = new int[N][M];
					arr = tmp;
				}
				break;
			case 5:
				if (arr[0].length == M) {
					tmp = new int[N][M];
					for (int j = 0; j < N/2; j++) {
						for (int k = 0; k < M/2; k++) {
							tmp[j][M/2+k] = arr[j][k];
						}
					}
					for (int j = 0; j < N/2; j++) {
						for (int k = M/2; k < M; k++) {
							tmp[N/2+j][k] = arr[j][k];
						}
					}
					for (int j = N/2; j < N; j++) {
						for (int k = M/2; k < M; k++) {
							tmp[j][k-M/2] = arr[j][k];
						}
					}
					for (int j = N/2; j < N; j++) {
						for (int k = 0; k < M/2; k++) {
							tmp[j-N/2][k] = arr[j][k];
						}
					}
					arr = tmp;
				} else {
					tmp = new int[M][N];
					for (int j = 0; j < M/2; j++) {
						for (int k = 0; k < N/2; k++) {
							tmp[j][N/2+k] = arr[j][k];
						}
					}
					for (int j = 0; j < M/2; j++) {
						for (int k = N/2; k < N; k++) {
							tmp[M/2+j][k] = arr[j][k];
						}
					}
					for (int j = M/2; j < M; j++) {
						for (int k = N/2; k < N; k++) {
							tmp[j][k-N/2] = arr[j][k];
						}
					}
					for (int j = M/2; j < M; j++) {
						for (int k = 0; k < N/2; k++) {
							tmp[j-M/2][k] = arr[j][k];
						}
					}
					arr = tmp;
				}
				break;
			case 6:
				if (arr[0].length == M) {
					tmp = new int[N][M];
					for (int j = 0; j < N/2; j++) {
						for (int k = 0; k < M/2; k++) {
							tmp[N/2+j][k] = arr[j][k];
						}
					}
					for (int j = 0; j < N/2; j++) {
						for (int k = M/2; k < M; k++) {
							tmp[j][k-M/2] = arr[j][k];
						}
					}
					for (int j = N/2; j < N; j++) {
						for (int k = M/2; k < M; k++) {
							tmp[j-N/2][k] = arr[j][k];
						}
					}
					for (int j = N/2; j < N; j++) {
						for (int k = 0; k < M/2; k++) {
							tmp[j][k+M/2] = arr[j][k];
						}
					}
					arr = tmp;
				} else {
					tmp = new int[M][N];
					for (int j = 0; j < M/2; j++) {
						for (int k = 0; k < N/2; k++) {
							tmp[M/2+j][k] = arr[j][k];
						}
					}
					for (int j = 0; j < M/2; j++) {
						for (int k = N/2; k < N; k++) {
							tmp[j][k-N/2] = arr[j][k];
						}
					}
					for (int j = M/2; j < M; j++) {
						for (int k = N/2; k < N; k++) {
							tmp[j-M/2][k] = arr[j][k];
						}
					}
					for (int j = M/2; j < M; j++) {
						for (int k = 0; k < N/2; k++) {
							tmp[j][k+N/2] = arr[j][k];
						}
					}
					arr = tmp;
				}
				break;
			}
		}
		if (arr[0].length == M) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					System.out.print(arr[j][k]+" ");
				}
				System.out.println();
			}
		} else {
			for (int j = 0; j < M; j++) {
				for (int k = 0; k < N; k++) {
					System.out.print(arr[j][k]+" ");
				}
				System.out.println();
			}
		}
	}

}
