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
   static actionListener al=new actionListener();
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

    public static class actionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
    JButton src=(JButton)e.getSource();
    if(src.equals(LogIn.LogIn)) {
        emailtext = LogIn.emailTextField.getText();
        char[] passwordchar = LogIn.jPasswordField.getPassword();
        loginpass = new String(passwordchar);

        DatabaseConnect.search_by(Component.conn, Component.tableName, emailtext);

        if(emailtext.equals(DatabaseConnect.getEmailValue())&&loginpass.equals(DatabaseConnect.getPasswordValue())){
           DatabaseConnect.read_data(Component.conn,Component.tableName,emailtext);
            JOptionPane.showMessageDialog(frame, "Login successfully!",
                    "Success", JOptionPane.INFORMATION_MESSAGE);
            cardLayout.show(panel,"dash");
        }else{
            JOptionPane.showMessageDialog(frame, "Login Failure!",
                    "Failure", JOptionPane.ERROR_MESSAGE);
        }

        //
    }
    if (src.equals(LogIn.createAcc)) {
       cardLayout.show(panel,"signUp");

    }

   if(src.equals(SignUp.signIn)){
       cardLayout.show(panel,"signIn");
   }

   if(src.equals(SignUp.Register)){
name=SignUp.nameTextField.getText();
yearOfBirth=SignUp.yearofBirthField.getText();
address=SignUp.addressfield.getText();
phoneNumber=SignUp.phoneNumber.getText();
email=SignUp.email.getText();
char[] passwordchar=SignUp.password.getPassword();
char[] confirmChar=SignUp.confirmpassword.getPassword();

if(Arrays.equals(passwordchar,confirmChar)){
    password=new String(SignUp.password.getPassword());
    confirmpassword=new String(SignUp.confirmpassword.getPassword());
}else{
    JOptionPane.showMessageDialog(frame,"Passwords must match!","Failure",JOptionPane.ERROR_MESSAGE);
}

if(!name.isEmpty()&& !yearOfBirth.isEmpty()&&!address.isEmpty()&&!phoneNumber.isEmpty()&&!email.isEmpty()&&!password.isEmpty()&&!confirmpassword.isEmpty()){

        DatabaseConnect.insert_Data(Component.conn,Component.tableName,name,yearOfBirth,address,phoneNumber,email,password);

        JOptionPane.showMessageDialog(frame, "Operation completed successfully!",
                "Success", JOptionPane.INFORMATION_MESSAGE);

            SignUp.nameTextField.setText("");
            SignUp.email.setText("");
            SignUp.phoneNumber.setText("");
            SignUp.addressfield.setText("");
            SignUp.password.setText("");
            SignUp.confirmpassword.setText("");
            cardLayout.show(panel,"dash");
    }else{
    JOptionPane.showMessageDialog(frame, "Operation Failed!",
            "Failure", JOptionPane.ERROR_MESSAGE);
}




   }
        }
    }

}
