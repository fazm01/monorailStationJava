
package javaprojectn_21;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.*;

public class Person extends JavaProjectN_21 implements Serializable{
    private String name, username, password, email;
    
    public void adminLogin(String u, String p){};

    public Person() {
        this.name = null;
        this.username = null;
        this.password = null;
        this.email = null;
        
        
        
    }
    
    
    
    public Person(String name, String username, String email, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
       
    }

    public String getName() {
        return this.name;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public String getEmail() {
        return this.email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public void readObject(ObjectInputStream aInputStream) throws ClassNotFoundException, IOException
    {
        name = aInputStream.readUTF();
        username = aInputStream.readUTF();
        password = aInputStream.readUTF();
        email = aInputStream.readUTF();
    }
    
    
    
    
    public void passengerLogin(String u, String p){
            ;
    
    };
    public void createAccount(String n, String u, String p, String e){
        
           


    }
};
    
    
