import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine();
        int[] arr = new int[num.length()];
        for(int i=0;i<num.length();i++){
            arr[i]=num.charAt(i)-'0';
        }

        int cnt = 0;//9나 6의개수
        int[] cards = new int[10];
        for(int i=0;i<arr.length;i++){
            if(arr[i]==9 || arr[i]==6){
                cnt++;

            }else{
                cards[arr[i]]++;
            }
        }
        int set = 0;
        for(int i=0;i<cards.length;i++){
            set = Math.max(set, cards[i]);
        }

        set = Math.max(set, (cnt+1)/2);
//        if(set==(cnt/2) && set > cnt) {
//            set = set + 1;
//        }else if(set==(cnt/2) && set < cnt){
//            set = cnt/2;
//        }else{
//            set = Math.max(set, cnt/2);
//        }
        System.out.println(set);


    }


}