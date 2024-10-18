package it.mlstn.event.gesture;

import java.time.LocalDate;
import java.util.Scanner;

public class TestEventMain {
    public static void main(String[] args) throws Exception {
        System.out.println(LocalDate.now());

        Scanner scan = new Scanner(System.in);

        System.out.println("Inserisci il titolo dell'evento");
        String title = scan.nextLine();

        System.out.println("Inserisci la data dell'evento:\n Inserisci l'anno");
        int year = scan.nextInt();
        System.out.println("Inserisci il mese");
        int month = scan.nextInt();
        System.out.println("Inserisci il giorno");
        int day = scan.nextInt();
        LocalDate date = LocalDate.of(year, month, day);

        System.out.println("Inserisci i posti totali disponibili dell'evento");
        int totalSeat = scan.nextInt();

        Event e1 = new Event(title, date, totalSeat);
        System.out.println(e1.toString());

        e1.reserve();
        e1.printSeatInformations();
        e1.reserve();
        e1.printSeatInformations();

    }

}
