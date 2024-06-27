/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccessObjects;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Category;
import java.sql.*;

/**
 *
 * @author HP
 */
public class CategoryDataAccessObject {
    public static void saveCategory(Category category){
        String query = "insert into category(name) values('"+category.getName()+"');";
        DBOperations.setOrDeleteData(query, "Category added successfully!");
    }
    
    public static ArrayList<Category> getCategoryList(){
        ArrayList<Category> categoryList = new ArrayList<>();
        try{
            ResultSet rs = DBOperations.getData("select * from category;");
            while(rs.next()){
                Category category = new Category();
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
                categoryList.add(category);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return  categoryList;
    }
    
    public static void deleteCategory(String id){
        String query = "delete from category where id='"+id+"';";
        DBOperations.setOrDeleteData(query, "Category deleted successfully!");
    }
}
