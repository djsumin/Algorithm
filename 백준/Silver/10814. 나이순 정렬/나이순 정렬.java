import java.io.*;
import java.util.*;

public class Main {
    static class Table{
        int age;
        String name;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        Table[] table = new Table[N];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            table[i] = new Table();
            table[i].age = Integer.parseInt(st.nextToken());
            table[i].name = st.nextToken();
        }

        Arrays.sort(table, new Comparator<Table>() {
            @Override
            public int compare(Table o1, Table o2) {
                return o1.age - o2.age;
            }
        });

        for(int i=0;i< table.length;i++){
            System.out.println(table[i].age + " " + table[i].name);
        }
    }
}
