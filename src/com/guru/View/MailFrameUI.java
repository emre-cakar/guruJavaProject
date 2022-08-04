package com.guru.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import com.guru.help.Config;
import com.guru.help.Mail;

public class MailFrameUI extends JInternalFrame {
	private Mail mail;
	private JLabel lblMailAdress, lblSubject, lblBody, lblSelectFile ;
	private JTextField tfMailAdress, tfMailSubject;
	private JTextArea taMailBody;
	private JButton btnCancel, btnSend , btnSelectFile;
	private Config config;

	public MailFrameUI() {
		config=new Config();
		initMailFrameUI();
		setTitle("Mail Gönder");
		setBackground(config.colorWhite);
		setBounds(100, 100, 367, 493);
		setClosable(true);
		getContentPane().setLayout(null);
		mail=new Mail();
	}

	public void initMailFrameUI() {

		lblMailAdress = new JLabel("Mail Adresi");
		lblMailAdress.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblMailAdress.setBounds(10, 11, 90, 14);
		getContentPane().add(lblMailAdress);

		tfMailAdress = new JTextField();
		tfMailAdress.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tfMailAdress.setColumns(10);
		tfMailAdress.setBounds(10, 27, 335, 20);
		getContentPane().add(tfMailAdress);

		lblSubject = new JLabel("Mail Konusu");
		lblSubject.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblSubject.setBounds(10, 58, 90, 14);
		getContentPane().add(lblSubject);

		tfMailSubject = new JTextField();
		tfMailSubject.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tfMailSubject.setColumns(10);
		tfMailSubject.setBounds(10, 74, 335, 20);
		getContentPane().add(tfMailSubject);

		lblBody = new JLabel("Mail İçeriği");
		lblBody.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblBody.setBounds(10, 105, 90, 14);
		getContentPane().add(lblBody);

		taMailBody = new JTextArea();
		taMailBody.setBounds(10, 120, 331, 240);
		taMailBody.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		getContentPane().add(taMailBody);
		
		lblSelectFile = new JLabel("Dosya Eki");
		lblSelectFile.setEnabled(false);
		lblSelectFile.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSelectFile.setBounds(10, 371, 331, 30);
		lblSelectFile.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		getContentPane().add(lblSelectFile);
		
		btnSelectFile = new JButton("Dosya Seç", null);
		btnSelectFile.setToolTipText("Dosya seçimini yapınız");
		btnSelectFile.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSelectFile.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSelectFile.setFocusPainted(false);
		btnSelectFile.setBackground(config.colorWhite);
		btnSelectFile.setBounds(212, 371, 129, 30);
		btnSelectFile.setPreferredSize(new Dimension(110, 30));
		getContentPane().add(btnSelectFile);
		

		btnCancel = new JButton("İptal", config.cancelIcon);
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCancel.setToolTipText("İptal et");
		btnCancel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancel.setBounds(10, 412, 161, 40);
		btnCancel.setPreferredSize(new Dimension(110, 30));
		btnCancel.setFocusPainted(false);
		btnCancel.setBackground(config.colorWhite);
		getContentPane().add(btnCancel);

		btnSend = new JButton("Mail Gönder", config.mailIcon);
		btnSend.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSend.setToolTipText("Mail Gönder");
		btnSend.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSend.setBounds(180, 412, 161, 40);
		btnSend.setPreferredSize(new Dimension(110, 30));
		btnSend.setFocusPainted(false);
		btnSend.setBackground(config.colorWhite);
		getContentPane().add(btnSend);

	}

	public JTextField getTfMailAdress() {
		return tfMailAdress;
	}

	public JTextField getTfMailSubject() {
		return tfMailSubject;
	}

	public JTextArea getTaMailBody() {
		return taMailBody;
	}

	public JButton getBtnCancel() {
		return btnCancel;
	}

	public JButton getBtnSend() {
		return btnSend;
	}

	public JLabel getLblSelectFile() {
		return lblSelectFile;
	}

	public void setLblSelectFile(String s) {
		lblSelectFile.setText(s);
	}

	public JButton getBtnSelectFile() {
		return btnSelectFile;
	}

	public Mail getMail() {
		return mail;
	}



}
