import java.util.*;
import java.io.*;

class Solution {
    public long solution(long n) {
        long answer = 0;
        
        String N = Long.toString(n);
        char[] arr = new char[N.length()];
        for(int i=0;i<N.length();i++){
            arr[i]=N.charAt(i);
        }
        
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder(String.valueOf(arr));
        sb.reverse();
        
        answer = Long.parseLong(sb.toString());
        return answer;
    }
}