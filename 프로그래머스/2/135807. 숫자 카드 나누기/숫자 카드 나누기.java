import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        List<Integer> gcdA = getGcd(arrayA, arrayB), gcdB = getGcd(arrayB, arrayA);
        return Math.max(gcdA.stream().filter(a -> !gcdB.contains(a)).mapToInt(i -> i).max().orElse(0),
            gcdB.stream().filter(b -> !gcdA.contains(b)).mapToInt(i -> i).max().orElse(0));
    }
    public List<Integer> getGcd(int[] arr1, int[] arr2) {
        int min = Arrays.stream(arr1).min().getAsInt();
        List<Integer> dividors = get(min);
        return dividors.stream().filter(d -> 
            Arrays.stream(arr1).noneMatch(a -> a % d > 0) && Arrays.stream(arr2).noneMatch(a -> a % d == 0)
        ).collect(Collectors.toList());
    }
    public List<Integer> get(int n) {
        return IntStream.rangeClosed(1, n).filter(i -> n % i == 0).boxed().collect(Collectors.toList());
    }
}