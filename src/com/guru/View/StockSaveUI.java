package com.guru.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import com.guru.help.Config;
import com.guru.help.Help;
import com.guru.model.Stock;
import com.guru.model.StockType;
import com.toedter.calendar.JDateChooser;

public class StockSaveUI extends JInternalFrame {
	private Stock stock;
	private MainFrameUI mf;
	private Config config;
	private JPanel pnlButtons;
	private JLabel lblCode, lblName, lblType, lblUnit, lblBarcode, lblVar, lblDescription, lblDateTime;
	private JTextField tfCode, tfName, tfBarcode;
	private JTextArea taDescription;
	private JComboBox<StockType> cmbType; 
	private JComboBox<String> cmbUnit;
	private JComboBox<Double> cmbVar;
	private JButton btnCancel, btnDelete, btnSave;
	private JPanel panel;
	private JButton btnFirst;
	private JButton btnBefore;
	private JButton btnNext;
	private JButton btnLast;
	private JDateChooser dateChooser;

	public StockSaveUI(MainFrameUI mf) {
		this.mf = mf;
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		config = new Config();
		initStockSaveUI();
		setVisible(true);
		stock=new Stock();
	}

	// Getters
	public MainFrameUI getMf() {
		return mf;
	}

	public JTextField getTfCode() {
		return tfCode;
	}

	public void setTfCode(String tfCode) {
		this.tfCode.setText(tfCode); 
	}

	public JButton getBtnCancel() {
		return btnCancel;
	}

	public JButton getBtnDelete() {
		return btnDelete;
	}

	public JButton getBtnSave() {
		return btnSave;
	}

	public JButton getBtnFirst() {
		return btnFirst;
	}

	public JButton getBtnBefore() {
		return btnBefore;
	}

	public JButton getBtnNext() {
		return btnNext;
	}

	public JButton getBtnLast() {
		return btnLast;
	}

	
	// Methods

	public Stock getStock() {
		return stock;
	}
	public void setStock(Stock s) {
		if (s!=null) {
		this.stock=s;
		}
	}

	public void initStockSaveUI() {
		setBackground(config.colorWhite);
		setBounds(100, 100, 371, 523);
		getContentPane().setLayout(null);

		lblCode = new JLabel("Stok Kodu");
		lblCode.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblCode.setBounds(10, 11, 90, 14);
		getContentPane().add(lblCode);

		tfCode = new JTextField();
		// tfCode.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		tfCode.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tfCode.setBounds(10, 27, 335, 20);
		getContentPane().add(tfCode);
		tfCode.setColumns(10);

		lblName = new JLabel("Stok Adı");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblName.setBounds(10, 58, 90, 14);
		getContentPane().add(lblName);

		tfName = new JTextField();
		tfName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		// tfName.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		tfName.setColumns(10);
		tfName.setBounds(10, 74, 335, 20);
		getContentPane().add(tfName);

		lblBarcode = new JLabel("Barkod");
		lblBarcode.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblBarcode.setBounds(10, 204, 90, 14);
		getContentPane().add(lblBarcode);

		tfBarcode = new JTextField();
		tfBarcode.setFont(new Font("Tahoma", Font.PLAIN, 12));
		// tfBarcode.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		tfBarcode.setColumns(10);
		tfBarcode.setBounds(10, 220, 335, 20);
		getContentPane().add(tfBarcode);

		lblType = new JLabel("Stok Tipi");
		lblType.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblType.setBounds(10, 104, 90, 14);
		getContentPane().add(lblType);

		cmbType = new JComboBox<StockType>();
		StockType st=new StockType();
		ArrayList <StockType> stl =st.getStockTypeList();
		
		for (int i = 0; i < stl.size(); i++) {
			cmbType.addItem(stl.get(i));
		}
		cmbType.setBounds(10, 121, 335, 22);
		getContentPane().add(cmbType);

		lblUnit = new JLabel("Stok Birimi");
		lblUnit.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblUnit.setBounds(10, 154, 90, 14);
		getContentPane().add(lblUnit);

		cmbUnit = new JComboBox<String>();
		cmbUnit.setBounds(10, 171, 335, 22);
		cmbUnit.addItem("TL");
		cmbUnit.addItem("Usd");
		cmbUnit.addItem("Euro");
		getContentPane().add(cmbUnit);

		lblVar = new JLabel("KDV");
		lblVar.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblVar.setBounds(10, 251, 90, 14);
		getContentPane().add(lblVar);

		cmbVar = new JComboBox<Double>();
		cmbVar.setBounds(10, 268, 335, 22);
		cmbVar.addItem(0.08);
		cmbVar.addItem(0.10);
		cmbVar.addItem(0.18);
		getContentPane().add(cmbVar);

		lblDescription = new JLabel("Açıklama");
		lblDescription.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblDescription.setBounds(10, 301, 90, 14);
		getContentPane().add(lblDescription);

		taDescription = new JTextArea();
		taDescription.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		taDescription.setBounds(10, 318, 335, 67);
		getContentPane().add(taDescription);

		lblDateTime = new JLabel("Tarih");
		lblDateTime.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblDateTime.setBounds(10, 396, 46, 14);
		getContentPane().add(lblDateTime);

		Calendar cld = Calendar.getInstance();
		dateChooser = new JDateChooser(cld.getTime());
		dateChooser.setBounds(10, 411, 335, 20);
		getContentPane().add(dateChooser);

		pnlButtons = new JPanel();
		pnlButtons.setBackground(config.colorWhite);
		pnlButtons.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		pnlButtons.setBorder(new MatteBorder(1, 0, 0, 0, (Color) new Color(0, 0, 0)));
		pnlButtons.setBounds(0, 450, 368, 44);
		getContentPane().add(pnlButtons);

		btnCancel = new JButton("İptal", config.cancelIcon);
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCancel.setToolTipText("İptal et");
		btnCancel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancel.setPreferredSize(new Dimension(110, 30));
		btnCancel.setFocusPainted(false);
		btnCancel.setBackground(config.colorWhite);
		pnlButtons.add(btnCancel);

		btnDelete = new JButton("Sil", config.deleteIcon);
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDelete.setToolTipText("Sil");
		btnDelete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDelete.setPreferredSize(new Dimension(110, 30));
		btnDelete.setFocusPainted(false);
		btnDelete.setBackground(config.colorWhite);
		pnlButtons.add(btnDelete);

		btnSave = new JButton("Kaydet", config.saveIcon);
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSave.setToolTipText("Kaydet");
		btnSave.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSave.setPreferredSize(new Dimension(110, 30));
		btnSave.setFocusPainted(false);
		btnSave.setBackground(config.colorWhite);
		pnlButtons.add(btnSave);

		panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		flowLayout.setVgap(0);
		flowLayout.setHgap(0);
		panel.setBounds(153, 5, 192, 20);
		getContentPane().add(panel);

		btnFirst = new JButton("<<");
		btnFirst.setToolTipText("İlk Kayıt");
		btnFirst.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnFirst.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		btnFirst.setFocusPainted(false);
		btnFirst.setFont(new Font("Tahoma", Font.BOLD, 9));
		btnFirst.setBackground(config.colorWhite);
		btnFirst.setPreferredSize(new Dimension(48, 20));
		panel.add(btnFirst);

		btnBefore = new JButton("<");
		btnBefore.setToolTipText("Önceki Kayıt");
		btnBefore.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBefore.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		btnBefore.setFocusPainted(false);
		btnBefore.setFont(new Font("Tahoma", Font.BOLD, 9));
		btnBefore.setBackground(config.colorWhite);
		btnBefore.setPreferredSize(new Dimension(48, 20));
		panel.add(btnBefore);

		btnNext = new JButton(">");
		btnNext.setToolTipText("Sonraki Kayıt");
		btnNext.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNext.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		btnNext.setFocusPainted(false);
		btnNext.setFont(new Font("Tahoma", Font.BOLD, 9));
		btnNext.setBackground(config.colorWhite);
		btnNext.setPreferredSize(new Dimension(48, 20));
		panel.add(btnNext);

		btnLast = new JButton(">>");
		btnLast.setToolTipText("Son Kayıt");
		btnLast.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLast.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		btnLast.setFocusPainted(false);
		btnLast.setFont(new Font("Tahoma", Font.BOLD, 9));
		btnLast.setBackground(config.colorWhite);
		btnLast.setPreferredSize(new Dimension(48, 20));
		panel.add(btnLast);

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
		if (tfBarcode.getText().isEmpty()) {
			Help.showMsg("Barkod alanı boş bırakılamaz");
			tfBarcode.requestFocusInWindow();
			return false;
		}
		if (taDescription.getText().isEmpty()) {
			Help.showMsg("Açıklama alanı boş bırakılamaz");
			taDescription.requestFocusInWindow();
			return false;
		}
		return true;
	}

