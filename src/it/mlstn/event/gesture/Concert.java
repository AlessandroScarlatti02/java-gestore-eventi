package it.mlstn.event.gesture;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalTime;

public class Concert extends Event{

    
    private LocalTime time;
    
    private double price;
    
    
    public Concert(String title, LocalDate date, LocalTime time ,int totalSeat, double price) throws Exception {
        super(title, date, totalSeat);
        setTime(time);
        setPrice(price);
    }


    public void setTime(LocalTime time) {
        this.time = time;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setPrice(double price) throws Exception {
        if (price<0) {
            throw new Exception("Il prezzo non può essere minore di 0");
        }else{
            this.price=price;
        }
    }

    public double getPrice() {
        return price;
    }

    private String getFormattedPrice(){
        
        DecimalFormat df = new DecimalFormat("0.00");
        
        return df.format(price);

    }

    private String getFromattedTime(){

        return time.getHour() + ":" + time.getMinute();
    }

    @Override
    public String toString() {
        
        return "Il concerto " + this.getTitle() + " si terrà il " + this.getFormattedDate() +
                    " alle" + getFromattedTime() + " prezzo: " + getFormattedDate() + "\nPosti totali: " + getTotalSeat();
    }
}
    