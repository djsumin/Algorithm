import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            double num = Double.parseDouble(st.nextToken());
            while(st.hasMoreTokens()){
                char mathEq = st.nextToken().charAt(0);
                if(mathEq == '@'){
                    num *= 3;
                }else if(mathEq == '%'){
                    num += 5;
                }else if(mathEq == '#'){
                    num -= 7;
                }
            }
            System.out.printf("%.2f", num);
            System.out.println();
        }
    }
}
