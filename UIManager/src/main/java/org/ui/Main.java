package org.ui;

import org.database.DatabaseConnect;

import javax.swing.*;
import java.rmi.server.Skeleton;
import java.sql.Connection;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

new Component();

SwingUtilities.invokeLater(()->{new AuthUI();});




    }
}