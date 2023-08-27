import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 스위치개수
		int[] condition = new int[N];
		for (int i = 0; i < N; i++) {
			condition[i] = sc.nextInt();
		}
		int student = sc.nextInt(); // 학생수

		for (int i = 0; i < student; i++) {
			int a = sc.nextInt(); // 성별이 주어진다.
			int b = sc.nextInt(); // 학생이 받은 수가 주어진다.
			if (a == 1) {// 남자라면
				//받은수의 배수인 스위치의 상태를 바꿔준다
				for (int j = 0; j < N; j++) {
					if((j+1) % b == 0) {
						condition[j] = condition [j] == 0? 1:0;
					}
				}
			} else {// 여자라면
				// 뽑은 수를 중심으로 좌우가 대칭이면 상태를 바꾼다.
				condition[b - 1] = condition[b - 1] == 0 ? 1 : 0;

				for (int j = 1; j < N / 2; j++) {
					if (b - j - 1 < 0 || b + j - 1 >= N) // 범위벗어날때
						break;
					if (condition[b - j - 1] == condition[b + j - 1]) {
						// 양쪽 값이 같을 때
						condition[b - j - 1] = condition[b - j - 1] == 0 ? 1 : 0;
						condition[b + j - 1] = condition[b + j - 1] == 0 ? 1 : 0;
					}else {
						break;
					}

				}

			}
		}//학생수 반복끝
		for(int i =0;i<condition.length;i++) {
			System.out.print(condition[i]+" ");
			if((i + 1) % 20 == 0) {
				System.out.println();
			}
		}
	}

}
