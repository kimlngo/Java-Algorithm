package review;

import java.util.Objects;
import java.util.PriorityQueue;
import java.util.UUID;

public class PriorityQueueExample {
    public static void main(String[] args) {
        PriorityQueue<Ticket> pQ = new PriorityQueue<>(Ticket::compareTo);

        pQ.add(new Ticket(UUID.randomUUID(), "P5", "p5 ticket"));
        pQ.add(new Ticket(UUID.randomUUID(), "P4", "p4 ticket"));
        pQ.add(new Ticket(UUID.randomUUID(), "P0", "p0 ticket #1"));
        pQ.add(new Ticket(UUID.randomUUID(), "P2", "p2 ticket"));
        pQ.add(new Ticket(UUID.randomUUID(), "P1", "p1 ticket"));
        pQ.add(new Ticket(UUID.randomUUID(), "P3", "p3 ticket"));
        pQ.add(new Ticket(UUID.randomUUID(), "P0", "p0 ticket #2"));

        while (!pQ.isEmpty()) {
            System.out.println(pQ.poll());
        }
    }

}

class Ticket implements Comparable<Ticket> {
    private UUID ticketId;
    private String priority; //P0 - P1 ... - P5
    private final int priorityInt;
    private String description;

    //... other details

    public Ticket(UUID ticketId, String priority, String description) {
        this.ticketId = ticketId;
        this.priority = priority;
        this.priorityInt = this.priority.charAt(1) - '0';
        this.description = description;
    }

    public UUID getTicketId() {
        return ticketId;
    }

    public void setTicketId(UUID ticketId) {
        this.ticketId = ticketId;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return Objects.equals(ticketId, ticket.ticketId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(ticketId);
    }

    @Override
    public int compareTo(Ticket o) {
        return Integer.compare(this.priorityInt, o.priorityInt); //P0 means highest priority, P5 is lowest priority
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketId=" + ticketId +
                ", priority='" + priority + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
