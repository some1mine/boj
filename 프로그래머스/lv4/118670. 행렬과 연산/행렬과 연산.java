import java.util.*;

class Solution {
    public int[][] solution(int[][] rc, String[] operations) {
        Deque<Integer> left = new LinkedList<>(), right = new LinkedList<>(), tmp = new LinkedList<>();
        Deque<Deque<Integer>> mid = new LinkedList<>();
        for(int[] r : rc) {
            left.add(r[0]); right.add(r[r.length - 1]); Deque<Integer> add = new LinkedList<>();
            for(int i = 1 ; i < r.length - 1 ; i++) add.add(r[i]);
            mid.add(add);
        }
        for(String s : operations) {
            if(s.charAt(0) == 'S') {
                left.addFirst(left.pollLast()); mid.addFirst(mid.pollLast()); 
                right.addFirst(right.pollLast()); continue;
            }
            mid.getFirst().addFirst(left.pollFirst());
            right.addFirst(mid.getFirst().pollLast());
            mid.getLast().addLast(right.pollLast());
            left.addLast(mid.getLast().pollFirst());
        }
        for(int i = 0 ; i < rc.length ; i++) {
            rc[i][0] = left.pollFirst(); tmp = mid.pollFirst();
            for(int j = 1 ; j < rc[i].length - 1 ; j++) rc[i][j] = tmp.pollFirst();
            rc[i][rc[i].length - 1] = right.pollFirst();
        }
        return rc;
    }
}