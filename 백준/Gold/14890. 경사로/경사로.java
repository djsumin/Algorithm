import java.io.*;
import java.util.*;


public class Main {
    static int ans = 0;
    static int[][] map;
    static int N, L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken()); //경사로의 길이
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }//입력완


        for (int i = 0; i < N; i++) {
            //가로
            if (horizontal(i)) {
                ans++;
            }
            //세로
            if (vertical(i)) {
                ans++;
            }

        }
        System.out.println(ans);

    }

    private static boolean vertical(int c) {
        boolean[] isIncline = new boolean[N];
        for (int i = 0; i < N - 1; i++) {
            int diff = map[i][c] - map[i + 1][c];
            if (diff > 1 || diff < -1) {
                return false;
            } else if (diff == -1) {
                for (int j = 0; j < L; j++) {
                    if (i - j < 0 || isIncline[i - j]) return false;
                    if (map[i][c] != map[i - j][c]) return false;
                    isIncline[i - j] = true;
                }
            } else if (diff == 1) {
                for (int j = 1; j <= L; j++) {
                    if (i + j >= N || isIncline[i + j]) return false;
                    if (map[i][c] - 1 != map[i + j][c]) return false;
                    isIncline[i + j] = true;
                }
            }
        }
        return true;
    }

    private static boolean horizontal(int r) {
        boolean[] isIncline = new boolean[N];

        for (int i = 0; i < N - 1; i++) {
            int diff = map[r][i] - map[r][i + 1];
            if (diff > 1 || diff < -1) {
                return false;
            } else if (diff == -1) {
                //다음 칸이 더 높은 경우
                for (int j = 0; j < L; j++) {
                    if (i - j < 0 || isIncline[i - j]) return false;
                    if (map[r][i] != map[r][i - j]) return false;
                    isIncline[i - j] = true; //경사면 설치
                }
            } else if (diff == 1) {
                //다음 칸이 더 낮은 경우
                for (int j = 1; j <= L; j++) {
                    if (i + j >= N || isIncline[i + j]) return false;
                    if (map[r][i] - 1 != map[r][i + j]) return false;
                    isIncline[i + j] = true; // 경사면 설치
                }
            }
        }
        return true;
    }
}

