package org.ui;

import org.database.DatabaseConnect;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.Arrays;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class AuthUI {
   static JFrame frame;
   static JPanel panel;
   static CardLayout cardLayout=new CardLayout();
   static Listener.actionListener al=new Listener.actionListener();
    static String name,address,email,phoneNumber,password,confirmpassword,yearOfBirth,loginpass;
    static String returnedEmail,returnedPassword;
    static String emailtext;
    public AuthUI(){
        this.designAuth();
    }

    public  JFrame designAuth(){
        frame=new JFrame("SWING AUTHENTICATION");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setBounds(200, 300, 1000, 1200);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.add(contentPanel());

        return frame;
    }

    public static JPanel contentPanel(){
           panel=new JPanel();
           panel.setLayout(cardLayout);
           panel.add("signIn",LogIn.signIn());
            panel.add("signUp",SignUp.SignUp());
            panel.add("dash",DashBoard.dashBoard());


       return panel;
    }



}
