class Solution {
    public int solution(int[] common) {
        int answer = 0;
        if(isEmdck(common[0], common[1], common[2])) {
            answer = common[common.length-1] + findRhdck(common[0], common[1]); 
        } else {
            answer = common[common.length-1] * findRhdql(common[0], common[1]); 
        }
        return answer;
    }

    public boolean isEmdck(int n1, int n2, int n3) { //등차수열 판별
        return (n1 + n3 == 2 * n2);
    }

    public int findRhdck(int n1, int n2) { //공차 구하기
        return n2 - n1;
    }

    public int findRhdql(int n1, int n2) { // 공비 구하기
        return n2 / n1;
    }
}