import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class Node {
	int next;
	int weight;

	public Node(int next, int weight) {
		super();
		this.next = next;
		this.weight = weight;
	}

}

public class Main {
	static int V;
	static int E;
	static int start;
	static List<Node>[] adjList;
	static int v;
	static int u;
	static int w;
	static int[] dist;
	static boolean[] visited;
	static int INF = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		start = Integer.parseInt(br.readLine());

		adjList = new ArrayList[V+1];
		for(int i=0;i<V+1;i++) {
			adjList[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			
			adjList[u].add(new Node(v, w));
		}//입력완
		
		dist = new int[V+1];
		Arrays.fill(dist, INF);
		
		dijkstra(start);
		for(int i=1;i<=V;i++) {
			if(dist[i]==INF)
				System.out.println("INF");
			else {
				System.out.println(dist[i]);
			}
		}
	}
	private static void dijkstra(int start) {
		visited = new boolean[V+1];
		dist[start] = 0;
		
		for(int i=1;i<V;i++) {
			int min = INF;
			int idx= -1;
			
			for(int j=1;j<V+1;j++) {
				if(!visited[j] && min > dist[j]) {
					min = dist[j];
					idx = j;
				}
				
			}
			if(idx==-1) {
				break;
			}
			visited[idx] = true;
			
			for(int j=0;j<adjList[idx].size();j++) {
				Node curr = adjList[idx].get(j);
				if(!visited[curr.next] && dist[curr.next] > curr.weight + dist[idx]) {
					dist[curr.next] = curr.weight + dist[idx];
				}
			}
		}
	}
}
