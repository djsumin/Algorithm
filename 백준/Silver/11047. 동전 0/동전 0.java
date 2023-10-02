import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());// 동전 종류 개수
		int k = Integer.parseInt(st.nextToken()); // 가치의 합이 k가 되도록

		int[] value = new int[n];

		for (int i = 0; i < value.length; i++) {
			value[i] = Integer.parseInt(br.readLine());
		} // 입력끝

		int res = 0;
		for (int i = value.length - 1; i >= 0; i--) {
			int sum = 0;
			if (value[i] > k)
				continue;
			else {
				res = res + k / value[i];
				sum = sum + k / value[i];
				k = k - value[i] * sum;
			}
		}

		System.out.println(res);

	}
}
