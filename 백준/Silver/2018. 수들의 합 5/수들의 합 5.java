import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int cnt = 0; // 자기자신
		
		for (int start = 1; start < N + 1; start++) {
			int sum = 0;
			for (int end = start; end < N + 1; end++) {
				sum = sum +end;
				if (sum == N) {
					cnt++;
					break;
				}else if(sum>N) break;
			}
		}

		System.out.println(cnt);
	}
}
