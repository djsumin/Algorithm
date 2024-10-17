import java.util.*;
import java.io.*;

class Solution{
    public int solution(String s){
        int answer = -1;
        
        char[] arr = s.toCharArray();
        
        Stack<Character> stack = new Stack<>();
        
        for(int i=0;i<arr.length;i++){
            if(stack.isEmpty()){
                stack.push(arr[i]);
            }else{
                if(stack.peek() == arr[i]){
                    stack.pop();
                }else{
                    stack.push(arr[i]);
                }
            }
        }

        
        
        return stack.isEmpty() ? 1 : 0;
    }
}