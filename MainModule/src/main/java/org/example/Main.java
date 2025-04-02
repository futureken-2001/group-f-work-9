package org.example;

import org.ui.AuthUI;
import org.ui.Component;

import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        new Component();

        SwingUtilities.invokeLater(()->{new AuthUI();});
    }
}