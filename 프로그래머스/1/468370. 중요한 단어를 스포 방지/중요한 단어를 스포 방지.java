import java.util.*;

class Solution {
    public int solution(String message, int[][] spoiler_ranges) {
        int n = message.length();
        boolean[] isSpoiler = new boolean[n];

        // 1. 스포 구간 표시
        for (int[] r : spoiler_ranges) {
            for (int i = r[0]; i <= r[1]; i++) {
                isSpoiler[i] = true;
            }
        }

        // 2. 전체 단어의 시작/끝 인덱스 구하기
        List<int[]> words = new ArrayList<>();
        int i = 0;
        while (i < n) {
            if (message.charAt(i) == ' ') {
                i++;
                continue;
            }
            int start = i;
            while (i < n && message.charAt(i) != ' ') i++;
            int end = i - 1;
            words.add(new int[]{start, end});
        }

        // 3. 스포 바깥에서 등장한 단어 수집
        Set<String> nonSpoilerWords = new HashSet<>();
        for (int[] w : words) {
            boolean hasSpoiler = false;
            for (int j = w[0]; j <= w[1]; j++) {
                if (isSpoiler[j]) {
                    hasSpoiler = true;
                    break;
                }
            }
            if (!hasSpoiler) {
                String word = message.substring(w[0], w[1] + 1);
                nonSpoilerWords.add(word);
            }
        }

        // 4. 스포 구간 순서대로 처리
        int answer = 0;
        Set<String> seen = new HashSet<>();

        for (int[] r : spoiler_ranges) {
            int idx = r[0];

            while (idx <= r[1]) {
                if (message.charAt(idx) == ' ') {
                    idx++;
                    continue;
                }

                // 단어 찾기
                int start = idx;
                while (start > 0 && message.charAt(start - 1) != ' ') start--;
                int end = idx;
                while (end < n - 1 && message.charAt(end + 1) != ' ') end++;

                String word = message.substring(start, end + 1);

                // 조건 검사
                if (!nonSpoilerWords.contains(word) && !seen.contains(word)) {
                    answer++;
                    seen.add(word);
                }

                idx = end + 1;
            }
        }

        return answer;
    }
}