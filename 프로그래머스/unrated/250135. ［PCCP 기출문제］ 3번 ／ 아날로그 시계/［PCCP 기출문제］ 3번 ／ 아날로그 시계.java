class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int answer = 0;
        double hour1 = (double) h1, hour2 = (double) h2, 
               minute1 = (double) m1, minute2 = (double) m2, 
               second1 = (double) s1, second2 = (double) s2;
        answer = (int) (calc(hour2, minute2, second2) - calc(hour1, minute1, second1));
        if (5 * (hour2 % 12 + minute2 / 60 + second2 / 3600) == second2 || minute2 + second2 / 60 == second2) answer++;
    
        return answer;
    }
    public double calc(double h, double m, double s) {
        if(h >= 12) return calc2(11, 59, 59) + calc2(h - 12, m, s);
        else return calc2(h, m, s);
    }
    public double calc2(double h, double m, double s) {
        if (h == m && m == s && s == 0) return 0;
        double answer = h * 59 + h * 60 + m * 2 - 1;
        if(5 * (h + m / 60 + s / 3600) < s) answer++;
        if(m + s / 60 < s) answer++; 
        return answer;
    }
}