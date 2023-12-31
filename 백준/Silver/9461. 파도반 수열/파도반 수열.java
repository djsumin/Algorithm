import java.io.*;
import java.util.*;


public class Main {
    static long[] arr = new long[101];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        triangle();
        for(int tc =0;tc<T;tc++){
            int n = Integer.parseInt(br.readLine());
            System.out.println(arr[n]);
        }

    }
    private static void triangle() {
        arr[1]= 1;
        arr[2] = 1;
        arr[3] = 1;
        for(int i=4;i<101;i++){
            arr[i] = arr[i-3] + arr[i-2];
        }
    }



}