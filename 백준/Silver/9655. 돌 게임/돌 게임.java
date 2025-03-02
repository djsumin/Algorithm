import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        boolean sk = true;
        while(n > 0){
            if(n >= 3){
                n -= 3;
            }else{
                n -= 1;
            }

            if(sk){
                sk = false;
            }else{
                sk = true;
            }
        }
        System.out.println(sk ? "CY" : "SK");


    }
}
