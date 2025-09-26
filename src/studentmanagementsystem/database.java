/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentmanagementsystem;

import java.sql.DriverManager;
import java.sql.Connection;
/**
 *
 * @author uthum
 */
public class database {
        public static Connection connectDb(){
        
        try{
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            Connection connect= DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdata?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=Asia/Colombo","admin","admin");
            return connect;
            
        }catch (Exception e){e.printStackTrace();}
        return null;
    }
}
