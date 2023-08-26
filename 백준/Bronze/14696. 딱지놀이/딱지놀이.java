import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 딱지놀이 총 라운드 수
		for (int i = 0; i < N; i++) {
			int a = sc.nextInt();
			int[] anum = new int[a];
			for (int j = 0; j < a; j++) {
				anum[j] = sc.nextInt();
			}
			int b = sc.nextInt();
			int[] bnum = new int[b];
			for (int j = 0; j < b; j++) {
				bnum[j] = sc.nextInt();
			} // 입력받기

			int cnta = 0;
			int cntb = 0;
			int cnt = 0;
			for (int j = 4; j > 0; j--) {// 별부터세모까지
				for (int k = 0; k < a; k++)
					if (anum[k] == j)
						cnta++;
				for (int k = 0; k < b; k++)
					if (bnum[k] == j)
						cntb++;

				if (cnta == cntb) {
					cnt++;
					continue;
				} else if (cnta > cntb) {
					System.out.println("A");
					break;
				} else {
					System.out.println("B");
					break;
				}
			}
			if (cnt == 4) {
				System.out.println("D");
			}

		}

	}
}
