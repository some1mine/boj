import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0 ; i < enroll.length ; i++) list.add(new ArrayList<>());
        for(int i = 0 ; i < referral.length ; i++) {
            if(referral[i].equals("-")) continue;
            list.get(i).add(findOrd(enroll, referral[i]));
        }
        for(int i = 0 ; i < seller.length ; i++) increase(answer, list, findOrd(enroll, seller[i]), amount[i] * 100);
        return answer;
    }
    public void increase(int[] answer, List<List<Integer>> list, int seller, int amount) {
        answer[seller] += amount - amount / 10; amount /= 10;
        Queue<Integer> queue = new LinkedList<>(); queue.offer(seller);
        while(amount > 0 && !queue.isEmpty()) {
            int cur = queue.poll();
            for(int i : list.get(cur)) {
                answer[i] += amount - amount / 10;
                queue.offer(i);
            }
            amount /= 10;
        }
    }
    public int findOrd(String[] enroll, String target) {
        for(int i = 0 ; i < enroll.length ; i++) if(enroll[i].equals(target)) return i;
        return -1;
    }
}