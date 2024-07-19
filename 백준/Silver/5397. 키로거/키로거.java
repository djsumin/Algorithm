import java.io.*;
import java.util.*;

public class Main {
    static LinkedList<Character> linkedList;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for(int i=0;i<N;i++){
            linkedList = new LinkedList<>();
            ListIterator<Character> list=  linkedList.listIterator();
            String str = sc.next();
            for(int j=0;j<str.length();j++){
                char c = str.charAt(j);
                switch (c){
                    case '<':
                        if(list.hasPrevious()){
                            list.previous();
                        }
                        break;
                    case '>' :
                        if(list.hasNext()){
                            list.next();
                        }
                        break;
                    case '-':
                        if(list.hasPrevious()){
                            list.previous();
                            list.remove();
                        }
                        break;
                    default:
                        list.add(c);
                }


            }
            StringBuilder sb = new StringBuilder();
            for(char s:linkedList){
                sb.append(s);
            }
            System.out.println(sb.toString());
        }


    }
}