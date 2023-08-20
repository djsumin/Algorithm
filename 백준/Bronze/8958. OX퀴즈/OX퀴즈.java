import java.util.Arrays;
import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // N개의 글자
		String str = null;

		for (int i = 0; i < N; i++) {
			int sum = 0;
			str = sc.next();
			char[] array = new char[str.length()];
			int[] score = new int[str.length()];

			for (int j = 1; j <= str.length(); j++) {
				array[j - 1] = str.charAt(j - 1); // 하나씩 잘라서 배열에 넣기

				if (array[j - 1] == 'O') {
					score[j - 1] = 1;
				} else {
					score[j - 1] = 0;
				}
			}
			for (int j = 1; j < str.length(); j++) {
				if (array[j - 1] == 'O' && array[j] == 'O') {
					score[j] = score[j - 1] + 1;
				}

			}

			for (int j = 0; j < score.length; j++) {
				sum = sum + score[j];
			}

			System.out.println(sum);

		}

	}
}