import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[] p;

	public static void main(String[] args) throws IOException {
		// 대표를 찾자!!!
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 정점의 개수
		int M = Integer.parseInt(st.nextToken()); // 간선의 개수
		int[][] edges = new int[M][2];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			edges[i][0] = Integer.parseInt(st.nextToken()); // 시작점
			edges[i][1] = Integer.parseInt(st.nextToken()); // 끝점
		}

		p = new int[N + 1];
		for (int i = 1; i < N + 1; i++) {
			p[i] = i;
		}

		for (int i = 0; i < M; i++) {
			int x = edges[i][0];
			int y = edges[i][1];

			// 대표가 같지 않다면?
			if (findset(x) != findset(y)) {
				union(x, y);
			}
		}
		
		for (int i = 1; i < N + 1; i++) {
			findset(i);
		}
//		System.out.println(Arrays.toString(p));
		int[] cnt = new int[N + 1];
		for (int i = 1; i < p.length; i++) {
			cnt[p[i]]++;
		}
//		System.out.println(Arrays.toString(cnt));
		int ans = 0;
		for (int i = 0; i < cnt.length; i++) {
			if (cnt[i] != 0)
				ans++;
		}
		System.out.println(ans);
	}

	private static void union(int x, int y) {
		p[findset(y)] = findset(x); // x의 대표를 y의 대표로 넣겠따.
	}

	private static int findset(int x) {
		if (x != p[x])
			p[x] = findset(p[x]);
		return p[x];
	}

}
