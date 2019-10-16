package eme;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class MySQLConnect {
    
    Connection conn=null;
    
    public static Connection connect() throws ClassNotFoundException, InstantiationException, IllegalAccessException
    {
        
     // Class.forName("com.mysql.jdbc.Driver");
        try
        {
             Connection conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost/office","root","root");
        
               
             return conn;
             
        }catch(SQLException e)
        {
            System.out.println(e);
        }
       return null;
    }
    
    
    
    
}

