/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccessObjects;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.*;

/**
 *
 * @author HP
 */
public class ProductDataAccessObject {

    public static void saveProduct(Product product) {
        String query = "insert into product(name,category,price) values('" + product.getName() + "','" + product.getCategory() + "','" + product.getPrice() + "');";
        DBOperations.setOrDeleteData(query, "New product has been added successfully!");
    }

    public static ArrayList<Product> getProducts() {

        ArrayList<Product> productList = new ArrayList<>();
        try {
            ResultSet rs = DBOperations.getData("select * from product;");
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setCategory(rs.getString("category"));
                product.setPrice(rs.getString("price"));
                productList.add(product);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return productList;
    }

    public static void updateProduct(Product product) {
        String query = "update product set name='" + product.getName() + "',category='" + product.getCategory() + "',price='" + product.getPrice() + "' where id='" + product.getId() + "';";
        DBOperations.setOrDeleteData(query, "Product updated successfully!");
    }

    public static void deleteProduct(String id) {
        String query = "delete from product where id='" + id + "';";
        DBOperations.setOrDeleteData(query, "Product deleted successfully!");
    }

    public static ArrayList<Product> getProductsByCategory(String category) {
        ArrayList<Product> productList = new ArrayList<>();
        try {
            ResultSet rs = DBOperations.getData("select * from product where category='" + category + "';");
            while (rs.next()) {
                Product product = new Product();
                product.setName(rs.getString("name"));
                productList.add(product);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return productList;
    }

    public static ArrayList<Product> filterProductsByName(String name, String category) {
        ArrayList<Product> productList = new ArrayList<>();
        try {
            ResultSet rs = DBOperations.getData("select * from product where name like '%"+name+"%' and category='" + category + "';");
            while (rs.next()) {
                Product product = new Product();
                product.setName(rs.getString("name"));
                productList.add(product);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return productList;
    }
    
    public static Product getProductsByName(String name){
        Product product = new Product();
        try {
            ResultSet rs = DBOperations.getData("select * from product where name='"+name+"';");
            while (rs.next()) {                
                product.setName(rs.getString(2));
                product.setCategory(rs.getString(3));
                product.setPrice(rs.getString(4));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return product;
    }
}
