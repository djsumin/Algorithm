import java.io.*;
import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        int pcnt= 0;
        int ycnt = 0;
        for(int i=0;i<s.length();i++){
           char c = Character.toLowerCase(s.charAt(i));
            if(c=='p'){
                pcnt++;
            }else if (c=='y'){
                ycnt++;
            }
        }
        
        
        
        return pcnt==ycnt;
    }
}