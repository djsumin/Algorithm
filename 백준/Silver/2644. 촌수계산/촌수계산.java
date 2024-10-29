import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static int ans, a, b;
    static boolean[] visited;
    static List<Integer>[] list;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        ans = -1;
        int n = Integer.parseInt(br.readLine());

        //a와 b의 촌수 계산
        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());

        list = new ArrayList[n+1];
        visited = new boolean[n+1];

        for(int i = 1; i < n+1; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list[start].add(end);
            list[end].add(start);
        }

        dfs(a, b, 0);

        System.out.println(ans);


    }

    private static void dfs(int start, int end, int count) {
        visited[start] = true;

        if(start == end){
            ans = count;
            return;
        }

        for(int i=0;i<list[start].size();i++){
            if(!visited[list[start].get(i)]){
                dfs(list[start].get(i), end, count + 1);
            }
        }


    }
}