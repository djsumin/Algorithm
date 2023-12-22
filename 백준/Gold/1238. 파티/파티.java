import java.io.*;
import java.util.*;
public class Main {
    static class Node implements Comparable<Node>{
        int end;
        int time;

        public Node(int end, int time) {
            this.end = end;
            this.time = time;
        }

        //다익스트라 오름차순으로 시간비용이 정렬된다.
        @Override
        public int compareTo(Node o) {
            return this.time - o.time;
        }

    }
    static final int INF = Integer.MAX_VALUE;
    static List<Node>[] adjList;
    static List<Node>[] reverse_adjList;
    static int[] dist;
    static int N, M, X;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 학생수
        M = Integer.parseInt(st.nextToken()); // 단방향도로 개수
        X = Integer.parseInt(st.nextToken()); //파티가 열리는 곳

        adjList = new ArrayList[N+1];
        reverse_adjList = new ArrayList[N+1];


        for(int i=1;i<N+1;i++){
            adjList[i] = new ArrayList<>();
            reverse_adjList[i] = new ArrayList<>();
        }
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            adjList[start].add(new Node(end, time));
            reverse_adjList[end].add(new Node(start, time));
        }

        int[] goRes = dijkstra(adjList);
        int[] backRes = dijkstra(reverse_adjList);

        //학생들 중 오고가는데 가장 오래 걸리는 학생의 소요시간 출력
        int max = Integer.MIN_VALUE;
        for(int i=1;i<N+1;i++){
            max = Math.max(max, goRes[i] + backRes[i]);
        }

        System.out.println(max);


    }

    private static int[] dijkstra(List<Node>[] list) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist = new int[N+1];
        Arrays.fill(dist, INF);
        boolean [] visited = new boolean[N+1];
        dist[X] = 0;
        pq.add(new Node(X, 0));

        while(!pq.isEmpty()){
            Node now = pq.poll();
            int num = now.end;
            if(visited[num])
                continue;

            visited[num] = true;
            for(Node node : list[num]){
                if(!visited[node.end] && dist[node.end] > (dist[num] + node.time)){
                    dist[node.end] = dist[num] + node.time;
                    pq.add(new Node(node.end, dist[node.end]));
                }
            }
        }

        return dist;
    }


}