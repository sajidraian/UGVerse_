/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model_ugv;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author pc
 */
public class Dashboard_model {
    public static boolean Post(String content){
        String query = "INSERT INTO posts (content) VALUES (?)";
        try (Connection conn = Database.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query)){
            pstmt.setString(1, content);
            return pstmt.executeUpdate() > 0;
        } 
        catch (SQLException e) {
            return false;
        }
    }
    public static ResultSet recentPosts(){
        try {
            Connection conn = Database.getConnection();
            Statement stmt = conn.createStatement();
            return stmt.executeQuery("SELECT * FROM posts ORDER BY id DESC");
        } 
        catch (SQLException e){
            return null;
        }
    }
}
