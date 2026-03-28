import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A); Arrays.sort(B);
        int answer = 0, idxA = 0, idxB = 0;
        // System.out.println(Arrays.toString(A)); System.out.println(Arrays.toString(B));
        while(idxB < B.length && A[idxA] > B[idxB]) idxB++;
        while(idxA < A.length && idxB < B.length) {
            if(A[idxA] < B[idxB]) {
                answer++; idxA++; idxB++;
            } else idxB++;
        }
        return answer;
    }
}