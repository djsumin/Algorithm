import java.io.*;
import java.util.*;

public class Main {
    static HashMap<Integer, Integer> cards;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        //key, value에서 value를 cnt값으로 잡아주자.
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<N;i++){
            int num = Integer.parseInt(st.nextToken());
            if(!map.containsKey(num)){
                map.put(num, 1);
            }else{
                map.put(num, map.get(num)+1);
            }
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++){
            int num = Integer.parseInt(st.nextToken());
            if(map.containsKey(num)){
                sb.append(map.get(num)+" ");
            }else{
                sb.append(0+" ");
            }
        } //입력완
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
