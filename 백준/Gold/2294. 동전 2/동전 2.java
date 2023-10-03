import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 동전의 개수
		int k = sc.nextInt(); // 가치의 합

		int[] coin = new int[n];
		for (int i = 0; i < n; i++) {
			coin[i] = sc.nextInt();
		} // 입력끝

		// dp배열을 가치의 합+1만큼의 길이로 만든다. (0~k)
		int[] dp = new int[k + 1];

		// 동전의 가치가 최대 100000원이기 때문
		Arrays.fill(dp, 100001);

		// 0개로는 0원일 수 밖에 없다.
		dp[0] = 0;

		for (int i = 0; i < n; i++) {
			for (int j = coin[i]; j <= k; j++) {
				dp[j] = Math.min(dp[j], dp[j - coin[i]] + 1);
			}
		}
		System.out.println(dp[k] == 100001 ? -1 : dp[k]);
		sc.close();

	}
}
