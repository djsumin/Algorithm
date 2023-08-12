import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] array = new int[9][9];
		int max = -1;
		int i;
		int j = 0;
		int imax=0;
		int jmax=0;
		for (i = 0; i < 9; i++) {
			for (j = 0; j < 9; j++) {
				array[i][j] = sc.nextInt();

				if (max <= array[i][j]) {
					max = array[i][j];
					imax=i+1;
					jmax=j+1;
				}
			}
		}

		System.out.println(max);
		System.out.println(imax + " " + jmax);

	}
}