import java.util.*;

class Solution {
    public int[] rates = {10, 20, 30, 40};
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];
        combination(0, users, emoticons, answer, new ArrayList<>());
        return answer;
    }
    public void combination(int start, int[][] users, int[] emoticons, int[] answer, List<Emoticon> list) {
        if(list.size() == emoticons.length) {
            calculate(users, answer, list);
            return;
        }
        for(int r : rates) {
            for(int i = start ; i < emoticons.length ; i++) {
                Emoticon cur = new Emoticon(r, emoticons[i], i);
                if(!list.contains(cur)) list.add(cur);
                combination(start + 1, users, emoticons, answer, list);
                list.remove(cur);
            }
        }
    }
    public void calculate(int[][] users, int[] answer, List<Emoticon> list) {
        int count = 0; int amount = 0;
        for(int[] user : users) {
            int sum = (int) list.stream().filter(e -> e.rate >= user[0]).mapToDouble(e -> (100 - e.rate) * e.cost * 1.0 / 100).sum();
            if(sum >= user[1]) {
                count++; continue;
            }
            amount += sum;
        }
        if(count > answer[0] || (count == answer[0] && amount > answer[1])) {
            answer[0] = count; answer[1] = amount;
        }
    }
}

class Emoticon {
    public int rate, cost, idx;
    public Emoticon(int rate, int cost, int idx) {
        this.rate = rate; this.cost = cost; this.idx = idx;
    }
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Emoticon == false) return false;
        Emoticon o = (Emoticon) obj;
        return this.idx == o.idx && this.cost == o.cost;
    }
    @Override
    public String toString() {
        return this.rate + " " + this.cost + " " + this.idx;
    }
}