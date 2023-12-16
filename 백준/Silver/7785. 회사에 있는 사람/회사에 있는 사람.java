
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        HashSet<String> record = new HashSet<>();
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String isEnter = st.nextToken();
            if(isEnter.equals("enter")){
                record.add(name);
            }else{
                record.remove(name);
            }
        }//입력완료

        ArrayList<String> record2 = new ArrayList<>(record);
        Collections.sort(record2, Collections.reverseOrder());
        Iterator<String> iter = record2.iterator();
        while(iter.hasNext()){
            System.out.println(iter.next());
        }

    }
}
