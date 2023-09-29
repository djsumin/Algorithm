import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main{
	static int[] visited;
	static int N;
	static int M;
	static int R;
	static int cnt;
	static List<Integer>[] adjList;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());// 정점의 개수
		M = Integer.parseInt(st.nextToken());// 간선의 개수
		R = Integer.parseInt(st.nextToken()); // 시작정점

		adjList = new ArrayList[N + 1];

		for (int i = 0; i < N + 1; i++) {
			adjList[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			adjList[from].add(to);
			adjList[to].add(from);
		} // 간선정보 입력받기 끝

		visited = new int[N + 1];

		for (int i = 1; i < N + 1; i++) {
			Collections.sort(adjList[i]);
		}
		cnt = 1;
		dfs(R);

		for (int i = 1; i < visited.length; i++) {
			System.out.println(visited[i]);
		}
		System.out.println();

	}// main

	private static void dfs(int v) {
		visited[v] = cnt;

		// 방문하지 않았다면?
		for (int i = 0; i < adjList[v].size(); i++) {
			int node = (int) adjList[v].get(i);
			if (visited[node] == 0) {
				cnt++;
				dfs(node);
			}
		}
	}

}
