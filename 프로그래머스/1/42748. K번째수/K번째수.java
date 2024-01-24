import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int i=0;i<commands.length;i++){
            int a = commands[i][0];
            int b = commands[i][1];
            int k = commands[i][2];
            
            int[] arr = new int[b-a+1];
            for(int j=0;j<=b-a;j++){
                arr[j] = array[a+j-1];                 
            }
            
            Arrays.sort(arr);
            answer[i] = arr[k-1];
        }
        
        
        
        return answer;
    }
}