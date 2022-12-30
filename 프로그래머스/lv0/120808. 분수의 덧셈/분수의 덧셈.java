class Solution {
    public int[] solution(int denum1, int num1, int denum2, int num2) {
        int[] answer = new int[2];
        answer[0] = denum1 * num2 + denum2 * num1;
        answer[1] = num1 * num2;
        int gcd = getGCD(answer[0], answer[1]);
        answer[0] /= gcd;
        answer[1] /= gcd;
        return answer;
    }
    public int getGCD(int a, int b) {
        int gcd = 1;
        for(int i = 1 ; i <= a ; i++) {
            if(a % i == 0 && b % i == 0) gcd = i;
        }
        return gcd;
    }
}