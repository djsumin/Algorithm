import java.util.*;

class Solution {
    public int solution(int n) {
        int ans = 0;
        
        for(int i=1;i<=n;i++){
            int sum = 0;
            for(int j=i;j<=n;j++){
                sum += j;
                if(sum == n){
                    ans++;
                    break;
                }
                
                if(sum > n){
                    break;
                }
            }
        }
        
        return ans;
    }
}