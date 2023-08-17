import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 색종이개수
		int[][] array = new int[100][100];
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			for (int j = x; j < x + 10; j++) {
				for (int k = y; k < y + 10; k++) {
					array[j][k] = 1;
				}
			}
		} // 좌표 입력받기

		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (array[i][j] == 1) {
					cnt++;
				}
			}
		}
		System.out.println(cnt);

	}
}