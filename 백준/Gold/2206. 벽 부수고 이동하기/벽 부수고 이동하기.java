import java.io.*;
import java.util.*;


public class Main {
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};
    static int N, M;
    static int[][] arr;
    static int[][][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        // 벽을 부수었는지에 대한 여부
        visited = new int[2][N][M];
        for(int i=0;i<N;i++){
            String str = br.readLine();
            for(int j=0;j<M;j++){
                arr[i][j] = str.charAt(j)-'0';
            }
        }//입력완

        if(N==1 && M==1){
            System.out.println(1);
            System.exit(0);
        }
        System.out.println(bfs());


    }

    private static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0,0});
        visited[0][0][0] = 1;
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            int isBroken = now[0];
            int r = now[1];
            int c = now[2];

            for(int d=0;d<4;d++){
                int nr = r + dr[d];
                int nc = c + dc[d];
                if(nr>=0 && nc>=0 && nr<N && nc<M){
                    if(arr[nr][nc]==0){
                        if(visited[isBroken][nr][nc]==0){
                            queue.add(new int[]{isBroken, nr,nc});
                            visited[isBroken][nr][nc] = visited[isBroken][r][c]+1;
                            if(nr == N-1 && nc==M-1){
                                return visited[isBroken][nr][nc];
                            }
                        }
                    }else{
                        if(isBroken==0){
                            if(visited[1][nr][nc]==0){
                                queue.add(new int[]{1, nr, nc});
                                visited[1][nr][nc] = visited[0][r][c]+1;
                                if(nr ==N-1&& nc==M-1){
                                    return visited[1][nr][nc];
                                }
                            }
                        }
                    }
                }
            }

            }
        return -1;
        }
    }

