import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);
        int min = 0;
        for(int i=people.length-1;i>=min;i--){
            if(people[i] + people[min] <= limit){
                min++;//최소 조건 합격하면 태워
                answer++;
            }else{
                //최소랑 합쳤는데도 안되면 혼자타
                answer++;
            }
            
        }
        
        
        return answer;
    }
}