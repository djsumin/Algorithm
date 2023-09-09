import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		String bracket = null;
		
		for (int i = 0; i < N; i++) {
			bracket = br.readLine();
			sb.append(solution(bracket)).append('\n');
		}
		System.out.println(sb);

	}// main

	// 기본적인 스택을 활용한다
	// '('가 나오면 스택 추가하고, ')'가 나오면 스택을 제거하자
	// 만약 스택이 없다면 no를 리턴하고, 문자열을 모두 읽었는데도 스택이 남았다면 no를 리턴한다.
	public static String solution(String bracket) {
		String answer = "YES";
		Stack<Character> stack = new Stack<>(); // 스택생성
		// 문자를 하나씩 검사하면서 스택을 추가하거나 삭제한다.
		for (char x : bracket.toCharArray()) {
			if (x == '(') {
				stack.push(x);
			} else {
				if (stack.isEmpty()) {
					return "NO";
				}
				stack.pop();
			}
		}
		if (!stack.isEmpty()) {
			return "NO";
		}
		return answer;

	}// solution
}
