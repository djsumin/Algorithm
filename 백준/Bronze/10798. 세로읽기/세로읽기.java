import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[][] array = new char[5][15];
		int max = 0;

		for (int i = 0; i < 5; i++) {
			String str = sc.next();
			max = Math.max(max, str.length()); // 가장 긴 문자열 찾기
			for (int j = 0; j < str.length(); j++) {
				array[i][j] = str.charAt(j);
			}
		} // 입력받기끝

		// 열 우선탐색
		for (int j = 0; j < max; j++) {
			for (int i = 0; i < 5; i++) {
                if(array[i][j] == '\0')
					continue;
				System.out.print(array[i][j]);
			}
		}

	}
}