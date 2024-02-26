import java.util.*;

class Solution {
    public int solution(String[] board) {
        char[][] arr = Arrays.stream(board).map(s -> s.toCharArray()).toArray(char[][]::new);
        long cntY = Arrays.stream(board).map(b -> b.chars().filter(c -> c == 'O').count()).mapToLong(l -> l).sum(),
             cntX = Arrays.stream(board).map(b -> b.chars().filter(c -> c == 'X').count()).mapToLong(l -> l).sum(), 
             diff = cntY - cntX, lineX = 0, lineY = 0;
        if(diff < 0 || diff > 1) return 0;
        
        if(formate(arr[1][1], arr[0][0], arr[2][2]) || formate(arr[2][0], arr[0][2], arr[1][1])) {
            if(arr[1][1] == 'X') lineX++; if(arr[1][1] == 'O') lineY++;
        }
        
        for(int i = 0 ; i < 3 ; i++) {
            if(formate(arr[i][0], arr[i][1], arr[i][2])) {
                if(arr[i][0] == 'X') lineX++; if(arr[i][0] == 'O') lineY++;
            }
            if(formate(arr[0][i], arr[1][i], arr[2][i])) {
                if(arr[0][i] == 'X') lineX++; if(arr[0][i] == 'O') lineY++;
            }
        }
        if(lineX == lineY && lineY > 0) return 0;
        if(lineY > 0 && diff == 0) return 0;
        if(lineX > 0 && diff == 1) return 0;
        return 1;
    }
    public boolean formate(char a, char b, char c) {
        return a == b && b == c;
    }
}