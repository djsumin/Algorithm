import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for(int i=0;i<N;i++){
            String test = sc.next();
            String word = sc.next();

            char[] testArr = test.toCharArray();
            char[] wordArr = word.toCharArray();
            Arrays.sort(testArr);
            Arrays.sort(wordArr);
            String answer = "Impossible";

            if(testArr.length == wordArr.length){
                int cnt = 0;
                for(int j=0;j<testArr.length;j++){
                    if(testArr[j] == wordArr[j]){
                        cnt++;
                    }
                }
                if(cnt==testArr.length){
                    answer = "Possible";
                }

            }
            System.out.println(answer);

        }

    }
}