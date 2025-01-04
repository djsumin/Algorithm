import java.util.*;

class Solution{
    public int solution(int []A, int []B){
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);
        
        int b_size = B.length;
        
        for(int i=0;i<A.length;i++){
                answer+=A[i]*B[b_size-i-1];
        }
        
        return answer;
    }
}