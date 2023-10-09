import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
	static int[][] map;
	static int N;
	static boolean[] visited;
	static int start;
	static int link;
	static int ans = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());

		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 입력완

		/*
		 * 1. N/2명씩 두 팀으로 나눠주기(조합) 2. 능력치 계산하기 3. 능력치가 최소인 경우 찾기
		 */
		visited = new boolean[N];
		combination(0, 0);
		System.out.println(ans);
		
	}

	// N/2명을 뽑자
	private static void combination(int cnt, int idx) {
		if (cnt == N / 2) {
			calculation();
			return;
		}
		for (int i = idx; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				combination(cnt + 1, i + 1);
				visited[i] = false;
			}
		}
	}

	// 능력치 계산하기
	private static void calculation() {
		start = 0;
		link = 0;

//		System.out.println(Arrays.toString(visited));
		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				if (visited[i] && visited[j]) {
					start += map[i][j];
					start += map[j][i];
				} else if (!visited[i] && !visited[j]) {
					link += map[i][j];
					link += map[j][i];
				}
			}
		}
		int diff = Math.abs(start - link);
		if(diff == 0) {
			System.out.println(0);
			System.exit(0);
		}
		ans = Math.min(ans, diff);
		
	}

}
