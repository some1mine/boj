import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        return Math.max(getMaxDiv(arrayA, arrayB), getMaxDiv(arrayB, arrayA));
    }
    public int getMaxDiv(int[] arr1, int[] arr2) {
        Set<Integer> divs = getDivs(Arrays.stream(arr1).min().getAsInt()); // 가장 작은 수의 모든 약수 구하기
        return divs.stream().filter(i
                    -> Arrays.stream(arr1).noneMatch(n -> n % i > 0)   // arr1에서 나누어 떨어지지 않는 수 filter
                    && Arrays.stream(arr2).noneMatch(n -> n % i == 0)) // arr2에서 나누어 떨어지는 수 filter
            .mapToInt(i -> i).max().orElse(0);
    }
    public Set<Integer> getDivs(int num) {
        return IntStream.rangeClosed(1, num).filter(i -> num % i == 0).boxed().collect(Collectors.toSet());
    }
}