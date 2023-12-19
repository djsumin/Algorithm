import java.io.*;
import java.util.*;
public class Main {
    static boolean[] visited;
    static int N, M;
    static long[][] dp;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        dp = new long[30][30];
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            // M개중에서 N개를 선택하자 (조합)
            bw.write(combination(M, N) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();

    }

    private static long combination(int m, int n) {
        if (m == n || n == 0) {
            return 1;
        } else if(n==1){
            return m;
        }else if(dp[n][m]!=0){
            return dp[n][m];
        }else{
            dp[n][m]=combination(m - 1, n - 1) + combination(m - 1, n);
            return dp[n][m];
        }

    }


}