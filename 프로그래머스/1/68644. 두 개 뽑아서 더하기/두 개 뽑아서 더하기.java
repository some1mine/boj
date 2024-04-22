import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] numbers) {
        return IntStream.range(0, numbers.length)
            .mapToObj(n1 -> 
                      IntStream.range(n1 + 1, numbers.length).map(n2 -> numbers[n1] + numbers[n2]).toArray())
            .flatMapToInt(Arrays::stream).sorted().boxed().distinct().mapToInt(i -> i).toArray();
    }
}