import java.util.*;
import java.io.*;

class Solution {
    public static int solution(String[] friends, String[] gifts) {
        //인당 받은 선물의 개수
        int[] receiveCount =  new int[friends.length];
        
        for(int i=0;i<friends.length-1;i++){
            for(int j=i+1;j<friends.length;j++){
                String friend1 = friends[i];
                String friend2 = friends[j];
                int friend1ToFriend2 = 0;
                int friend2ToFriend1 = 0;
                
                for(String gift : gifts){
                    if(gift.equals(friend1 + " " + friend2)){
                        friend1ToFriend2++;
                    }else if(gift.equals(friend2 + " " + friend1)){
                        friend2ToFriend1++;
                    }
                }
                
                if((friend1ToFriend2 + friend2ToFriend1 == 0) || (friend1ToFriend2 ==  friend2ToFriend1)){
                    //선물을 주고받은 기록이 없거나, 선물주고받은 횟수가 같다면?
                    int friend1GiftScore = 0;
                    int friend2GiftScore = 0;
                    //선물지수 계산하기. 준 사람은 +  받은사람은 -
                    for(String gift : gifts){
                        if(gift.split(" ")[0].equals(friend1)) {
                            friend1GiftScore++;
                        }else if(gift.split(" ")[0].equals(friend2)){
                            friend2GiftScore++;
                        }
                        if(gift.split(" ")[1].equals(friend1)){
                            friend1GiftScore--;
                        }else if(gift.split(" ")[1].equals(friend2)){
                            friend2GiftScore--;
                        }
                    }
                    
                    if(friend1GiftScore > friend2GiftScore){
                        receiveCount[i]++;
                    }else if(friend1GiftScore < friend2GiftScore){
                        receiveCount[j]++;
                    }
                    
                }else{
                    //선물을  주고받은 기록이 있다면?
                    if(friend1ToFriend2>friend2ToFriend1){
                        receiveCount[i]++;
                    }else if(friend1ToFriend2<friend2ToFriend1){
                        receiveCount[j]++;
                    }
                }
                
            }
        }
        
        
        
        Arrays.sort(receiveCount);
        
        
        return receiveCount[receiveCount.length-1];
        
    }
    
  
}