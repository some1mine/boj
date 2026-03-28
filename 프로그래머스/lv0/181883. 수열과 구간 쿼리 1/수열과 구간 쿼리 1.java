class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        for(int[] ar : queries) {
            for(int i = ar[0] ; i <= ar[1] ; i++) arr[i]++;
        }
        return arr;
    }
}