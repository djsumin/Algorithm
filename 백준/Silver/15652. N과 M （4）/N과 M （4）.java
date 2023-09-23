import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	//중복조합
	static int N;
	static int M;
	static int[] arr; // 배열
	static int[] result;
	static int[] visited;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		// n개중에 M개를 뽑자 먼저.
		arr = new int[N];
		result = new int[M];
		visited = new int[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i + 1;
		} // 선택하고자 하는 대상 집합
		combination(0,0);
		bw.write(sb.toString());
		bw.close();
	}

	private static void combination(int cnt, int idx) {
		if(cnt == M) {
			for(int i=0;i<result.length;i++) {
				sb.append(result[i]+" ");
			}
			sb.append("\n");
			return;
		}
		for(int i=idx;i<N;i++) {
			result[cnt]=arr[i];
			combination(cnt+1, i);
		}
	}

	

}
