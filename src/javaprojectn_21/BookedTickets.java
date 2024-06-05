package javaprojectn_21;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.util.ArrayList;

 
   
public class BookedTickets extends Ticket {
    int Num_BookedTicktets;
    ArrayList <Ticket> BookedTickets = new ArrayList<>();
    
    
    
    public BookedTickets() {
       BookedTickets.add(new BookedTickets(1, 12.50,1, "Embaba","12:30 P.M.", "345678" ));
       BookedTickets.add(new BookedTickets(1, 12.00,1, "Helwan","08:30 P.M.", "345678" ));
       BookedTickets.add(new BookedTickets(1, 11.50,1, "El mounib","12:30 P.M.", "345678" ));
       
       Num_BookedTicktets = 0;
       
       try {
            FileOutputStream s = new FileOutputStream("BookedTickets.txt");
            ObjectOutputStream a = new ObjectOutputStream(s);
            
            
            a.writeObject(BookedTickets);
            
            
            a.close();  
            s.close();
            
       
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public BookedTickets(int seatnumber, double price, int ticketid, String rout, String time, String passengerPASS) {
        super(seatnumber, price, ticketid, rout, time, passengerPASS);
    }
    
   
    
    public void setOrigin(int BookedTicketsNum) {
        this.Num_BookedTicktets = BookedTicketsNum;
    }
    
    public int getNumOfBookedTickets() {
        return Num_BookedTicktets;
    }

    public String getRout() {
        return rout;
    }

    public String getTime() {
        return time;
    }
  
    
    
    
       
 

 @Override
      public String toString(){
           return (" Seatnumber: " + getSeatnumber() + " \n Price: " + getPrice() + " \n Ticket ID: " + getTicketid() + " \n Route: " + getRout());
       
       }
}