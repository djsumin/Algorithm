import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;// 비밀번호 체크배열
	static int[] cnt;// 현재상태 카운트배열
	static int checkSecret = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(st.nextToken()); // 민호가 임의로 만든 dna 문자열 길이
		int P = Integer.parseInt(st.nextToken()); // 비밀번호로 사용할 부분문자열의 길이
		int ans = 0;
		arr = new int[4];
		cnt = new int[4];
		char[] A = new char[S];

		A = br.readLine().toCharArray();
		st = new StringTokenizer(br.readLine());
		// A , C, G, T
		for (int i = 0; i < 4; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if (arr[i] == 0) {
				checkSecret++;
			}
		}

		for (int i = 0; i < P; i++) {
			Add(A[i]);
		}
		if (checkSecret == 4) {
			ans++;
		}

		// 슬라이딩윈도우(이동할 때마다 바뀌는 앞과 뒤를 확인해주자
		for (int i = P; i < S; i++) {
			int j = i - P;
			Add(A[i]);
			Remove(A[j]);
			if (checkSecret == 4) {
				ans++;
			}
		}

		System.out.println(ans);
		br.close();
	}

	private static void Remove(char c) {
		switch (c) {
		case 'A':
			if (cnt[0] == arr[0]) {
				checkSecret--;
			}
			cnt[0]--;
			break;
		case 'C':
			if (cnt[1] == arr[1]) {
				checkSecret--;
			}
			cnt[1]--;
			break;
		case 'G':
			if (cnt[2] == arr[2]) {
				checkSecret--;
			}
			cnt[2]--;
			break;
		case 'T':
			if (cnt[3] == arr[3]) {
				checkSecret--;
			}
			cnt[3]--;
			break;
		}

	}

	private static void Add(char c) {
		switch (c) {
		case 'A':
			cnt[0]++;
			if (cnt[0] == arr[0]) {
				checkSecret++;
			}
			break;
		case 'C':
			cnt[1]++;
			if (cnt[1] == arr[1]) {
				checkSecret++;
			}
			break;
		case 'G':
			cnt[2]++;
			if (cnt[2] == arr[2]) {
				checkSecret++;
			}
			break;
		case 'T':
			cnt[3]++;
			if (cnt[3] == arr[3]) {
				checkSecret++;
			}
			break;
		}
	}
}
