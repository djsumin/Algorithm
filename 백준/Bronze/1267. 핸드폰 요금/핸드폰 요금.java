import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] arr = new int[N];
        for(int i=0;i<N;i++){
            arr[i] = sc.nextInt();
        }

        int sum1 = 10;
        int sum2 = 15;
        sum1 *= N;
        sum2 *= N;
        for(int i=0;i<N;i++){
            sum1 += (arr[i] / 30) * 10;
            sum2 += (arr[i] / 60) * 15;
        }

        if(sum1 > sum2 ){
            System.out.println("M " + sum2);
        }else if(sum1 < sum2){
            System.out.println("Y " + sum1);
        }else{
            System.out.println("Y M "+ sum1);
        }



    }
}