import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[][] omok = new char [19][19];
		int [] dx = {0,1,1,-1};
		int [] dy = {1,0,1,1};
		
		//입력받기
		for(int i=0;i<19;i++) {
			String input = br.readLine();
			for(int j=0, index=0;j<19;index +=2, j++) {
				omok[i][j] = input.charAt(index); //공백빼고 글자만 입력받아야하니까.
			}
		}
		
		//모든 칸에 대해 오목 완성본 찾자
		for(int j=0;j<19;j++) {
			for(int i=0;i<19;i++) {
				if(omok[i][j] == '1' || omok[i][j]=='2') {
					for(int k=0;k<4;k++) {
						int ax = i; //x좌표
						int ay = j; //y좌표
						int cnt = 1; //일치하는 바둑돌의 개수
						
						//증가하는 방향 탐색
						while(true) {
							ax = ax + dx[k];
							ay = ay + dy[k];
							if(0<=ax && ax < 19 && ay>=0 && ay<19) {
								if(omok[i][j]==omok[ax][ay])cnt++;
								else {
									break;
								}
							}else break;
						}
						
						ax= i;
						ay=j;
						
						//증가하는 방향의 반대방향 탐색
						while(true) {
							ax = ax - dx[k];
							ay = ay - dy[k];
							if(0<=ax && ax < 19 && ay>=0 && ay<19) {
								if(omok[i][j]==omok[ax][ay])cnt++;
								else {
									break;
								}
							}else break;
						}
						
						//같은 오목눈이 5개라면
						if(cnt==5) {
							System.out.println(omok[i][j]);
							System.out.println((i+1)+" "+(j+1));
							return;
						}
						
					}
				}
			}
		}
		System.out.println(0);
	}
}
