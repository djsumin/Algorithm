import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] visited;
	static List<Integer>[] adjList;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());

		visited = new int[N + 1];

		// 인접리스트
		adjList = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++) {
			adjList[i] = new ArrayList<>();
			visited[i] = -1;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			adjList[u].add(v);
			adjList[v].add(u);

		} // 입력완료


		bfs(R);
		for(int i=1;i<N+1;i++) {
			System.out.println(visited[i]);
		}
		
	}

	private static void bfs(int r) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(r);
		visited[r] = 0;

		int dep = 0;
		while (!queue.isEmpty()) {
			int t = queue.poll();
			for (int i = 0; i < adjList[t].size(); i++) {
				int next = (int) adjList[t].get(i);
				if (visited[next]==-1) {
//					System.out.println(visited[t]);
					visited[next] = visited[t]+1;
					queue.add(next);
				}
			}
		} // 반복문

	}
}
