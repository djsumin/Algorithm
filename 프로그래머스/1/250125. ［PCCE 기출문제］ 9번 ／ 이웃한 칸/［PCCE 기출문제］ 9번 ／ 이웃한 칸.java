import java.util.*;
import java.io.*;

class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        int[] dh = {0, 1, -1, 0};
        int[] dw = {1, 0, 0, -1};
        
        int n = board.length;
        String color = board[h][w];
        
        for(int i=0;i<4;i++){
            int nh = h + dh[i];
            int nw = w + dw[i];
            if(nh >= 0 && nh < n && nw >= 0 && nw < n){
                if(board[nh][nw].equals(color)){
                    answer++;
                }
            }
        }
        
        
        
        return answer;
    }
}