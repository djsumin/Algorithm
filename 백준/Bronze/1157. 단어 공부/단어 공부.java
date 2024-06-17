import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.next().toUpperCase();
        int[] alphabet = new int[26];

        for(int i=0;i<word.length();i++){
            int num = word.charAt(i)-'A';
            alphabet[num]++;
        }

        int max = 0;
        int maxI = 0;
        char answer = '?';
        for(int i=0;i<alphabet.length;i++){
            max = Math.max(max, alphabet[i]);
        }

        int cnt = 0;
        for(int i=0;i<alphabet.length;i++){
            if(max==alphabet[i]){
                maxI = i;
                cnt++;
            }
        }
        if(cnt==1){
            answer = (char)(maxI + 'A');
        }
        System.out.println(answer);
    }
}