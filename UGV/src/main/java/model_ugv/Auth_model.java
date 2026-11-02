/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model_ugv;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author pc
 */
public class Auth_model {
        public static boolean register(String name, String email, String password, String role){
        String query = "INSERT INTO users (name, email, password, role) VALUES (?, ?, ?, ?)";      
  
        try (Connection conn = Database.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)){            
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setString(3, password);
            pstmt.setString(4, role);           
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;            
        } 
        catch (SQLException e){           
            return false;
        }
    }
    public static boolean login(String email, String password, String role){
        String query = "SELECT * FROM users WHERE email = ? AND password = ? AND role = ?";
        
        try (Connection conn = Database.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)){           
            pstmt.setString(1, email);
            pstmt.setString(2, password);
            pstmt.setString(3, role);           
            ResultSet rs = pstmt.executeQuery();
            return rs.next();            
        } 
        catch (SQLException e){
            return false;
        }
    }
}
