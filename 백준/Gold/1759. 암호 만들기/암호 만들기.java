import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int L;
	static int C;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		String[] arr = new String[C];
		boolean[] visited;
		for (int i = 0; i < C; i++) {
			arr[i] = st.nextToken();
		}
		Arrays.sort(arr);
		// 6개중에 4개뽑기
		combination(arr, new boolean[C], 0, 0, L);

	}

	private static void combination(String[] arr, boolean[] visited, int start, int depth, int r) {
		// 기저조건
		if (depth == L) {
			print(arr, visited);
			return;
		}

		// 재귀조건
		for (int i = start; i < arr.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				combination(arr, visited, i + 1, depth + 1, r);
				visited[i] = false;
			}
		}

	}

	private static void print(String[] arr, boolean[] visited) {
        StringBuilder result = new StringBuilder();

        if (check(arr, visited)) {
        	//check 함수가 true : 자음모음개수 충족되면 출력
            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) {
                    result.append(arr[i]);
                }
            }
        } else {
        	//자음모음개수가 충족되지 못하면 출력 불가능 
        	//아예 조건에 맞지 않기 때문에 리턴시키기..!
            return;
        }

        result.append("\n");
        System.out.print(result);

    }

	private static boolean check(String[] arr, boolean[] visited) {
		int cnt = 0;
		int cnt2 = 0;
		for (int i = 0; i < arr.length; i++) {
			if (visited[i]) {
				if (arr[i].contains("a") || arr[i].contains("i") || arr[i].contains("e") || arr[i].contains("u")
						|| arr[i].contains("o")) {
					cnt++;
				}else {
					cnt2++;
				}
			}

		}
		if (cnt >= 1 && cnt2>=2) {
			return true;
		}
		return false;
	}

}
