import java.util.*;
import java.util.stream.*;

class Solution {
    public String[] solution(String[] orders, int[] course) {
        List<Set<String>> orderList = Arrays.stream(orders).map(String::chars)
            .map(charStream -> charStream.mapToObj(menu -> String.valueOf((char) menu))
                .collect(Collectors.toSet())).collect(Collectors.toList());
        Map<Integer, List<Course>> courses = new HashMap<>();
        for(int len : course) {
            List<Course> list = new ArrayList<>();
            list.add(new Course("", 0));
            courses.put(len, list);
        }
        getCourses('A', new HashSet<>(), orderList, courses);
        
        return courses.values().stream().filter(list -> list.get(0).occurence >= 2).flatMap(List::stream)
            .map(c -> c.course).sorted().toArray(String[]::new);
    }
    public void getCourses(char nextMenu, Set<String> selectedMenus, List<Set<String>> orderList,
                          Map<Integer, List<Course>> courses) {
        int occurences = (int) orderList.stream().filter(order -> order.containsAll(selectedMenus)).count();
        if(occurences < 2) return;
        
        int size = selectedMenus.size();
        if(courses.containsKey(size)) {
            List<Course> courseList = courses.get(size);
            Course course = new Course(selectedMenus.stream().sorted().collect(Collectors.joining(""))
                                      , occurences);
            Course original = courseList.get(0);
            if(original.occurence < occurences) {
                courseList.clear();
                courseList.add(course);
            } else if(original.occurence == occurences) {
                courseList.add(course);
            }
        }
        if(size >= 10) return;
        for(char menuC = nextMenu ; menuC <= 'Z' ; menuC++) {
            String menu = String.valueOf(menuC);
            selectedMenus.add(menu);
            getCourses((char) (menuC + 1), selectedMenus, orderList, courses);
            selectedMenus.remove(menu);
        }
    }
}

class Course {
    String course;
    int occurence;
    
    public Course(String course, int occurence) {
        this.course = course;
        this.occurence = occurence;
    }
}