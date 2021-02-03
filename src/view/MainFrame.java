package view;

import javax.swing.*;

public class MainFrame extends JFrame {

    public MainFrame(LoginPanel loginpanel) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("OnlineStore");
        setLocation(100, 100);
        setContentPane(loginpanel);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
       LoginPanel lp = new LoginPanel();
    }
}

