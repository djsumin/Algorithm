import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.nextLine();
		char[] jari = new char[N];
		int cnt = 1;
		String seat = sc.next();
		for (int i = 0; i < N; i++) {
			jari[i] = seat.charAt(i);
		}
		for (int i = 0; i < N; i++) {
			if (jari[i] == 'S') {
				cnt++;
			} else { // L이 나오면
				if (i != N - 1 && jari[i + 1] == 'L') {
					cnt++;
					i++;
				}
			}
		}
		if (cnt > N) {
			cnt = N;
		}
		System.out.println(cnt);

	}
}