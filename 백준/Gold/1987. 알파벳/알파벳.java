import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] visited;
	static char[][] map;
	static int R, C;
	static int ans = 1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
			}
		} // 입력완

		visited = new int[26];
		// 대문자니까 A : 65, Z: 90

		dfs(0, 0, 0);
		System.out.println(ans);

	}

	private static void dfs(int r, int c, int cnt) {
		// 기저조건
		// 방문했으면 답 출력해!
		if (visited[map[r][c] - 65] == 1) {
			ans = Math.max(ans, cnt);
			return;
		}

		// 재귀조건
		else {
			//방문하지 않은 애
			visited[map[r][c] - 65] = 1;
			int[] dr = {  0, 1, 0, -1 };
			int[] dc = { 1, 0, -1, 0 };
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if (nr >= 0 && nc >= 0 && nr < R && nc < C) {
					dfs(nr, nc, cnt + 1);
				}
			}
			
			//백트
			visited[map[r][c] - 65] = 0;
		}
	}
}
