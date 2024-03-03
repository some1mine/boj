import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        Set<Integer> divA = getDiv(arrayA, arrayB), divB = getDiv(arrayB, arrayA);
        return Math.max(divA.stream().mapToInt(i -> i).max().orElse(0), 
                        divB.stream().mapToInt(i -> i).max().orElse(0));
    }
    public Set<Integer> getDiv(int[] arr1, int[] arr2) {
        Set<Integer> dividors = getDiv(Arrays.stream(arr1).min().getAsInt()); // 가장 작은 수의 모든 약수 구하기
        return dividors.stream().filter(d -> 
            Arrays.stream(arr1).noneMatch(a -> a % d > 0) // arr1에서 나누어 떨어지지 않는 수 filter
            && Arrays.stream(arr2).noneMatch(a -> a % d == 0) // arr2에서 나누어 떨어지는 수 filter
        ).collect(Collectors.toSet());
    }
    public Set<Integer> getDiv(int n) {
        return IntStream.rangeClosed(1, n).filter(i -> n % i == 0).boxed().collect(Collectors.toSet());
    }
}