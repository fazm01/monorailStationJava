package javaprojectn_21;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Route implements Serializable {
    private double r1price;
    private double r2price;
    private double r3price;
    private String Origin, StopingStatation, Destination;
    private double routeDistance;
    
     ArrayList <Route> routes = new ArrayList<>();

    public Route() {
        routes.add(new Route("Embaba", "Boulaq", "Airport",21));
        routes.add(new Route("Helwan","Sadat" ,"El marg",34.8));
        routes.add(new Route("El mounib","Ataba" ,"Shobra",41.8));
        
        try {
            FileOutputStream s = new FileOutputStream("routes.txt");
            ObjectOutputStream a = new ObjectOutputStream(s);
            
            
            a.writeObject(routes);
            
            
            a.close();  
            s.close();
            
       
        } catch (IOException ex) {
            ex.printStackTrace();
        }
  
        
    }
    
    public Route(String Origin,String StoppingStation, String Destination, double routeDistance) {
        this.Origin = Origin;
        this.Destination = Destination;
        this.routeDistance = routeDistance;
        this.StopingStatation = StoppingStation;
         try {
        FileInputStream fis = new FileInputStream("route.txt");
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

    public String getOrigin() {
        return Origin;
    }

    public String getDestination() {
        return Destination;
    }

    public double getRouteDistance() {
        return routeDistance;
    }

    public void setOrigin(String Origin) {
        this.Origin = Origin;
    }

    public void setDestination(String Destination) {
        this.Destination = Destination;
    }

    public void setRouteDistance(double RouteDistance) {
        this.routeDistance = RouteDistance;
    }
    
    
    }
          
    

