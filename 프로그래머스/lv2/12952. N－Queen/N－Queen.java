class Solution {
    int answer = 0; int[] arr;
    public int solution(int n) {
        arr = new int[n];
        search(0, n);
        return answer;
    }
    public void search(int depth, int n) {
        if(depth == n) {
            answer++; return;
        }
        for(int i = 0 ; i < n ; i++) {
            arr[depth] = i;
            if(possible(depth)) search(depth + 1, n);
        }
    }
    public boolean possible(int n) {
        for(int i = 0 ; i < n ; i++) {
            if(arr[i] == arr[n] || Math.abs(arr[i] - arr[n]) == Math.abs(i - n)) return false;
        }
        return true;
    }
}