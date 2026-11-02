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

public class Connection {
    private view.Connection view;
    private String currentUserEmail;

    public Connection(view.Connection view, String currentUserEmail) {
        this.view = view;
        this.currentUserEmail = currentUserEmail;

        loadConnectionList();

        this.view.getBtnSend().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleSendRequest();
            }
        });

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

    private void handleSendRequest() {
        String targetEmail = view.getTxtTargetEmail().getText().trim();
        
        if (targetEmail.isEmpty()) {
            JOptionPane.showMessageDialog(view, "Please enter an email!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        boolean success = model.Connection.sendConnectionRequest(currentUserEmail, targetEmail);
        if (success) {
            JOptionPane.showMessageDialog(view, "Connection request sent!", "Success", JOptionPane.INFORMATION_MESSAGE);
            view.getTxtTargetEmail().setText("");
            loadConnectionList();
        } else {
            JOptionPane.showMessageDialog(view, "Failed to send request (Check email or avoid self-request).", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void loadConnectionList() {
        String list = model.Connection.getConnections(currentUserEmail);
        view.getTxtConnectionList().setText(list);
    }
}