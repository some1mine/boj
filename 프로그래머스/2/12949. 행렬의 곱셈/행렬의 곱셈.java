import java.util.*;
import java.util.stream.*;

class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        final int[][] a1 = arr1, a2 = arr2;
        return IntStream.range(0, arr1.length)
            .mapToObj(n1 -> IntStream.range(0, arr2[0].length)
                     .map(n2 -> IntStream.range(0, arr2.length)
                               .map(n3 -> a1[n1][n3] * a2[n3][n2]).sum()).toArray())
            .toArray(int[][]::new);
    }
}