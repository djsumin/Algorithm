import java.io.*;
import java.util.*;

public class Main {
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int tc = 0; tc<T;tc++){
            int n = Integer.parseInt(br.readLine());

            int[][] sticker = new int[2][n+1];
            int[][] dp = new int[2][n+1];

            for(int i=0;i<2;i++){
                st = new StringTokenizer(br.readLine());
                for(int j=1;j<=n;j++){
                    sticker[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            //자기자신 초기화
            dp[0][1] = sticker[0][1];
            dp[1][1] = sticker[1][1];

            for(int i=2;i<=n;i++){
                dp[0][i] = Math.max(dp[1][i-1], dp[1][i-2]) + sticker[0][i];
                dp[1][i] = Math.max(dp[0][i-1], dp[0][i-2]) + sticker[1][i];
            }
            System.out.println(Math.max(dp[1][n], dp[0][n]));

        }








    }
}