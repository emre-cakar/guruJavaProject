package com.guru.command;

import java.beans.PropertyVetoException;

import com.guru.view.StockSaveUI;

public class StockSaveUI_CancelCommand implements Command{
	private final StockSaveUI stockSaveUI;
	
	public StockSaveUI_CancelCommand(StockSaveUI stockSaveUI) {
		this.stockSaveUI=stockSaveUI;
	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		try {
			stockSaveUI.setClosed(true);
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
