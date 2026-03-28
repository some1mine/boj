import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        HashMap<String, Person> map = new HashMap<>(); map.put("-", new Person("-"));
        for(String s : enroll) map.put(s, new Person(s));
        for(int i = 0 ; i < enroll.length ; i++) map.get(enroll[i]).parent = map.get(referral[i]);
        for(int i = 0 ; i < seller.length ; i++) map.get(seller[i]).increase(amount[i] * 100);
        for(int i = 0 ; i < enroll.length ; i++) answer[i] = map.get(enroll[i]).money;
        return answer;
    }
}

class Person {
    String name; int money; Person parent;
    public Person(String name) {
        this.name = name; this.money = 0; this.parent = null;
    }
    void increase(int income) {
        this.money += income - income / 10;
        if(this.parent != null) this.parent.increase(income / 10);
    }
}