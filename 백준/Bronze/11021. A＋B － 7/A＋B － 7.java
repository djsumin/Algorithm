import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int i = 1; i < T + 1; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			System.out.print("Case #" + i + ": ");
			System.out.println(A + B);
		}

	}

}