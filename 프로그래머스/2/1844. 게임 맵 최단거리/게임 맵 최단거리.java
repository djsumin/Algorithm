import java.util.*;
import java.io.*;

class Solution {
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};
    static int[][] visited;
    static int N;
    static int M;
    public int solution(int[][] maps) {
        int answer = 0;
        
        N = maps.length;
        M = maps[0].length;
    
        visited = new int[N][M];
        bfs(maps);
        
        answer = visited[N-1][M-1];
        if(answer==0){
            answer=-1;
        }
        return answer;
    }
    public void bfs(int[][] maps){
        int x = 0;
        int y = 0;
        visited[x][y] = 1;
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        while(!q.isEmpty()){
            int[] now = q.poll();
            int nowx = now[0];
            int nowy = now[1];
            for(int d=0;d<4;d++){
                int nx = nowx + dr[d];
                int ny = nowy + dc[d];
                if(nx<0 || ny < 0 || nx >=N || ny >=M){
                    continue;
                }
                if(visited[nx][ny]==0 && maps[nx][ny]==1){
                    visited[nx][ny] = visited[nowx][nowy] + 1;
                    q.add(new int[]{nx, ny});
                }
            }
        }
    }
}