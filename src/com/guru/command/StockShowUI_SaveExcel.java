package com.guru.command;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import com.guru.help.Excel;
import com.guru.help.Help;
import com.guru.model.Stock;
import com.guru.view.StockShowUI;

public class StockShowUI_SaveExcel implements Command{
	private final StockShowUI stockShowUI;
	private Stock stock;

	public StockShowUI_SaveExcel(StockShowUI stockShowUI) {
		this.stockShowUI=stockShowUI;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
        stock =new Stock();
        ArrayList<Stock> stockList=stock.searchStock("");
        Excel ex=new Excel(stockList);
        ex.selectFolder();
        if (ex.getPath()!=null){
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMddyyHHmmss");
            ex.setFileName("Stock_" + dtf.format(LocalDateTime.now()).toString());
            ex.reportFile();
        }else{
            Help.showMsg("Process canceled.");
        }
	}
	
}
