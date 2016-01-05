package javase07.t01;

import java.time.LocalDateTime;

public class Bill {
    private String sender;
    private String recipient;
    private int sum;
    private LocalDateTime date;

    public Bill(String sender, String recipient, int sum, LocalDateTime date) {
        this.sender = sender;
        this.recipient = recipient;
        this.sum = sum;
        this.date = date;
    }

    public String getSender() {
        return sender;
    }

    public String getRecipient() {
        return recipient;
    }

    public int getSum() {
        return sum;
    }

    public LocalDateTime getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "sender='" + sender + '\'' +
                ", recipient='" + recipient + '\'' +
                ", sum=" + sum +
                ", date=" + date +
                "}\n" ;
    }
}

