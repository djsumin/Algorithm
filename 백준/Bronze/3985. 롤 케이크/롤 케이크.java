import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int L = sc.nextInt(); // 롤케이크 길이
		int N = sc.nextInt(); // 방청객수
		int[] rollcake = new int[L + 1];
		int[] exp = new int[N + 1];
		int[] cnt = new int[N + 1];
		int a = 0;
		int b = 0;
		int maxexp = -1; // 가장 많은 조각을 받을 것으로 기대하고 있던 방청객의 번호
		int realmax = -1; // 실제고 가장 많은 조각을 받은 방청객
		int expidx = 0;
		int realidx = 0;

		for (int i = 1; i <= N; i++) {
			a = sc.nextInt();
			b = sc.nextInt(); // a부터 b까지
			exp[i] = b - a;

			if (maxexp < exp[i]) {
				maxexp = exp[i];
				expidx = i;
			} // 가장 많은 조각을 받을것으로 예상했는데

			for (int j = a; j <= b; j++) {
				if (rollcake[j] != 0) {
					continue;
				} else {
					rollcake[j] = i; // a부터 b까지 다 채워주기 덮어쓰기
				}
			} // 입력 다받음

			for (int j = 1; j < rollcake.length; j++) {
				a = rollcake[j];
				cnt[a]++;

			}

			if (realmax < cnt[i]) {
				realmax = cnt[i];
				realidx = i;
			}

		}

		System.out.println(expidx);
		System.out.println(realidx);

	}
}
