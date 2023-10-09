import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int ans = Integer.MIN_VALUE;
	static int[][] map;
	static boolean[][] visited;
	static int max;
	static int cnt; // 안전영역의 개수

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 비의 양에 따라 안전영역의 개수가 달라짐
		// 안전영역의 개수가 최대일 때의 개수 구하기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(max, map[i][j]);
			}
		} // 입력완
//		System.out.println(max);

		rainCheck(0);
//		ans = Math.max(ans, cnt);
		System.out.println(ans);
	}

	// 물에 잠기는 영역을 0으로 만들자.
	private static void rainCheck(int rain_depth) {
		// i가 수면의 높이
		// 기저조건
		if (rain_depth == max) {
			return;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] <= rain_depth) {
					map[i][j] = 0;
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] != 0 && !visited[i][j]) {
					safeplace(i, j);
					cnt++;
				}
			}
		}
		ans = Math.max(ans, cnt);
		cnt = 0;
		visited = new boolean[N][N];
		rainCheck(rain_depth + 1);
	}

	// dfs로 안전영역 체크 , 값이 0인곳만 돌면서 덩어리체크하기!(최대인 애 뽑기)
	private static void safeplace(int r, int c) {
		visited[r][c] = true;
		int[] dr = { -1, 0, 1, 0 };
		int[] dc = { 0, 1, 0, -1 };
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (nr >= 0 && nc >= 0 && nr < N && nc < N) {
				if (map[nr][nc] !=0  && !visited[nr][nc])
					safeplace(nr, nc);
			}
		}

	}
}
