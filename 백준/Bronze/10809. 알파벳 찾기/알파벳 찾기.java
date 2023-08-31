import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		
		int [] alphabet = new int [26];
		for(int i=0;i<alphabet.length;i++) {
			alphabet[i]=-1;
		}
		
		
		for(int i=0;i<str.length();i++) {
			char c =str.charAt(i);
			
			if(alphabet[c - 'a']==-1) {
				alphabet[c - 'a']= i;				
			}
		}
		

		for(int i=0;i<alphabet.length;i++) {
			System.out.print(alphabet[i]+" ");
		}
		
		

	}

}
