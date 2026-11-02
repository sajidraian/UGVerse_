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

public class Dashboard {
    private view.Dashboard view;
    private String currentUserName;
    private String currentUserEmail;

    public Dashboard(view.Dashboard view, String currentUserName, String currentUserEmail) {
        this.view = view;
        this.currentUserName = currentUserName;
        this.currentUserEmail = currentUserEmail;

        view.getLblWelcome().setText("Welcome, " + currentUserName + " to UGVerse Campus Feed");

        loadFeed();

        view.getBtnPost().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handlePost();
            }
        });

        view.getBtnProfile().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.dispose(); 
                view.Profile profileView = new view.Profile();
                new controller.Profile(profileView, currentUserEmail);
                profileView.setVisible(true);
            }
        });

        view.getBtnNetwork().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.dispose();
                view.Connection connView = new view.Connection();
                new controller.Connection(connView, currentUserEmail); 
                connView.setVisible(true);
            }
        });

        view.getBtnLogout().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.dispose();
                view.Authentication authView = new view.Authentication();
                new controller.Authentication(authView);
                authView.setVisible(true);
            }
        });
    }
        
    private void handlePost() {
        String content = view.getTxtPostContent().getText().trim();
        
        if (content.isEmpty()) {
            JOptionPane.showMessageDialog(view, "Post content cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        boolean success = model.Dashboard.createPost(currentUserName, content);
        if (success) {
            JOptionPane.showMessageDialog(view, "Post published successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            view.getTxtPostContent().setText("");
            loadFeed();
        } else {
            JOptionPane.showMessageDialog(view, "Failed to publish post!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void loadFeed() {
        String posts = model.Dashboard.getAllPosts();
        view.getTxtFeed().setText(posts);
    }
}