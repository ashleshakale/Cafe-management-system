/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author prati
 */
public class OpenPDF {

    public static void openById(String id) {
//        try {
//            if ((new File("D:\\Bill"+id+".pdf")).exists()) {
//                @SuppressWarnings("deprecation")
//                Process p = Runtime
//                        .getRuntime()
//                        .exec("rundll32 url.dll,FileProtocolHandler C:\\"+id+".pdf");
//            }
//            else{
//                JOptionPane.showMessageDialog(null, "File does not exist!");
//            }
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e);
//        }
        try {
            // Open the PDF file
            Desktop.getDesktop().open(new File("D:\\Bill"+id+".pdf"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
