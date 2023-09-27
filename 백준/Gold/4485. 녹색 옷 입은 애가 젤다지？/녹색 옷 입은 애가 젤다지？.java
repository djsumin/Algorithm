import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static final int INF = 140626;
	static int N;
	static int[][] map;
	static int[][] dist;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int cnt = 1;
		while (true) {
			N = Integer.parseInt(br.readLine());
			if (N == 0)
				break;
			map = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			} // 입력끝
//			System.out.println(Arrays.deepToString(map));
			dijkstra(0, 0);

			System.out.println("Problem " + cnt + ": " + dist[N - 1][N - 1]);
			cnt++;
			dist[0][0] = map[0][0];
		} // while

	}

	private static void dijkstra(int i, int j) {
		int[] dr = { -1, 0, 1, 0 };
		int[] dc = { 0, 1, 0, -1 };
		dist = new int[N][N]; //누적합배열
		for(int[] g : dist) {
			Arrays.fill(g, INF);
		}//처음에 다 무한대로 초기화
		dist[i][j] = map[i][j];
		// 상우하좌
		Deque<int[]> queue = new LinkedList<>();
		queue.add(new int[] { i, j });

		while (queue.size() > 0) {
			int[] ele = queue.poll();
			int r = ele[0];
			int c = ele[1];

			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
					if (dist[nr][nc] > dist[r][c] + map[nr][nc]) {
						dist[nr][nc] = dist[r][c] + map[nr][nc];
						queue.add(new int[] { nr, nc });
					}
				}
			}
		}

	}
}
