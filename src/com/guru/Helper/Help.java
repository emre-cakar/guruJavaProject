package com.guru.Helper;

import javax.swing.*;
import java.awt.*;

public class Help {
    public static int screenCenter(String eksen, Dimension size){
        int point=0;
        switch (eksen) {
            case "x":
                point = (Toolkit.getDefaultToolkit().getScreenSize().width - size.width) / 2;
                break;
            case "y":
                point = (Toolkit.getDefaultToolkit().getScreenSize().height - size.height) / 2;
                break;
            default:
                point = 0;
        }
        return point;
    }

    public static void showMsg(String str){
        String msg, title;
        switch (str){
            case "err":
                msg="İşlem sırasında hata meydana geldi.";
                title="ERROR";
                break;
            case "cancel":
                msg="İşlem iptal edildi";
                title="CANCEL";
                break;
            case "success":
                msg="İşlem başarılı";
                title="STATE";
                break;
            default:
                msg=str;
                title="INFO";
        }
        JOptionPane.showMessageDialog(null,msg,title,JOptionPane.INFORMATION_MESSAGE);
    }
}