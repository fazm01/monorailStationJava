package javaprojectn_21;
import java.io.Serializable;
import java.util.Scanner;
import java.util.ArrayList;

public class Ticket implements Serializable{

 private int seatnumber;
 static int i = 1;
 private double price;
 private int ticketid;
 private String passengerPass;

 
 
 public static int r1counter = 1;
 public static int r2counter = 1;
 public static int r3counter = 1;
 public static int passengercount = 1;


 String rout;
 String time;


    public Ticket() {
      
       
    }

    public String getPassengerPass() {
        return passengerPass;
    }

    public void setPassengerPass(String passengerPass) {
        this.passengerPass = passengerPass;
    }
 

 

    public Ticket(int seatnumber, double price, int ticketid, String rout, String time, String passengerPASS) {
        this.seatnumber = seatnumber;
        this.price = price;
        this.ticketid = ticketid;
        this.passengerPass = passengerPASS;
        this.rout = rout;
        this.time = time;
        
    }



    public int getSeatnumber() {
        return seatnumber;
    }

    public double getPrice() {
        
        return price;
    }

    public int getTicketid() {
        
        return ticketid;
    }


    public void setSeatnumber(int seatnumber) {
        this.seatnumber = seatnumber;
    }

    public void setPrice(double price) {
       this.price = price;
    }

    public void setTicketid(int ticketid) {
        this.ticketid = ticketid;
    }
 
 
public void makeReservation(String pass)
    {   
        BookedTickets b1 = new BookedTickets();
        Scanner scan = new Scanner(System.in);
        String Troute = null;
        String Ttime = null;
        double rprice= 0.00;
        
        int ych = 1;
        while(ych == 1){      
      
      
      System.out.println(" Choose route: \n 1. Embaba - Boulaq - Airport \n 2. Helwan - Sadat - El Marg \n 3. El mounib - Ataba - Shoubra");
      int ch1 = scan.nextInt();
      
      switch (ch1){
          case 1: 
              Troute = "Embaba";
              rprice = 12.50;
              r1counter++;
              break;
          case 2:
              Troute = "Helwan";
              rprice = 12.00;
              r2counter++;
              break;
          case 3:
              rprice = 11.50;
              Troute = "El mounib";
              r3counter++;
              break;
          default:
              System.out.println("Invalid route.");
      }
      
      System.out.println(" Choose time: \n 1. 12:30 P.M. \n 2. 08:30 P.M. ");
      int ch2 = scan.nextInt();
      
      switch (ch2){
          case 1:
              Ttime = "12:30 P.M.";
              break;
          case 2:
              Ttime = "08:30 P.M.";
              break;
        }
      
      System.out.println(" Enter seat: \n 1-5: business class \n 6-15 economy class");
      int S = scan.nextInt();
      Train tr1= new Train();
      if(!tr1.reserve(Troute, Ttime, S).equals("Seat taken")){
      passengercount++;
      
      
      b1.BookedTickets.add(new BookedTickets (S, rprice, passengercount,  Troute, Ttime, "345678"));
      System.out.println("Press 1 to reserve another ticket, Press 0 to quit.");
      ych = scan.nextInt();
      }
    }

    }
    



public void updateticket(int ticketid, String p){
       BookedTickets b1 = new BookedTickets();
        Scanner updt = new Scanner(System.in);
         for (int i = 0; i < b1.BookedTickets.size(); i++){
         if (ticketid == b1.BookedTickets.get(i).getTicketid() && p.equals(b1.BookedTickets.get(i).getPassengerPass())){
         System.out.println(b1.BookedTickets.get(i));
         System.out.println(" 1. Cancel this ticket \n 2. Book new ticket");
         int updt1 = updt.nextInt();
         switch (updt1){
             case 1:
                 removeticket();
                 break;
             case 2:
                 makeReservation(p);
                 break;
             default:
                 System.out.println("Error: Invalid option");
         }
         }
         }

}
        
 public Ticket viewTicket(String p){
     BookedTickets b1 = new BookedTickets();
     Ticket t1 = new Ticket();
        for(int i = 0; i < b1.BookedTickets.size(); i++ ){
        if(p.equals(b1.BookedTickets.get(i).getPassengerPass()) )
        {
        t1 = b1.BookedTickets.get(i);
        }
   
        }
        return t1;
 }

public Ticket removeticket (){
         BookedTickets b1 = new BookedTickets();
            System.out.println("Enter ticket id to remove");
            Scanner input1 = new Scanner(System.in);
            ticketid = input1.nextInt();
            for (int i=0; i<b1.BookedTickets.size(); i++){
            Ticket t = b1.BookedTickets.get(i);            
            if (t.getTicketid() == ticketid)
                passengercount--;
                System.out.println("Ticket removed sucessfully");
                 return  b1.BookedTickets.remove(i);
           
                    
        }
            
            return null;
       }
       
      
}