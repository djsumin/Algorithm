import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int X = sc.nextInt();

		int[] Arr = new int[N];
		for (int i = 0; i < Arr.length; i++) {
			Arr[i] = sc.nextInt();
		}

		ArrayList<Integer> result = new ArrayList<>();

		for (int i = 0; i < Arr.length; i++) {
			if (Arr[i] < X) {
				result.add(Arr[i]);
			}
		}
		for(int i=0; i<result.size();i++) {
			System.out.print(result.get(i)+ " ");
		}
	
	}
}