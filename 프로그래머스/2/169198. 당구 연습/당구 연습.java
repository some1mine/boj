class Solution {
    public int[] solution(int m, int n, int x, int y, int[][] balls) {
        int[] result = new int[balls.length];
        for(int i = 0 ; i < balls.length ; i++) result[i] = getDistance(m, n, x, y, balls[i]);
        return result;
    }
    public int getDistance(int m, int n, int x, int y, int[] ball) {    /* 막혀서 못가는 경우 큰 값으로 거름 */
        int d1 = (x - ball[0]) * (x - ball[0]),                         // 공 사이의 x거리 제곱
            d2 = (y - ball[1]) * (y - ball[1]),                         // 공 사이의 y거리 제곱
            d3 = (2 * n - y - ball[1]) * (2 * n - y - ball[1]),         // 벽과 공과의 y거리 합 제곱
            d4 = (2 * m - x - ball[0]) * (2 * m - x - ball[0]),         // 벽과 공과의 x거리 합 제곱
            d5 = (y + ball[1]) * (y + ball[1]),                         // 공 사이의 y 거리 합 제곱
            d6 = (x + ball[0]) * (x + ball[0]);                         // 공 사이의 x 거리 합 제곱
                
        return  Math.min(ball[1] > y && x == ball[0] ? Integer.MAX_VALUE : d1 + d3,
                Math.min(ball[0] > x && y == ball[1] ? Integer.MAX_VALUE : d2 + d4,
                Math.min(ball[1] < y && x == ball[0] ? Integer.MAX_VALUE : d1 + d5,
                         ball[0] < x && y == ball[1] ? Integer.MAX_VALUE : d2 + d6)));
    }
}