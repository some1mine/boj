class Solution {
    public int solution(int[][] dots) {
        int answer = 0, row = 0, col = 0;
        for(int i = 0 ; i < dots.length - 1 ; i++) {
            if(dots[i][0] != dots[i + 1][0]) row = Math.abs(dots[i][0] - dots[i + 1][0]);
            if(dots[i][1] != dots[i + 1][1]) col = Math.abs(dots[i][1] - dots[i + 1][1]);
        }
        answer = row * col;
        return answer;
    }
}