import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        int max = nums.length/2;

        //중복제거
        HashSet<Integer> set = new HashSet<>();
        
        for(int i =0 ;i<nums.length;i++){
            set.add(nums[i]);
        }
        
        System.out.println(set);
        
        if(set.size() >= max){
            answer = max;
        }else{
            answer = set.size();
        }
        
        
        return answer;
    }
}