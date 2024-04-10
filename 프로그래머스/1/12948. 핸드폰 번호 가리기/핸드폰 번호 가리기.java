import java.util.*;
import java.io.*;

class Solution {
    public String solution(String phone_number) {
        String answer = "";
    
        char[] phone = phone_number.toCharArray();
        int length = phone.length;
        int starsCount = length - 4;
        
        for(int i=0;i<length;i++){
            if(i<starsCount){
                phone[i] = '*';
            }
        }
        answer = String.valueOf(phone);
        
        
        return answer;
    }
}