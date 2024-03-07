import java.util.*;
import java.io.*;

class Solution {
    public long solution(int price, int money, int count) {
        long answer = 0;

        long total = 0;
        for(int i=1;i<=count;i++){
            total += i*price;
        }
        answer=total-money;
        if(total <= money){
            return 0;
        }else{
            return answer;
        }
        
        
    }
}