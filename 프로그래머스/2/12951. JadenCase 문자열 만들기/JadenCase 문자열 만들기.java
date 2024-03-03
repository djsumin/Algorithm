import java.util.*;
import java.io.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        String[] str = s.split(" ");
        
        for(int i=0;i<str.length;i++){
            String now = str[i];
            if(now.length() == 0){
                answer+= " ";
            }else{
                //첫번째문자는 대문자
                answer += now.substring(0,1).toUpperCase();
                
                //두번째문자부터는 소문자
                answer += now.substring(1, now.length()).toLowerCase();
                
                
                answer+=" ";
            }
        } 
        
        if(s.substring(s.length()-1, s.length()).equals(" ")){
            return answer;
        }
            
        
        return answer.substring(0, answer.length()-1);
    }
}