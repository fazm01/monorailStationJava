package javaprojectn_21;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;
import java.util.InputMismatchException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Admin extends Person implements Serializable {
public static Scanner input=new Scanner(System.in);
private int A_ID;
private String Email;

 ArrayList <Admin> admins = new ArrayList<>();

 
    public Admin() {
        
        admins.add(new Admin(1324,  "Ahmed Aly","AhmedAly1324", "ahmedaly1324@mono.gov.eg","qwertyuiop"));
        admins.add(new Admin(1325, "Mohamed Ahmed","MohamedAhmed1325", "mohamedahmed1325@mono.gov.eg","asdfghjkl"));
        admins.add(new Admin(1326,  "Karim Tawfik","KarimTawfik1326","karimtawfik1326@mono.gov.eg","zxcvbnm"));
        admins.add(new Admin(1327, "Adel Samir","AdelSamir1327", "adelsamir1327@mono.gov.eg","qazwsxedc"));
        admins.add(new Admin(1328, "Ali Mohamed","AliMohamed1328", "alimohamed1328@mono.gov.eg","rfvtgbyhn"));

      try {
            FileOutputStream s = new FileOutputStream("admins.txt");
            ObjectOutputStream a = new ObjectOutputStream(s);
            
            
            a.writeObject(admins);
            
            
            a.close();  
            s.close();
            
       
        } catch (IOException ex) {
            ex.printStackTrace();
        }
      
    
      
  
    }
    
    
    

    public Admin(int A_ID, String name, String username, String email, String password) {
        super(name, username,email, password);
        
        this.A_ID = A_ID;
        
         
      
      
            try {
        FileInputStream fis = new FileInputStream("admins.txt");
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
public void setA_ID(int A_ID) {
        this.A_ID = A_ID;
    }
    public int getA_ID() {
        return A_ID;
    }

    
    
    
    public void addtrain() {
        try{
     System.out.println("Enter new train information \n");
       System.out.println("Enter new train id");
       Scanner a12 = new Scanner(System.in);
       int I = a12.nextInt();
       System.out.println("Enter new train start station");
       Scanner a13 = new Scanner(System.in);
       String starts = a13.nextLine();
       System.out.println("Enter new train stop station");
       Scanner a14 = new Scanner(System.in);
       String stops = a14.nextLine();
       
       System.out.println("Enter new train number of seats");
       Scanner a15 = new Scanner(System.in);
       int sn = a15.nextInt();
       System.out.println("Enter new train run time");
       Scanner a16 = new Scanner(System.in);
       String rt = a16.nextLine();
       Train t3 = new Train();
       t3.trainAdd( I, starts, stops, sn, rt);
        }
       catch(InputMismatchException e){
       System.out.println("error in inputs type ");


        }
      
        
    }
    
    public void removetrain(int ID){
    Train t2 = new Train();
    t2.trainRemove(ID);
    }
    
    
    public void adminLogin(String u, String p) {
        System.out.println("__ADMIN ACCESS__");
            System.out.println("Press 2 to login. Press 3 for passenger Access");
            Scanner a1 = new Scanner(System.in);
            int a = a1.nextInt();
            if (a == 2){
           /* login */
            System.out.println("Username: "  );
            Scanner j6 = new Scanner(System.in);
            u = j6.nextLine();
            System.out.println("Password: "  );
            Scanner j7 = new Scanner(System.in);
            p = j7.nextLine();
            if(u.equals("")&& p.equals("")){
            
            }
               for(int i = 0; i < admins.size(); i++){
                   
                   if (u.equals(admins.get(i).getUsername()) && p.equals(admins.get(i).getPassword())){
                       System.out.println("Login Successful.");
                       int choice = 0;
                       while(choice < 6){
                       System.out.println("1. Add train");
                       System.out.println("2. Delete train");
                       System.out.println("3. Update train");
                       System.out.println("4. Generate report");
                       System.out.println("5. Edit account");
                       System.out.println("6. Sign out");
                       System.out.println("7. Quit");
                       Scanner a11 = new Scanner(System.in);
                       choice = a11.nextInt();
                       switch (choice){
                           case 1:
                               addtrain();
                               break;
                            case 2:
                                try{
                               System.out.println("Enter train ID to remove");
                               Scanner a13 = new Scanner(System.in);
                               int I2 = a13.nextInt();
                               removetrain(I2);
                               break;
                                }
                               catch(InputMismatchException e){
                                System.out.println("Error. Try again with valid input.");
                                System.exit(0);  
                                }
                            case 3:
                                System.out.println("Enter train ID to edit");
                                Scanner a14 = new Scanner(System.in);
                                int I3 = a14.nextInt();
                                updatetrain(I3);
                                break;
                            case 4:
                                try{
                                System.out.println(" Choose route: \n 1. Embaba \n 2. Helwan \n 3.El mounib ");
                                Scanner y = new Scanner(System.in);
                                int r = y.nextInt();
                                if(r > 3 || r < 1){
                                System.out.println("Error. Try again with valid input.");
                                System.exit(0);
                                }
                                else{
                                generateRep(r);
                                break;
                                }
                                }
                                catch(InputMismatchException e){
                                System.out.println("Error. Try again with valid input.");
                                System.exit(0);
                                }
                            case 5:
                                System.out.println("Enter the USERNAME of the admin you want to update : \n ");
                                Scanner in = new Scanner(System.in);
                                String user = in.nextLine();
                                
                                System.out.println("Enter the PASSWORD of the admin you want to update : \n ");
                                Scanner on = new Scanner(System.in);
                                String pass = on.nextLine();
                                manageAccount(user, pass);
                                break;
                            case 6:
                                adminLogin(null,null);
                            default:
                                System.out.println("See you soon!");
                                break;
                       
                       }
                       }
                   }
                       
                  
               }
            }
            else if(a==3){
                Passenger pl = new Passenger();
                pl.passengerLogin(null,null);
            }
    }
    

        
    
    

    public void updatetrain(int ID){
        Train t1 = new Train();
       for(int i = 0; i < t1.trains.size(); i++){
       if (ID == t1.trains.get(i).getID()){
       t1.trainEdit(i);
       }
       
       
       }
       
        
    }
   
   
    public void generateRep(int route){
        Ticket t9 = new Ticket();
        BookedTickets b9 = new BookedTickets();
        switch (route){
            case 1:
                System.out.println("Total bookings for this route: " + t9.r1counter );
                System.out.println("Total fare for this route: " + (t9.r1counter * b9.BookedTickets.get(0).getPrice()));
                break;
            case 2:
                System.out.println("Total bookings for this route: " + t9.r2counter );
                System.out.println("Total fare for this route: " + (t9.r2counter * b9.BookedTickets.get(1).getPrice()));
                break;
            case 3:
                System.out.println("Total bookings for this route: " + t9.r3counter );
                System.out.println("Total fare for this route: " + (t9.r3counter * b9.BookedTickets.get(2).getPrice()));
                break;
        
        }
        
        
       
    
        
    }
    public void manageAccount(String u, String p){
      
        
        for(int i = 0; i < admins.size(); i++){
          if (u.equals(admins.get(i).getUsername()) && p.equals(admins.get(i).getPassword())){
        System.out.println("Enter new account information: \n ");
        
        
         System.out.println("Enter new admin username ");
        Scanner chp4 = new Scanner(System.in);
         String aun = chp4.nextLine();
         
          System.out.println("Enter new password ");
          Scanner chp5 = new Scanner(System.in);
          String np1 = chp5.nextLine();
         
           System.out.println("Do you want to change name and email? \n 1. Yes \n 2. No");
            Scanner chp6 = new Scanner(System.in);
            char cho = chp6.next().charAt(0);
            if (cho == '1'){
            
            System.out.println("Enter new admin full name ");
            Scanner chp1 = new Scanner(System.in);
            String  an = chp1.nextLine();
         
            System.out.println("Enter new admin email ");
            Scanner chp3 = new Scanner(System.in);
            String ae1 = chp3.nextLine();
            
            admins.set(i, new Admin(admins.get(i).getA_ID(), an, aun, ae1, np1));
            }
          
            else{
            admins.set(i, new Admin(admins.get(i).getA_ID(), admins.get(i).getName(), aun, admins.get(i).getEmail(), np1));
            }
            System.out.println(admins.get(i));
          }
        
             
            
        }

    
    }   
    @Override
    public String toString(){
        return (" Username : " + getUsername() + "\n Password: " + getPassword() + "\n Full name: "+ getName() + "\n Email: " + getEmail() + "\n ID: " + getA_ID());
    }
}
 