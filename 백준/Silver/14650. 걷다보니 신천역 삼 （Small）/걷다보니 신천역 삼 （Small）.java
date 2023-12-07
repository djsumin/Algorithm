import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] num = { 0, 1, 2 };
	static int[] res;
	static int N;
	static int count;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		// 3개중에 N개 뽑아서 중복순열!
		count = 0;
		res = new int[N];

		perm(0, 0);
		System.out.println(count);
	}

	private static void perm(int cnt, int sum) {
		// 기저조건
		for (int i = 0; i < 3; i++) {
			if(cnt==0 && i==0) {
				continue;
			}
			if (cnt == N) {
				if(sum % 3 ==0)
					count++;
				return;
			}else {
				perm(cnt+1, sum+i);
			}
			
		}
	}

}
