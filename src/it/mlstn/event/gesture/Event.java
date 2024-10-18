package it.mlstn.event.gesture;

import java.time.LocalDate;
import java.util.Scanner;

public class Event {

    private String title;

    private LocalDate date;

    private int totalSeat;

    private int reservedSeat = 0;

    public Event(String title, LocalDate date, int totalSeat) throws Exception {

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

    public void setDate(LocalDate date) throws Exception {
        if (date.isAfter(LocalDate.now())) {
            this.date = date;
        } else {
            throw new Exception("La data inserita è già passata");
        }
    }

    public LocalDate getDate() {
        return date;
    }

    private void setTotalSeat(int totalSeat) throws Exception {
        if (totalSeat > 0) {
            this.totalSeat = totalSeat;
        } else {
            throw new Exception("Numero di posti inseriti non valido");
        }
    }

    public int getTotalSeat() {
        return totalSeat;
    }

    public int getReservedSeat() {
        return this.reservedSeat;
    }

    public void reserve() {
        System.out.println("Sono disponibili " + (getTotalSeat() - getReservedSeat()) + " posti");
        Scanner scan = new Scanner(System.in);
        System.out.println("Inserisci il numero di posti che vuoi prenotare");
        int n = scan.nextInt();
        int i = 0;

        if (checkDate()) {

            for (i = 0; i < n; i++) {

                if (totalSeat > reservedSeat) {
                    reservedSeat++;
                } else {
                    System.out.println("Non ci sono più posti disponibili");
                    break;
                }
            }

        }

        System.out.println("Hai prenotato correttamente " + i + " posti");

    }

    public void disdict() {

        if (checkDate()) {

            if (reservedSeat != 0) {
                reservedSeat--;
            } else {
                System.out.println("Non hai nessun posto prenotato");
            }

        }

    }

    public void printSeatInformations() {
        System.out.println("\nI posti che hai prenotato per l'evento " + title + " sono " + getReservedSeat()
                + " ne rimangono disponibili " + (getTotalSeat() - getReservedSeat()) + "\n");
    }

    private boolean checkDate() {
        if (date.isAfter(LocalDate.now())) {
            return true;
        } else {
            System.out.println("L'evento " + title + " è già passato");
            return false;
        }
    }

    @Override
    public String toString() {
        return "L'evento " + title + "sarà il " + date.toString();
    }
}
