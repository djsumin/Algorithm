import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        int N = citations.length;
        for(int i=0;i<=citations[N-1];i++){
            int cnt = 0;
            for(int j=0;j<N;j++){
                if(citations[j]>=i){
                    cnt++;
                }
            }
            if(cnt>=i){
                answer = Math.max(answer, i);
            }
            
        }
        
        
        
        return answer;
    }
}