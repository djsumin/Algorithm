import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int[][] maze;
	static int cnt;
	static boolean[][] visited;
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		maze = new int[N][M];
		visited = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			String[] str = br.readLine().split("");
			for (int j = 0; j < M; j++) {
				maze[i][j] = Integer.parseInt(str[j]);
			}

		} // 입력완
//		System.out.println(Arrays.deepToString(maze));
		visited[0][0] = true;
		bfs(0, 0);
		System.out.println(maze[N-1][M-1]);
	}

	private static void bfs(int r, int c) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {r, c});
		
		while(!queue.isEmpty()) {
			int [] arr = queue.poll();
			int x = arr[0];
			int y = arr[1];
			for (int i = 0; i < 4; i++) {
				// 상우하좌
				int[] dr = { -1, 0, 1, 0 };
				int[] dc = { 0, 1, 0, -1 };
				int nr = x + dr[i];
				int nc = y + dc[i];
				if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
					if (!visited[nr][nc]&& maze[nr][nc] == 1) {
						queue.add(new int[] {nr, nc});
						maze[nr][nc] = maze[x][y] + 1;
						visited[nr][nc]=true;
					}
				}
			}
		}
		
	}
}
