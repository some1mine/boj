class Solution {
    public int solution(int n) {
        int answer = 0;
        String str = Integer.toString(n, 3);
        String reversed = new StringBuilder(str).reverse().toString();
        answer = Integer.parseInt(reversed, 3);
        return answer;
    }
}