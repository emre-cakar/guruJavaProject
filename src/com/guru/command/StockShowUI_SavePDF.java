package com.guru.command;

import java.time.format.DateTimeFormatter;

import com.guru.help.Help;
import com.guru.help.Pdf;
import com.guru.view.StockShowUI;

public class StockShowUI_SavePDF implements Command{
	private StockShowUI stockShowUI;
	
	public StockShowUI_SavePDF(StockShowUI stockShowUI) {
		this.stockShowUI=stockShowUI;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		Pdf report=new Pdf();
        report.selectFolder();
        if (report.getOutFolder()!=null){
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMddyyHHmmss");
           // report.setFileName("Stock_" + dtf.format(LocalDateTime.now()).toString());
            report.setFileName("Rapor");
            report.createPDFReport();
        }else{
            Help.showMsg("Process canceled.");
        }
	}

}
