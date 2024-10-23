import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb;
    static int n, m, v;
    static int[][] adjarr;
    static boolean[] visit;
    static Queue<Integer> q = new LinkedList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken()); // 시작점

        adjarr = new int[n+1][n+1];
        visit = new boolean[n+1];

        for(int i= 0; i<m;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            adjarr[start][end] = 1;
            adjarr[end][start] = 1;
        }

        dfs(v);
        sb.append("\n");
        visit = new boolean[n+1];

        bfs(v);

        System.out.println(sb.toString());
    }

    private static void bfs(int start) {
        q.add(start);
        visit[start] = true;

        while(!q.isEmpty()){
            int now = q.poll();
            sb.append(now+" ");

            for(int i=1;i<=n;i++){
                if(!visit[i] && adjarr[now][i] == 1){
                    visit[i] = true;
                    q.add(i);
                }
            }
        }

    }

    private static void dfs(int start) {
        visit[start] = true;
        sb.append(start + " ");

        for(int i=0;i<=n;i++){
            if(!visit[i] && adjarr[start][i] == 1){
                dfs(i);
            }
        }
    }
}