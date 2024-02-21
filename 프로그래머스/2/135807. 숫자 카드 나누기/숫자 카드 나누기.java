import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0; List<Integer> gcdA = getGcd(arrayA, arrayB), gcdB = getGcd(arrayB, arrayA);
        return Math.max(gcdA.stream().filter(a -> !gcdB.contains(a)).mapToInt(i -> i).max().orElse(0),
            gcdB.stream().filter(b -> !gcdA.contains(b)).mapToInt(i -> i).max().orElse(0));
    }
    public List<Integer> getGcd(int[] arr1, int[] arr2) {
        List<Integer> list = new ArrayList<>();
        int min = Arrays.stream(arr1).min().getAsInt();
        List<Integer> dividors = get(min);
        out: for(int d : dividors) {
            for(int a : arr1) {
                if(a % d != 0) continue out;
            }
            for(int a : arr2) {
                if(a % d == 0) continue out;
            }
            list.add(d);
        }
        return list;
    }
    public List<Integer> get(int n) {
        List<Integer> list = new ArrayList<>();
        for(int i = 1 ; i <= n ; i++) {
            if(n % i == 0) list.add(i);
        }
        return list;
    }
}