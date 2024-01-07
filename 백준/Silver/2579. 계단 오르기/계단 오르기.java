import java.io.*;
import java.util.*;

public class Main {
    static int[] stairs;
    static int N;
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        stairs = new int[N+1];
        int[] dp = new int[N+1];
        for(int i=1;i<=N;i++){
            stairs[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = stairs[1];
        if(N==1){
            System.out.println(dp[1]);
            System.exit(0);
        }
        dp[2] = stairs[1]+stairs[2];
        if(N==2){
            System.out.println(dp[2]);
            System.exit(0);
        }

        dp[3] = Math.max(stairs[1],stairs[2]) + stairs[3];
        if(N==3){
            System.out.println(dp[3]);
            System.exit(0);
        }

        for(int i=4;i<N+1;i++){
            //i==4일때, dp[i-3]+stairs[i-1]은 1번계단, 3번계단을 오른 경우고,
            //dp[i-2]는 1번계단과 2번계단을 오른 경우다.
            dp[i] = Math.max(dp[i-3]+stairs[i-1], dp[i-2])+stairs[i];
        }
//        System.out.println(Arrays.toString(dp));
        System.out.println(dp[N]);


    }



}