package com.guru.command;

import com.guru.view.StockSaveUI;

public class StockSaveUI_GetFirstStockSave implements Command{
	private StockSaveUI stockSaveUI;
	public StockSaveUI_GetFirstStockSave(StockSaveUI stockSaveUI) {
		this.stockSaveUI=stockSaveUI;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		stockSaveUI.setStock(stockSaveUI.getStock().beforNextStock("first","")); 
		stockSaveUI.writeStockCode();	
		stockSaveUI.getTfCode().setFocusable(false);
		stockSaveUI.getTfCode().setEnabled(false);
	}
}
