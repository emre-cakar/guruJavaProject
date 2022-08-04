package com.guru.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import com.guru.help.Config;
import com.guru.help.Help;
import com.guru.model.StockType;

public class StockTypeUI extends JInternalFrame {
	private Config config;
	private JPanel pnlNavigasyon;
	private JButton btnFirst, btnBefore, btnNext, btnLast, btnSave,btnDelete;
	private JLabel lblCode, lblName, lblDecription;
	private JTextField tfCode,tfName;
	private JTextArea taDecription;
	private StockType stockTypeModel;
	

	
	public StockTypeUI() {
		config=new Config();
		initStockTypeUI();
		stockTypeModel=new StockType();
	}
	
	public void initStockTypeUI() {
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBackground(config.colorWhite);
		setBounds(100, 100, 238, 322);
		getContentPane().setLayout(null);
		
		pnlNavigasyon = new JPanel();
		pnlNavigasyon.setBounds(1, 0, 217, 28);
		pnlNavigasyon.setBackground(config.colorWhite);
		getContentPane().add(pnlNavigasyon);
		
		btnFirst = new JButton("<<");
		btnFirst.setToolTipText("İlk Kayıt");
		btnFirst.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnFirst.setPreferredSize(new Dimension(48, 20));
		btnFirst.setFont(new Font("Tahoma", Font.BOLD, 9));
		btnFirst.setFocusPainted(false);
		btnFirst.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		btnFirst.setBackground(config.colorWhite);
		pnlNavigasyon.add(btnFirst);
		
		btnBefore = new JButton("<");
		btnBefore.setToolTipText("Önceki Kayıt");
		btnBefore.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBefore.setPreferredSize(new Dimension(48, 20));
		btnBefore.setFont(new Font("Tahoma", Font.BOLD, 9));
		btnBefore.setFocusPainted(false);
		btnBefore.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		btnBefore.setBackground(config.colorWhite);
		pnlNavigasyon.add(btnBefore);
		
		btnNext = new JButton(">");
		btnNext.setToolTipText("Sonraki Kayıt");
		btnNext.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNext.setPreferredSize(new Dimension(48, 20));
		btnNext.setFont(new Font("Tahoma", Font.BOLD, 9));
		btnNext.setFocusPainted(false);
		btnNext.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		btnNext.setBackground(config.colorWhite);
		pnlNavigasyon.add(btnNext);
		
		btnLast = new JButton(">>");
		btnLast.setToolTipText("Son Kayıt");
		btnLast.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLast.setPreferredSize(new Dimension(48, 20));
		btnLast.setFont(new Font("Tahoma", Font.BOLD, 9));
		btnLast.setFocusPainted(false);
		btnLast.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		btnLast.setBackground(config.colorWhite);
		pnlNavigasyon.add(btnLast);
		
		lblCode = new JLabel("Stok Kart Tipi Kodu");
		lblCode.setBounds(11, 39, 180, 14);
		getContentPane().add(lblCode);
		lblCode.setFont(new Font("Tahoma", Font.BOLD, 10));
		
		tfCode = new JTextField();
		tfCode.setBounds(11, 55, 199, 20);
		getContentPane().add(tfCode);
		tfCode.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tfCode.setColumns(10);
		
		lblName = new JLabel("Stok Kart Tipi İsmi");
		lblName.setBounds(12, 86, 180, 14);
		getContentPane().add(lblName);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 10));
		
		tfName = new JTextField();
		tfName.setBounds(12, 102, 199, 20);
		getContentPane().add(tfName);
		tfName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tfName.setColumns(10);
		
		lblDecription = new JLabel("Stok Kart Tipi Açıklaması");
		lblDecription.setBounds(11, 133, 180, 14);
		getContentPane().add(lblDecription);
		lblDecription.setFont(new Font("Tahoma", Font.BOLD, 10));
		
		taDecription = new JTextArea();
		taDecription.setBounds(11, 149, 199, 96);
		getContentPane().add(taDecription);
		taDecription.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0,0,0)));
		
		btnSave = new JButton("Kaydet", config.saveIcon);
		btnSave.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSave.setToolTipText("Kaydet");
		btnSave.setPreferredSize(new Dimension(110, 30));
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSave.setFocusPainted(false);
		btnSave.setBackground(config.colorWhite);
		btnSave.setBounds(125, 256, 110, 30);
		getContentPane().add(btnSave);
		
		btnDelete = new JButton("Sil", config.deleteIcon);
		btnDelete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDelete.setToolTipText("Sil");
		btnDelete.setPreferredSize(new Dimension(110, 30));
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDelete.setFocusPainted(false);
		btnDelete.setBackground(config.colorWhite);
		btnDelete.setBounds(-11, 256, 110, 30);
		getContentPane().add(btnDelete);

	}

	
	public JButton getBtnFirst() {
		return btnFirst;
	}

	public void setBtnFirst(JButton btnFirst) {
		this.btnFirst = btnFirst;
	}

	public JButton getBtnBefore() {
		return btnBefore;
	}

	public void setBtnBefore(JButton btnBefore) {
		this.btnBefore = btnBefore;
	}

	public JButton getBtnNext() {
		return btnNext;
	}

	public void setBtnNext(JButton btnNext) {
		this.btnNext = btnNext;
	}

	public JButton getBtnLast() {
		return btnLast;
	}

	public void setBtnLast(JButton btnLast) {
		this.btnLast = btnLast;
	}

	public JButton getBtnSave() {
		return btnSave;
	}

	public void setBtnSave(JButton btnSave) {
		this.btnSave = btnSave;
	}

	public JButton getBtnDelete() {
		return btnDelete;
	}

	public void setBtnDelete(JButton btnDelete) {
		this.btnDelete = btnDelete;
	}

	public StockType getStockTypeModel() {
		return stockTypeModel;
	}

	public void setStockTypeModel(StockType stockTypeModel) {
		if (stockTypeModel!=null) {
			this.stockTypeModel = stockTypeModel;
		}
		
	}

	
	
	
	
	public JTextField getTfCode() {
		return tfCode;
	}

	public void setTfCode(JTextField tfCode) {
		this.tfCode = tfCode;
	}

	public void writeStockType() {
		tfCode.setText(stockTypeModel.getCode());
		tfName.setText(stockTypeModel.getName());
		taDecription.setText(stockTypeModel.getDescription());
	}
	
	public StockType prepareStockType() {
		stockTypeModel = null;
		if (isFillofUI()) {
			stockTypeModel = new StockType(1,
					tfCode.getText(), 
					tfName.getText(),
					taDecription.getText());
		}
		return stockTypeModel;
	}
	
	public boolean isFillofUI() {
		if (tfCode.getText().isEmpty()) {
			Help.showMsg("Stok Kodu alanı boş bırakılamaz");
			tfCode.requestFocusInWindow();
			return false;
		}
		if (tfName.getText().isEmpty()) {
			Help.showMsg("Stok Adı alanı boş bırakılamaz");
			tfName.requestFocusInWindow();
			return false;
		}
		if (taDecription.getText().isEmpty()) {
			Help.showMsg("Açıklama alanı boş bırakılamaz");
			taDecription.requestFocusInWindow();
			return false;
		}
		return true;
	}
	
	

}
