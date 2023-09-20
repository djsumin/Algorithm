import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	static int[] p;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 정점의 개수
		int M = sc.nextInt(); // 간선의 개수
		int[][] edges = new int[M][3];
		for (int i = 0; i < M; i++) {
			edges[i][0] = sc.nextInt(); // 시작정점
			edges[i][1] = sc.nextInt(); // 끝정점
			edges[i][2] = sc.nextInt(); // 간선
		} // 입력 끝
		p = new int[N + 1];
		for (int i = 1; i < N + 1; i++) {
			p[i] = i;
		}

		Arrays.sort(edges, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}

		});

//		for(int[] e: edges) {
//			System.out.println(Arrays.toString(e));
//		}

		int ans = 0;
		int pick = 0;

		for (int i = 0; i < M; i++) {
			int x = edges[i][0];
			int y = edges[i][1];

			if (find(x) != find(y)) {
				union(x, y);
				ans += edges[i][2];
				pick++;
			}
			if (pick == M - 1)
				break;
		}
		System.out.println(ans);

	}

	public static void union(int x, int y) {
		p[find(y)] = find(x);
	}

	public static int find(int x) {
		if (x != p[x])
			p[x] = find(p[x]);
		return p[x];
	}
}
