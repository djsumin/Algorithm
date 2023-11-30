import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int S;
	static int[] arr;
	static boolean[] visited;
	static int cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // N개의 정수로 이루어진 수열
		S = Integer.parseInt(st.nextToken()); // 부분수열의 합이 s

		arr = new int[N];
		visited = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		} // 입력완

		// 합이 s가 되는 부분수열의 개수 구하기!
		// i개 뽑음!
		for (int i = 1; i <= N; i++) {
			combination(arr, visited, 0, i);
		}
		
		System.out.println(cnt);

	}

	private static void combination(int[] arr, boolean[] visited, int start, int r) {
		if (r == 0) {
			sum(arr, visited);
			return;
		} else {
			for (int i = start; i < arr.length; i++) {
				visited[i] = true;
				combination(arr, visited, i + 1, r - 1);
				visited[i] = false;
			}
		}
	}

	// 부분수열의 합 구하기
	private static void sum(int[] arr, boolean[] visited) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			if (visited[i]) {
				sum = sum + arr[i];
			}
		}
		if(sum == S) {
			cnt++;
		}
	}

}
