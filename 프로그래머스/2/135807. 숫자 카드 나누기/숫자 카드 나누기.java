import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        List<Integer> divA = getDiv(arrayA, arrayB), divB = getDiv(arrayB, arrayA);
        return Math.max(divA.stream().filter(a -> !divB.contains(a)).mapToInt(i -> i).max().orElse(0),
            divB.stream().filter(b -> !divA.contains(b)).mapToInt(i -> i).max().orElse(0));
    }
    public List<Integer> getDiv(int[] arr1, int[] arr2) {
        List<Integer> dividors = getDiv(Arrays.stream(arr1).min().getAsInt());
        return dividors.stream().filter(d -> 
            Arrays.stream(arr1).noneMatch(a -> a % d > 0) && Arrays.stream(arr2).noneMatch(a -> a % d == 0)
        ).collect(Collectors.toList());
    }
    public List<Integer> getDiv(int n) {
        return IntStream.rangeClosed(1, n).filter(i -> n % i == 0).boxed().collect(Collectors.toList());
    }
}