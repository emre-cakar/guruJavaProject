package com.guru.Helper;

import java.awt.*;

public class Config {
    public static final String PROJECT_TITLE="Stock Control";
    public static final String DB_URL="jdbc:mysql://localhost:3306/guru";
    public static final String DB_USER="root";
    public static final String DB_PASSWORD="";

    public static final Color colorBg=new Color(65,165,184);
    public static final  Color colorWhite=new Color(255,255,255);
    public static final Color colorInfo=new Color(0, 123, 255);
    public static final Color colorSuccess=new Color(40, 167, 69);
    public static final Color colorDanger=new Color(220, 53, 69);

    public static final String [] COLUMN_NAME={"Code","Name","Type","Unit","Barcode","VarType","Description","CreatedTime"};

}
