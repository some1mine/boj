class Solution {
    public int[] solution(int m, int n, int x, int y, int[][] balls) {
        int[] result = new int[balls.length];
        for(int i = 0 ; i < balls.length ; i++) result[i] = getDistance(m, n, x, y, balls[i]);
        return result;
    }
    public int getDistance(int m, int n, int x, int y, int[] ball) {
        int d1 = (x - ball[0]) * (x - ball[0]),
            d3 = (y - ball[1]) * (y - ball[1]),
            d2 = (2 * n - y - ball[1]) * (2 * n - y - ball[1]),
            d4 = (2 * m - x - ball[0]) * (2 * m - x - ball[0]),
            d5 = (y + ball[1]) * (y + ball[1]),
            d6 = (x + ball[0]) * (x + ball[0]);
                
        return  Math.min(ball[1] > y && x == ball[0] ? Integer.MAX_VALUE : d1 + d2,
                Math.min(ball[0] > x && y == ball[1] ? Integer.MAX_VALUE : d3 + d4,
                Math.min(ball[1] < y && x == ball[0] ? Integer.MAX_VALUE : d1 + d5,
                         ball[0] < x && y == ball[1] ? Integer.MAX_VALUE : d3 + d6)));
    }
}