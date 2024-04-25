import java.util.*;
import java.io.*;

class Solution {
    boolean solution(String s) {
        int openCnt = 0;
        int closeCnt = 0;
        char[] arr = s.toCharArray();

        for(int i=0;i<arr.length;i++){
            if(arr[i]=='('){
                openCnt++;        
            }
            if(arr[i]==')'){
                closeCnt++;
            }
            //항상 열린 괄호가 더 많아야함
            if(openCnt < closeCnt){
                return false;
            }
        }

        if(openCnt==closeCnt){
            return true;
        }
        
        return false;
    }
}