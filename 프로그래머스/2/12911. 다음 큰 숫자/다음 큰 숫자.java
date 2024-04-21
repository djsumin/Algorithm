import java.util.*;
import java.io.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        
        String binary = Integer.toBinaryString(n);
        char[] binaryarr = new char[binary.length()];
        int count = 0;
        
        for(int i=0;i<binaryarr.length;i++){
            binaryarr[i] = binary.charAt(i);
        }
        
        // System.out.println(Arrays.toString(binaryarr));
        
        for(int i=0;i<binaryarr.length;i++){
            if(binaryarr[i]==('1')){
                count++;
            }
        }
        
        while(true){
            int oneCnt = Integer.bitCount(++n);
           
            
            if(oneCnt == count){
                answer = n;
                break;
            }
        }
        
        return answer;
    }
}