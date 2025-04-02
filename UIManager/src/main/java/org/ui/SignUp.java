package org.ui;
import javax.swing.*;
import java.awt.*;




public class SignUp {
   static JPanel frame;
    static JTextField nameTextField,yearofBirthField,addressfield,phoneNumber,email;
    static JPasswordField password,confirmpassword;
    static JButton Register,signIn;
    static String name;
    public static JPanel SignUp() {
        frame = new JPanel();
        frame.setLayout(null);
        frame.setBounds(200, 300, 1000, 1200);
        frame.setVisible(true);

        frame.add(Component.labelComponent("NAME",100));
        frame.add(def_nameField(100));

        frame.add(Component.labelComponent("BIRTH YEAR",200));
        frame.add(def_yearOfBirth(200));

        frame.add(Component.labelComponent("ADDRESS",300));
        frame.add(def_address(300));

        frame.add(Component.labelComponent("PHONE No",400));
        frame.add(def_phoneNumber(400));

        frame.add(Component.labelComponent("EMAIL",500));
        frame.add(def_email(500));

        frame.add(Component.labelComponent("PASSWORD",600));
        frame.add(def_password(600));

        frame.add(Component.labelComponent("CONFIRM *",700));
        frame.add(def_confirmPassword(700));

        frame.add(def_registerButton());
        frame.add(def_Login());

        frame.add(title());

        return frame;

    }

    //password text field
    public static JTextField def_nameField(int y_axis){
        nameTextField=new JTextField();
        nameTextField.setFont(new Font("Tahoma", Font.PLAIN, 32));
        nameTextField.setBorder(BorderFactory.createEmptyBorder(0,0,0,40));
        nameTextField.setBounds(280,y_axis,700,90);
       // nameTextField.setBackground(new Color(204,229,255));
        name=nameTextField.getText();
        return nameTextField;
    }


    //Year of Birth text Field
    public static JTextField def_yearOfBirth(int y_axis){
        yearofBirthField=new JTextField();
        yearofBirthField.setFont(new Font("Tahoma", Font.PLAIN, 32));
        yearofBirthField.setBorder(BorderFactory.createEmptyBorder(0,0,0,40));
        yearofBirthField.setBounds(280,y_axis,700,90);
        // yearofBirthField.setBackground(new Color(204,229,255));
        return yearofBirthField;
    }

    //Address field in Swing
    public static JTextField def_address(int y_axis){
        addressfield=new JTextField();
        addressfield.setFont(new Font("Tahoma", Font.PLAIN, 32));
        addressfield.setBorder(BorderFactory.createEmptyBorder(0,0,0,40));
        addressfield.setBounds(280,y_axis,700,90);
        // addressfield.setBackground(new Color(204,229,255));
        return addressfield;
    }

    //Text field capturing phone Number
    public static JTextField def_phoneNumber(int y_axis){
        phoneNumber=new JTextField();
        phoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 32));
        phoneNumber.setBorder(BorderFactory.createEmptyBorder(0,0,0,40));
        phoneNumber.setBounds(280,y_axis,700,90);
        // phoneNumber.setBackground(new Color(204,229,255));
        return phoneNumber;
    }


    //Text field for entering Email

    public static JTextField def_email(int y_axis){
        email=new JTextField();
        email.setFont(new Font("Tahoma", Font.PLAIN, 32));
        email.setBorder(BorderFactory.createEmptyBorder(0,0,0,40));
        email.setBounds(280,y_axis,700,90);
        return email;
    }

    //PASSWORD FIELD
    public static JTextField def_password(int y_axis){
        confirmpassword=new JPasswordField();
        confirmpassword.setFont(new Font("Tahoma", Font.PLAIN, 32));
        confirmpassword.setBorder(BorderFactory.createEmptyBorder(0,0,0,40));
        confirmpassword.setBounds(280,y_axis,700,90);
        return confirmpassword;
    }


    //PASSWORD FIELD
    public static JTextField def_confirmPassword(int y_axis){
        password=new JPasswordField();
        password.setFont(new Font("Tahoma", Font.PLAIN, 32));
        password.setBorder(BorderFactory.createEmptyBorder(0,0,0,40));
        password.setBounds(280,y_axis,700,90);
        //password.setEchoChar((char)0);
        return password;
    }


    //Registration Button
    public static JButton def_registerButton(){
        Register=new JButton();
        Register.setText("REGISTER");
        Register.setBounds(145,900,300,90);
        Register.setPreferredSize(new Dimension(2,9));
        Register.setFocusPainted(false);
        Register.setFont(new Font("Tahoma", Font.BOLD, 24));
        Register.addActionListener(AuthUI.al);

        return Register;
    }

    //Registration Button
    public static JButton def_Login(){
        signIn=new JButton();
        signIn.setText("BACK TO LOGIN");
        signIn.setBounds(550,900,300,90);
        signIn.setPreferredSize(new Dimension(2,9));
        signIn.setFocusPainted(false);
        signIn.setFont(new Font("Tahoma", Font.BOLD, 24));
        signIn.addActionListener(AuthUI.al);
        return signIn;
    }

    public static JLabel title(){
        JLabel label=new JLabel();
        label.setText("CREATE ACCOUNT!");
        label.setBounds(400,10,700,40);
        label.setFont(new Font("Tahoma", Font.BOLD, 32));
        return label;
    }











}
