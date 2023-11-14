import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Date> aloha = new ArrayList<>();
        List<Date> applicants = new ArrayList<>();
        List<Date> passed = new ArrayList<>();
        for(int i = 0 ; i < 7 ; i++) {
            int[] arr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            aloha.add(new Date(arr[0], arr[1]));
        }
        
        int n = Integer.parseInt(scanner.nextLine());
        while(n-- > 0) {
            int[] arr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            applicants.add(new Date(arr[0], arr[1]));
        }
            
        Collections.sort(aloha); Collections.sort(applicants);
        for(Date applicant : applicants) {
            if(isPassed(aloha, applicant)) passed.add(applicant);
        }
        if(!passed.isEmpty()) {
        	for(Date pass : passed) System.out.println(pass.month + " " + pass.day);
        } else {
        	System.out.println("ALL FAILED");
        }
    }
    public static boolean isPassed(List<Date> aloha, Date applicant) {
        for(Date member : aloha) {
            if(getConstellation(member).equals(getConstellation(applicant))) return false;
        }
        return true;
    }
    public static String getConstellation(Date date) {
        if(date.month == 1 && date.day < 20) return "염소자리";
        else if(date.month == 1) return "물병자리";
        else if(date.month == 2 && date.day < 19) return "물병자리";
        else if(date.month == 2) return "물고기자리";
        else if(date.month == 3 && date.day < 21) return "물고기자리";
        else if(date.month == 3) return "양자리";
        else if(date.month == 4 && date.day < 20) return "양자리";
        else if(date.month == 4) return "황소자리";
        else if(date.month == 5 && date.day < 21) return "황소자리";
        else if(date.month == 5) return "쌍둥이자리";
        else if(date.month == 6 && date.day < 22) return "쌍둥이자리";
        else if(date.month == 6) return "게자리";
        else if(date.month == 7 && date.day < 23) return "게자리";
        else if(date.month == 7) return "사자자리";
        else if(date.month == 8 && date.day < 23) return "사자자리";
        else if(date.month == 8) return "처녀자리";
        else if(date.month == 9 && date.day < 23) return "처녀자리";
        else if(date.month == 9) return "천칭자리";
        else if(date.month == 10 && date.day < 23) return "천칭자리";
        else if(date.month == 10) return "전갈자리";
        else if(date.month == 11 && date.day < 23) return "전갈자리";
        else if(date.month == 11) return "사수자리";
        else if(date.month == 12 && date.day < 22) return "사수자리";
        return "염소자리";
    }
}

class Date implements Comparable<Date> {
    public int month, day;
    public Date(int month, int day) {
        this.month = month;
        this.day = day;
    }
    @Override
    public int compareTo(Date o) {
        if(this.month == o.month) return this.day - o.day;
        return this.month - o.month;
    }
}