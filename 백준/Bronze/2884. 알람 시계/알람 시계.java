import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int H = sc.nextInt();
		int M = sc.nextInt();
		
		if(M<45) {
			if(H == 0) {
				System.out.print(23);
				System.out.println(" " + (60-(45-M)));
			}else {
				System.out.print(H-1);
				System.out.println(" " + (60-(45-M)));
			}
		} else {
			System.out.print(H);
			System.out.println(" " + (M-45));
		}
	}

}