package com.guru.help;

import java.awt.Color;

import javax.swing.ImageIcon;

public class Config {
	public final String PROJECT_TITLE = "Stock Control";
	public final String DB_URL = "jdbc:mysql://localhost:3306/guru";
	public final String DB_USER = "root";
	public final String DB_PASSWORD = "";

	//Color
	public final Color colorBg = new Color(65, 165, 184);
	public final Color colorWhite = new Color(255, 255, 255);
	public final Color colorInfo = new Color(0, 123, 255);
	public final Color colorSuccess = new Color(40, 167, 69);
	public final Color colorDanger = new Color(220, 53, 69);

	public final String[] COLUMN_NAME = { "Kodu", "Adı", "Tipi", "Birim", "Barkod", "KDV", "Açıklama",
			"Tarihi" };

	//Icon
	public final ImageIcon addIcon = new ImageIcon("icon\\add24.png");
	public final ImageIcon copyIcon = new ImageIcon("icon\\copy24.png");
	public final ImageIcon deleteIcon = new ImageIcon("icon\\delete24.png");
	public final ImageIcon cancelIcon = new ImageIcon("icon\\cancel24.png");
	public final ImageIcon saveIcon = new ImageIcon("icon\\save24.png");
	public final ImageIcon excelIcon = new ImageIcon("icon\\excel32.png");
	public final ImageIcon pdfIcon = new ImageIcon("icon\\pdf32.png");
	public final ImageIcon mailIcon = new ImageIcon("icon\\mail32.png");
	public final ImageIcon updateIcon = new ImageIcon("icon\\update32.png");

	
	//For mail setting 
	public final String mailHost = "smtp.yandex.com";
	public final String mailPort = "587";
	public final String mailUser = "guruEmre@yandex.com";
	public final String mailPassword = "qjasldbrvolzzdan";

}
