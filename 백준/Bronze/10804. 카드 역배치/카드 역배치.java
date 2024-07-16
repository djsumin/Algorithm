import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static ArrayList<Integer> map = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        for(int i=1;i<21;i++){
            map.add(i);
        }

        for(int i=0;i<10;i++){
            reverse(sc.nextInt(), sc.nextInt());
        }

        for(int i: map){
            System.out.print(i + " ");
        }

    }

    private static void reverse(int start, int end) {
        ArrayList<Integer> tmp = new ArrayList<>();
        for(int i=start;i<=end;i++){
            tmp.add(map.remove(start-1));
        }
        for(int i : tmp){
            map.add(start-1, i);
        }
    }
}