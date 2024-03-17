import java.util.*;
import java.io.*;

class Solution {
    public List<Integer> solution(int[] arr) {
        List<Integer> ansarr = new ArrayList<>();
        if(arr.length == 1){
            ansarr.add(-1);
            return ansarr;
        }
        int min = Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            min = Math.min(min, arr[i]);
        }
        
        for(int i=0;i<arr.length;i++){
            if(arr[i]==min){
                continue;
            }
            ansarr.add(arr[i]); 
        }
        return ansarr;
    }
}