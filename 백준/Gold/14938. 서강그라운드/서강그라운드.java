import java.io.*;
import java.util.*;

public class Main {
    static class Pos implements Comparable<Pos>{
        int num;
        int cost;

        public Pos(int num, int cost) {
            this.num = num;
            this.cost = cost;
        }

        @Override
        public int compareTo(Pos o) {
            return cost - o.cost;
        }
    }
    static List<Pos>[] adjList;
    static int[] dist;
    static boolean[] visited;
    static int N, M, R;
    static int[] item;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //지역의 개수
        M = Integer.parseInt(st.nextToken()); //수색범위
        R = Integer.parseInt(st.nextToken()); //길의 개수

        st = new StringTokenizer(br.readLine());
        item = new int[N+1];
        for(int i=1;i<N+1;i++){
           item[i] = Integer.parseInt(st.nextToken());
        }

        adjList = new ArrayList[N+1];
        for(int i=1;i<=N;i++){
            adjList[i] = new ArrayList<>();
        }
        for(int i=0;i<R;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());
            adjList[start].add(new Pos(end, length));
            adjList[end].add(new Pos(start, length));
        }

        dist = new int[N+1];
        visited = new boolean[N+1];

        int ans = 0;
        for(int i=1;i<N+1;i++){
            ans = Math.max(ans, dijkstra(i));
        }

        System.out.println(ans);





    }

    private static int dijkstra(int start) {
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(visited, false);

        PriorityQueue<Pos> pq = new PriorityQueue<>();
        pq.add(new Pos(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()){
            Pos now = pq.poll();
            int num = now.num;

            if(!visited[num]){
                visited[num]=true;
                for(Pos pos : adjList[num]){
                    if(!visited[pos.num] && dist[pos.num] > dist[num] + pos.cost){
                        dist[pos.num] = dist[num] + pos.cost;
                        pq.add(new Pos(pos.num, dist[pos.num]));
                    }
                }
            }
        }
        int result = 0;
        for(int i=0;i<N+1;i++){
            if(dist[i] <=M){
                //수색범위보다 작으면
                result += item[i];
            }
        }
        return result;
    }


}