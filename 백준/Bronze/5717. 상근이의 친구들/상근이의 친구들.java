import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int boys;
        int girls;
        StringTokenizer st;
        while(true){
            st = new StringTokenizer(br.readLine());
            boys = Integer.parseInt(st.nextToken());
            girls = Integer.parseInt(st.nextToken());

            if(boys==0 && girls==0){
                break;
            }

            System.out.println(boys+girls);

        }

    }
}

