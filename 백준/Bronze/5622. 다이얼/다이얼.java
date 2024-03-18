import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        Scanner sc = new Scanner(System.in);
        String target = sc.next();

        char[] letter = new char[target.length()];
        for(int i=0;i<target.length();i++){
            letter[i] = target.charAt(i);
        }
        int ans = 0;
        for(int i=0;i<letter.length;i++){
            if(letter[i] == 'A' || letter[i] == 'B' || letter[i]=='C'){
                ans+=3;
            }else if(letter[i] == 'D' || letter[i] == 'E'|| letter[i] == 'F'){
                ans+=4;
            }else if(letter[i] == 'G' || letter[i] == 'H' || letter[i] == 'I'){
                ans+=5;
            }else if(letter[i] == 'J' || letter[i] == 'K' || letter[i] == 'L'){
                ans+=6;
            }else if(letter[i] == 'M' || letter[i] == 'N' || letter[i] == 'O'){
                ans+=7;
            }else if(letter[i] == 'P' || letter[i] == 'Q' || letter[i] == 'R' || letter[i] == 'S'){
                ans+=8;
            }else if(letter[i] == 'U' || letter[i] == 'T' || letter[i] == 'V'){
                ans+=9;
            }else if(letter[i] == 'W' || letter[i] == 'X' || letter[i] == 'Y' || letter[i] == 'Z'){
                ans+=10;
            }
        }
        System.out.println(ans);

    }
}