	public void writeStockCode(String stockCode) {
		tfCode.setText(stockCode);
	}
	public void writeStockCode() {
		StockType st=new StockType();
		st.setId(stock.getType());
		st=st.getStockTypeItem(st);
		tfCode.setText(stock.getCode());
		tfName.setText(stock.getName());
		for(int i=0;i<cmbType.getItemCount();i++) {
			if ( cmbType.getItemAt(i).getName().equals(st.getName())) {
				cmbType.setSelectedItem(cmbType.getItemAt(i));
				break;
			}
		}
		cmbUnit.setSelectedItem(stock.getUnit());
		tfBarcode.setText(stock.getBarcode());
		cmbVar.setSelectedItem(stock.getVarType());
		taDescription.setText(stock.getDescription());
		dateChooser.setDate(stock.getCreatedDate());
	}

	public Stock prepareStock() {
		stock = null;
		if (isFillofUI()) {
			StockType item=(StockType)(cmbType.getSelectedItem());
			
			stock = new Stock(
					tfCode.getText(), 
					tfName.getText(),
					item.getId(), 
					cmbUnit.getSelectedItem().toString(),
					tfBarcode.getText(), 
					Double.parseDouble(cmbVar.getSelectedItem().toString()),
					taDescription.getText(),
					new java.sql.Date(dateChooser.getDate().getTime()));
		}
		return stock;
	}

	public void SetFocusOFTfCode() {
		stock = new Stock();
		if (tfCode.getText().trim().length() > 0) {
			stock = stock.getStock(tfCode.getText().trim());
			StockType st=new StockType();
			st.setId(stock.getType());
			st=st.getStockTypeItem(st);
			
			
			if (stock != null) {
				//StockType item=(StockType)(stock.getType());
				tfCode.setEnabled(false);
				tfName.setText(stock.getName());
				for(int i=0;i<cmbType.getItemCount();i++) {
					if ( cmbType.getItemAt(i).getName().equals(st.getName())) {
						cmbType.setSelectedItem(cmbType.getItemAt(i));
						break;
					}
				}
				cmbUnit.setSelectedItem(stock.getUnit());
				tfBarcode.setText(stock.getBarcode());
				cmbVar.setSelectedItem(stock.getVarType());
				taDescription.setText(stock.getDescription());
				dateChooser.setDate(stock.getCreatedDate());
			}
		}
	}
}
