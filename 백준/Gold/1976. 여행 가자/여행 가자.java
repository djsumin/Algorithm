import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int[] parent;
	static int N, M;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine()); // 도시의 수
		M = Integer.parseInt(br.readLine()); // 여행계획에 속한 도시들의 수

		parent = new int[N + 1];
		for (int i = 1; i < N + 1; i++) {
			parent[i] = i;
		}

		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < N + 1; j++) {
				int num = Integer.parseInt(st.nextToken());
				// 두 도시가 연결되어있으면, 부모를 하나로 통일시키자! (유니온)
				if (num == 1)
					union(i, j);
			}
		}

		// 여행계획
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		for (int i = 1; i < M; i++) {
			int now = Integer.parseInt(st.nextToken());
			if (find(start) != find(now)) {
				// 시작점과 그 후가 이어져있지 않으면 여행불가능
				bw.write("NO\n");
				bw.flush();
				bw.close();
				br.close();
				return;
			}
		}

		bw.write("YES\n");
		bw.flush();
		bw.close();
		br.close();
	}

	// 최상위 부모(대표)찾기
	private static int find(int x) {
		if (parent[x] == x)
			return x;
		return parent[x] = find(parent[x]);
	}

	// 도시 연결하기
	private static void union(int x, int y) {
		int a = find(x);
		int b = find(y);

		if (a > b) {
			parent[a] = b;
		} else {
			parent[b] = a;
		}
	}
}
