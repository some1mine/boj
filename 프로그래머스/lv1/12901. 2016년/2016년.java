class Solution {
    public String solution(int a, int b) {
        String answer = "";
        String[] ant = new String[]{"FRI","SAT","SUN","MON","TUE","WED","THU"};
        switch(a){
            case 1:
                answer = ant[b%7-1<0 ? b%7+6 : b%7-1];
                break;
            case 2:
                answer = ant[b%7-5<0 ? b%7+2 : b%7-5];
                break;
            case 3:
                answer = ant[b%7-4<0 ? b%7+3 : b%7-4];
                break;
            case 4:
                answer = ant[b%7-1<0 ? b%7+6 : b%7-1];
                break;
            case 5:
                answer = ant[b%7-6<0 ? b%7+1 : b%7-6];
                break;
            case 6:
                answer = ant[b%7-3<0 ? b%7+4 : b%7-3];
                break;
            case 7:
                answer = ant[b%7-1<0 ? b%7+6 : b%7-1];
                break;
            case 8:
                answer = ant[b%7-5<0 ? b%7+2 : b%7-5];
                break;
            case 9:
                answer = ant[b%7-2<0 ? b%7+5 : b%7-2];
                break;
            case 10:
                answer = ant[b%7];
                break;
            case 11:
                answer = ant[b%7-4<0 ? b%7+3 : b%7-4];
                break;
            case 12:
                answer = ant[b%7-2<0 ? b%7+5 : b%7-2];
                break;
            
        }
        return answer;
    }
}