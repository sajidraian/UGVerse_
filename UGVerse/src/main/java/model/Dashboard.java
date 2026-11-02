/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author pc
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import config.Database;
public class Dashboard {

    public static boolean createPost(String name, String content) {
        String query = "INSERT INTO posts (name, content) VALUES (?, ?)";
        
        try (Connection conn = Database.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setString(1, name);
            pstmt.setString(2, content);
            
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String getAllPosts() {
        StringBuilder postsBuilder = new StringBuilder();
        String query = "SELECT name, content, created_at FROM posts ORDER BY id DESC";
        
        try (Connection conn = Database.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            
            while (rs.next()) {
                String name = rs.getString("name");
                String content = rs.getString("content");
                String time = rs.getString("created_at");
                
                postsBuilder.append("--------------------------------------------------\n");
                postsBuilder.append("User: ").append(name).append("  (").append(time).append(")\n");
                postsBuilder.append("Post: ").append(content).append("\n\n");
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return postsBuilder.toString();
    }
}