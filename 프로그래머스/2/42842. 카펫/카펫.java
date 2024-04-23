import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int sum = brown + yellow;
        
        for(int i=3;i<=sum;i++){
            int col = i; //세로
            int row = sum / i; // 가로
            
            if(row < 3){
                continue;
            }
            
            if(row >= col){
                if((row-2)*(col-2)==yellow){
                    answer[0] = row;
                    answer[1] = col;
                    break;
                }
            }
        }
        return answer;
    }
}