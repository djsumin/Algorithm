import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static boolean[] visited;
	static int cnt;
	static int C;
	static List<ArrayList<Integer>> graph;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		C =Integer.parseInt(br.readLine()); //컴퓨터의 개수 (정점의개수)
		int couple = Integer.parseInt(br.readLine());//네트워크 상에서 직접 연결되어 있는 컴퓨터 번호쌍(간선의 개수)
		
		graph = new ArrayList<>();
		for(int i=1;i<=C+1;i++) {
			graph.add(new ArrayList<Integer>());
		}
		visited = new boolean[C+1];
		
		for(int i=0;i<couple;i++) {
			st= new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			graph.get(A).add(B);
			graph.get(B).add(A);
		}//입력끝
		
//		cnt = 0;
		dfs(1);
//		System.out.println(cnt-1);
//		for(int i=1;i<visited.length;i++) {
//			if(visited[i])
//				cnt++;
//		}
		System.out.println(cnt -1);
	}

	private static void dfs(int v) {
		cnt++;
		visited[v]=true; //들어온 애 방문체크
		
		for(int i=0; i<graph.get(v).size();i++) {
//			visited[graph.get(v).indexOf(i)] = true;
			if(!visited[graph.get(v).get(i)]) {
				dfs(graph.get(v).get(i));				
			}
		}
	}
}
