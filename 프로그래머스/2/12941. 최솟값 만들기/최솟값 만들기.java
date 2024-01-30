import java.util.*;
import java.io.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        int length= A.length;
        if(A[length-1] > B[length-1]){
            for(int i=0;i<length;i++){
                answer+=B[i]*A[length-1-i];
            }
        }else{
            for(int i=0;i<length;i++){
                answer+=A[i]*B[length-1-i];
            }
        }
        
        return answer;
    }
}