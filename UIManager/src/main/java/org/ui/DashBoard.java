package org.ui;
import org.database.DatabaseConnect;

import javax.swing.*;
import java.awt.*;
public class DashBoard {
static JPanel frame;
static JLabel title;
static JLabel Name,Address,phoneNumber,Email,label;
static JButton data;
    public static JPanel dashBoard() {
        frame = new JPanel();
        frame.setLayout(null);
        frame.setBounds(200, 300, 1000, 1200);
        frame.setVisible(true);
//        frame.add(def_dashName(50,10,"NAME: "));
//        frame.add(def_dashName(100,10,"ADDRESS: "));
//        frame.add(def_dashName(150,10,"PHONE no: "));
//        frame.add(def_dashName(200,10,"EMAIL: "));
//
//        frame.add(def_dashName(50,200,DatabaseConnect.getName()));
//        frame.add(def_dashName(100,200,DatabaseConnect.getAddress()));
//        frame.add(def_dashName(150,200,DatabaseConnect.getPhoneNumber()));
//        frame.add(def_dashName(200,200,DatabaseConnect.getEmailValue()));



        frame.add(def_title());
        return frame;
    }

    public static JLabel def_title(){
        title=new JLabel();
        title.setText("Welcome to the DashBoard");
        title.setBounds(350,10,700,40);
        title.setFont(new Font("Tahoma", Font.BOLD, 32));
        return title;
    }

    public static JLabel def_dashName(int y,int x,String labelName){
       label=new JLabel();
       label.setText(labelName);
       label.setFont(new Font("Tahoma", Font.PLAIN, 32));
       label.setBorder(BorderFactory.createEmptyBorder(0,0,0,40));
       label.setBounds(x,y,400,90);
        //label.setBackground(new Color(204,229,255));


        return label;
    }

    public static JButton def_loginButton(){
       data=new JButton();
       data.setText("GET DATA");
       data.setBounds(145,800,300,90);
       data.setPreferredSize(new Dimension(2,9));
       data.setFont(new Font("Tahoma", Font.BOLD, 24));
       data.setFocusPainted(false);

       return data;

    }




}
