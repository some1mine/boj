import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] numbers) {
        return (int) IntStream.range(1, 10).filter(i -> !Arrays.stream(numbers).boxed().collect(Collectors.toList()).contains(i)).sum();
    }
}