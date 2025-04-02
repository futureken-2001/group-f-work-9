package org.ui;

import org.database.DatabaseConnect;

import javax.swing.*;
import  java.awt.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class LogIn {
    static JPanel frame;
    static JPasswordField jPasswordField;
    static JTextField emailTextField;
    static JLabel emailLable,passwordLabel;
    static JButton createAcc,LogIn;



    public static JPanel signIn() {
        frame=new JPanel();
        //frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setBounds(200,300,900,1200);
       // frame.setResizable(false);
        frame.setVisible(true);
       // frame.getContentPane().setBackground(new Color(52, 73, 94));
        frame.add(def_emailLabel());
        frame.add(def_emailField());
        frame.add(def_passwordLabel());
        frame.add(def_passsword());
        frame.add(def_loginButton());
        frame.add(def_createButton());
        frame.add(def_title());


        return frame;
    }
//password text field
    public static JPasswordField def_passsword(){
        jPasswordField=new JPasswordField();
        jPasswordField.setFont(new Font("Tahoma", Font.PLAIN, 32));
        jPasswordField.setBorder(BorderFactory.createEmptyBorder(0,0,0,40));
        jPasswordField.setBounds(100,600,700,90);
        //jPasswordField.setBackground(new Color(204,229,255));
        return jPasswordField;
    }

 //textfield for email field
 public static JTextField def_emailField(){
        emailTextField=new JTextField();
        emailTextField.setFont(new Font("Tahoma", Font.PLAIN, 32));
        emailTextField.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        emailTextField.setBounds(100,286,700,90);
//        emailTextField.setForeground(new Color(36, 37, 42));
//        emailTextField.setBackground(new Color(204,229,255));
        return emailTextField;
 }

 //email label
    public static JLabel def_emailLabel(){
        emailLable=new JLabel("EMAIL");
        emailLable.setBounds(100,200,700,90);
        emailLable.setFont(new Font("Tahoma", Font.BOLD, 32));
        //emailLable.setForeground(new Color(153,153,0));
        return emailLable;
    }

    //email label
    public static JLabel def_title(){
        emailLable=new JLabel("LOGIN OR CREATE ACCOUNT");
        emailLable.setBounds(145,10,700,90);
        emailLable.setFont(new Font("Arial", Font.BOLD, 40));
      //  emailLable.setForeground(new Color(153,153,0));
        return emailLable;
    }


    //email label
    public static JLabel def_passwordLabel(){
        passwordLabel=new JLabel("PASSWORD");
        passwordLabel.setBounds(100,520,700,90);
        passwordLabel.setFont(new Font("Tahoma", Font.BOLD, 32));
        //passwordLabel.setForeground(new Color(153,153,0));
        return passwordLabel;
    }

    public static JButton def_loginButton(){
        LogIn=new JButton();
        LogIn.setText("LOGIN");
        LogIn.setBounds(145,800,300,90);
        LogIn.setPreferredSize(new Dimension(2,9));
        LogIn.setFont(new Font("Tahoma", Font.BOLD, 24));
        LogIn.setFocusPainted(false);
        LogIn.addActionListener(AuthUI.al);
        return LogIn;

    }


    public static JButton def_createButton(){
        createAcc=new JButton();
        createAcc.setText("CREATE ACCOUNT");
        createAcc.setBounds(455,800,300,90);
        createAcc.setPreferredSize(new Dimension(2,9));
        createAcc.setFocusPainted(false);
        createAcc.setFont(new Font("Tahoma", Font.BOLD, 24));
        createAcc.addActionListener(AuthUI.al);


        return createAcc;

    }

}

