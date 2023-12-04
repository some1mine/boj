class Solution {
    public String solution(String p) {
        return get(p, 0);
    }
    public String get(String p, int flag) {
        for(int i = 0 ; i < p.length() ; i++) {
            flag = p.charAt(i) == '(' ? flag + 1 : flag - 1;
            if(flag == 0) {
                p = recursion(p, i + 1); break;
            }
        }
        return p;
    }
    public String recursion(String s, int idx) {
        String u = s.substring(0, idx), v = s.substring(idx);
        if(!isProper(u, 0)) return "(" + get(v, 0) + ")" + reverse(u.substring(1, u.length() - 1));
        return u + get(v, 0);
    }
    public boolean isProper(String s, int flag) {
        for(int i = 0 ; i < s.length() ; i++) {
            flag = s.charAt(i) == '(' ? flag + 1 : flag - 1;
            if(flag < 0) return false;
        }
        return true;
    }
    public String reverse(String s) {
        char[] arr = s.toCharArray();
        for(int i = 0 ; i < arr.length ; i++) {
            arr[i] = arr[i] == ')' ? '(' : ')';
        }
        return new String(arr);
    }
}