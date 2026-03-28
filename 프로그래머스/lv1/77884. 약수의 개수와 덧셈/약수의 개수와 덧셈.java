import java.util.stream.*;

class Solution {
    public int solution(int left, int right) {
        return (int) IntStream.rangeClosed(left, right).map(i -> Math.sqrt(i) % 1 == 0 ? -i : i).sum();
    }
}