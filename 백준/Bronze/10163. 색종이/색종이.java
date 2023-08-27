import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 색종이의 장수
		int[][] array = new int[101][101]; // 색종이가 놓이는 평면\
	
		for (int i = 1; i <= N; i++) {
			int x = sc.nextInt(); // 가장 왼쪽 아래 칸의 번호
			int y = sc.nextInt();
			int nubi = sc.nextInt(); // 너비
			int height = sc.nextInt(); // 높이

			for (int j = x; j < x + nubi; j++) {
				for (int k = y; k < y + height; k++) {
					array[j][k] = i; // 색종이 넓이만큼 행과 열을 순회하면서 다 색종이 번호로 채우기
				}
			}
		} // 입력받기 끝

		for(int i=1;i<=N;i++) {
			int cnt = 0;
			for(int j=0;j<101;j++) {
				for(int k=0;k<101;k++) {
					if(array[j][k] == i) {
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}
			
			
		
	}

}
