import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());
        for(int t = 0; t < tc; t++) {
            int n = Integer.parseInt(br.readLine());
            HashMap<String, Integer> map = new HashMap<>();
            for(int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                map.put(st.nextToken(), Integer.parseInt(st.nextToken()));
            }
            List<String> keySet = new ArrayList<>(map.keySet());
            keySet.sort(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return map.get(o1).compareTo(map.get(o2));
                }
            });
            System.out.println(keySet.get(n-1));
        }

    }
}
