/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LENOVO
 */
public class Conexion {
      public static Connection conn;
      
      @SuppressWarnings("empty-statement")
      public Connection conectar(){
        try {
            String bd = "reto5";
            String direccion="jdbc:mysql://localhost:3306/";
            String user="root";
            String password="12345";
            Class.forName("com.mysql.jdbc.Driver");
            String databaseURL = direccion + bd;
            conn = java.sql.DriverManager.getConnection(databaseURL, user,password);
            //System.out.println("conectó");
        } catch (SQLException ex) {
             System.out.println("" + ex);
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            System.out.println("" + ex);
              Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
          }
        return conn;
    }
     public static void main(String args[]){  
        try{  
        Class.forName("com.mysql.jdbc.Driver");  
        Connection con=DriverManager.getConnection(  
        "jdbc:mysql://localhost:3306/reto5","root","12345");   
        Statement stmt=con.createStatement();  
        String query= "select * from usuarios";
        ResultSet rs=stmt.executeQuery(query);  
        while(rs.next())  
        System.out.println(rs.getInt(1)+"  "+rs.getInt(2)+"  "+rs.getString(3));  
        con.close();  
        }catch(Exception e){ System.out.println(e);}  
    }  
}  

