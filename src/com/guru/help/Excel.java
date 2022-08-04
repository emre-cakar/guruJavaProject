package com.guru.help;


import com.guru.model.Stock;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;


public class Excel {
    private String fileName, path;
    private ArrayList<Stock> stockList;

    public Excel(){}
    public Excel(ArrayList<Stock> stockList) {
        this.stockList = stockList;
    }

    public String getFileName() {
        return fileName;
    }
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    public String getPath() {
        return path;
    }

    // Methods
    public void selectFolder(){
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle("Select Folder");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            // System.out.println("getCurrentDirectory(): " + chooser.getCurrentDirectory());
            // System.out.println("getSelectedFile() : " + chooser.getSelectedFile());
            path=chooser.getSelectedFile().getPath();
        } else {
            path=null;
        }
    }
    public void createdFolder(){
        if (path==null){
            path=System.getProperty("user.dir");
            File f = new File(path + "\\Excel");
            if (!f.exists() && !f.isDirectory()){
               f.mkdir();
               path=path + "\\Excel";
            }else{
                path=System.getProperty("user.dir")  + "\\Excel";
            }
        }
    }
    public void reportFile(){
        XSSFWorkbook workbook = new XSSFWorkbook();
        CreationHelper createHelper = workbook.getCreationHelper();
        CellStyle cellStyle = workbook.createCellStyle();

        Sheet sheet = workbook.createSheet("Stock");

        Cell cell;
        int rownum = 0;
        int cellnum = 0;
        Row row;

        row = sheet.createRow(rownum++);
        cell=row.createCell(cellnum++);
        cell.setCellValue("Code");

        cell=row.createCell(cellnum++);
        cell.setCellValue("Name");

        cell=row.createCell(cellnum++);
        cell.setCellValue("Type");

        cell=row.createCell(cellnum++);
        cell.setCellValue("Unit");

        cell=row.createCell(cellnum++);
        cell.setCellValue("Barcode");

        cell=row.createCell(cellnum++);
        cell.setCellValue("VarType");

        cell=row.createCell(cellnum++);
        cell.setCellValue("Description");

        cell=row.createCell(cellnum++);
        cell.setCellValue("CreatedDate");
        for(Stock s:stockList){
            cellnum=0;
            row = sheet.createRow(rownum++);
            cell=row.createCell(cellnum++);
            cell.setCellValue(s.getCode());

            cell=row.createCell(cellnum++);
            cell.setCellValue(s.getName());

            cell=row.createCell(cellnum++);
            cell.setCellValue(s.getType());

            cell=row.createCell(cellnum++);
            cell.setCellValue(s.getUnit());

            cell=row.createCell(cellnum++);
            cell.setCellValue(s.getBarcode());

            cell=row.createCell(cellnum++);
            cell.setCellValue(s.getVarType());

            cell=row.createCell(cellnum++);
            cell.setCellValue(s.getDescription());

            cell=row.createCell(cellnum++);
            cellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd/mm/yyyy"));
            cell.setCellValue(s.getCreatedDate());
            cell.setCellStyle(cellStyle);

        }
        OutputStream  out = null;
        try {
            out = new FileOutputStream(new File( path + "\\" +fileName + ".xlsx"));
            workbook.write(out);
            out.close();
            workbook.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            Desktop.getDesktop().open(new File(path + "\\" +fileName + ".xlsx"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}
