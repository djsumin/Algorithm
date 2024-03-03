import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int zero_cnt = 0;
        int total_cnt=0;
        
        while(!s.equals("1")){
            //1. 0제거하면서 0의 숫자 세기
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<s.length();i++){
                if(s.charAt(i) == '0' ){
                    zero_cnt++;
                }else{
                    sb.append(s.charAt(i));
                }
            }
            //1인애들만 다시 문자열로 재구성
            s = sb.toString();
            // s=s.replaceAll("0", "");
            
            
            
            //2. s의 길이를 2진법으로 변환하면서 cnt 세기
            int s_num = s.length();
            s = Integer.toBinaryString(s_num);
            total_cnt++;
        }
        
        answer[0] = total_cnt;
        answer[1] = zero_cnt;
        return answer;
    }
}