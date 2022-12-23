class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        char[] arr = s.toCharArray();
        for(int i = 0 ; i < arr.length ; i++) {
            if(i == 0) {
                answer[i] = -1; continue;
            }
            int cnt = 1; int idx = i - 1;
            while(idx > -1) {
                if(arr[idx] == arr[i]) break;
                cnt++; idx--;
            }
            if(idx == -1) answer[i] = idx;
            else answer[i] = cnt;
        }
        return answer;
    }
}