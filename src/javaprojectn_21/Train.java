
package javaprojectn_21;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Train extends Admin implements Serializable {
    
    private int ID;
    private String startingstation;
    private String stoppingstation;
    private int numberofseats;
    private String runingtime;
    static int i = 0;
    
    
    
    private int[] train1 = {0,1,0,0,0,0,0,0,0,0,0};
    private int[] train2 = {0,0,0,0,0,0,0,0,0,0,0};
    
    private int[] train3 = {0,0,0,0,0,0,0,0,0,0,0};
    private int[] train4 = {0,0,0,0,0,0,0,0,0,0,0};
    
    private int[] train5 = {0,0,0,0,0,0,0,0,0,0,0};
    private int[] train6 = {0,0,0,0,0,0,0,0,0,0,0};
        
    
    ArrayList <Train> trains = new ArrayList<>();
   
    
    public Train() {
       
       trains.add(new Train(1, "Embaba", "Airport", 15, "12:30 P.M."));
       trains.add(new Train(1, "Embaba", "Airport", 15, "08:30 P.M."));
       
       trains.add(new Train(2, "Helwan", "El Marg", 15, "12:30 P.M."));
       trains.add(new Train(2, "Helwan", "El Marg", 15, "08:30 P.M."));
       
       trains.add(new Train(3, "El mounib", "Shobra", 15, "12:30 P.M."));
       trains.add(new Train(3, "El mounib", "Shobra", 15, "08:30 P.M."));
       
       try {
            FileOutputStream s = new FileOutputStream("trains.txt");
            ObjectOutputStream a = new ObjectOutputStream(s);
            
            
            a.writeObject(trains);
            
            
            a.close();  
            s.close();
            
       
        } catch (IOException ex) {
            ex.printStackTrace();
        }
  
    }
     
     

    public Train(int ID, String startingstation, String stoppingstation, int numberofseats, String runingtime) {
        this.ID = ID;
        this.startingstation = startingstation;
        this.stoppingstation = stoppingstation;
        this.numberofseats = numberofseats;
        this.runingtime = runingtime;
       
        
            try {
        FileInputStream fis = new FileInputStream("trains.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
            try {
                System.out.println(ois.readObject());
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            }
        ois.close();
        fis.close();
         } catch (IOException ex) {
            ex.printStackTrace();
        }
     
    }
    public String reserve(String r, String t, int s){
        String ret = "-";
       if (r == "Embaba" && t == "12:30 P.M."){
                if (train1[s] == 0){
                train1[s] = 1;
                System.out.println("Seat no." + s + "has been reserved.");
                        } 
                else{
                    System.out.println("Seat taken");
                    ret = "Seat taken";
                      }
       }
       
       else if(r == "Embaba" && t == "08:30 P.M."){
        if (train2[s] == 0){
       train2[s] = 1;
       System.out.println("Seat no." + s + "has been reserved.");
       } 
       else{
       System.out.println("Seat taken");
       ret = "Seat taken";
       }
       }
       
       else if(r == "Helwan" && t == "12:30 P.M."){
        if (train3[s] == 0){
       train3[s] = 1;
       System.out.println("Seat no." + s + "has been reserved.");
       } 
       else{
       System.out.println("Seat taken");
       ret = "Seat taken";
       }
       }
       
       else if(r == "Helwan" && t == "08:30 P.M."){
        if (train4[s] == 0){
       train4[s] = 1;
       System.out.println("Seat no." + s + "has been reserved.");
       } 
       else{
       System.out.println("Seat taken");
       ret = "Seat taken";
       }
       }
       
       else if(r == "El mounib" && t == "12:30 P.M."){
        if (train5[s] == 0){
       train5[s] = 1;
       System.out.println("Seat no." + s + "has been reserved.");
       } 
       else{
       System.out.println("Seat taken");
       ret = "Seat taken";
       }
       }
       
       else if(r == "El mounib" && t == "08:30 P.M."){
        if (train6[s] == 0){
       train6[s] = 1;
       System.out.println("Seat no." + s + "has been reserved.");
       } 
       else{
       System.out.println("Seat taken");
       ret = "Seat taken";
       }
       }
       
            return ret;
        
        }
        
        
   
     
    
    public int getID() {
        return ID;
    }

    public String getStartingstation() {
        return startingstation;
    }

    public String getStoppingstation() {
        return stoppingstation;
    }

    public int getNumberofseats() {
        return numberofseats;
    }

    public String getRuningtime() {
        return runingtime;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setStartingstation(String startingstation) {
        this.startingstation = startingstation;
    }

    public void setStoppingstation(String stoppingstation) {
        this.stoppingstation = stoppingstation;
    }

    public void setNumberofseats(int numberofseats) {
        this.numberofseats = numberofseats;
    }

    public void setRuningtime(String runingtime) {
        this.runingtime = runingtime;
    }
    
    public void displayAllTrains(){
       
       System.out.println(trains.size());
    }
    
    public void trainAdd(int i, String s1, String s2, int n, String rt){
        trains.add(new Train(i,s1,s2,n,rt));
        for(int k = 0; k < trains.size(); k++){
        if(i == trains.get(k).getID()){
            System.out.println(trains.get(k));
        }
        }
    }
    
    
    public void trainEdit(int i){  
        try{
       System.out.println("Enter new train ID: ");
       Scanner update1 = new Scanner(System.in);
       int i1 = update1.nextInt();
       
       System.out.println("Enter new starting station: ");
       Scanner update2 = new Scanner(System.in);
       String s1 = update2.nextLine();
       
       System.out.println("Enter new stopping station: ");
       Scanner update3 = new Scanner(System.in);
       String s2 = update3.nextLine();
       
       System.out.println("Enter new seat numbers: ");
       Scanner update4 = new Scanner(System.in);
       int sn = update4.nextInt();
       
       System.out.println("Enter new running time: ");
       Scanner update5 = new Scanner(System.in);
       String rn = update5.nextLine();
        
       trains.set(i, new Train(i1,s1,s2,sn,rn));
       System.out.println(trains.get(i));
        }
        catch(InputMismatchException e){             
         System.out.println("error in inputs type ");
}
    }
    
    public Train trainRemove(int I2){
        for (int i=0; i<trains.size(); i++){
            Train t = trains.get(i);            
            if (t.getID() == I2){
                System.out.println("Train removed sucessfully");
                 return trains.remove(i);
            }
            else
                System.out.println("Invalid ID");
                
            
        
    }
        return null;
    }

    @Override
    public String toString(){
        return (" Train id: " + ID + " \n Start station: " + startingstation + " \n Stop station: " + stoppingstation + " \n No. of seats: "+ numberofseats + " \n Running time: " + runingtime );
    }


}
    
