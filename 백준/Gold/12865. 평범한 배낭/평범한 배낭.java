import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] weights = new int[N + 1];
		int[] cost = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			weights[i] = Integer.parseInt(st.nextToken());
			cost[i] = Integer.parseInt(st.nextToken());
		}

		int[][] dp = new int[N + 1][K + 1];

		for (int i = 1; i <= N; i++) {
			for(int w=0;w<=K;w++) {
				if(weights[i]<=w) {
					dp[i][w] = Math.max(dp[i-1][w], dp[i-1][w-weights[i]] + cost[i]);
				}else {
					dp[i][w] = dp[i-1][w];
				}
			}
		}
		System.out.println(dp[N][K]);
	
	}
}
