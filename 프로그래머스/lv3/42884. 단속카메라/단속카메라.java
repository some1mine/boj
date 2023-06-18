import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes, (x, y) -> {
            return x[1] - y[1];
        });
        int endPoint = -30001;
        for(int[] car : routes) {
            if(car[0] > endPoint) {
                answer++; endPoint = car[1];
            }
        }
        return answer;
    }
}