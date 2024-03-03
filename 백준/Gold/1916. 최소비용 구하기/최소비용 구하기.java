import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Node implements Comparable<Node> {
		int v;
		int w;

		public Node(int v, int w) {
			super();
			this.v = v;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.w, o.w);
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());// 정점
		int M = Integer.parseInt(br.readLine());// 간선

		List<Node>[] adjList = new ArrayList[N + 1];

		for (int i = 1; i < N + 1; i++) {
			adjList[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());

			adjList[A].add(new Node(B, W));
//			adjList[B].add(new Node(A, W));
		}

		st = new StringTokenizer(br.readLine());
		int from = Integer.parseInt(st.nextToken());
		int to = Integer.parseInt(st.nextToken());

		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[N + 1];

		Node[] dist = new Node[N + 1];

		for (int i = 1; i < N + 1; i++) {
			if (i == from) {
				dist[i] = new Node(i, 0);
				pq.add(dist[i]);
			} else {
				dist[i] = new Node(i, 987654321);
			}
		}

		while (!pq.isEmpty()) {
			Node t = pq.poll();
			if (visited[t.v]) {
				continue;
			}
			visited[t.v] = true;
//			System.out.println(t.v);

			if (t.w == 987654321) {
				break;
			}

			for (Node i : adjList[t.v]) {
//				if (visited[t.v]) {
//					continue;
//				}

				if (dist[i.v].w > dist[t.v].w + i.w) {
					dist[i.v].w = dist[t.v].w + i.w;
					pq.add(new Node(i.v, dist[i.v].w));
				}
			}

			visited[t.v] = true;
		}

		System.out.println(dist[to].w);

	}
}