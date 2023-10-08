import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static List<Integer>[] adjList;
	static boolean[] visited;
	static int cnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			cnt = 0;

			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 국가의 수
			int M = Integer.parseInt(st.nextToken()); // 비행기의 종류

			visited = new boolean[N + 1];
			adjList = new ArrayList[N + 1];
			for (int i = 1; i < N + 1; i++) {
				adjList[i] = new ArrayList<>();
			}

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				adjList[a].add(b);
				adjList[b].add(a);
			}
			
			dfs(1);
			System.out.println(cnt);
		}

	}

	private static void dfs(int idx) {
		visited[idx] = true;
		
		for(int i=1;i<N+1;i++) {
			if(!visited[i]) {
				cnt++;
				dfs(i);
				
			}
		}
	}
}
