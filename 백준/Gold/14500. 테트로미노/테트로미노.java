import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int N, M, cnt;
	static int[][] map;
	static int ans;
	static int max = Integer.MIN_VALUE;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 1. 5종류의 테트로미노마다 놓을 수 있는 자리를 다 체크
		// 2. 테트로미노 놓을 때마다 값 체크 -> max 갱신
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				visited[i][j] = true;
				dfs(i, j, 1, map[i][j]);
				visited[i][j] = false;
				int sum = map[i][j];
				if (i - 1 >= 0 && j - 1 >= 0 && j + 1 < M) {
					sum += map[i - 1][j] + map[i][j - 1] + map[i][j + 1];
					max = Math.max(max, sum);
				}
				sum = map[i][j];
				if (j - 1 >= 0 && j + 1 < M && i + 1 < N) {
					sum += map[i][j - 1] + map[i][j + 1] + map[i + 1][j];
					max = Math.max(max, sum);
				}
				sum = map[i][j];
				if (i - 1 >= 0 && j - 1 >= 0 && i + 1 < N) {
					sum += map[i - 1][j] + map[i][j - 1] + map[i + 1][j];
					max = Math.max(max, sum);
				}
				sum = map[i][j];
				if (i - 1 >= 0 && i + 1 < N && j + 1 < M) {
					sum += map[i - 1][j] + map[i + 1][j] + map[i][j + 1];
					max = Math.max(max, sum);
				}
				
			}
		}
		System.out.println(max);

	}

	private static void dfs(int r, int c, int cnt, int ans) {
		// 기저조건
		if (cnt == 4) {
			max = Math.max(max, ans);
			return;
		}

		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (nr >= 0 && nc >= 0 && nr < N && nc < M) {
				if (!visited[nr][nc]) {
					visited[nr][nc] = true;
//					System.out.println(map[nr][nc]);
					dfs(nr, nc, cnt + 1, map[nr][nc] + ans);
					visited[nr][nc] = false;
				}
			}

		}

	}
}
