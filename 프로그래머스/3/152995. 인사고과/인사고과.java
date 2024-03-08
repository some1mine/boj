class Solution {
    public int solution(int[][] scores) {
        int answer = 1;
        for(int i = 1 ; i < scores.length ; i++) {
            if(checkUpper(scores, i) && possible(scores, scores[i])) answer++;
            if(!possible(scores, i)) return -1;
        }
        return answer;
    }
    public boolean possible(int[][] scores, int[] arr) {
        for(int[] score : scores) {
            if(score[0] > arr[0] && score[1] > arr[1]) return false;
        }
        return true;
    }
    public boolean possible(int[][] scores, int idx) {
        return !(scores[idx][0] > scores[0][0] && scores[idx][1] > scores[0][1]);
    }
    public boolean checkUpper(int[][] scores, int idx) {
        return scores[idx][0] + scores[idx][1] > scores[0][0] + scores[0][1];
    }
}