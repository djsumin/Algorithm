import java.io.*;
import java.util.*;

public class Main {
    static LinkedList<Character> linkedList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        linkedList = new LinkedList<>();

        for(int i=0;i<str.length();i++){
            linkedList.add(str.charAt(i));
        }

        ListIterator<Character> list = linkedList.listIterator(linkedList.size());

        int M = Integer.parseInt(br.readLine());

        for(int i=0;i<M;i++) {
            String command = br.readLine();
            char order = command.charAt(0);

            switch (order) {
                case 'L':
                    if (list.hasPrevious()) {
                        list.previous();
                    }
                    break;
                case 'D':
                    if (list.hasNext()) {
                        list.next();
                    }
                    break;
                case 'B':
                    if (list.hasPrevious()) {
                        list.previous();
                        list.remove();
                    }
                    break;
                case 'P':
                    char character = command.charAt(2);
                    list.add(character);
                    break;
                default:
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(char s : linkedList){
            sb.append(s);
        }

        System.out.println(sb.toString());
    }
}