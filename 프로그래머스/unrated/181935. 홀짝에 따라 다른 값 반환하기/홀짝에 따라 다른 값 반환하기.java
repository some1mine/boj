import java.util.stream.*;

class Solution {
    public int solution(int n) {
        int answer = n % 2 == 0 ? IntStream.rangeClosed(1, n).filter(x -> x % 2 == 0).map(x -> x * x).sum()
            : IntStream.rangeClosed(1, n).filter(x -> x % 2 == 1).sum();
        return answer;
    }
}