package org.ui;

import org.database.DatabaseConnect;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import static org.ui.AuthUI.*;

public class Listener {

    public static class actionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton src=(JButton)e.getSource();
            if(src.equals(LogIn.LogIn)) {
                AuthUI.emailtext = LogIn.emailTextField.getText();
                char[] passwordchar = LogIn.jPasswordField.getPassword();
                AuthUI.loginpass = new String(passwordchar);

                DatabaseConnect.search_by(Component.conn, Component.tableName, emailtext);

                if(AuthUI.emailtext.equals(DatabaseConnect.getEmailValue())&&AuthUI.loginpass.equals(DatabaseConnect.getPasswordValue())){
                    DatabaseConnect.read_data(Component.conn,Component.tableName,AuthUI.emailtext);
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
