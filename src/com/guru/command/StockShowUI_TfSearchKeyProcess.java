package com.guru.command;

import java.awt.event.ComponentEvent;

import com.guru.view.StockShowUI;

public class StockShowUI_TfSearchKeyProcess implements Command{
	private StockShowUI stockShowUI;
	
	public StockShowUI_TfSearchKeyProcess(StockShowUI stockShowUI) {
		this.stockShowUI=stockShowUI;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}
	public void execute(ComponentEvent e) {
		if(e.getID()==402) {
			stockShowUI.updateDataTable();
		}
	}
	

}
