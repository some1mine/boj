class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        for(int[] ar : queries) {
            int tmp = arr[ar[0]]; arr[ar[0]] = arr[ar[1]]; arr[ar[1]] = tmp;
        }
        return arr;
    }
}