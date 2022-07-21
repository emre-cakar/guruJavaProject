package com.guru.View;

import com.guru.Helper.Config;
import com.guru.Helper.Help;

import javax.swing.*;
import java.awt.*;

public class AlertWindow extends JFrame {

    private int width, height;
    private JPanel content;
    private JButton btnClose;
    private JLabel lblIcon, lblContent;
    private JProgressBar pgBar;
    public AlertWindow(int width,int height) {
        this.width=width;
        this.height=height;

        int xPoint=Help.screenCenter("x",new Dimension(width,height))*2-15;
        setContentPane(AlertWindow());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(xPoint,15,width,height);
        setUndecorated(true);
        setVisible(true);
    }

    private JPanel AlertWindow(){
        content=new JPanel();
        content.setBackground(Config.colorWhite);
        content.setBounds(0,0,width,height);
        content.setPreferredSize(new Dimension(width,height));
        content.setBackground(Config.colorSuccess);

        ImageIcon icon = new ImageIcon("src/guru/Icons/info50.png");
        lblIcon=new JLabel("Code");
        lblIcon.setBounds(20,20,60,60);
        lblIcon = new JLabel("", icon, JLabel.LEFT);
        lblIcon.setPreferredSize(new Dimension(60,60));
        lblIcon.setFont(new Font("Serif", Font.BOLD, 12));
        content.add(lblIcon);

        lblContent=new JLabel("Success");
        lblContent.setBounds(20,20,60,60);
        lblContent = new JLabel("", icon, JLabel.LEFT);
        lblContent.setPreferredSize(new Dimension(60,60));
        lblContent.setFont(new Font("Serif", Font.BOLD, 12));
        content.add(lblIcon);



       // content.add(panelNavbar());
        return content;
    }
}
