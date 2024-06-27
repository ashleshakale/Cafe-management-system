/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccessObjects;

import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class tables {                                                         // Query to create user table

    public static void main(String[] args) {
        try {
            String userTable = "create table user(id int AUTO_INCREMENT primary key,"
                    + " name varchar(200), email varchar(200), mobileNumber varchar(10), address varchar(200),"
                    + " password varchar(200), securityQuestion varchar(200), answer varchar(200), status varchar(20), privilegeLevel varchar(200), UNIQUE (email))";
            String adminDetails = "insert into user(name,email,mobileNumber,address,password,securityQuestion,answer,status) values('admin','admin@email.com','1234567890','india','admin','What is your favourite game?','cricket','true');";
            String categoryTable = "create table category(id int AUTO_INCREMENT primary key, name varchar(200));";
            String productTable = "create table product(id int AUTO_INCREMENT primary key,name varchar(200),category varchar(200),price varchar(200));";
            String billTable = "create table bill(id int primary key, name varchar(200),mobileNumber varchar(10),email varchar(200),date varchar(200),total varchar(200),createdBy varchar(200));";

//            DBOperations.setOrDeleteData(userTable, "User Table Created Successfully");
//            DBOperations.setOrDeleteData(adminDetails, "Admin details Added successfully!");
//            DBOperations.setOrDeleteData(categoryTable, "Category Table Created Successfully");
//            DBOperations.setOrDeleteData(productTable, "Product Table Created Successfully");
//            DBOperations.setOrDeleteData(billTable, "Bill Table Created Successfully");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Message", JOptionPane.OK_OPTION);
        }
    }
}
