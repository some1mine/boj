class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];
        for(int i = 0 ; i < answer.length ; i++) {
            int num = Integer.MAX_VALUE;
            for(int j = queries[i][0] ; j <= queries[i][1] ; j++) {
                if(arr[j] > queries[i][2] && arr[j] <= num) num = arr[j];
            }
            if(num != Integer.MAX_VALUE) answer[i] = num;
            else answer[i] = -1;
        }
        return answer;
    }
}