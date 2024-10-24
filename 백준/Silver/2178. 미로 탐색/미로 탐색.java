

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};
    static int[][] map;
    static boolean[][] visited;
    static int n, m;
    public static void main(String[] args) throws Exception {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine());
       n = Integer.parseInt(st.nextToken());
       m = Integer.parseInt(st.nextToken());

       map = new int[n][m];
       visited = new boolean[n][m];

       for(int i = 0; i < n; i++) {
           String line = br.readLine();
           for(int j = 0; j < m; j++) {
               map[i][j] = line.charAt(j) - '0';
           }
       }

       int start_r = 0;
       int start_c = 0;

       bfs(start_r, start_c);
       System.out.println(map[n-1][m-1]);

    }

    private static void bfs(int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        visited[r][c] = true;
        q.add(new int[]{r,c});

        while(!q.isEmpty()) {
            int[] start = q.poll();

            int x = start[0];
            int y = start[1];

            for(int d=0;d<4;d++){
                int nr = x + dr[d];
                int nc = y + dc[d];
                if(nr >= 0 && nc >= 0 && nr < n && nc < m){
                    if(!visited[nr][nc] && map[nr][nc] == 1){
                        q.add(new int[]{nr,nc});
                        visited[nr][nc] = true;
                        map[nr][nc] = map[x][y] + 1;
                    }
                }
            }

        }

    }
}