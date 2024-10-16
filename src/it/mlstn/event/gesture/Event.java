package it.mlstn.event.gesture;

import java.time.LocalDate;

public class Event {

    private String title;

    private LocalDate date;

    private int totalSeat;

    private int reservedSeat = 0;

    public Event(String title, LocalDate date, int totalSeat) {

        setTitle(title);
        setDate(date);
        setTotalSeat(totalSeat);

    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDate getDate() {
        return date;
    }

    private void setTotalSeat(int totalSeat) {
        this.totalSeat = totalSeat;
    }

    public int getTotalSeat() {
        return totalSeat;
    }

    private void setReservedSeat(int reservedSeat) {
        this.reservedSeat = reservedSeat;
    }

    public int getReservedSeat() {
        return reservedSeat;
    }

    public void reserve() {
        if (totalSeat > reservedSeat) {
            reservedSeat++;
        } else {
            System.out.println("Non ci sono più posti disponibili");
        }
    }

    public void disdict() {
        if (reservedSeat != 0) {
            reservedSeat--;
        } else {
            System.out.println("Non hai nessun posto prenotato");
        }
    }

    @Override
    public String toString() {
        return "L'evento " + title + "sarà il " + date.getDayOfMonth() + " " + date.getMonth() + " " + date.getYear();
    }
}
