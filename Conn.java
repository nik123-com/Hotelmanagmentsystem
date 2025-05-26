package hotel.management.system;

import java.sql.*;

public class Conn {
    
    Connection c;
    Statement s;
    Conn(){
        try{
        Class.forName("com.mysql.cj.jdbc.Driver"); //Register Driver (1 step)
        c = DriverManager.getConnection("jdbc:mysql:///hotelmanagementsystem","root",""); // Create connection string(Step2)
        s = c.createStatement(); // Step 3
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
   
}
