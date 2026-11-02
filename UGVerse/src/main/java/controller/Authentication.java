/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author pc
 */

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Authentication {
    private view.Authentication view;

    public Authentication(view.Authentication view) {
        this.view = view;

        this.view.getBtnRegister().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleRegister();
            }
        });

        this.view.getBtnLogin().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleLogin();
            }
        });
    }

    private void handleRegister() {
        String name = view.getTxtName().getText().trim();
        String email = view.getTxtEmail().getText().trim();
        String password = new String(view.getTxtPassword().getPassword());
        String role = view.getCmbRole().getSelectedItem().toString();

        if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(view, "Please fill all fields!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        boolean success = model.Authentication.register(name, email, password, role);
        if (success) {
            JOptionPane.showMessageDialog(view, "Registration successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(view, "Registration failed! (Email might already exist)", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void handleLogin() {
        String email = view.getTxtEmail().getText().trim();
        String password = new String(view.getTxtPassword().getPassword());
        String role = view.getCmbRole().getSelectedItem().toString();

        if (email.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(view, "Please enter email and password!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        boolean success = model.Authentication.login(email, password, role);
        if (success) {
            String userName = model.Authentication.getNameByEmail(email);
            
            JOptionPane.showMessageDialog(view, "Login successful! Welcome to UGVerse.", "Success", JOptionPane.INFORMATION_MESSAGE);
            
            view.dispose();
            view.Dashboard dashView = new view.Dashboard();
    
            new controller.Dashboard(dashView, userName, email);
            dashView.setVisible(true);
            
        } else {
            JOptionPane.showMessageDialog(view, "Invalid email, password, or role!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}