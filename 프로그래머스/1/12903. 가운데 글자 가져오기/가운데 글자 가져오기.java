import java.io.*;
import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";

        char[] arr = new char[s.length()];
        for(int i=0;i<s.length();i++){
            arr[i] = s.charAt(i);
        }
        if(s.length()%2==0){
            answer = String.valueOf(arr[s.length()/2-1]) + String.valueOf(arr[s.length()/2]);
        }else{
            answer = String.valueOf(arr[s.length()/2]);
        }
        
        return answer;
    }
}