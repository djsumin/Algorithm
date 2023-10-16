import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author judy3
 *
 */
public class Main {
	static int N;
	static int[][] chess;
	static int r;
	static int c;
	static int cnt;

	static class Pos {
		int x;
		int y;
		int cnt;

		public Pos(int x, int y, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			N = Integer.parseInt(br.readLine());
			chess = new int[N][N];
			cnt = 0;
			// 나이트가 현재 있는 칸
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());

			Pos now = new Pos(r, c, 0);

			// 나이트가 이동하려고 하는 칸
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			Pos goal = new Pos(r, c, 0);

			System.out.println(bfs(now, goal));

		} // 테케

	}

	static int[] dr = { -2, -2, -1, 1, 2, 2, 1, -1 };
	static int[] dc = { -1, 1, 2, 2, 1, -1, -2, -2 };

	private static int bfs(Pos now, Pos goal) {
		Queue<Pos> queue = new LinkedList<>();
		boolean[][] visited = new boolean[N][N];
		visited[now.x][now.y] = true;

		queue.add(new Pos(now.x, now.y, 0));
		while (!queue.isEmpty()) {
			Pos ing = queue.poll();

			// 기저조건
			if (ing.x == goal.x && ing.y == goal.y) {
				cnt = ing.cnt;
				break;
			}

			for (int d = 0; d < 8; d++) {
				int nr = ing.x + dr[d];
				int nc = ing.y + dc[d];
				if (nr >= 0 && nc >= 0 && nr < N && nc < N) {
					if (!visited[nr][nc]) {
						visited[nr][nc] = true;
						queue.add(new Pos(nr, nc, ing.cnt + 1));
					}
				}
			}
		}
		return cnt;
	}
}
