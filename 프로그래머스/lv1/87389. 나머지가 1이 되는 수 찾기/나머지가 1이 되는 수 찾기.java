import java.util.stream.*;

class Solution {
    public int solution(int n) {
        return IntStream.range(1, n).filter(i -> n % i == 1).min().getAsInt();
    }
}