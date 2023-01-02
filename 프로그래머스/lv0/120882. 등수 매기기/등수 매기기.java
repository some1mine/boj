class Solution {
    public int[] solution(int[][] score) {
        int[] answer = new int[score.length];
        int[] tmp = new int[score.length];
        for(int i = 0 ; i < score.length ; i++) tmp[i] = score[i][0] + score[i][1];
        for(int i = 0 ; i < score.length ; i++) {
            int rank = 1;
            for(int j : tmp) {
                if(j > tmp[i]) rank++;
            }
            answer[i] = rank;
        }
        return answer;
    }
}