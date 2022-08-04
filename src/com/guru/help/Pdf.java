package com.guru.help;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFileChooser;

import com.guru.model.Stock;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRMapCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

public class Pdf {
    private String fileName;
    private String outFolder;


    public String getFileName() {
        return fileName;
    }
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getOutFolder() {
        return outFolder;
    }

    public void setOutFolder(String outFolder) {
        this.outFolder = outFolder;
    }

    public void selectFolder(){
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle("Select Folder");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            // System.out.println("getCurrentDirectory(): " + chooser.getCurrentDirectory());
            // System.out.println("getSelectedFile() : " + chooser.getSelectedFile());
            outFolder=chooser.getSelectedFile().getPath();
        } else {
            outFolder=null;
        }
    }
    public void createPDFReport(){
        if (outFolder!=null){
            Stock stock=new Stock();
            String outputFile = outFolder + "\\" + fileName + ".pdf";
            InputStream input = null;
            
            ArrayList<Map<String, ?>> stockMaps = new ArrayList<Map<String, ?>> (); 
            for(Stock temp:stock.searchStock("")) {
            	Map<String,Object> stockMap = new HashMap<String, Object>();
            	stockMap.put("code", temp.getCode());
            	stockMap.put("name", temp.getName());
            	stockMap.put("type", temp.getType());
            	stockMap.put("unit", temp.getUnit());
            	stockMap.put("barcode", temp.getBarcode());
            	stockMap.put("varType", temp.getVarType());
            	stockMap.put("description", temp.getDescription());
            	stockMap.put("createdDate", temp.getCreatedDate());
            	stockMaps.add(stockMap);
            }       
            try {
				input = new FileInputStream(new File("StockReport.jrxml"));
				JRMapCollectionDataSource dataSource = new JRMapCollectionDataSource(stockMaps);
				JasperReport jasperReport = JasperCompileManager.compileReport(input);
				JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, dataSource);
				JasperExportManager.exportReportToPdfFile(jasperPrint, outputFile);
				JasperViewer.viewReport(jasperPrint, false);
				
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (JRException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
        }else {
            Help.showMsg("Kaydedilecek dizin seçilmedi...");
        }


    }


}
