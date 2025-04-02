package org.example;
import org.ui.AuthUI;
import org.ui.Component;

import javax.swing.*;
public class Main {
    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        new Component();

        UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");

            SwingUtilities.invokeLater(()->{new AuthUI();});


    }
}