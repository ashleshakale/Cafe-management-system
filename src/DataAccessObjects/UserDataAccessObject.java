/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccessObjects;

import javax.swing.JOptionPane;
import model.*;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class UserDataAccessObject {

// Query to add new user to the system
    public static void save(User user) {
        String query = "insert into user(name, email, mobileNumber, address, password, securityQuestion, answer, status, privilegeLevel)"
                + " values('" + user.getName() + "','" + user.getEmail() + "','" + user.getMobileNumber() + "','" + user.getAddress()
                + "','" + user.getPassword() + "','" + user.getSecurityQuestion() + "','" + user.getAnswer() + "','" + user.getStatus() + "','" + user.getPrivilegeLevel() + "');";
        if (user.getStatus().equals("true")) {
            DBOperations.setOrDeleteData(query, "Registered Successfully! Now you can log in!");

        } else {
            DBOperations.setOrDeleteData(query, "Registered Successfully! Wait for the Admin's Approval!");
        }
    }

    public static User login(String email, String password) {
        User user = null;
        try {
            String query = "select * from user where email='" + email + "' and password='" + password + "';";
            ResultSet rs = DBOperations.getData(query);
            if (rs.next()) {
                user = new User();
                user.setEmail(email);
                user.setStatus(rs.getString("status"));
                user.setPrivilegeLevel(rs.getString("privilegeLevel"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return user;
    }

    public static User getSecurityQuestion(String email) {
        User user = null;
        try {
            ResultSet rs = DBOperations.getData("select * from user where email='" + email + "';");
            while (rs.next()) {
                user = new User();
                user.setSecurityQuestion(rs.getString("securityQuestion"));
                user.setAnswer(rs.getString("answer"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return user;
    }

    public static void updatePassword(String email, String newPassword) {
        String query = "update user set password='" + newPassword + "' where email='" + email + "';";
        DBOperations.setOrDeleteData(query, "Password changed Successfully");
    }

    public static ArrayList<User> getUsers(String email) {
        ArrayList<User> userList = new ArrayList<>();
        try {
            ResultSet rs = DBOperations.getData("select * from user where email like '%" + email + "%';");
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setMobileNumber(rs.getString("mobileNumber"));
                user.setAddress(rs.getString("address"));
                user.setSecurityQuestion(rs.getString("securityQuestion"));
                user.setPrivilegeLevel(rs.getString("privilegeLevel"));
                user.setStatus(rs.getString("status"));
                userList.add(user);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return userList;
    }

    public static void changeStatus(String email, String status) {
        String query = "update user set status='" + status + "' where email='" + email + "';";
        DBOperations.setOrDeleteData(query, "Status changed successfully!");
    }

    public static void changePassword(User user, String oldPassword, String newPassword) {
        try {
            ResultSet rs = DBOperations.getData("select * from user where email='" + user.getEmail() + "' and password='" + oldPassword + "';");
            if (rs.next()) {
                updatePassword(user.getEmail(), newPassword);
            } else {
                JOptionPane.showMessageDialog(null, "Old password is wrong!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public static void changeSecurityQuestion(String email, String password, String securityQuestion, String answer) {
        try {
            ResultSet rs = DBOperations.getData("select * from user where email='" + email + "' and password='" + password + "';");
            if (rs.next()) {
                updateSecurityQuestion(email, securityQuestion, answer);
            } else {
                JOptionPane.showMessageDialog(null, "Password is wrong!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public static void updateSecurityQuestion(String email, String securityQuestion, String answer) {
        String query = "update user set securityQuestion='" + securityQuestion + "',answer='" + answer + "' where email='" + email + "';";
        DBOperations.setOrDeleteData(query, "Security question changed successfully!");
    }
}
