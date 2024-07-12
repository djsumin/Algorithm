import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for(int i=0;i<N;i++){
            for(int j=0;j<i;j++){
                System.out.print(" ");
            }
            for(int j=0;j<2*N-(2*i+1);j++){
                System.out.print("*");
            }
            System.out.println();
        }

        for(int i=0;i<N-1;i++){
            for(int j=0;j<N-2-i;j++){
                System.out.print(" ");
            }
            for(int j=0;j<2*i+3;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}