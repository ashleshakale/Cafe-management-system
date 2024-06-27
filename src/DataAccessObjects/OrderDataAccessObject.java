/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccessObjects;

import javax.swing.JOptionPane;
import java.sql.*;
import java.util.ArrayList;
import model.*;

/**
 *
 * @author prati
 */
public class OrderDataAccessObject {

    public static String getId() {
        int id = 1;
        try {
            ResultSet rs = DBOperations.getData("select max(id) from bill;");
            if (rs.next()) {
                id = rs.getInt(1);
                id += 1;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return String.valueOf(id);
    }

    public static void saveBill(Order bill) {
        String query = "insert into bill values('" + bill.getId() + "','" + bill.getName() + "','" + bill.getMobileNumber() + "','" + bill.getEmail() + "','" + bill.getDate() + "','" + bill.getTotal() + "','" + bill.getCreatedBy() + "');";
        DBOperations.setOrDeleteData(query, "Bill details saved successfully!");
    }

    public static ArrayList<Order> getAllRecordsByIncrement(String date) {
        ArrayList<Order> billList = new ArrayList<>();
        try {
            ResultSet rs = DBOperations.getData("select * from bill where date like '%" + date + "%';");
            while (rs.next()) {
                Order bill = new Order();
                bill.setId(rs.getInt("id"));
                bill.setName(rs.getString("name"));
                bill.setMobileNumber(rs.getString("mobileNumber"));
                bill.setEmail(rs.getString("email"));
                bill.setDate(rs.getString("date"));
                bill.setTotal(rs.getString("total"));
                bill.setCreatedBy(rs.getString("createdBy"));
                billList.add(bill);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return billList;
    }

    public static ArrayList<Order> getAllRecordsByDecrement(String date) {
        ArrayList<Order> billList = new ArrayList<>();
        try {
            ResultSet rs = DBOperations.getData("select * from bill where date like '%" + date + "%' order By id DESC;");
            while (rs.next()) {
                Order bill = new Order();
                bill.setId(rs.getInt("id"));
                bill.setName(rs.getString("name"));
                bill.setMobileNumber(rs.getString("mobileNumber"));
                bill.setEmail(rs.getString("email"));
                bill.setDate(rs.getString("date"));
                bill.setTotal(rs.getString("total"));
                bill.setCreatedBy(rs.getString("createdBy"));
                billList.add(bill);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return billList;
    }
}
