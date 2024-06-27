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
public class DBOperations {

    public static void setOrDeleteData(String query, String msg) {             // To execute any database query (Add, Update or Delete rows)
        try {
            Connection con = DatabaseConnectionProvider.getCon();
            Statement st = con.createStatement();
            int r = st.executeUpdate(query);                             // Here, the number of rows affected by the query will be returned
                                                              
            JOptionPane.showMessageDialog(null, msg);
//            if (!msg.equals("")) {
//                JOptionPane.showConfirmDialog(null, msg);
//            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public static ResultSet getData(String query) {
        try {
            Connection con = DatabaseConnectionProvider.getCon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
}
