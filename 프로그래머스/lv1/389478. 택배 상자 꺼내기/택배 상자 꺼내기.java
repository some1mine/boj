import java.util.*;

class Solution {
    public int solution(int n, int w, int num) {
        boolean isRight = false;
        int[][] arr = new int[n / w + 1][w];
        for(int i = 0 ; i < n ; i++) { // 택배 상자의 번호들을 채운다
            if(i % w == 0) isRight = !isRight;
            arr[i / w][isRight ? i % w : (w - 1) - (i % w)] = i + 1;
        }
        int ord = -1, answer = 0;
        for(int i = 0 ; i < w ; i++) { // 꺼낼 택배 상자의 상대적 위치를 구한다
            if(arr[(num - 1) / w][i] == num) {
                ord = i; break;
            }
        }
        for(int i = n / w ; i >= (num - 1) / w ; i--) { // 위에 있는 택배 상자의 수를 더한다.
            if(arr[i][ord] != 0) answer++;
        }
        return answer;
    }
}