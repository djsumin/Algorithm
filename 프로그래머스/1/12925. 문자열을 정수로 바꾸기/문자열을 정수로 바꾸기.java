import java.util.*;
import java.io.*;

class Solution {
    public static int solution(String s) {
        int answer = 0;
        
        if(s.charAt(0)=='-'){
            answer = Integer.parseInt(s);
        }else if(s.charAt(0)=='+'){
            answer = Integer.parseInt(s);
        }else{
            answer = Integer.parseInt(s);
        }
        
        return answer;
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(solution(str));
    }
}