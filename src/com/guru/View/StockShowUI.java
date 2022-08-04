package com.guru.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import com.guru.help.Config;
import com.guru.help.Help;
import com.guru.model.Stock;

public class StockShowUI extends JInternalFrame {
	private MainFrameUI mf;
	private Stock stock;
	private Config config;
	private JPanel pnlTableData;
	private JButton btnUpdateTableData, btnExcel, btnPDF, btnMail;
	private JTextField tfSearch;
	private JTable tableData;
	private DefaultTableModel mdlTableData;
	private JPopupMenu ppm;
	private JMenuItem  miStock, miCopy, miDelete, miToExcel, miToPDF, miToMail;
	private JScrollPane jsrlPane;

	
	public StockShowUI(MainFrameUI mf) {
		this.mf=mf;
		config=new Config();
		initStockShow();
		updateDataTable();
		setVisible(true);
	}

	public void initStockShow() {
		setBackground(config.colorWhite);
		setTitle("Stok");
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(0, 0, 673, 447);
		getContentPane().setLayout(null);

		JPanel pnlButtons = new JPanel();
		pnlButtons.setBackground(config.colorWhite);
		pnlButtons.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		pnlButtons.setBounds(0, 0, 684, 50);
		pnlButtons.setLayout(null);
		getContentPane().add(pnlButtons);
		
		tfSearch = new JTextField("Ara...");
		tfSearch.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfSearch.setBounds(10, 10, 480, 29);
		pnlButtons.add(tfSearch);
		
		btnUpdateTableData = new JButton("",config.updateIcon);
		btnUpdateTableData.setToolTipText("Tabloyu Güncelle");
		btnUpdateTableData.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		btnUpdateTableData.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUpdateTableData.setFocusPainted(false);
		btnUpdateTableData.setBackground(config.colorWhite);
		btnUpdateTableData.setBounds(498, 10, 30, 30);
		btnUpdateTableData.setPreferredSize(new Dimension(30, 30));
		pnlButtons.add(btnUpdateTableData);
		
		btnExcel = new JButton("",config.excelIcon);
		btnExcel.setToolTipText("Excel Kaydet");
		btnExcel.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		btnExcel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnExcel.setFocusPainted(false);
		btnExcel.setBackground(config.colorWhite);
		btnExcel.setBounds(538, 10, 30, 30);
		btnExcel.setPreferredSize(new Dimension(30, 30));
		pnlButtons.add(btnExcel);

		btnPDF = new JButton("", config.pdfIcon);
		btnPDF.setToolTipText("PDF Kaydet");
		btnPDF.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		btnPDF.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPDF.setFocusPainted(false);
		btnPDF.setBackground(config.colorWhite);
		btnPDF.setBounds(578, 10, 30, 30);
		btnPDF.setPreferredSize(new Dimension(30,30));
		pnlButtons.add(btnPDF);
		
		btnMail = new JButton("", config.mailIcon);
		btnMail.setToolTipText("Mail Gönder");
		btnMail.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		btnMail.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnMail.setPreferredSize(new Dimension(30, 30));
		btnMail.setFocusPainted(false);
		btnMail.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		btnMail.setBackground(Color.WHITE);
		btnMail.setBounds(618, 11, 30, 30);
		pnlButtons.add(btnMail);

		
		pnlTableData = new JPanel();
		pnlTableData.setBackground(config.colorWhite);
		FlowLayout flowLayout = (FlowLayout) pnlTableData.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		flowLayout.setVgap(0);
		flowLayout.setHgap(0);
		pnlTableData.setBounds(10, 61, 637, 345);
		getContentPane().add(pnlTableData);
				mdlTableData = new DefaultTableModel();
				mdlTableData.setColumnIdentifiers(config.COLUMN_NAME);
				tableData = new JTable();
				tableData.setBackground(Color.WHITE);
				tableData.setDoubleBuffered(false);
				tableData.getTableHeader().setReorderingAllowed(false);
				tableData.setModel(mdlTableData);
				tableData.setBounds(0, 0, 630, 300);
				tableData.setPreferredSize(new Dimension(630, 285));
				tableData.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				tableData.addMouseListener((MouseListener) new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						if (SwingUtilities.isRightMouseButton(e) && e.getClickCount() == 1) {
							ppm.show(tableData, e.getX(), e.getY());
						}
					}
				});
				jsrlPane = new JScrollPane(tableData);
				pnlTableData.add(jsrlPane);
				jsrlPane.setPreferredSize(new Dimension(630, 310));
				pnlTableData.add(jsrlPane);
		
		ppm = new JPopupMenu();
		miStock = new JMenuItem("Yeni Kayıt");
		miCopy = new JMenuItem("Kopyala");
		miDelete = new JMenuItem("Sil");
		miToExcel = new JMenuItem("Excel Kaydet");
		miToPDF = new JMenuItem("PDF Kaydet");
		miToMail = new JMenuItem("Mail Gönder");
		ppm.add(miStock);
		ppm.add(miCopy);
		ppm.add(miDelete);
		ppm.add(miToExcel);
		ppm.add(miToPDF);
		ppm.add(miToMail);
	}
	
	//Getter
	public MainFrameUI getMf() {
		return mf;
	}
	public JButton getBtnUpdateTableData() {
		return btnUpdateTableData;
	}
	public JButton getBtnExcel() {
		return btnExcel;
	}
	public JButton getBtnPDF() {
		return btnPDF;
	}
	public JButton getBtnMail() {
		return btnMail;
	}
	public JMenuItem getMiStock() {
		return miStock;
	}
	public JMenuItem getMiCopy() {
		return miCopy;
	}
	public JMenuItem getMiDelete() {
		return miDelete;
	}
	public JMenuItem getMiToExcel() {
		return miToExcel;
	}
	public JMenuItem getMiToPDF() {
		return miToPDF;
	}
	public JMenuItem getMiToMail() {
		return miToMail;
	}
	public JTextField getTfSearch() {
		return tfSearch;
	}
	public void setTfSearch(String search) {
		tfSearch.setText(search);
	}

	//Methods
	public void updateDataTable() {
        stock=new Stock();
        DefaultTableModel clearModel=(DefaultTableModel) tableData.getModel();
        clearModel.setRowCount(0);
        tableData.getTableHeader().setReorderingAllowed(false);
        tableData.getSelectionModel().clearSelection();

        String aranan=(tfSearch.getText().equals("Ara..."))?"":tfSearch.getText().trim();
        for(Stock temp: stock.searchStock(aranan)){
        	mdlTableData.addRow(new Object[]{
                    temp.getCode(),
                    temp.getName(),
                    temp.getType(),
                    temp.getUnit(),
                    temp.getBarcode(),
                    temp.getVarType(),
                    temp.getDescription(),
                    new SimpleDateFormat("yyyy-MM-dd").format( new Date(temp.getCreatedDate().getTime()))
            });
        }
	}
	public String copySelectedStock() {
        int selectedRow=tableData.getSelectedRow();
        if(selectedRow>-1){
            return tableData.getValueAt(selectedRow,0).toString();
        }else{
            Help.showMsg("Lütfen bir satır seçiniz...");
        }
        return null;
	}
	public void deleteStock() {
        int selectedRow=tableData.getSelectedRow();
        if(selectedRow>-1){
        	String stockCode=tableData.getValueAt(selectedRow, 0).toString();
        	if(stock.delete(stockCode)) {
    			Help.showMsg("Kayıt silinmiştir.");
    		}else {
    			Help.showMsg("Silme işlemi sırasında bir hata meydana gelmiştir.");
    		}
        }else{
            Help.showMsg("Lütfen bir satır seçiniz...");
        }
	}
	

}
