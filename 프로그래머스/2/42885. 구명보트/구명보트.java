import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] people, int limit) {
        
        Arrays.sort(people);
        
        int boat = 0;
        int min = 0;
        int size = people.length;
        int max = size-1;
        
        for(int i = 0;i<size;i++){
            if(people[min] + people[max] <= limit){
                min++;
                max--;
                boat++;
            }else{
                max--;
                boat++;
            }
            
            if(min > max){
                break;
            }
            if(min==max){
                boat++;
                break;
            }
        }
        
        return boat;
    }
}