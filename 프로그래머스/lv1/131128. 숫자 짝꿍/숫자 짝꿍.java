import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(String X, String Y) {
        String answer = "";
        int[] arrX = new int[10];
        int[] arrY = new int[10];
        int[] arr = new int[10];
        
        for(String s : X.split("")) arrX[Integer.parseInt(s)]++;
        for(String s : Y.split("")) arrY[Integer.parseInt(s)]++;
        for(int i = 0 ; i < 10 ; i++) arr[i] = Math.min(arrX[i], arrY[i]);
        
        for(int i = 9 ; i >= 0 ; i--)  answer += String.valueOf(i).repeat(arr[i]);
       
        if(answer.equals("")) return "-1";
        if(answer.startsWith("0")) return "0";
        
        return answer;
    }
}