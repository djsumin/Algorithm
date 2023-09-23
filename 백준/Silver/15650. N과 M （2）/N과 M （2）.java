import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int[] arr; // 배열
	static int[] result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		// n개중에 M개를 뽑자 먼저.
		arr = new int[N];
		result= new int[M];
		for(int i=0;i<arr.length;i++) {
			arr[i]=i+1;
		}//선택하고자 하는 대상 집합
//		System.out.println(Arrays.toString(arr));
		
		combination(0,0);
	}

	//i는 arr의 인덱스, j는 결과값의 인덱스
	private static void combination(int cnt, int idx) {
		//기저조건
		if(cnt==M) {
			for(int i=0;i<result.length;i++) {
				System.out.print(result[i]+" ");
			}
			System.out.println();
			return;
		}
		//재귀조건
		for(int i=idx;i<N;i++) {
			result[cnt] = arr[i];
			combination(cnt+1, i+1);
		}
	}


	

}
