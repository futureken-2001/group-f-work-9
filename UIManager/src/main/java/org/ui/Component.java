package org.ui;

import org.database.DatabaseConnect;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;

public class Component {
   static JLabel label;
    public static JLabel labelComponent(String labelName,int y_axis){
        label=new JLabel(labelName);
        label.setBounds(40,y_axis,700,90);
        label.setFont(new Font("Tahoma", Font.BOLD, 32));
        //label.setForeground(new Color(153,153,0));
        return label;
    }
    //"task9_oop","postgres","NTALE1234"
    public static final String dbname="user_Information";
    public static final String userName="postgres";
    public static final String password="NTALE1234";
    public static final String tableName="user_info";

    //password Comparison
    public static boolean passwordCheck(String password,String confirmPassword){
        if (password.equals(confirmPassword)){
            return true;
        }else {
            return false;
        }
    }

   public static final Connection conn=DatabaseConnect.dbConn(dbname,userName,password,tableName);

    }
