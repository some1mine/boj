import java.util.*;

class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        int[] powers = new int[number];
        for(int i = 0 ; i < number ; i++) {
            powers[i] = getDivisor(i + 1);
            if(powers[i] > limit) powers[i] = power;
        }
        answer = Arrays.stream(powers).sum();
        return answer;
    }
    public int getDivisor(int n) {
        int answer = 0;
        for(int i = 1 ; i * i <= n ; i++) {
            if(i * i == n) answer++;
            else if(n % i == 0) answer += 2;
        }
        return answer;
    }
}