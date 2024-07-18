import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i=0;i<N;i++){
            arr[i] = sc.nextInt();
        }

        int K = sc.nextInt();
        Arrays.sort(arr);
        int cnt = 0;
        for(int i=0;i<N;i++){
            int M = K - arr[i];
            for(int j=i+1;j<N;j++){
                if(arr[j]==M){
                    cnt++;
                    break;
                }
            }
        }

        System.out.println(cnt);

    }
}