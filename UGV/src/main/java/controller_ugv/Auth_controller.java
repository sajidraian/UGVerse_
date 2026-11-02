/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller_ugv;
import model_ugv.Auth_model;
/**
 *
 * @author pc
 */
public class Auth_controller {    
    public boolean register(String name, String email, String password, String role){
        if(name.isEmpty()||email.isEmpty()||password.isEmpty()) {
            return false;
        }
       
        return Auth_model.register(name, email, password, role);
    }

    public boolean login(String email, String password, String role) {
        if(email.isEmpty()||password.isEmpty()) {
            return false;
        }
        
        return Auth_model.login(email,password,role);
    }
}