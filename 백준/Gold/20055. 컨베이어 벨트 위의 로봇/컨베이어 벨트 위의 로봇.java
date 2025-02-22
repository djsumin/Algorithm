import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int ans = 1;

        st = new StringTokenizer(br.readLine());
        int[] belt = new int[2*N];
        boolean[] robot = new boolean[N];
        for (int i = 0; i < 2*N; i++) {
            belt[i] = Integer.parseInt(st.nextToken());
        }

        while(true){
            //1단계: 한 칸 회전
            int tmp = belt[2*N-1];
            for(int i=belt.length-1;i>0;i--){
                belt[i] = belt[i-1];
            }
            belt[0] = tmp;
            for(int i=N-1;i>0;i--){
                robot[i] = robot[i-1];
            }
            robot[0] = false;
            robot[N-1] = false;

            //2단계: 로봇 움직이기
            for(int i=N-1;i>0;i--){
                if(robot[i-1] && !robot[i]&&belt[i]>0){
                    robot[i-1] = false;
                    robot[i] = true;
                    belt[i]--;
                    robot[N-1] = false;
                }
            }

            //3단계: 로봇 올리기
            if(belt[0]>0){
                robot[0] = true;
                belt[0]--;
            }

            //4단계: 0 개수 체크
            int cnt = 0;
            for(int i = 0; i < belt.length; i++){
                if(belt[i] == 0){
                    cnt++;
                }
            }
            if(cnt >= K){
                break;
            }
            ans++;
        }
        System.out.println(ans);


    }
}
