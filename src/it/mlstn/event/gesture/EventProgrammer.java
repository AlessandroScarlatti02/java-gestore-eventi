package it.mlstn.event.gesture;

import java.time.LocalDate;
import java.util.ArrayList;

public class EventProgrammer {

    private String title;

    private ArrayList<Event> eventList;

    public EventProgrammer(String title) {

        setTitle(title);

        this.eventList = new ArrayList<Event>();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {

        if (!title.isBlank() && title != null) {
            this.title = title;

        } else {

            System.out.println("Titolo non valido utilizza il metodo setTitle() per inserirne uno nuovo ");
        }

    }

    public ArrayList<Event> getEventList() {
        return eventList;
    }

    public void addEvent(Event event) {
        this.eventList.add(event);
    }

    public void printEventOnDate(LocalDate date) {
        Event event;
        boolean flag = false;
        System.out.println("Gli eventi che si terranno il " + date.toString() + " sono:");
        for (int i = 0; i < eventList.size(); i++) {
            event = eventList.get(i);
            if (event.getDate() == date) {
                event.toString();
                flag = true;
            }
        }
        if (!flag) {
            System.err.println("Non ci sono eventi presenti nella data indicata");
        }
    }

    public int numberOfEvents() {

        return eventList.size();

    }

    public void clearEventList() {
        eventList.clear();
        System.out.println("La lista eventi chiamata " + this.title + " è stata svuotata correttamente");
    }

    public void printAllEvents() {

        ArrayList<Event> orderedList = eventList;
        Event event;

        for (int i = 0; i < orderedList.size(); i++) {
            int p = 0;
            for (int i2 = p; i2 < orderedList.size(); i2++) {
                if (orderedList.get(p).getDate().isAfter(orderedList.get(i2).getDate())) {

                    event = orderedList.get(i2);
                    orderedList.add(i2, orderedList.get(p));
                    orderedList.add(p, event);

                }
            }
            p++;
        }
        System.out.println("La lista eventi nome: " + title + " è:\n");
        for (int i = 0; i < orderedList.size(); i++) {
            orderedList.get(i).toString();
        }

    }

}
