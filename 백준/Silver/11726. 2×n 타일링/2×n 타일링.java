import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		dp = new int[1001];
		dp[1] = 1;
		dp[2] = 2;
		for(int i=3;i<=n;i++) {
			dp[i] = (dp[i-2] % 10007) + (dp[i-1]%10007);
		}
		System.out.println(dp[n] % 10007);
	}
}
