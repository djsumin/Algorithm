import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		if (str.contains("dz=")) {
			str = str.replace("dz=", "1");
		}

		for (int i = 0; i < str.length(); i++) {
			if (str.contains("c=")) {
				str = str.replace("c=", "1");
			} else if (str.contains("c-")) {
				str = str.replace("c-", "1");
			} else if (str.contains("d-")) {
				str = str.replace("d-", "1");
			} else if (str.contains("lj")) {
				str = str.replace("lj", "1");
			} else if (str.contains("nj")) {
				str = str.replace("nj", "1");
			} else if (str.contains("s=")) {
				str = str.replace("s=", "1");
			} else if (str.contains("z=")) {
				str = str.replace("z=", "1");
			}
		}
		
		System.out.println(str.length());

	}

}
