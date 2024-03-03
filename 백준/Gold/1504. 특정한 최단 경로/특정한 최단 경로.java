import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int v, w;

        public Node(int v, int w){
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return w - o.w;
        }
    }
    static List<Node>[] adjList;
    static int[] dist;
    static boolean[] visited;
    static final int INF = 200000000;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //정점의 개수
        int E = Integer.parseInt(st.nextToken()); //간선의 개수

        adjList = new ArrayList[N+1];
        for(int i=0;i<N+1;i++){
            adjList[i] = new ArrayList<>();
        }

        dist = new int[N+1];
        visited = new boolean[N+1];
        Arrays.fill(dist, INF);

        for(int i=0;i<E;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            adjList[start].add(new Node(end, weight));
            adjList[end].add(new Node(start,weight));
        }

        // 두개의 정점 v1, v2 를 지나는 최단경로 구하기
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        //1-v1-v2-N
        int res1 = 0;
        res1 += dijkstra(1, v1);
        res1 += dijkstra(v1, v2);
        res1 += dijkstra(v2, N);

        //1-v2-v1-N
        int res2 = 0;
        res2 += dijkstra(1,v2);
        res2 += dijkstra(v2, v1);
        res2 += dijkstra(v1, N);

        int ans = (res1 >= INF && res2 >= INF) ? -1 : Math.min(res1, res2);
        System.out.println(ans);

    }

    private static int dijkstra(int start, int end) {
        Arrays.fill(dist, INF);
        Arrays.fill(visited, false);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[N+1];
        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()){
            Node nowNode = pq.poll();
            int now = nowNode.v;
            if(!visited[now]){
                visited[now] = true;
                for(Node node : adjList[now]){
                    if(!visited[node.v] && dist[node.v] > dist[now] + node.w){
                        dist[node.v] = dist[now] + node.w;
                        pq.add(new Node(node.v, dist[node.v]));
                    }
                }
            }
        }
        return dist[end];
    }


}