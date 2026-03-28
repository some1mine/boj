class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n]; 
        int ord = 1, direction = 1, startX = 0, startY = 0, endX = n, endY = n;
        
        while(ord <= n * n) {
            switch(direction) {
                case 1:
                    for(int i = startX ; i < endX ; i++) answer[startY][i] = ord++;
                    startY++; direction++; break;
                case 2:
                    for(int i = startY ; i < endY ; i++) answer[i][endX - 1] = ord++;
                    endX--; direction++; break;
                case 3:
                    for(int i = endX - 1 ; i >= startX ; i--) answer[endY - 1][i] = ord++;
                    endY--; direction++; break;
                case 4:
                    for(int i = endY - 1 ; i >= startY ; i--) answer[i][startX] = ord++;
                    startX++; direction = 1; break;
            }
        }
        
        return answer;
    }
}