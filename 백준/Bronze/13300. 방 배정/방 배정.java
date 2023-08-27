import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 전체학생수
		int K = sc.nextInt(); // 한방에 배정할 수 있는 최대 인원수
		int cnt = 0;
		int S = 0;
		int Y = 0;
		int[][] array = new int[6][2];
		for (int i = 0; i < N; i++) {
			S = sc.nextInt(); // 성별 : 남자는 1, 여자는 0
			Y = sc.nextInt(); // 학년 1~6

			if (S == 0) {
				array[Y - 1][0]++;
			} else {
				array[Y - 1][1]++;
			}

		}

		for (int j = 0; j < 6; j++) {
			for (int k = 0; k < 2; k++) {
				if (array[j][k] % K == 0) {
					cnt += array[j][k] / K;
				} else {
					cnt += (array[j][k] / K) + 1;
				}
			}
		}
		System.out.println(cnt);
	}

}
