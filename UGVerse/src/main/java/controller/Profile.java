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
import java.sql.ResultSet;
import java.sql.SQLException;

public class Profile {
    private view.Profile view;
    private String currentUserEmail;

    public Profile(view.Profile view, String currentUserEmail) {
        this.view = view;
        this.currentUserEmail = currentUserEmail;

        loadProfileData();
        
        this.view.getBtnUpdate().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleUpdate();
            }
        });

        // Back বাটনের ইভент হ্যান্ডলার
        this.view.getBtnBack().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.dispose();
                String userName = model.Authentication.getNameByEmail(currentUserEmail);
                view.Dashboard dashView = new view.Dashboard();
                new controller.Dashboard(dashView, userName, currentUserEmail);
                dashView.setVisible(true);
            }
        });
    }

    private void loadProfileData() {
        ResultSet rs = model.Profile.getUserDetails(currentUserEmail);
        try {
            if (rs != null && rs.next()) {
                view.getTxtName().setText(rs.getString("name"));
                view.getTxtEmail().setText(rs.getString("email"));
                view.getTxtRole().setText(rs.getString("role"));
                
                view.getTxtEmail().setEditable(false);
                view.getTxtRole().setEditable(false);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void handleUpdate() {
        String newName = view.getTxtName().getText().trim();

        if (newName.isEmpty()) {
            JOptionPane.showMessageDialog(view, "Name cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        boolean success = model.Profile.updateProfile(currentUserEmail, newName);
        if (success) {
            JOptionPane.showMessageDialog(view, "Profile updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(view, "Failed to update profile!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}