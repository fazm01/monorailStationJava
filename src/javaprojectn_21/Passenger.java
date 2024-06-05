
package javaprojectn_21;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Passenger extends Person implements Serializable {
    
    private int P_ID;
    private String p_email;
    private static int i = 2;
 ArrayList <Passenger> passengers = new ArrayList<>();

    ArrayList <Ticket> tickets = new ArrayList<>();

    public Passenger() {
        passengers.add(new Passenger("Mohamed Ahmed","mo_h12","mohamedahmed@gmail.com","123456"));
        passengers.add(new Passenger("Ali Ahmed","ao_h12","aliahmed@gmail.com","789012"));
        passengers.add(new Passenger("Karim Ahmed","ko_h12","karimahmed@gmail.com","345678"));
        
        try {
            FileOutputStream s = new FileOutputStream("passengers.txt");
            ObjectOutputStream a = new ObjectOutputStream(s);
            
            
            a.writeObject(passengers);
            
            
            a.close();  
            s.close();
            
       
        } catch (IOException ex) {
            ex.printStackTrace();
        }
  
    }
    
  
    
    public Passenger(String name, String username, String email, String password) {
        super(name, username, email, password);
        this.P_ID = P_ID;
        this.p_email = email;
       try {
        FileInputStream fis = new FileInputStream("passengers.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
            try {
                ois.readObject();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            }
        ois.close();
        fis.close();
         } catch (IOException ex) {
            ex.printStackTrace();
        }
  
            
     
    }
    
          
    public void passengerLogin(String j, String k){
            
            System.out.println("___PASSENGER ACCESS___");
            System.out.println("Press 2 to login, Press 3 to create account, Press 4 for Admin access");
            Scanner a1 = new Scanner(System.in);
            int a = a1.nextInt();
            if (a == 2){
           /* login */
            System.out.println("Username: "  );
            Scanner j6 = new Scanner(System.in);
            j = j6.nextLine();
            System.out.println("Password: "  );
            Scanner j7 = new Scanner(System.in);
            k = j7.nextLine();
               for(int i = 0; i < passengers.size(); i++){
                   if (j.equals(passengers.get(i).getUsername()) && k.equals(passengers.get(i).getPassword())){
                       System.out.println("Login Successful.");
                       int choice = 0;
                       while(choice < 5){
                       
                       System.out.println("1. Book ticket");
                       System.out.println("2. Update ticket");
                       System.out.println("3. Cancel ticket");
                       System.out.println("4. Edit account");
                       System.out.println("5. View Ticket");
                       System.out.println("6. Sign out");
                       System.out.println("7. Quit");
                       Scanner a11 = new Scanner(System.in);
                       choice = a11.nextInt();
                       BookedTickets t = new BookedTickets();
                       switch (choice){
                           case 1:
                               t.makeReservation(k);
                               break;
                               
                            case 2:
                                 System.out.println("enter the ticketid");
                                 Scanner inputid= new Scanner(System.in);
                                 int ticketid=inputid.nextInt();
                                
                                t.updateticket(ticketid, k);
                                break;
                               
                            case 3:
                                
                                t.removeticket();
                                break;
                                
                            case 4:
                                System.out.println("Enter username: ");
                                Scanner p1 = new Scanner(System.in);
                                String n = p1.nextLine();
                                
                                System.out.println("Enter password: ");
                                Scanner p4 = new Scanner(System.in);
                                String p = p4.nextLine();
                                editAccount(j,p);
                                break;
                            case 5: 
                                
                                System.out.println(t.viewTicket(passengers.get(i).getPassword()));
                                break;
                            case 6: 
                                passengerLogin(null, null);
                            default:
                                System.out.println("Thank you for choosing Cairo Monorail. See you soon!");
                                break;
                       }
                       }
 
                    }
               }
            }
            else if (a == 3)
                
                createAccount(null, null, null, null);
            else if (a==4){
                Admin a0 = new Admin();
                a0.adminLogin(null,null);
            }
    
    };

   
    public void editAccount(String j, String p){
      
        Scanner EA = new Scanner(System.in);
        for(int i = 0; i < passengers.size(); i++){
        if (j.equals(passengers.get(i).getUsername()) && p.equals(passengers.get(i).getPassword())){
            System.out.println("Enter new Username: ");
            String uea = EA.nextLine();
            
            System.out.println("Enter new password: ");
            String pea = EA.nextLine();
          
            System.out.println("Do you want to change name and email? \n 1. Yes \n 2. No");
            char cho = EA.next().charAt(0);
            if (cho == '1'){
                
            Scanner EA2 = new Scanner(System.in);
            System.out.println("Enter new name: ");
            String nea = EA2.nextLine();
            
            System.out.println("Enter new email: ");
            String eea = EA2.nextLine();
            
            passengers.set(i, new Passenger(nea, uea, eea, pea) );
            
            }
            else{
            passengers.set(i, new Passenger(passengers.get(i).getName(), uea, passengers.get(i).getEmail(), pea) );
            }
            System.out.println(passengers.get(i));
           
            }
        
            
        }
    }
    
    
   
    public void createAccount(String n, String u, String p, String e){
            JavaProjectN_21 main2 = new JavaProjectN_21();
            String p2;
            System.out.println("Enter full name");
            Scanner j1 = new Scanner(System.in);
            n = j1.nextLine();
            System.out.println("Enter email");
            Scanner j2 = new Scanner(System.in);
            e = j2.nextLine();
            System.out.println("Enter username:");
            Scanner j3 = new Scanner(System.in);
            u = j3.nextLine();
            do{
            System.out.println("Enter password");
            Scanner j4 = new Scanner(System.in);
            p = j4.nextLine();
            System.out.println("Re-enter password");
            Scanner j5 = new Scanner(System.in);
            p2 = j5.nextLine();
           
            }
            while(!p.equals(p2));
            
            passengers.add(new Passenger(n,u,e,p));
            
            System.out.println("Account created Successfully. Press 2 to login");
            Scanner a1 = new Scanner(System.in);
            int a = a1.nextInt();
            if (a==2)
            {
                passengerLogin(null, null);
            }
            else
                System.out.println("Error");
                return;
            }
    
   

    @Override
    public String toString(){
        return " Name: "+ getName() +"\n Email: " + getEmail()+ "\n Username: " + getUsername() + "\n Password: " + getPassword();
    }
}