import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int a_score = 100;
        int b_score = 100;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); //창영
            int b = Integer.parseInt(st.nextToken()); //상덕
            if(a>b){
                b_score -= a;
            }else if(a < b){
                a_score -= b;
            }
        }
        System.out.println(a_score);
        System.out.println(b_score);


    }
}
