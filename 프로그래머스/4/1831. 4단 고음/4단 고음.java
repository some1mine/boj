class Solution {
    public int solution(int n) {
        int s = (int) (Math.log(n) / Math.log(3));
        return run(n - 2, s, s * 2 - 2, 0, 2);
    }
    int run(int n, int s, int p, int cut_s, int cut_p){
        int a = 0, b = 0;
        if(cut_s * 2 > cut_p) return 0;
        if(n < 3) return 0;
        else if(n == 3 && s == 1 && p == 0) return 1;
        if(p > 0) a = run(n - 1, s, p - 1, cut_s, cut_p + 1);
        if(n % 3 == 0 && s > 0) b = run(n / 3, s - 1, p, cut_s + 1, cut_p);
        return a + b;
    }
}