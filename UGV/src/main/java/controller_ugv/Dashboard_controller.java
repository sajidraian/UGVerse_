/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller_ugv;
import java.sql.ResultSet;
import java.sql.SQLException;
import model_ugv.Dashboard_model;
/**
 *
 * @author pc
 */
public class Dashboard_controller {
    public static boolean Post(String content){
        if (content == null || content.trim().isEmpty()){
            return false;
        }
        return Dashboard_model.Post(content.trim());
    }

    public static String Feed(){
        StringBuilder feed= new StringBuilder();
        ResultSet result= Dashboard_model.recentPosts();

        if (result!= null) {
            try {
                while (result.next()) {
                    String content =result.getString("content");
                feed.append(content).append("\n");
                feed.append("--------------------------------------------------\n");
                }
            } catch (SQLException e) {
            }
        }
        return feed.toString();
    }
}
