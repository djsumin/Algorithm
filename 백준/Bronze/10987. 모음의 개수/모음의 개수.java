import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		char[] word= new char[str.length()];
		for(int i=0;i<str.length();i++){
			word[i] = str.charAt(i);
		}
		int cnt = 0;
		for(int i=0;i<str.length();i++) {
			if(word[i]=='a'||word[i]=='e' || word[i] =='i' || word[i] == 'o' || word[i]=='u') {
				cnt++;
			}
		}
		System.out.println(cnt);
		
		
	}
}
