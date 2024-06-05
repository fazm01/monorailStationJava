package javaprojectn_21;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class JavaProjectN_21 extends JFrame {
    
    private JLabel Msg;
    private JButton Admin;
    private JButton Passenger;
    
  
       
    public static void main(String[] args) {
        

  
        String uname,pass,em;
        String u,p,e,p2;
        int a;
        
         HomePage hp1 = new HomePage();
         hp1.setVisible(true);
        
        System.out.println("Welcome to the Cairo Monorail Station");
        System.out.println("Press 1 to login as Adminstrator");
        System.out.println("Press 2 to login/sign up as Passenger");
    
        
        Scanner j = new Scanner(System.in);
        int x = j.nextInt();
        
        if(x == 1) {
           Person a1 = new Admin();
           a1.adminLogin(null, null);
          
        }
        
        else if (x == 2){
            Person p1 = new Passenger();
            p1.passengerLogin(null, null);
        }
        
        
       
    }

    
}
