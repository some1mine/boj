import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        return Math.max(getMaxDiv(arrayA, arrayB), getMaxDiv(arrayB, arrayA));
    }
    public int getMaxDiv(int[] arr1, int[] arr2) {
        int min = Arrays.stream(arr1).min().getAsInt();
        return IntStream.rangeClosed(1, min).filter(i
                    -> min % i == 0
                    && Arrays.stream(arr1).noneMatch(n -> n % i > 0)   // arr1에서 나누어 떨어지지 않는 수 filter
                    && Arrays.stream(arr2).noneMatch(n -> n % i == 0)) // arr2에서 나누어 떨어지는 수 filter
            .max().orElse(0);
    }
}