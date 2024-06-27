/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccessObjects;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */

public class DatabaseConnectionProvider {

    public static Connection getCon(){                                        // To create and provide database connection
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cafems?useSSL=false","root","Pratik@mysql7");
            return con;
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
}
