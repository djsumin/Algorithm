import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 시험장개수

		int[] person = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			person[i] = Integer.parseInt(st.nextToken()); // i번째 시험장 응시자수
		}
		st = new StringTokenizer(br.readLine());
		int B = Integer.parseInt(st.nextToken()); // 총감독관이 감시할 수 있는 응시자수
		int C = Integer.parseInt(st.nextToken()); // 부감독관이 감시할 수 있는 응시자수

//		System.out.println(Arrays.toString(person));
		// 총감독관 1명만, 그리고 필요한 감독관 수의 최솟값

		long cnt = N;
		for (int i = 0; i < person.length; i++) {
			if((person[i]-B) < 0)
				continue;
			
			if ((person[i] - B) % C == 0) {
				cnt = cnt + (person[i] - B) / C;
			} else {
				if(C > person[i]-B) {
					cnt++;
				}else {
					cnt = cnt + 1 + ((person[i] - B) / C);
				}
			}

		}
		System.out.println(cnt);
	}
}
