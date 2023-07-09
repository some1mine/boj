import java.util.*;

class Solution {
    public List<String> list = new ArrayList<>();
    public List<Ticket> ticketList = new ArrayList<>();
    public String[] solution(String[][] tickets) {
        setSolution(tickets);
        return list.stream().toArray(String[]::new);
    } 
    public void setSolution(String[][] tickets) {
        for(String[] ticket : tickets) ticketList.add(new Ticket(ticket[0], ticket[1]));
        List<Ticket> taken = new ArrayList<>();
        
        Queue<String> queue = new LinkedList<>();
        queue.offer("ICN");
        while(!queue.isEmpty()) {
            String cur = queue.poll();
            list.add(cur);
            List<Ticket> candidate = new ArrayList<>();
            for(Ticket t : ticketList) {
                if(t.from.equals(cur) 
                   && taken.stream().filter(ticket -> ticket.equals(t)).count() 
                   < ticketList.stream().filter(ticket -> ticket.equals(t)).count()
                  && possible(t, new ArrayList(taken))) candidate.add(t);
            }
            if(candidate.size() == 0) break;
            Collections.sort(candidate);
            queue.offer(candidate.get(0).to);
            taken.add(candidate.get(0));
        }
    }
    public boolean possible(Ticket point, List<Ticket> took) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(point.to);
        took.add(point);
        while(!queue.isEmpty()) {
            String cur = queue.poll();
            for(Ticket t : ticketList) {
                if(t.from.equals(cur) 
                   && took.stream().filter(ticket -> ticket.equals(t)).count() 
                   < ticketList.stream().filter(ticket -> ticket.equals(t)).count()) {
                    queue.offer(t.to); took.add(t);
                }
            }
        }
        return took.size() == ticketList.size();
    }
}

class Ticket implements Comparable<Ticket> {
    String from, to;
    public Ticket(String from, String to) {
        this.from = from;
        this.to = to;
    }
    @Override
    public boolean equals(Object obj) {
        Ticket o = (Ticket) obj;
        return (this.from.equals(o.from)) && (this.to.equals(o.to));
    }
    @Override
    public int compareTo(Ticket obj) {
        return this.to.compareTo(obj.to);
    }
    @Override
    public String toString() {
        return this.from + " " + this.to;
    }
}