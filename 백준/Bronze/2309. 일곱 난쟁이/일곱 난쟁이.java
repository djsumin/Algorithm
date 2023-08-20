import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] height = new int[9];
		int sum = 0;
		for (int i = 0; i < 9; i++) {
			height[i] = sc.nextInt();
			sum = sum + height[i];
		} // 9명의 난쟁이 키 입력받기

		int a = sum - 100;
		for (int i = 0; i < 8; i++) {
			for (int j = i + 1; j < 9; j++) {
				if (height[i] + height[j] == a) {
					height[i] = 0;
					height[j] = 0;
					Arrays.sort(height);
					for (int k = 2; k < 9; k++) {
						System.out.println(height[k]);
					}
					return;
				}
			}
		}
		

		

	}
}
