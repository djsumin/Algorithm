import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int[] arr2 = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			arr2[i] = Integer.parseInt(st.nextToken());
		}
		//arr2원소가 arr에 포함되어 있는지 check
//		int [] check = new int [M];
//		 for(int i=0;i<M;i++) {
//			for(int j=0;j<N;j++) {
//				if(arr[j] == arr2[i]) {
//					check[i]++;
//				}
//			}
//			if(check[i] == 1) {
//				sb.append(1+"\n");
//			}else {
//				sb.append(0+"\n");
//			}
//		}
		Arrays.sort(arr);
		for(int i=0;i<arr2.length;i++) {
			int idx = Arrays.binarySearch(arr, arr2[i]);
			if(idx < 0) {
				sb.append(0+"\n");
			}else {
				sb.append(1+"\n");
			}
		}
		
		 System.out.println(sb);
	}
}