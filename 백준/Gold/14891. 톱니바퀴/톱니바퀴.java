import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	static int[][] wheels;
	static int cnt;
	static int num;
	static int dir;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		wheels = new int[4][8];
		for (int i = 0; i < 4; i++) {
			String str = br.readLine();
			for (int j = 0; j < 8; j++) {
				wheels[i][j] = str.charAt(j) - '0';
			}
		} // 입력완
		int K = Integer.parseInt(br.readLine()); // 회전 횟수
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			num = Integer.parseInt(st.nextToken())-1;// 회전시킨 톱니바퀴 번호
			dir = Integer.parseInt(st.nextToken()); // 방향
			left(num -1, -dir);
			right(num + 1, -dir);
			rotate(num, dir);
		}
		score();
		System.out.println(cnt);
	}

	private static void right(int num, int dir) {
		if (num > 3)
			return;
		if (wheels[num][6] != wheels[num - 1][2]) {
			right(num +1, -dir);
			rotate(num , dir);
		}
	}

	private static void left(int num, int dir) {
		if (num < 0)
			return;
		if (wheels[num][2] != wheels[num+1][6]) {
			left(num - 1, -dir);
			rotate(num, dir);
		}
	}

	// 톱니바퀴 회전시키는 메소드
	private static void rotate(int num, int dir) {
		if (dir == 1) {
			int tmp = wheels[num][7];
			for (int i = 7; i > 0; i--) {
				wheels[num][i] = wheels[num][i-1];
			}
			wheels[num][0] = tmp;
			// 시계방향

		} else {
			// 반시계방향
			int tmp = wheels[num][0];
			for (int i = 0; i < 7; i++) {
				wheels[num][i] = wheels[num][i+1];
			}
			wheels[num][7] = tmp;
			
		}

	}

	// 점수 계산해주는 메소드
	private static void score() {
		if (wheels[0][0] == 1) {
			cnt += 1;
		}
		if (wheels[1][0] == 1) {
			cnt += 2;
		}
		if (wheels[2][0] == 1) {
			cnt += 4;
		}
		if (wheels[3][0] == 1) {
			cnt += 8;
		}
	}

}