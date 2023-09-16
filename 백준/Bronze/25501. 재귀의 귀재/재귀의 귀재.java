import java.util.Scanner;

public class Main{
	public static int cnt;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			String str = sc.next();
			
			
			System.out.print(isPalindrome(str)+" ");
			System.out.println(cnt);
			cnt = 0;
		}//입력 끝
		
	}//main
	public static int isPalindrome(String str) {
		return recursion(str, 0, str.length()-1);
	}
	
	public static int recursion(String str, int l, int r ) {
		if(l>=r) {
			cnt++;
			return 1;
		}else if(str.charAt(l) != str.charAt(r)) {
			cnt++;
			return 0;
		}else {
			cnt++;
			return recursion(str, l+1, r-1);
		}
	}
}
