import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        Set<Integer> divA = getDivs(arrayA, arrayB), divB = getDivs(arrayB, arrayA);
        return Math.max(divA.stream().mapToInt(i -> i).max().orElse(0), divB.stream().mapToInt(i -> i).max().orElse(0));
    }
    public Set<Integer> getDivs(int[] arr1, int[] arr2) {
        Set<Integer> divs = getDivs(Arrays.stream(arr1).min().getAsInt());
        return divs.stream().filter(i -> Arrays.stream(arr1).noneMatch(n -> n % i > 0)
                                        && Arrays.stream(arr2).noneMatch(n -> n % i == 0))
            .collect(Collectors.toSet());
    }
    public Set<Integer> getDivs(int num) {
        return IntStream.rangeClosed(1, num).filter(i -> num % i == 0).boxed().collect(Collectors.toSet());
    }
}