import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N= sc.nextInt();
        int cute=0;
        int notcute = 0;
        for(int i=0;i<N;i++){
            int a = sc.nextInt();
            if( a == 1){
                cute++;
            }else{
                notcute++;
            }
        }
        if(cute>notcute){
            System.out.println("Junhee is cute!");
        }else{
            System.out.println("Junhee is not cute!");
        }
    }


}