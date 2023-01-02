class Solution {
    public int solution(int[] array) {
        int answer = 0;
        for(int i : array) {
            for(String s : String.valueOf(i).split("")) {
                if(s.equals("7")) answer++;
            }
        }
        return answer;
    }
}