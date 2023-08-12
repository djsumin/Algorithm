import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		int[] basket = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			basket[i] = i;
		} // N개의 바구니가 있다.

		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			for (int j = a; j <= b; j++) {
				int ab = b--; // 역순으로 만들어주기

				int tmp = basket[j];
				basket[j] = basket[ab];
				basket[ab] = tmp;

			}
		}
		
		for(int i=1;i<=N;i++) {
			System.out.print(basket[i]+" ");
		}

	}
}