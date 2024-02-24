import java.util.*;
import java.io.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        char[] arr = new char[s.length()];
        for(int i=0;i<arr.length;i++){
            arr[i] = s.charAt(i);
        }
        
        Arrays.sort(arr);
        char[] ans = new char[arr.length];
        for(int i=0;i<arr.length;i++){
            ans[i] = arr[arr.length-1-i]; 
        }
        // System.out.println(Arrays.toString(ans));
        answer = new String(ans);
        return answer;
    }
}