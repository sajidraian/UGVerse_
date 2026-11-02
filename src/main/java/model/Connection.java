/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
/**
 *
 * @author pc
 */

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Connection {

    public static boolean sendConnectionRequest(String senderEmail, String receiverEmail) {
        if (senderEmail.equals(receiverEmail)) {
            return false;
        }
        
        String query = "INSERT INTO connections (sender_email, receiver_email, status) VALUES (?, ?, 'Pending')";
        try (java.sql.Connection conn = Database.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setString(1, senderEmail);
            pstmt.setString(2, receiverEmail);
            return pstmt.executeUpdate() > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String getConnections(String userEmail) {
        StringBuilder sb = new StringBuilder();
        String query = "SELECT sender_email, status FROM connections WHERE receiver_email = ? OR sender_email = ?";
        
        try (java.sql.Connection conn = Database.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setString(1, userEmail);
            pstmt.setString(2, userEmail);
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                String sender = rs.getString("sender_email");
                String status = rs.getString("status");
                sb.append("User: ").append(sender).append(" | Status: ").append(status).append("\n");
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return sb.toString();
    }
}