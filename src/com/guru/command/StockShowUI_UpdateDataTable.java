package com.guru.command;

import com.guru.help.Help;
import com.guru.view.StockShowUI;

public class StockShowUI_UpdateDataTable implements Command{
	private StockShowUI stockShowUI;
	
	public  StockShowUI_UpdateDataTable (StockShowUI stockShowUI) {
		this.stockShowUI=stockShowUI;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		stockShowUI.updateDataTable();
		Help.showMsg("Tablo güncellenmiştir...");
	}
	
	

}
