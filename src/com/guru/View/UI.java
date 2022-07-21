package com.guru.View;
import com.guru.Helper.Help;
import com.mysql.cj.jdbc.result.UpdatableResultSet;
import com.toedter.calendar.JDateChooser;
import com.guru.Helper.Config;
import com.guru.Model.Stock;
import com.guru.Model.StockManager;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class UI extends JFrame {

    private int width, height;

    private Stock stock=null;

    private JPanel pnlWrapper, pnlHeader, pnlNavbar,pnlHR,pnlContentTable,pnlTable, pnlContentArea;
    private JLabel lblHeader,lblCode,lblName,lblType,lblUnit,lblBarcode,lblVar,lblDescription,lblDateTime;
    private JButton btnClose, btnAdd, btnCopy, btnUpdate, btnDelete, btnCancel, btnSave;
    private ImageIcon iconClose, iconAdd, iconCopy,iconUpdate,iconDelete, iconCancel, iconSave;
    private JTextField tfSearch,tfCode,tfName,tfBarcode,tfDateTime;
    private JTable dataTable;
    private JComboBox cmbxType,cmbxUnit,cmbxVar;
    private JTextArea taDescription;
    private DefaultTableModel mdl_stockList;
    private JPopupMenu pm;
    private JDateChooser dateChooser;


    public UI(int width, int height) {
        this.width=width;
        this.height=height;

        setContentPane(panelWrapper());
        setSize(width,height);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        tfSearch.setText("Search...");
    }

    private JPanel panelWrapper(){
        pnlWrapper=new JPanel();
        pnlWrapper.setBackground(Config.colorWhite);
        pnlWrapper.setBounds(0,0,width,height);
        pnlWrapper.setPreferredSize(new Dimension(width,height));

        //   pnlWrapper.add(panelHeader());
        pnlWrapper.add(panelNavbar());
        pnlWrapper.add(panelHR());
        pnlWrapper.add(panelContentTable());
        pnlWrapper.add(panelContentArea());

        return pnlWrapper;
    }

    private JPanel panelHeader(){
        pnlHeader=new JPanel();
        pnlHeader.setBackground(Config.colorBg);
        pnlHeader.setBounds(0,0,width,34);
        pnlHeader.setPreferredSize(new Dimension(width,34));

        lblHeader=new JLabel(Config.PROJECT_TITLE);
        lblHeader.setFont(new Font("Arial", Font.BOLD, 18));
        lblHeader.setForeground(Config.colorWhite);
        lblHeader.setBounds(0,0,0,34);
        lblHeader.setPreferredSize(new Dimension(pnlHeader.getWidth()*90/100, 34));
        pnlHeader.add(lblHeader);

        iconClose = new ImageIcon("Icons/close.png");
        btnClose=new JButton("x",iconClose);
        btnClose.setBounds(width-34,0,34,34);
        btnClose.setPreferredSize(new Dimension(34, 34));
        btnClose.setOpaque(false);
        btnClose.setContentAreaFilled(false);
        btnClose.setBorderPainted(false);
        pnlHeader.add(btnClose);

        return pnlHeader;
    }

    private  JPanel panelNavbar(){
        pnlNavbar=new JPanel();
        pnlNavbar.setBackground(Config.colorWhite);
        pnlNavbar.setBounds(0,0,width,45);
        pnlNavbar.setPreferredSize(new Dimension(width,45));

        iconAdd = new ImageIcon("Icons/add24.png");
        btnAdd=new JButton("Stock",iconAdd);
        btnAdd.setFont(new Font("Arial", Font.BOLD, 18));
        btnAdd.setBounds(0,0,75,30);
        btnAdd.setPreferredSize(new Dimension(150,40));
        btnAdd.setBackground(Config.colorWhite);
        btnAdd.setFocusPainted(false);
        btnAdd.setHorizontalAlignment(SwingConstants.LEFT);
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeJPanelVisible(pnlContentTable,pnlContentArea);
                clearAllFields();
            }
        });

        pnlNavbar.add(btnAdd);

        iconCopy = new ImageIcon("Icons/copy24.png");
        btnCopy=new JButton("Copy",iconCopy);
        btnCopy.setFont(new Font("Arial", Font.BOLD, 18));
        btnCopy.setBounds(0,0,75,30);
        btnCopy.setPreferredSize(new Dimension(150,40));
        btnCopy.setBackground(Config.colorWhite);
        btnCopy.setFocusPainted(false);
        btnCopy.setHorizontalAlignment(SwingConstants.LEFT);
        btnCopy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(dataTable.getSelectedRow()>-1){
                    copySelectedStock(dataTable.getSelectedRow());
                }else{
                    Help.showMsg("Please, select row...");
                }
            }
        });
        pnlNavbar.add(btnCopy);




        return pnlNavbar;
    }

    private JPanel panelHR(){
        pnlHR=new JPanel();
        pnlHR.setBackground(Config.colorBg);
        pnlHR.setBounds(60,60,width,1);
        pnlHR.setPreferredSize(new Dimension(width,1));

        return pnlHR;
    }

    private JPanel panelContentTable(){
        pnlContentTable=new JPanel();
        pnlContentTable.setVisible(true);
        pnlContentTable.setBackground(Config.colorWhite);
        pnlContentTable.setBounds(0,75,width,450);
        pnlContentTable.setPreferredSize(new Dimension(width,580));

        tfSearch=new JTextField();
        tfSearch.setBounds(0,0,width*90/100,36);
        tfSearch.setPreferredSize(new Dimension(width*90/100, 36));
        tfSearch.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                tfSearch.setText(null);
                dataTable.getSelectionModel().clearSelection();
            }
            @Override
            public void focusLost(FocusEvent e) {
                if(tfSearch.getText().isEmpty()){
                    updateTable();
                    tfSearch.setText("Search...");


                }
            }
        });


        tfSearch.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                updateTable();
            }
        });


        pnlContentTable.add(tfSearch);

        pnlTable=new JPanel();
        pnlTable.setBackground(Config.colorWhite);
        pnlTable.setBounds(0,75,width,450);
        pnlTable.setPreferredSize(new Dimension(width,450));
        pnlContentTable.add(pnlTable);



        dataTable=new JTable();
        dataTable.setDoubleBuffered(false);
        mdl_stockList=new DefaultTableModel();
        mdl_stockList.setColumnIdentifiers(Config.COLUMN_NAME);
        dataTable.getTableHeader().setReorderingAllowed(false);
        updateTable();
        dataTable.setModel(mdl_stockList);
        dataTable.setBounds(350,60,width*90/100,425);
        dataTable.setPreferredSize(new Dimension(width*90/100, 425));
        dataTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        pm=new JPopupMenu();
        JMenuItem add=new JMenuItem("Stock");
        JMenuItem copy=new JMenuItem("Copy");
        JMenuItem info=new JMenuItem("Info");
        JMenuItem delete=new JMenuItem("Delete");
        pm.add(add);
        pm.add(copy);
        pm.add(info);
        pm.add(delete);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeJPanelVisible(pnlContentTable,pnlContentArea);
                clearAllFields();
            }
        });
        copy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(dataTable.getSelectedRow()>-1){
                    copySelectedStock(dataTable.getSelectedRow());
                }else{
                    Help.showMsg("Please, select row...");
                }
            }
        });
        info.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(dataTable.getSelectedRow()>-1){
                    clearAllFields();
                    tfCode.setText(dataTable.getValueAt(dataTable.getSelectedRow(),0).toString());
                    Stock stock=StockManager.isThereByCode(tfCode.getText().toString());
                    if(stock!=null) {
                        tfCode.setFocusable(false);
                        tfCode.setEnabled(false);
                        tfName.setText(stock.getName());
                        cmbxType.setSelectedItem(stock.getType());
                        cmbxUnit.setSelectedItem(stock.getUnit());
                        tfBarcode.setText(stock.getBarcode());
                        cmbxVar.setSelectedItem(stock.getVarType());
                        taDescription.setText(stock.getDescription());
                        Date date = null;
                        try {
                            date = new SimpleDateFormat("yyyy-MM-dd").parse(stock.getCreatedDate());
                        } catch (ParseException ex) {
                            ex.printStackTrace();
                        }
                        dateChooser.setDate(date);
                    }
                    changeJPanelVisible(pnlContentTable,pnlContentArea);
                    tfName.requestFocusInWindow();
                }else{
                    Help.showMsg("Please, select row...");
                }
            }
        });


        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(dataTable.getSelectedRow()>-1){
                    tfSearch.setText(null);
                    StockManager.delete(dataTable.getValueAt(dataTable.getSelectedRow(),0).toString());
                    updateTable();
                    tfSearch.setText("Search");
                    Help.showMsg("Record is deleted.");
                }else{
                    Help.showMsg("Please, select row...");
                }
            }
        });
        dataTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e) && e.getClickCount() == 1) {
                    pm.show(dataTable,e.getX(),e.getY());
                }
            }
        });



        JScrollPane js=new JScrollPane(dataTable);
        js.setBounds(350,60,width*90/100,450);
        js.setPreferredSize(new Dimension(width*90/100, 450));
        pnlTable.add(js);

        pnlContentTable.add(pnlTable);

        return pnlContentTable;

    }

    private JPanel panelContentArea(){
        pnlContentArea=new JPanel();
        pnlContentArea.setBackground(Config.colorWhite);
        pnlContentArea.setBounds(0,75,width*90/100,500);
        pnlContentArea.setPreferredSize(new Dimension(width*90/100,580));
        pnlContentArea.setVisible(false);


        lblCode=new JLabel("Code");
        lblCode.setBounds(20,10,width*90/100,16);
        lblCode.setPreferredSize(new Dimension(width*90/100,16));
        lblCode.setFont(new Font("Serif", Font.BOLD, 12));
        pnlContentArea.add(lblCode);

        tfCode=new JTextField();
        tfCode.setBounds(20,28,width*90/100,32);
        tfCode.setPreferredSize(new Dimension(width*90/100,32));
        tfCode.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (tfCode.getText().length() >= 50 ) // limit to 3 characters
                    e.consume();
            }
        });
        tfCode.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                if (tfCode.getText().trim().length()>0){
                    Stock stock=StockManager.isThereByCode(tfCode.getText().toString());
                    if(stock!=null){
                        tfCode.setFocusable(false);
                        tfCode.setEnabled(false);
                        tfName.setText(stock.getName());
                        cmbxType.setSelectedItem(stock.getType());
                        cmbxUnit.setSelectedItem(stock.getUnit());
                        tfBarcode.setText(stock.getBarcode());
                        cmbxVar.setSelectedItem(stock.getVarType());
                        taDescription.setText(stock.getDescription());
                        Date date = null;
                        try {
                            date = new SimpleDateFormat("yyyy-MM-dd").parse(stock.getCreatedDate());
                        } catch (ParseException ex) {
                            ex.printStackTrace();
                        }
                        dateChooser.setDate(date);
                    }
                }
            }
        });
        pnlContentArea.add(tfCode);



        lblName=new JLabel("Name");
        lblName.setBounds(20,32,width*90/100,16);
        lblName.setPreferredSize(new Dimension(width*90/100,16));
        lblName.setFont(new Font("Serif", Font.BOLD, 12));
        pnlContentArea.add(lblName);

        tfName=new JTextField();
        tfName.setBounds(20,78,width*90/100,32);
        tfName.setPreferredSize(new Dimension(width*90/100,32));
        tfName.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (tfCode.getText().length() >= 100 ) // limit to 3 characters
                    e.consume();
            }
        });
        pnlContentArea.add(tfName);



        lblType=new JLabel("Type");
        lblType.setBounds(20,110,width*90/100,16);
        lblType.setPreferredSize(new Dimension(width*90/100,16));
        lblType.setFont(new Font("Serif", Font.BOLD, 12));
        pnlContentArea.add(lblType);

        cmbxType=new JComboBox();
        for (int i=1;i<=100;i++){
            cmbxType.addItem(i);
        }
        cmbxType.setBounds(20,128,width*90/100,32);
        cmbxType.setPreferredSize(new Dimension(width*90/100,32));
        pnlContentArea.add(cmbxType);




        lblUnit=new JLabel("Unit");
        lblUnit.setBounds(20,160,width*90/100,16);
        lblUnit.setPreferredSize(new Dimension(width*90/100,16));
        lblUnit.setFont(new Font("Serif", Font.BOLD, 12));
        pnlContentArea.add(lblUnit);

        cmbxUnit=new JComboBox();
        cmbxUnit.addItem("TL");
        cmbxUnit.addItem("Usd");
        cmbxUnit.addItem("Euro");
        cmbxUnit.setBounds(20,178,width*90/100,32);
        cmbxUnit.setPreferredSize(new Dimension(width*90/100,32));
        pnlContentArea.add(cmbxUnit);



        lblBarcode=new JLabel("Barcode");
        lblBarcode.setBounds(20,210,width*90/100,16);
        lblBarcode.setPreferredSize(new Dimension(width*90/100,16));
        lblBarcode.setFont(new Font("Serif", Font.BOLD, 12));
        pnlContentArea.add(lblBarcode);

        tfBarcode=new JTextField();
        tfBarcode.setBounds(20,228,width*90/100,32);
        tfBarcode.setPreferredSize(new Dimension(width*90/100,32));
        pnlContentArea.add(tfBarcode);




        lblVar=new JLabel("VarType");
        lblVar.setBounds(20,260,width*90/100,16);
        lblVar.setFont(new Font("Serif", Font.BOLD, 12));
        lblVar.setPreferredSize(new Dimension(width*90/100,16));
        pnlContentArea.add(lblVar);

        cmbxVar=new JComboBox();
        cmbxVar.addItem(0.08);
        cmbxVar.addItem(0.10);
        cmbxVar.addItem(0.18);
        cmbxVar.setBounds(20,278,width*90/100,32);
        cmbxVar.setPreferredSize(new Dimension(width*90/100,32));
        pnlContentArea.add(cmbxVar);



        lblDescription=new JLabel("Description");
        lblDescription.setBounds(20,310,width*90/100,16);
        lblDescription.setPreferredSize(new Dimension(width*90/100,16));
        lblDescription.setFont(new Font("Serif", Font.BOLD, 12));
        pnlContentArea.add(lblDescription);

        taDescription=new JTextArea();
        taDescription.setBounds(20,328,width*90/100,64);
        taDescription.setPreferredSize(new Dimension(width*90/100,64));
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        taDescription.setBorder(BorderFactory.createCompoundBorder(border,
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        pnlContentArea.add(taDescription);


        lblDateTime=new JLabel("Created Date");
        lblDateTime.setBounds(20,400,width*90/100,16);
        lblDateTime.setPreferredSize(new Dimension(width*90/100,16));
        lblDateTime.setFont(new Font("Serif", Font.BOLD, 12));
        pnlContentArea.add(lblDateTime);


        Calendar cld=Calendar.getInstance();
        dateChooser=new JDateChooser(cld.getTime());
        dateChooser.setLocale(Locale.ENGLISH);
        dateChooser.setDateFormatString("yyyy-MM-dd");

        dateChooser.setBounds(20,418,width*90/100,32);
        dateChooser.setPreferredSize(new Dimension(width*90/100,32));
        pnlContentArea.add(dateChooser);


        iconCancel = new ImageIcon("Icons/cancel24.png");
        btnCancel=new JButton("Cancel",iconCancel);
        btnCancel.setFont(new Font("Arial", Font.BOLD, 18));
        btnCancel.setBounds(20, 430,75,30);
        btnCancel.setPreferredSize(new Dimension(150,40));
        btnCancel.setBackground(Config.colorWhite);
        btnCancel.setFocusPainted(false);
        btnCancel.setHorizontalAlignment(SwingConstants.LEFT);
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfCode.setFocusable(true);
                tfCode.setEnabled(true);
                dataTable.getSelectionModel().clearSelection();
                changeJPanelVisible(pnlContentTable,pnlContentArea);
                tfSearch.setText(null);
                updateTable();
                tfSearch.setText("Search...");
                Help.showMsg("cancel");
            }
        });
        pnlContentArea.add(btnCancel);

        iconDelete = new ImageIcon("Icons/delete24.png");
        btnDelete=new JButton("Delete",iconDelete);
        btnDelete.setFont(new Font("Arial", Font.BOLD, 18));
        btnDelete.setBounds(20,430,75,30);
        btnDelete.setPreferredSize(new Dimension(150,40));
        btnDelete.setBackground(Config.colorWhite);
        btnDelete.setFocusPainted(false);
        btnDelete.setHorizontalAlignment(SwingConstants.LEFT);
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!tfCode.isEnabled()){
                    StockManager.delete(tfCode.getText());
                    tfSearch.setText(null);
                    updateTable();
                    tfSearch.setText("Search...");
                    Help.showMsg("Record is deleted.");
                    changeJPanelVisible(pnlContentTable,pnlContentArea);
                    clearAllFields();
                }else{
                    Help.showMsg("Not found record...");
                }
            }
        });
        pnlContentArea.add(btnDelete);

        iconSave = new ImageIcon("Icons/save24.png");
        btnSave=new JButton("Save",iconSave);
        btnSave.setFont(new Font("Arial", Font.BOLD, 18));
        btnSave.setBounds(20, 430,75,30);
        btnSave.setPreferredSize(new Dimension(150,40));
        btnSave.setBackground(Config.colorWhite);
        btnSave.setFocusPainted(false);
        btnSave.setHorizontalAlignment(SwingConstants.LEFT);

        stock=new Stock();
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(tfCode.getText().isEmpty() ){
                    Help.showMsg("Code alanı boş bırakılamaz");
                    tfCode.requestFocusInWindow();
                    return;
                }else{
                    stock.setCode(tfCode.getText());
                }
                if(tfName.getText().isEmpty() ){
                    Help.showMsg("Name alanı boş bırakılamaz");
                    tfName.requestFocusInWindow();
                    return;
                }else{
                    stock.setName(tfName.getText());
                }
                if(tfBarcode.getText().isEmpty()){
                    Help.showMsg("Barcode alanı boş bırakılamaz");
                    tfBarcode.requestFocusInWindow();
                    return;
                }else{
                    stock.setBarcode(tfBarcode.getText());
                }
                if(taDescription.getText().isEmpty()){
                    Help.showMsg("Description alanı boş bırakılamaz");
                    taDescription.requestFocusInWindow();
                    return;
                }else{
                    stock.setDescription(taDescription.getText());
                }
                DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
                stock.setCreatedDate(df.format(dateChooser.getDate()));
                stock.setType((int) cmbxType.getSelectedItem());
                stock.setVarType((double)cmbxVar.getSelectedItem());
                stock.setUnit((String) cmbxUnit.getSelectedItem());

                if(tfCode.isEnabled()){
                    if(StockManager.add(stock)){
                        Help.showMsg("success");
                    }else{
                        Help.showMsg("err");
                    }
                }else{
                    if(StockManager.update(stock)){
                        Help.showMsg("success");
                    }else{
                        Help.showMsg("err");
                    }
                }
                tfSearch.setText(null);
                updateTable();
                tfSearch.setText("Search...");
                changeJPanelVisible(pnlContentTable,pnlContentArea);
                tfCode.setFocusable(true);
                tfCode.setEnabled(true);
            }
        });
        pnlContentArea.add(btnSave);

        return pnlContentArea;
    }

    private void fillCompanentArea(Stock s){

    }
    private void clearAllFields() {
        Component[] components = pnlContentArea.getComponents();
        for (Component component: components) {
            if(component instanceof JTextField) {
                ((JTextField) component).setText("");
            }else if(component instanceof JTextArea) {
                ((JTextArea) component).setText("");
            }
        }
    }
    private void btnSetVisible(){
        Component[] components = pnlNavbar.getComponents();
        for (Component component: components) {
            if(component instanceof JButton) {
                component.setEnabled(component.isEnabled()?false:true);
            }
        }
    }
    private void updateTable(){
        DefaultTableModel clearModel=(DefaultTableModel) dataTable.getModel();
        clearModel.setRowCount(0);

        dataTable.getTableHeader().setReorderingAllowed(false);
        dataTable.getSelectionModel().clearSelection();
        for(Stock stock: StockManager.getListByCode(tfSearch.getText().trim())){
            mdl_stockList.addRow(new Object[]{
                    stock.getCode(),
                    stock.getName(),
                    stock.getType(),
                    stock.getUnit(),
                    stock.getBarcode(),
                    stock.getVarType(),
                    stock.getDescription(),
                    stock.getCreatedDate()
            });
        }
    }
    private void changeJPanelVisible(JPanel ... panels){
        btnSetVisible();
        for(JPanel p:panels){
            p.setVisible( p.isVisible()?false:true);
        }
    }
    private void copySelectedStock(int selectedRow){
        tfCode.setText(null);
        tfName.setText(dataTable.getValueAt(selectedRow,1).toString());
        cmbxType.setSelectedItem( dataTable.getValueAt(selectedRow,2));
        cmbxUnit.setSelectedItem(dataTable.getValueAt(selectedRow,3).toString());
        tfBarcode.setText(dataTable.getValueAt(selectedRow,4).toString());
        cmbxVar.setSelectedItem(dataTable.getValueAt(selectedRow,5).toString());
        taDescription.setText(dataTable.getValueAt(selectedRow,6).toString());
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(dataTable.getValueAt(selectedRow,7).toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        dateChooser.setDate(date);
        changeJPanelVisible(pnlContentTable,pnlContentArea);
        tfCode.requestFocusInWindow();
    }
    private void updateSelectedStock(int selectedRow){
        tfCode.setText(dataTable.getValueAt(selectedRow, 0).toString());
        tfCode.setFocusable(false);
        tfCode.setEnabled(false);

        tfName.setText(dataTable.getValueAt(selectedRow, 1).toString());
        cmbxType.setSelectedItem(dataTable.getValueAt(selectedRow, 2).toString());
        cmbxUnit.setSelectedItem(dataTable.getValueAt(selectedRow, 3).toString());
        tfBarcode.setText(dataTable.getValueAt(selectedRow, 4).toString());
        cmbxVar.setSelectedItem(dataTable.getValueAt(selectedRow, 5).toString());
        taDescription.setText(dataTable.getValueAt(selectedRow, 6).toString());
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(dataTable.getValueAt(selectedRow,7).toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        dateChooser.setDate(date);
        changeJPanelVisible(pnlContentTable,pnlContentArea);
    }

}
